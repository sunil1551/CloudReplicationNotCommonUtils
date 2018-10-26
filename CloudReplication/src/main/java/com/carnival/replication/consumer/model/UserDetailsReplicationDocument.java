package com.carnival.replication.consumer.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author E01551
 *
 */
@Document(collection = "UserDetailsReplication")
public class UserDetailsReplicationDocument {

	private Date msgUpdateTime;
	private Date nghSendTime;
	// Header
	private String msgId; // will be a shipcode_uuid
	private String msgSource;
	private Date msgSendTime;
	private String voyageNo;
	private UserDetailsReplication userDetailsReplication;

	public Date getMsgUpdateTime() {
		return msgUpdateTime;
	}

	public void setMsgUpdateTime(Date msgUpdateTime) {
		this.msgUpdateTime = msgUpdateTime;
	}

	public Date getNghSendTime() {
		return nghSendTime;
	}

	public void setNghSendTime(Date nghSendTime) {
		this.nghSendTime = nghSendTime;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgSource() {
		return msgSource;
	}

	public void setMsgSource(String msgSource) {
		this.msgSource = msgSource;
	}

	public Date getMsgSendTime() {
		return msgSendTime;
	}

	public void setMsgSendTime(Date msgSendTime) {
		this.msgSendTime = msgSendTime;
	}

	public String getVoyageNo() {
		return voyageNo;
	}

	public void setVoyageNo(String voyageNo) {
		this.voyageNo = voyageNo;
	}

	public UserDetailsReplication getUserDetailsReplication() {
		return userDetailsReplication;
	}

	public void setUserDetailsReplication(UserDetailsReplication userDetailsReplication) {
		this.userDetailsReplication = userDetailsReplication;
	}

	@Override
	public String toString() {
		return "UserDetailsReplicationDocument [msgUpdateTime=" + msgUpdateTime + ", nghSendTime=" + nghSendTime
				+ ", msgId=" + msgId + ", msgSource=" + msgSource + ", msgSendTime=" + msgSendTime + ", voyageNo="
				+ voyageNo + ", userDetailsReplication=" + userDetailsReplication + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((msgId == null) ? 0 : msgId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetailsReplicationDocument other = (UserDetailsReplicationDocument) obj;
		if (msgId == null) {
			if (other.msgId != null)
				return false;
		} else if (!msgId.equals(other.msgId))
			return false;
		return true;
	}
}
