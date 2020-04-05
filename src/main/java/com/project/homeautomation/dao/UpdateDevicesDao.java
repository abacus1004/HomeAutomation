package com.project.homeautomation.dao;

import com.jcabi.aspects.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository public class UpdateDevicesDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Loggable
    public void addNewDevice(String userId, String deviceName) {
        String query = "Insert into homeautomation.devices (DeviceName, UserId) values (:deviceName, :userId);";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("deviceName", deviceName);
        parameters.put("userId", userId);
        this.jdbcTemplate.update(query,parameters);
    }

    @Loggable
    public void deleteDevice(Long deviceId) {
        String query = "delete from homeautomation.devices where deviceId=:deviceId;";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("deviceId", deviceId);
        this.jdbcTemplate.update(query,parameters);
    }
}