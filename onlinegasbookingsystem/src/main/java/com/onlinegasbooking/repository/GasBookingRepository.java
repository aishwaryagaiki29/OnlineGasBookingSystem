package com.onlinegasbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinegasbooking.entity.GasBooking;

@Repository
public interface GasBookingRepository extends JpaRepository<GasBooking, Integer> {



}
