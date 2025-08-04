package com.model.user;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "tt_UserPreference")
@NamedQuery(name = "UserPreference.findAll", query = "SELECT p FROM UserPreference p")
public class UserPreference implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "UserPreferenceId")
	private long userPreferenceId;
	private String datePattern;
	private String timePatternt;
	private String currencyISOCode;
	private String numberFormat;
	private String percentageFormat;
	private String Country;
	private String language;
	private String timezoneId;
	private int maxRowPerPage=20;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modtime;
	private long userId;
	private int isActive;
	
	public long getUserPreferenceId() {
		return userPreferenceId;
	}
	public void setUserPreferenceId(long userPreferenceId) {
		this.userPreferenceId = userPreferenceId;
	}
	public String getDatePattern() {
		return datePattern;
	}
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	public String getTimePatternt() {
		return timePatternt;
	}
	public void setTimePatternt(String timePatternt) {
		this.timePatternt = timePatternt;
	}
	public String getCurrencyISOCode() {
		return currencyISOCode;
	}
	public void setCurrencyISOCode(String currencyISOCode) {
		this.currencyISOCode = currencyISOCode;
	}
	public String getNumberFormat() {
		return numberFormat;
	}
	public void setNumberFormat(String numberFormat) {
		this.numberFormat = numberFormat;
	}
	public String getPercentageFormat() {
		return percentageFormat;
	}
	public void setPercentageFormat(String percentageFormat) {
		this.percentageFormat = percentageFormat;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getTimezoneId() {
		return timezoneId;
	}
	public void setTimezoneId(String timezoneId) {
		this.timezoneId = timezoneId;
	}
	public int getMaxRowPerPage() {
		return maxRowPerPage;
	}
	public void setMaxRowPerPage(int maxRowPerPage) {
		this.maxRowPerPage = maxRowPerPage;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getModtime() {
		return modtime;
	}
	public void setModtime(Date modtime) {
		this.modtime = modtime;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	

	
	
	
}
