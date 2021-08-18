package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class County {
    private String countyId;
    private String countyName;
    private String state;
    @JsonBackReference(value = "county-region")
    private Region regionByRegionId;

    @Id
    @Column(name = "county_id")
    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    @Basic
    @Column(name = "county_name")
    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        County county = (County) o;

        if (countyId != null ? !countyId.equals(county.countyId) : county.countyId != null) return false;
        if (countyName != null ? !countyName.equals(county.countyName) : county.countyName != null) return false;
        if (state != null ? !state.equals(county.state) : county.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countyId != null ? countyId.hashCode() : 0;
        result = 31 * result + (countyName != null ? countyName.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    public Region getRegionByRegionId() {
        return regionByRegionId;
    }

    public void setRegionByRegionId(Region regionByRegionId) {
        this.regionByRegionId = regionByRegionId;
    }
}
