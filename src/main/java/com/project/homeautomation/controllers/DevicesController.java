package com.project.homeautomation.controllers;

import com.project.homeautomation.bo.DeviceBo;
import com.project.homeautomation.facade.DevicesFacade;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/v1/device")
public class DevicesController {
    @RequestMapping(path = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "I am alive!";
    }

    @Autowired private DevicesFacade devicesFacade;

    @ApiOperation("Get All devices")
    @GetMapping("/{userId}") @ResponseBody
    public List<DeviceBo> getDevices(HttpServletRequest request,
                                     @PathVariable("userId") String userId) {

        List<DeviceBo> devices = devicesFacade.getDevices(userId);
        return devices;
    }

    @ApiOperation("Add a new Device")
    @RequestMapping(path = "add/{userId}/{deviceName}",method = RequestMethod.POST)
    public String addNewDevice(HttpServletRequest request,
                                       @PathVariable("userId") String userId,
                                       @PathVariable("deviceName") String deviceName) {

        String message = devicesFacade.addNewDevice(userId, deviceName);
        return message;
    }

    @ApiOperation("Delete Device")
    @RequestMapping(path = "delete/{deviceId}",method = RequestMethod.DELETE)
    public String deleteDevice(HttpServletRequest request,
                               @PathVariable("deviceId") Long deviceId) {

        String message = devicesFacade.deleteDevice(deviceId);
        return message;
    }

    @ApiOperation("Operation on a Device")
    @RequestMapping(path = "operation/{userId}/{deviceId}/{operation}",method = RequestMethod.POST)
    public String performOperation(HttpServletRequest request,
                                   @PathVariable("userId") String userId,
                                   @PathVariable("deviceId") Long deviceId,
                                   @PathVariable("operation") String operation) {

        String message = devicesFacade.performOperation(userId, deviceId, operation);
        return message;
    }
}
