package com.epicode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.enumerations.DeviceState;
import com.epicode.enumerations.DeviceType;
import com.epicode.model.Device;
import com.epicode.service.DeviceService;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
	
	@Autowired DeviceService devService;
	
	@GetMapping
	public ResponseEntity<List<Device>> getAll() {
		List<Device> listaDevice = devService.findAll();
		return new ResponseEntity<List<Device>>(listaDevice, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		Device d = devService.findById(id);
		return new ResponseEntity<Device>(d, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createDevice(@RequestBody Device device) {
		Device d = devService.createDevice(device);
		return new ResponseEntity<Device>(d, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateDevice(@PathVariable Long id, @RequestBody Device device) {
		Device d = devService.modificaDevice(id, device);
		return new ResponseEntity<Device>(d, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeDevice(@PathVariable Long id) {
		String msg = devService.rimuoviDeviceById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
