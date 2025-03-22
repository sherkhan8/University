package com.ali.wahaj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ali.wahaj.entity.Student;
import com.ali.wahaj.feignclients.AddressFeignClient;
import com.ali.wahaj.repository.StudentRepository;
import com.ali.wahaj.request.CreateStudentRequest;
import com.ali.wahaj.response.AddressResponse;
import com.ali.wahaj.response.StudentResponse;

import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	WebClient webClient;
	
	@Autowired
	AddressFeignClient addressFeignClient;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());

		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);

		StudentResponse studentResponse = new StudentResponse(student);
		//studentResponse.setAddressResponse(addressResponse(student.getAddressId()));
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));

		return studentResponse;
	}

	public StudentResponse getById(long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		//studentResponse.setAddressResponse(addressResponse(student.getAddressId()));
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		return studentResponse;
	}

	public AddressResponse addressResponse(long addressId) {
		Mono<AddressResponse> bodyToMono = webClient.get().uri("/getById/" + addressId).retrieve()
				.bodyToMono(AddressResponse.class);
		return bodyToMono.block();
	}
}
