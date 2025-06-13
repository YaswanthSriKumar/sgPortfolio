package com.sgcore.sgportfolio.repository;

import com.sgcore.sgportfolio.entity.SectorEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepo extends JpaRepository<SectorEntity,Integer> {

	
}
