package com.carnival.replication.consumer.impl;

import static com.carnival.replication.utils.Constants.SCHEDULAR_SCHEDULED_TIME;
import static com.carnival.replication.utils.Constants.POLL_DURATION;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.carnival.replication.consumer.IMessageConsumer;
import com.carnival.replication.consumer.model.UserDetailsReplication;
import com.carnival.replication.consumer.model.UserDetailsReplicationDocument;
import com.carnival.replication.consumer.service.IDataPersistanceServiceProvider;
import com.carnival.utility.common.exceptions.ApplicationDataAccessException;

/**
 * @author E01551
 *
 */
@Component
public class KafkaMessageConsumer implements IMessageConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageConsumer.class);

	Set<UserDetailsReplicationDocument> userDetails = Collections
			.synchronizedSet(new LinkedHashSet<UserDetailsReplicationDocument>());

	@Autowired
	KafkaConsumer<String, UserDetailsReplication> consumer;

	@Autowired
	IDataPersistanceServiceProvider iDataPersistanceServiceProvider;

	@Value("${batchSize}")
	private int batchSize;

	@Value("${topicName}")
	private String topicName;
	
	@Value("${pollDuration}")
	private Long pollDuration;
	
	@Override
	@Scheduled(fixedRateString = "${scheduledTime}")
	public void consumeMessages() {
		LOGGER.info("Waiting for consuming Messages from topic {}", topicName);
		RebalanceListener RebalanceListener = new RebalanceListener(consumer);

		consumer.subscribe(Arrays.asList(topicName), RebalanceListener);
		try {

			ConsumerRecords<String, UserDetailsReplication> records = consumer.poll(pollDuration);
			for (ConsumerRecord<String, UserDetailsReplication> record : records) {
				LOGGER.info("inside kafka consumer with logback");
				UserDetailsReplicationDocument userDetailsReplicationDocument = new UserDetailsReplicationDocument();
				UserDetailsReplication userDetailsReplication = record.value();
				userDetailsReplicationDocument.setMsgId(userDetailsReplication.getHeader().getMsgId());
				userDetailsReplicationDocument.setMsgSource(userDetailsReplication.getHeader().getMsgSource());
				userDetailsReplicationDocument.setMsgSendTime(userDetailsReplication.getHeader().getMsgSendTime());
				userDetailsReplicationDocument.setVoyageNo(userDetailsReplication.getHeader().getVoyageNo());
				userDetailsReplicationDocument.setUserDetailsReplication(userDetailsReplication);
				userDetails.add(userDetailsReplicationDocument);
				LOGGER.info("Message " + userDetailsReplication.toString() + " added to cache successfully !!");
				if (userDetails.size() == batchSize) {
					LOGGER.info("Message with batchSize {} is processed  ", userDetails.size());
					try {
						iDataPersistanceServiceProvider.saveUserDetails(userDetails);
					} catch (ApplicationDataAccessException ex) {
						LOGGER.error("ApplicationDataAccessException occurred while upserting records in DB", ex);
					}
					//consumer.commitAsync();
					userDetails.clear();
				}
			}
			consumer.commitAsync();
		} catch (Exception ex) {
			LOGGER.error("ApplicationDataProcessingException occurs while consuming messages from Kafka ", ex);
		} finally {
			consumer.commitSync();
		}

	}

}
