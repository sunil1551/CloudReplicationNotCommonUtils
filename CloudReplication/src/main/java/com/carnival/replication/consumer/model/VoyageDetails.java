package com.carnival.replication.consumer.model;

import java.util.Date;

/**
 * @author E01551
 *
 */
public class VoyageDetails {
	private String cabinNumber;
	private String voyageNumber;
	private Date embarkDate;
	private Date disembarkDate;

	public Date getEmbarkDate() {
		return embarkDate;
	}

	public void setEmbarkDate(Date embarkDate) {
		this.embarkDate = embarkDate;
	}

	public Date getDisembarkDate() {
		return disembarkDate;
	}

	public void setDisembarkDate(Date disembarkDate) {
		this.disembarkDate = disembarkDate;
	}

	public String getCabinNumber() {
		return cabinNumber;
	}

	public void setCabinNumber(String cabinNumber) {
		this.cabinNumber = cabinNumber;
	}

	public String getVoyageNumber() {
		return voyageNumber;
	}

	public void setVoyageNumber(String voyageNumber) {
		this.voyageNumber = voyageNumber;
	}
}
