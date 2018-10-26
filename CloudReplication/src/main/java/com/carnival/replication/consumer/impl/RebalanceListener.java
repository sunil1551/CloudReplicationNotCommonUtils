package com.carnival.replication.consumer.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.carnival.replication.consumer.model.UserDetailsReplication;

public class RebalanceListener implements ConsumerRebalanceListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(RebalanceListener.class);
	KafkaConsumer<String, UserDetailsReplication> consumer;
	private Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();

	public RebalanceListener(KafkaConsumer<String, UserDetailsReplication> consumer) {
		this.consumer = consumer;
	}

	public void addOffset(String topic, int partition, long offset) {
		currentOffsets.put(new TopicPartition(topic, partition), new OffsetAndMetadata(offset, "Commit"));
	}

	public Map<TopicPartition, OffsetAndMetadata> getCurrentOffsets() {
		return currentOffsets;
	}

	public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
		LOGGER.debug("Below Partitions Assigned");
		for (TopicPartition partition : partitions)
			LOGGER.debug(partition.partition() + ",");
	}

	public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
		LOGGER.debug("Below Partitions Revoked");
		for (TopicPartition partition : partitions)
			LOGGER.debug(partition.partition() + ",");

		LOGGER.debug("Below Partitions commited");
		for (TopicPartition tp : currentOffsets.keySet())
			LOGGER.debug(tp.partition() + "");

		consumer.commitSync(currentOffsets);
		currentOffsets.clear();
	}
}
