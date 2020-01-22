package com.tucanoo.springbootlil.data.repository;

import com.tucanoo.springbootlil.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

}
