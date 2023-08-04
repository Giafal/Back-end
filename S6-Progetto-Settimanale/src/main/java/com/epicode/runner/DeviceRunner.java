package com.epicode.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.enumerations.DeviceState;
import com.epicode.enumerations.DeviceType;
import com.epicode.model.Device;
import com.epicode.service.DeviceService;

@Component
public class DeviceRunner implements CommandLineRunner {
	
	@Autowired DeviceService deviceService;

	@Override
	public void run(String... args) throws Exception {
		//setDevices();
		
	}
	
	private void setDevices() {
		Device smartphone = deviceService.creaDevice(DeviceState.AVAILABLE, DeviceType.SMARTPHONE);
		Device tablet = deviceService.creaDevice(DeviceState.AVAILABLE, DeviceType.TABLET);
		Device laptop = deviceService.creaDevice(DeviceState.AVAILABLE, DeviceType.LAPTOP);
	}

}
