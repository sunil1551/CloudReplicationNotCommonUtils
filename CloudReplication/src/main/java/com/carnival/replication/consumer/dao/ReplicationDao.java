package com.carnival.replication.consumer.dao;

import java.util.Set;

import com.carnival.replication.consumer.model.UserDetailsReplicationDocument;
import com.carnival.utility.common.exceptions.ApplicationDataAccessException;

public interface ReplicationDao {

	public void saveUserDetails(Set<UserDetailsReplicationDocument> userDetailsReplication)
			throws ApplicationDataAccessException;

}
