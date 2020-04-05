package com.project.homeautomation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.homeautomation.bo.DeviceBo;
import com.project.homeautomation.service.DevicesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class) @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DevicesTest extends BasicRestTest {

    private DevicesService devicesService;

    @Test public void testGetDeviceWithValidUserId() throws IOException {
        String userId = "6c57599f-2c43-4c82-806a-e07c3410f5d3";

        String url = MessageFormat.format("device/{0}", userId);

        ResponseEntity<String> response = getCall(url, String.class);

        assertThat(response.getStatusCode().is2xxSuccessful());

        ObjectMapper objectMapper = new ObjectMapper();
        List<DeviceBo>
                deviceBos =
                objectMapper.readValue(response.getBody(), new TypeReference<List<DeviceBo>>() {
                });

        assertThat(deviceBos.size()).isEqualTo(2);

        DeviceBo deviceBo1 = deviceBos.get(0);
        assertThat(deviceBo1.getDeviceName()).isEqualTo("Phone");
        assertThat(deviceBo1.getUserId()).isEqualTo("6c57599f-2c43-4c82-806a-e07c3410f5d3");
        DeviceBo deviceBo2 = deviceBos.get(1);
        assertThat(deviceBo2.getDeviceName()).isEqualTo("Laptop");
        assertThat(deviceBo2.getUserId()).isEqualTo("6c57599f-2c43-4c82-806a-e07c3410f5d3");
        }

}
