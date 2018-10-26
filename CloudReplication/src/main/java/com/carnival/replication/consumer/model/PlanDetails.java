package com.carnival.replication.consumer.model;

import java.util.Date;
import java.util.List;

/**
 * @author E01551
 *
 */
public class PlanDetails {

	private Date planStartDate; // Plan Start Date
	private Date planExpiryDate; // Expiry date
	private Integer status; // Plan Status - active or expired
	private Double amount; // Plan purchase ammount
	private Long maxdevicesAllowed; // Maximum device allowed (1/4)
	private Long deviceInUse; // Device in Use
	private List<DeviceDetails> deviceDetails;

	public Date getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}

	public Date getPlanExpiryDate() {
		return planExpiryDate;
	}

	public void setPlanExpiryDate(Date planExpiryDate) {
		this.planExpiryDate = planExpiryDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getMaxdevicesAllowed() {
		return maxdevicesAllowed;
	}

	public void setMaxdevicesAllowed(Long maxdevicesAllowed) {
		this.maxdevicesAllowed = maxdevicesAllowed;
	}

	public Long getDeviceInUse() {
		return deviceInUse;
	}

	public void setDeviceInUse(Long deviceInUse) {
		this.deviceInUse = deviceInUse;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<DeviceDetails> getDeviceDetails() {
		return deviceDetails;
	}

	public void setDeviceDetails(List<DeviceDetails> deviceDetails) {
		this.deviceDetails = deviceDetails;
	}
}