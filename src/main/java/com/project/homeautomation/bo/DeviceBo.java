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


	private String deviceName;
	private long deviceId;
	private String userId;

	public DeviceBo(DevicesDto devicesDto) {
		this.deviceName = devicesDto.getDeviceName();
		this.deviceId = devicesDto.getDeviceId();
		this.userId = devicesDto.getUserId();
	}
}