package com.me.springboot.sample.secure.oauth2.resource;

import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {
	Iterable<Flight> findAll();
	
	Flight findOne(Long aLong);
	
	<S extends Flight> S save(S entity);
}
