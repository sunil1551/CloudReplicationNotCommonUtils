package com.carnival.replication.consumer.mongo.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carnival.replication.consumer.dao.ReplicationDao;
import com.carnival.replication.consumer.model.UserDetailsReplicationDocument;
import com.carnival.replication.consumer.service.IDataPersistanceServiceProvider;
import com.carnival.utility.common.exceptions.ApplicationDataAccessException;

@Service
public class MongoDataPersistanceServiceProvider implements IDataPersistanceServiceProvider {

	private static final Logger LOGGER = LoggerFactory.getLogger(MongoDataPersistanceServiceProvider.class);

	@Autowired
	ReplicationDao replicationDao;

	@Override
	public void saveUserDetails(Set<UserDetailsReplicationDocument> userDetailsReplication)
			throws ApplicationDataAccessException {
		LOGGER.debug("Sending UserDetailsReplication object named {} to dao layer", userDetailsReplication);
		replicationDao.saveUserDetails(userDetailsReplication);
	}

}