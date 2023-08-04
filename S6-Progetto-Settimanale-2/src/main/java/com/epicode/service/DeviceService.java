package com.epicode.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.epicode.security.entity.User;

import jakarta.persistence.EntityNotFoundException;



@Service
public class DeviceService {
	
	Logger log = LoggerFactory.getLogger(DeviceService.class);
	@Autowired DeviceRepository repo;
	@Autowired UserService userService;
	@Autowired @Qualifier("deviceBean") private ObjectProvider<Device> deviceProvider;
	
	
	public Device creaDevice(DeviceState state, DeviceType type) {
		Device d = deviceProvider.getObject();
		d.setState(state);
		d.setDeviceType(type);
		repo.save(d);
		log.info("Device " + d.getDeviceType() + " salvato nel DB!!!");
		return d;
	}
	
	public Device modificaDevice(Long id, Device d) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Device not exists!!!");
		}
		if(id != d.getId()) {
			throw new EntityNotFoundException("Id and DeviceID do not match!");
		}
		return repo.save(d);
	}
	
	public Device findById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Device doesn't exists");
		}
		return repo.findById(id).get();
	}
	
	public List<Device> findAll() {
		return (List<Device>) repo.findAll();
	}
	
	public String rimuoviDeviceById(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Device not exists!!!");
		}
		Device d = findById(id);
		repo.delete(d);
		return "Device cancellato!!";
	}
	
	public void assegnaDevice(Device d, Long id) {
		if(d.getState() == DeviceState.AVAILABLE) {
			d.setState(DeviceState.ASSIGNED);
			Set<Device> devices = new HashSet<>();
			devices.add(d);
			User u = userService.findById(id);
			u.setDevices(devices);
			userService.modificaUser(u);
			System.out.println(u);
		}
		
	}
	
	public Device createDevice(Device d) {
		return repo.save(d);
	}

}
