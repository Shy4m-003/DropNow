package com.scrop.dropnow.repository;

import com.scrop.dropnow.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Reservation_Repository extends CrudRepository<ReservationEntity,Long> {
    List<ReservationEntity> findAllByUserEntityId(long userId);
}
