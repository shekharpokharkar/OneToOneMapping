package com.shekhar.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shekhar.DTO.AddressDTO;
import com.shekhar.service.AddressService;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping(value = "/{studentId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	private ResponseEntity<AddressDTO> addAddress(@PathVariable("studentId") Long studentId,
			@RequestBody AddressDTO address) {
		AddressDTO dto = addressService.saveAddress(studentId, address);
		return new ResponseEntity<AddressDTO>(dto, HttpStatus.CREATED);
	}

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	private ResponseEntity<List<AddressDTO>> getAllAddress() {
		List<AddressDTO> dto = addressService.getAllAddress();
		return new ResponseEntity<List<AddressDTO>>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "/{studentId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	private ResponseEntity<AddressDTO> getAddressById(@PathVariable("studentId") Long studentId) {
		AddressDTO dto = addressService.getAddressById(studentId);
		return new ResponseEntity<AddressDTO>(dto, HttpStatus.OK);
	}

	@PutMapping(value = "/{addressId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	private ResponseEntity<AddressDTO> updateAddress(@PathVariable("addressId") Long addressId,
			@RequestBody AddressDTO address) {
		AddressDTO dto = addressService.updateAddress(addressId, address);
		return new ResponseEntity<AddressDTO>(dto, HttpStatus.ACCEPTED);
	}

	@PatchMapping(value = "/{addressId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	private ResponseEntity<AddressDTO> partialUpdateAddress(@PathVariable("addressId") Long addressId,
			@RequestBody Map<String, Object> addressInfo) {
		AddressDTO dto = addressService.partialUpdateAddress(addressId, addressInfo);
		return new ResponseEntity<AddressDTO>(dto, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/{addressId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	private ResponseEntity<AddressDTO> deleteAddressById(@PathVariable("addressId") Long addressId) {
		AddressDTO dto = addressService.deleteAddressById(addressId);
		return new ResponseEntity<AddressDTO>(dto, HttpStatus.OK);
	}

}
