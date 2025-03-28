package com.ali.wahaj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ali.wahaj.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
