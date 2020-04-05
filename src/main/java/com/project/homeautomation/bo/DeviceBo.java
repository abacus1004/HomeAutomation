package com.project.homeautomation.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.homeautomation.datamodel.mysql.dto.DevicesDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
public @Data @NoArgsConstructor @AllArgsConstructor
class DeviceBo {


	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	private String deviceName;
	private long deviceId;
	private String userId;

	public DeviceBo(DevicesDto devicesDto) {
		this.deviceName = devicesDto.getDeviceName();
		this.deviceId = devicesDto.getDeviceId();
		this.userId = devicesDto.getUserId();
	}
}