package com.carnival.replication.consumer;

import com.carnival.utility.common.exceptions.ApplicationDataProcessingException;

public interface IMessageConsumer {

	 public void consumeMessages() throws ApplicationDataProcessingException; 
	 
}
