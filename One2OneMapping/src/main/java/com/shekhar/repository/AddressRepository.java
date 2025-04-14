package com.shekhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shekhar.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
