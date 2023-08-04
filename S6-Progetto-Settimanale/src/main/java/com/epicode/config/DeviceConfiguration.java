package com.epicode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.model.Device;

@Configuration
public class DeviceConfiguration {
	
	@Bean("deviceBean")
	@Scope("prototype")
	public Device device() {
		return new Device();
	}

}
