package com.project.homeautomation.datamodel.mysql.dto;

import com.project.homeautomation.datamodel.mysql.dto.base.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "devices")
public class DevicesDto implements TranslatableEntity {
    private static final long serialVersionUID = -4008459905826449400L;

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "deviceId")
    private long deviceId;

    @Column(name = "deviceName")
    private String deviceName;

    @Column(name = "userId")
    private String userId;

    @Override public Long getEntityId() {
        return deviceId;
    }

    @Override public boolean isMasterTable() {
        return false;
    }

    @Override public boolean isTransientEntityMasterData() {
        return false;
    }

}
