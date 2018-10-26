package com.carnival.replication.consumer.model;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author E01551
 *
 */

@SuppressWarnings("rawtypes")
public class UserDetailsReplicationDeserializer implements Deserializer {

	@Override
	public void configure(Map configs, boolean isKey) {

	}

	@Override
	public Object deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		UserDetailsReplication userDetailsReplication = null;
		try {
			userDetailsReplication = mapper.readValue(data, UserDetailsReplication.class);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return userDetailsReplication;
	}

	@Override
	public void close() {

	}

}
