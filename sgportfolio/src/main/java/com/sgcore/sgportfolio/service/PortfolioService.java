package com.sgcore.sgportfolio.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.sgcore.sgportfolio.entity.SectorEntity;
import com.sgcore.sgportfolio.repository.SectorRepo;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sgcore.sgportfolio.dto.PortfolioDto;
import com.sgcore.sgportfolio.entity.PortfolioEntity;
import com.sgcore.sgportfolio.repository.PortfolioRepo;

@Service
public class PortfolioService {

	@Autowired
	PortfolioRepo portfolioRepo;
	@Autowired
	SectorRepo sectorRepo;
	public ResponseEntity<String> addportfolio(String portfolioName, String portfolioDescription, Boolean portfolioShow,
			MultipartFile portfolioImage,int sectorId) throws IOException {
		SectorEntity sectorEntity = sectorRepo.findById(sectorId)
		        .orElseThrow(() -> new EntityNotFoundException("Sector not found"));
		PortfolioEntity portfolioEntity = new PortfolioEntity();
		portfolioEntity.setPortfolioName(portfolioName);
		portfolioEntity.setPortfolioDescription(portfolioDescription);
		portfolioEntity.setPortfolioShow(portfolioShow);
		
		portfolioEntity.setSectorEntity(sectorEntity);
		if (portfolioImage != null && !portfolioImage.isEmpty()) {
            portfolioEntity.setPortfolioImage(portfolioImage.getBytes());
        } else {
            return ResponseEntity.badRequest().body("Image path is missing or invalid");
        }
		Optional<PortfolioEntity> result =Optional.of(portfolioRepo.save(portfolioEntity)) ;
		 if(result.isPresent())
	            return ResponseEntity.status(HttpStatus.CREATED).body("service uploaded successfully");
			else
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload service");
	}
	public ResponseEntity<List<PortfolioDto>> getPortfolios() {
		Optional<List<PortfolioEntity>>  result =Optional.of(portfolioRepo.findAll()) ;
		if(result.isPresent())
		{
			 // Convert entities to DTOs with image URLs
		    List<PortfolioDto> resultDto = result.get().stream().map(portfolio -> {
		    	PortfolioDto dto = new PortfolioDto();
		        dto.setPortfolioId(portfolio.getPortfolioId());
		        dto.setPortfolioName(portfolio.getPortfolioName());
		        dto.setPortfolioDescription(portfolio.getPortfolioDescription());
		        dto.setPortfolioShow(portfolio.isPortfolioShow());
		       
		        dto.setPortfolioImage("http://localhost:8088/SGPORTFOLIO/image/" + portfolio.getPortfolioId()); // Construct image URL
		        System.out.println( dto.getPortfolioImage());
		        portfolio.getSectorEntity().setSectorImage(null);
		        dto.setSector(portfolio.getSectorEntity());
		        return dto;
		    }).toList();
		    return ResponseEntity.status(HttpStatus.OK).body(resultDto);
		}
           
	
		else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	public ResponseEntity<byte[]> findById(int id) {
         Optional<PortfolioEntity> portfolio = portfolioRepo.findById(id);
		
		if(portfolio.isPresent())
		{
			System.out.println("sending ");
			 return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Adjust to IMAGE_PNG or other type if needed
	                .body(portfolio.get().getPortfolioImage());
		}
		else
		{
			System.out.println("notsending");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(portfolio.get().getPortfolioImage());
		}
	}
	public ResponseEntity<List<PortfolioDto>> getSelectedPortfolios() {
		Optional<List<PortfolioEntity>>  result =Optional.of(portfolioRepo.findByPortfolioShow(true)) ;
		if(result.isPresent())
		{
			 // Convert entities to DTOs with image URLs
		    List<PortfolioDto> servicesDtos = result.get().stream().map(portfolio -> {
		    	PortfolioDto dto = new PortfolioDto();
		        dto.setPortfolioId(portfolio.getPortfolioId());
		        dto.setPortfolioName(portfolio.getPortfolioName());
		        dto.setPortfolioDescription(portfolio.getPortfolioDescription());
		        dto.setPortfolioShow(portfolio.isPortfolioShow());
		       
		        dto.setPortfolioImage("http://localhost:8088/SGPORTFOLIO/image/" + portfolio.getPortfolioId()); // Construct image URL
		        System.out.println( dto.getPortfolioImage());
		        return dto;
		    }).toList();
		    return ResponseEntity.status(HttpStatus.CREATED).body(servicesDtos);
		}
           
	
		else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	public ResponseEntity<String> updateShow(int id, PortfolioDto portfolioDto) {
		Optional<PortfolioEntity> result =portfolioRepo.findById(id) ;
		if(result.isPresent())
		{
			result.get().setPortfolioShow(portfolioDto.isPortfolioShow());
			Optional<PortfolioEntity>  portfolioEntity =Optional.of(portfolioRepo.save(result.get()) );
			if (portfolioEntity.isPresent())
			{
				 return ResponseEntity.status(HttpStatus.OK).body("update successfull");
			}
			else
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("update fail");
				
			
		}
		
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("record not found");
	}
	public ResponseEntity<String> updateportfolio(int portfolioId, String portfolioName, String portfolioDescription,
			Boolean portfolioShow, MultipartFile portfolioImage,int sectorId) throws IOException {
		SectorEntity sectorEntity = sectorRepo.findById(sectorId)
		        .orElseThrow(() -> new EntityNotFoundException("Sector not found"));
		Optional<PortfolioEntity> dbresult= portfolioRepo.findById(portfolioId);
		if(dbresult.isPresent())
		{
			System.out.println("portfolio is present");
			PortfolioEntity portfolioEntity = new PortfolioEntity();
			portfolioEntity.setPortfolioId(portfolioId);
			portfolioEntity.setPortfolioName(portfolioName);
			portfolioEntity.setPortfolioDescription(portfolioDescription);
			portfolioEntity.setPortfolioShow(portfolioShow);
			
			portfolioEntity.setSectorEntity(sectorEntity);
			if (portfolioImage != null && !portfolioImage.isEmpty()) {
	            byte[] imageBytes = portfolioImage.getBytes(); // Read file as bytes
	            portfolioEntity.setPortfolioImage(imageBytes);
	        } else {
	            return ResponseEntity.badRequest().body("Image path is missing or invalid");
	        }
			Optional<PortfolioEntity> result =Optional.of(portfolioRepo.save(portfolioEntity)) ;
			 if(result.isPresent())
		            return ResponseEntity.status(HttpStatus.CREATED).body("service uploaded successfully");
				else
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload service");
			
		}
		else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");

		}
	}
	public ResponseEntity<SectorEntity> uploadSector(String sectorName, MultipartFile sectorImage) throws IOException {
		SectorEntity sectorEntity = new SectorEntity();
		sectorEntity.setSectorImage(sectorImage.getBytes());
		sectorEntity.setSectorName(sectorName);
		Optional<SectorEntity> result=Optional.of(sectorRepo.save(sectorEntity)) ;
		if(result.isPresent())
            return ResponseEntity.status(HttpStatus.CREATED).body(result.get());
		else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result.get());}
	}
	
	public ResponseEntity<List<SectorEntity>> getSectors() {
		Optional<List<SectorEntity>> result=Optional.of(sectorRepo.findAll()) ;
		
		if(result.isPresent()) {
			List<SectorEntity> sectorData=result.get().stream().map((sector)->{
				sector.setSectorImage(null);
				return sector;
			}).toList();
            return ResponseEntity.status(HttpStatus.OK).body(result.get());
		}
		else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result.get());}
	}


	

	

}
