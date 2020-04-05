package com.project.homeautomation.facade;

import com.project.homeautomation.bo.DeviceBo;
import com.project.homeautomation.datamodel.mysql.dto.DevicesDto;
import com.project.homeautomation.service.DevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component public class DevicesFacade {

    @Autowired private DevicesService devicesService;

    public List<DeviceBo> getDevices(String userId) {

        List<DevicesDto> deviceDtos = devicesService.getDevices(userId);
        List<DeviceBo> response = new ArrayList<>();

        for(DevicesDto dto : deviceDtos) {
            response.add(new DeviceBo(dto));
        }

        return response;
    }

    public String addNewDevice(String userId, String deviceName) {

        String messaage = devicesService.addNewDevice(userId, deviceName);

        return messaage;
    }

    public String deleteDevice(String deviceId) {

        String messaage = devicesService.deleteDevice(deviceId);

        return messaage;
    }

    public String performOperation(String userId, String deviceId, String operation) {

        String messaage = devicesService.performOperation(userId, deviceId, operation);

        return messaage;
    }



}
