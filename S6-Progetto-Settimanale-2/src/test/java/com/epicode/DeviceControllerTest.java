package com.epicode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.epicode.enumerations.DeviceState;
import com.epicode.enumerations.DeviceType;
import com.epicode.model.Device;
import com.epicode.repositories.DeviceRepository;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
//@ComponentScan(basePackages = "com.epicode")
class DeviceControllerTest {
	
	@Autowired TestRestTemplate restTemplate;
	@Autowired DeviceRepository repo;
	@Autowired @Qualifier("deviceBean") ObjectProvider<Device> deviceProvider;
	//@Autowired MockMvc mockMvc;

	@Test
	void testSuccessGetById() {
		Device d = deviceProvider.getObject();
		d.setState(DeviceState.AVAILABLE);
		d.setDeviceType(DeviceType.SMARTPHONE);
		repo.save(d);
		
		String url = "http://localhost:8080/api/devices/" + d.getId();
		ResponseEntity<Device> resp = restTemplate.getForEntity(url, Device.class);
		
		Device testDevice = resp.getBody();
		HttpStatusCode code = resp.getStatusCode();
		
		
		assertThat(code).isEqualTo(HttpStatus.OK);
		assertThat(testDevice.getId()).isEqualTo(d.getId());
	}
	
	@Test
	void testFailGetByID() {
				
		String url = "http://localhost:8080/api/devices/999" ;
		ResponseEntity<String> resp = restTemplate.getForEntity(url, String.class);
		
		HttpStatusCode code = resp.getStatusCode();
		
		
		assertThat(code).isEqualTo(HttpStatus.NOT_FOUND);
		
	}
	
//	@Test
//	void testCreateDevice() throws Exception {
//		ResultActions result = mockMvc.perform(
//                    MockMvcRequestBuilders.post("http://localhost:8080/api/devices")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content("{\"state\": \"AVAILABLE\", \"deviceType\": \"SMARTPHONE\"}")
//                    );
//		result.andExpect(MockMvcResultMatchers.status().isOk());
//	}

}
