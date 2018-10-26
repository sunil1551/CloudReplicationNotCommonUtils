package com.carnival.replication.consumer.model;

/**
 * @author E01551
 *
 */
public class TrackingDetails {
	private Long rowInsertionTime;
	private int publishReplicationStatus;
	private Long replicationInitiationTime;

	public Long getRowInsertionTime() {
		return rowInsertionTime;
	}

	public void setRowInsertionTime(Long rowInsertionTime) {
		this.rowInsertionTime = rowInsertionTime;
	}

	public int getPublishReplicationStatus() {
		return publishReplicationStatus;
	}

	public void setPublishReplicationStatus(int publishReplicationStatus) {
		this.publishReplicationStatus = publishReplicationStatus;
	}

	public Long getReplicationInitiationTime() {
		return replicationInitiationTime;
	}

	public void setReplicationInitiationTime(Long replicationInitiationTime) {
		this.replicationInitiationTime = replicationInitiationTime;
	}

}
