package com.carnival.replication.consumer.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.carnival.replication.consumer.dao.ReplicationDao;
import com.carnival.replication.consumer.model.UserDetailsReplicationDocument;
import com.carnival.utility.common.exceptions.ApplicationDataAccessException;

@Repository
public class ReplicationDaoImpl implements ReplicationDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReplicationDaoImpl.class);

	@Autowired
	MongoTemplate mongoTemplate;
	Query query = null;
	Update update = null;
	Date date = null;

	@Override
	public void saveUserDetails(Set<UserDetailsReplicationDocument> entities) throws ApplicationDataAccessException {
		LOGGER.debug("Saving UserDetails in MongoDb");
		List<UserDetailsReplicationDocument> userDetailsLists = Collections
				.synchronizedList(new ArrayList<UserDetailsReplicationDocument>());
		userDetailsLists.addAll(entities);

		date = new Date();
		try {
			BulkOperations ops = mongoTemplate.bulkOps(BulkMode.ORDERED, UserDetailsReplicationDocument.class);
			for (UserDetailsReplicationDocument userDetailsList : userDetailsLists) {
				query = new Query();
				query.addCriteria(Criteria.where("_id")
						.is(userDetailsList.getUserDetailsReplication().getPayload().getUserDetails().getId()));
				Update update = new Update();
				update.set("msgUpdateTime", date);
				update.set("nghSendTime", null);
				update.set("msgId", userDetailsList.getMsgId());
				update.set("msgSource", userDetailsList.getMsgSource());
				update.set("msgSendTime", userDetailsList.getMsgSendTime());
				update.set("payload", userDetailsList.getUserDetailsReplication().getPayload());
				ops.upsert(query, update);
			}
			ops.execute();
		} catch (Exception ex) {
			throw new ApplicationDataAccessException("ApplicationDataAccessException occurred while upserting records", ex);

		}

	}
}
