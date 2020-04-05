package com.project.homeautomation.controllers;

import com.project.homeautomation.bo.DeviceBo;
import com.project.homeautomation.facade.DevicesFacade;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/v1/device")
public class DevicesController {
    @RequestMapping(path = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "If you ping me, I will ping you back!";
    }

    @Autowired private DevicesFacade devicesFacade;

    @ApiOperation("Get All devices")
    @GetMapping("/{userId}") @ResponseBody
    public List<DeviceBo> getDevices(HttpServletRequest request,
                                     @PathVariable("userId") String userId) {

        List<DeviceBo> devices = devicesFacade.getDevices(userId);
        return devices;
    }

    // make this post API
    @ApiOperation("Add a new Device")
    @GetMapping("add/{userId}/{deviceName}") @ResponseBody
    public String addNewDevice(HttpServletRequest request,
                                       @PathVariable("userId") String userId,
                                       @PathVariable("deviceName") String deviceName) {

        String message = devicesFacade.addNewDevice(userId, deviceName);
        return message;
    }

    @ApiOperation("Delete Device")
    @GetMapping("delete/{deviceId}") @ResponseBody
    public String deleteDevice(HttpServletRequest request,
                               @PathVariable("deviceId") String deviceId) {

        String message = devicesFacade.deleteDevice(deviceId);
        return message;
    }

    @ApiOperation("Operation on a Device")
    @GetMapping("operation/{userId}/{deviceId}/{operation}") @ResponseBody
    public String performOperation(HttpServletRequest request,
                                   @PathVariable("userId") String userId,
                                   @PathVariable("deviceId") String deviceId,
                                   @PathVariable("operation") String operation) {

        String message = devicesFacade.performOperation(userId, deviceId, operation);
        return message;
    }
}