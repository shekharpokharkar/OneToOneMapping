package com.shekhar.service;

import java.util.List;
import java.util.Map;

import com.shekhar.DTO.AddressDTO;

public interface AddressService {

	AddressDTO partialUpdateAddress(Long addressId, Map<String, Object> addressInfo);

	AddressDTO deleteAddressById(Long addressId);

	AddressDTO updateAddress(Long addressId, AddressDTO address);

	AddressDTO getAddressById(Long studentId);

	List<AddressDTO> getAllAddress();

	AddressDTO saveAddress(Long studentId, AddressDTO address);

}
