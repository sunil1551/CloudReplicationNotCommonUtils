package com.carnival.replication.consumer.service;

import java.util.Set;

import com.carnival.replication.consumer.model.UserDetailsReplicationDocument;
import com.carnival.utility.common.exceptions.ApplicationDataAccessException;

public interface IDataPersistanceServiceProvider {

	// CRUD Operations
	public void saveUserDetails(Set<UserDetailsReplicationDocument> userDetailsReplication)
			throws ApplicationDataAccessException;

}
