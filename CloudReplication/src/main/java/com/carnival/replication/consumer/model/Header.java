package com.carnival.replication.consumer.model;

import java.util.Date;

/**
 * @author E01551
 *
 */
public class Header {
	private String msgId; // will be a shipcode_uuid
	private String msgSource;
	private Date msgSendTime;
	private String voyageNo;

	public String getVoyageNo() {
		return voyageNo;
	}

	public void setVoyageNo(String voyageNo) {
		this.voyageNo = voyageNo;
	}

	public Date getMsgSendTime() {
		return msgSendTime;
	}

	public void setMsgSendTime(Date msgSendTime) {
		this.msgSendTime = msgSendTime;
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

	@Override
	public String toString() {
		return "Header [msgId=" + msgId + ", msgSource=" + msgSource + ", msgSendTime=" + msgSendTime + ", voyageNo="
				+ voyageNo + "]";
	}
}