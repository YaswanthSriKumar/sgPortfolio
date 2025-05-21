package com.sgcore.sgportfolio.dto;

import com.sgcore.sgportfolio.entity.SectorEntity;

public class PortfolioDto {

	private int portfolioId;
	private String portfolioName;
	private String portfolioImage;
	private String portfolioDescription;
	private boolean portfolioShow;
	private SectorEntity sector;
	
	
	public SectorEntity getSector() {
		return sector;
	}
	public void setSector(SectorEntity sector) {
		this.sector = sector;
	}
	public int getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}
	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	public String getPortfolioImage() {
		return portfolioImage;
	}
	public void setPortfolioImage(String portfolioImage) {
		this.portfolioImage = portfolioImage;
	}
	public String getPortfolioDescription() {
		return portfolioDescription;
	}
	public void setPortfolioDescription(String portfolioDescription) {
		this.portfolioDescription = portfolioDescription;
	}
	public boolean isPortfolioShow() {
		return portfolioShow;
	}
	public void setPortfolioShow(boolean portfolioShow) {
		this.portfolioShow = portfolioShow;
	}
	
	
}
