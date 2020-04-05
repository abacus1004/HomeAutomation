package com.project.homeautomation.service;

import com.project.homeautomation.dao.GetDevicesDao;
import com.project.homeautomation.datamodel.mysql.dto.DevicesDto;
import com.project.homeautomation.dao.UpdateDevicesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service public class DevicesService {
    @Autowired
    UpdateDevicesDao devicesDao;
    @Autowired
    GetDevicesDao getDevicesDao;

    public List<DevicesDto> getDevices(String userId) {
        return getDevicesDao.findByUserId(userId);

    }

    public String addNewDevice(String userId, String deviceName){
        devicesDao.addNewDevice(userId, deviceName);

        return "device Added Successfully";
    }

    public String deleteDevice(String deviceId){
        devicesDao.deleteDevice(deviceId);

        return "device Deleted Successfully";
    }

    public String performOperation(String userId, String deviceId, String operation){
        if(operation.equals("on")){
            return "device turned on successfully";
        }
        else if(operation.equals("off")){
            return "device turned off successfully";
        }

        return "invalid operation";
    }


}
