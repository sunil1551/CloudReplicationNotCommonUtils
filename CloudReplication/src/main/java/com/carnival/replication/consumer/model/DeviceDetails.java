package com.carnival.replication.consumer.model;

import java.util.Date;

/**
 * @author E01551
 *
 */
public class DeviceDetails {

	private String userMACAddress; // User Mac Address
	private Long dataUsageinMB; // Data Usage in MB
	private Integer deviceStatusFlag; // Device Status
										// (login,logout,expiry,inactive

	private Date updatedOn;

	public Long getDataUsageinMB() {
		return dataUsageinMB;
	}

	public void setDataUsageinMB(Long dataUsageinMB) {
		this.dataUsageinMB = dataUsageinMB;
	}

	public Integer getDeviceStatusFlag() {
		return deviceStatusFlag;
	}

	public void setDeviceStatusFlag(Integer deviceStatusFlag) {
		this.deviceStatusFlag = deviceStatusFlag;
	}

	public String getUserMACAddress() {
		return userMACAddress;
	}

	public void setUserMACAddress(String userMACAddress) {
		this.userMACAddress = userMACAddress;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "DeviceDetails [userMACAddress=" + userMACAddress + ", dataUsageinMB=" + dataUsageinMB
				+ ", deviceStatusFlag=" + deviceStatusFlag + ", updatedOn=" + updatedOn + "]";
	}

}