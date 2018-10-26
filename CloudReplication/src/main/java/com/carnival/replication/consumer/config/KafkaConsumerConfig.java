package com.carnival.replication.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.carnival.replication.consumer.model.UserDetailsReplication;

@Configuration
public class KafkaConsumerConfig {

	@Value("${bootstrap.servers}")
	public String bootstrapServers;

	@Value("${key.deserializer}")
	public String keyDeserializer;

	@Value("${value.deserializer}")
	public String valueDeserializer;

	@Value("${group.id}")
	public String groupId;

	@Bean
	public KafkaConsumer<String, UserDetailsReplication> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		return new KafkaConsumer<String, UserDetailsReplication>(props);
	}

}
