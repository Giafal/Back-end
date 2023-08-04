package com.epicode.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.enumerations.DeviceState;
import com.epicode.enumerations.DeviceType;
import com.epicode.model.Device;
import com.epicode.repositories.DeviceRepository;



@Service
public class DeviceService {
	
	Logger log = LoggerFactory.getLogger(DeviceService.class);
	@Autowired DeviceRepository repo;
	@Autowired @Qualifier("deviceBean") private ObjectProvider<Device> deviceProvider;
	
	
	public Device creaDevice(DeviceState state, DeviceType type) {
		Device d = deviceProvider.getObject();
		d.setState(state);
		d.setDeviceType(type);
		repo.save(d);
		log.info("Device " + d.getDeviceType() + " salvato nel DB!!!");
		return d;
	}
	
	public void modificaDevice(Device d) {
		repo.save(d);
		log.info("Device " + d.getDeviceType() + " modificato nel DB!!!");
	}
	
	public Device findById(Long id) {
		return repo.findById(id).get();
	}
	
	public void findAll() {
		repo.findAll().forEach(e -> System.out.println(e));
	}
	
	public void rimuoviDevice(Device e) {
		repo.delete(e);
		log.info("Device " + e.getDeviceType() + " eliminato dal DB!!!");
	}

}
