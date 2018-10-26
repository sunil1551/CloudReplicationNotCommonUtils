package com.carnival.replication.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author E01551
 *
 */
public class UserDetailsReplication {
	private Header header;
	private UserDataPayload payload;
	@JsonIgnore
	private TrackingDetails trackingDetails;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public UserDataPayload getPayload() {
		return payload;
	}

	public void setPayload(UserDataPayload payload) {
		this.payload = payload;
	}

	public TrackingDetails getTrackingDetails() {
		return trackingDetails;
	}

	public void setTrackingDetails(TrackingDetails trackingDetails) {
		this.trackingDetails = trackingDetails;
	}

	@Override
	public String toString() {
		return "UserDetailsReplication [header=" + header + ", payload=" + payload + ", trackingDetails="
				+ trackingDetails + "]";
	}

}
