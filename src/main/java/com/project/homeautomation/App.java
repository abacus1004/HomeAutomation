package com.project.homeautomation;


import com.capillary.platforms.catalogserviceclient.api.ProductPriceListApi;
import com.capillary.platforms.catalogserviceclient.api.TaskApi;
import com.capillary.platforms.ecom_backend_core.ApiClient;
import com.capillary.platforms.ecom_backend_core.api.*;
import com.capillary.platforms.fileservice.api.LegacycontrollerApi;
import com.squareup.okhttp.ConnectionPool;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.beans.factory.annotation.*;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableSwagger2
@EnableAsync
public class App {

    private  String APP_NAME = "home-automation";

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
