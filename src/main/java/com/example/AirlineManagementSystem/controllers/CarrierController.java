package com.example.AirlineManagementSystem.controllers;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.AirlineManagementSystem.beans.Carrier;
import com.example.AirlineManagementSystem.service.CarrierService;


@RestController
@RequestMapping("carrier")
public class CarrierController {
	
	@Autowired
    private Environment env;
	
	@Autowired
	CarrierService carrierService;
	
	@GetMapping("getAllCarriers")
	public List<Carrier> getAllCarriers() {
		List<Carrier> carrierList = carrierService.getAllCarriers();
		carrierList.forEach(c -> System.out.println(c));
		return carrierList;
	}
	
	@GetMapping("getCarrierById")
	public ResponseEntity<Carrier> getCarrierById(@RequestParam Integer id) {
		Carrier carrier = carrierService.getCarrierById(id);
		return ResponseEntity.ok().header("getCarrierById", Integer.valueOf(id).toString()).body(carrier);
	}
	
	@PostMapping(value = "addCarrier")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> addCarrier(@RequestBody Carrier carrier) {
		System.out.println(carrier);
		carrierService.addCarrier(carrier);
		return ResponseEntity.ok().build();
	} 
	
	@PutMapping("updateCarrier")
	@ResponseStatus(HttpStatus.OK)
	public Carrier updateCarrier(@RequestBody Carrier carrier) {
		return carrierService.updateCarrier(carrier);
	}

	@DeleteMapping("deleteCarrierById/{id}")
	public ResponseEntity<String> deleteCarrierById(@PathVariable Integer id) {
		System.out.println("Deleting carrier with ID: " + id);
		carrierService.deleteCarrierById(id);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "GET,POST,OPTIONS,DELETE,PUT");
	    
	    return new ResponseEntity<>("Carrier deleted successfully", responseHeaders, HttpStatus.OK);
	}
	
	// Endpoint to delete multiple carriers by IDs
	@DeleteMapping("deleteMultipleCarriers")
	public Integer[] deleteMultipleCarriers(@RequestParam Integer[] id) {
		return carrierService.deleteMultipleCarriers(id);
	}
	
	// Endpoint to delete all carriers
	@DeleteMapping("deleteAllCarriers")
	public void deleteAllCarriers() {
		carrierService.deleteAllCarriers();
	}
	
	// Endpoint to get environment details (similar to ProductController's env endpoint)
	@GetMapping("/env")
	public Map<String, String> getEnvDetails() {
        String server = env.getProperty("server.port");
        String database = env.getProperty("spring.jpa.database-platform");
        String h2console = env.getProperty("spring.h2.console.enabled");
        String logFile = env.getProperty("logging.file.name");

        Map<String, String> map = new HashMap<>();
        map.put("server", server);
        map.put("database", database);
        map.put("h2console-Enabled", h2console);
        map.put("Log File", logFile);

        return map;
    }
}