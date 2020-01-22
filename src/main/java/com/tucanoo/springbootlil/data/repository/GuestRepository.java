package com.tucanoo.springbootlil.data.repository;

import com.tucanoo.springbootlil.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

}
