package com.ali.wahaj.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ali.wahaj.response.AddressResponse;

@FeignClient(url = "${address.service.url}", value = "address-feign-client", path = "/api/address")
//@FeignClient( value = "address-service", path = "/api/address")
public interface AddressFeignClient {

	@GetMapping("/getById/{id}")
	public AddressResponse getById(@PathVariable long id);

}
