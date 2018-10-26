package com.carnival.replication.consumer.model;

import java.util.List;

/**
 * @author E01551
 *
 */
public class UserDataPayload {
	private UserDetails userDetails;
	private List<VoyageDetails> voyageDetails;
	private List<PlanDetails> planDetails;
	private Header header;

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public List<VoyageDetails> getVoyageDetails() {
		return voyageDetails;
	}

	public void setVoyageDetails(List<VoyageDetails> voyageDetails) {
		this.voyageDetails = voyageDetails;
	}

	public List<PlanDetails> getPlanDetails() {
		return planDetails;
	}

	public void setPlanDetails(List<PlanDetails> planDetails) {
		this.planDetails = planDetails;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	@Override
	public String toString() {
		return "UserDataPayload [userDetails=" + userDetails + ", voyageDetails=" + voyageDetails + ", planDetails="
				+ planDetails + ", header=" + header + "]";
	}
}
