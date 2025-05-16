package com.sgcore.sgportfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgcore.sgportfolio.entity.PortfolioEntity;

@Repository
public interface PortfolioRepo extends JpaRepository<PortfolioEntity, Integer>{

	List<PortfolioEntity> findByPortfolioShow(boolean b);

}
