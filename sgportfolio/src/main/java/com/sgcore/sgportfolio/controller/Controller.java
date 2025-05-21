package com.sgcore.sgportfolio.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sgcore.sgportfolio.dto.PortfolioDto;
import com.sgcore.sgportfolio.entity.PortfolioEntity;
import com.sgcore.sgportfolio.entity.SectorEntity;
import com.sgcore.sgportfolio.service.PortfolioService;

@RestController
public class Controller {

	@Autowired
	PortfolioService portfolioService;
	
	@PostMapping("/uploadportfolio")
	public ResponseEntity<String> uploadPortfolio( @RequestParam("portfolioName") String portfolioName,
			
	        @RequestParam("portfolioDescription") String portfolioDescription,
	        @RequestParam("portfolioShow") Boolean portfolioShow,
	        @RequestParam("portfolioImage") MultipartFile portfolioImage,
	        @RequestParam("sectorId") int sectorId) throws IOException
	{
		System.out.println("got in");
		System.out.println("service name"+portfolioName);
		System.out.println("service image"+portfolioImage);
		return portfolioService.addportfolio(portfolioName,portfolioDescription,portfolioShow,portfolioImage,sectorId);
		
	}
	
	@GetMapping("/getportfolio")
	public ResponseEntity<List<PortfolioDto>> getServices()
	{
		System.out.println("got");
		return portfolioService.getPortfolios();
	}
	@GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
    	System.out.println("second");
        return portfolioService.findById(id);
    }
    @GetMapping("/getSelectedportfolio")
    public ResponseEntity<List<PortfolioDto>> getSelectedServices()
    {
    	return portfolioService.getSelectedPortfolios();
    }
    @PutMapping("/updateShow/{id}")
    public ResponseEntity<String> updateShow(@PathVariable int id, @RequestBody PortfolioDto portfolioDto )
    {
    	System.out.println("got into update");
    	System.out.println("in controller"+portfolioDto.isPortfolioShow());
    	return portfolioService.updateShow(id,portfolioDto);
    }
    
    @PutMapping("/updateportfolio")
	public ResponseEntity<String> updatePortfolio(@RequestParam("portfolioid") int portfolioId, @RequestParam("portfolioName") String portfolioName,
	        @RequestParam("portfolioDescription") String portfolioDescription,
	        @RequestParam("portfolioShow") Boolean portfolioShow,
	        @RequestParam("portfolioImage") MultipartFile portfolioImage,
	        @RequestParam("sectorId") int sectorId) throws IOException
	{
		System.out.println("got in");
		System.out.println("service name"+portfolioName);
		System.out.println("service image"+portfolioImage);
		System.out.println("service portfolioid"+portfolioId);
		return portfolioService.updateportfolio(portfolioId,portfolioName,portfolioDescription,portfolioShow,portfolioImage,sectorId);
		
	}
//    methods for Sectors______________________________________________________
	@PostMapping("/uploadsector")
	public ResponseEntity<SectorEntity> uploadSector( @RequestParam("sectorName") String sectorName,  @RequestParam("sectorImage") MultipartFile sectorImage ) throws IOException{
		return portfolioService.uploadSector(sectorName,sectorImage);
	}
	
	@GetMapping("/getSectors")
	public ResponseEntity<List<SectorEntity>> getSectors()
	{
		return portfolioService.getSectors();
	}

}

