package com.oreste.eTokens.repository;

import com.oreste.eTokens.entity.Meter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterRepository extends JpaRepository<Meter,Long> {
}
