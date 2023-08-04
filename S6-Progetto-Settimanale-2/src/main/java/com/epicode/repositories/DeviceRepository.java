package com.epicode.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.epicode.enumerations.DeviceType;
import com.epicode.model.Device;

public interface DeviceRepository extends CrudRepository<Device, Long>{
     
	  Optional<Device> findByDeviceType(DeviceType deviceType);
	  
	  boolean existsById(Long id);
		
}
