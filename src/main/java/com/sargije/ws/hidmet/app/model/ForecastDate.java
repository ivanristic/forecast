package com.sargije.ws.hidmet.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "datum")
public class ForecastDate {

	@Id
	@GeneratedValue
	@Column(name = "d_id")
	private Long dateId;

	@Column(name = "d_datum")
	private Date forecastDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dateId")
	private Set<Forecast> forecastFK = new HashSet<Forecast>();

	public Long getDateId() {
		return dateId;
	}

	public void setDateId(Long dateId) {
		this.dateId = dateId;
	}

	public Date getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(Date forecastDate) {
		this.forecastDate = forecastDate;
	}

}
