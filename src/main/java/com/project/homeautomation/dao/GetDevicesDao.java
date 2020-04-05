package com.project.homeautomation.dao;

import com.project.homeautomation.datamodel.mysql.dto.DevicesDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GetDevicesDao extends
        CrudRepository<DevicesDto, Long> {

    List<DevicesDto> findByUserId(String userId);
}