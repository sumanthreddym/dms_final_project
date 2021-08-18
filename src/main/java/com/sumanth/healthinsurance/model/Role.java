package com.sumanth.healthinsurance.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {
    private String roleId;
    private String type;
    private String phoneNumber;
    private String districtName;
    private String regionName;
    private String stateName;
    @JsonManagedReference(value = "associate-role-role")
    private Collection<AssociateRole> associateRolesByRoleId;

    @Id
    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "district_name")
    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Basic
    @Column(name = "region_name")
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Basic
    @Column(name = "state_name")
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (roleId != null ? !roleId.equals(role.roleId) : role.roleId != null) return false;
        if (type != null ? !type.equals(role.type) : role.type != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(role.phoneNumber) : role.phoneNumber != null) return false;
        if (districtName != null ? !districtName.equals(role.districtName) : role.districtName != null) return false;
        if (regionName != null ? !regionName.equals(role.regionName) : role.regionName != null) return false;
        if (stateName != null ? !stateName.equals(role.stateName) : role.stateName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (districtName != null ? districtName.hashCode() : 0);
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (stateName != null ? stateName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<AssociateRole> getAssociateRolesByRoleId() {
        return associateRolesByRoleId;
    }

    public void setAssociateRolesByRoleId(Collection<AssociateRole> associateRolesByRoleId) {
        this.associateRolesByRoleId = associateRolesByRoleId;
    }
}
