package com.sgcore.sgportfolio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="portfolio")
public class PortfolioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int portfolioId;
	private String portfolioName;
	@Lob
	private byte[] portfolioImage;
	@Column(name="portfolio_discription")
	private String portfolioDescription;
	private boolean portfolioShow;
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
	public byte[] getPortfolioImage() {
		return portfolioImage;
	}
	public void setPortfolioImage(byte[] portfolioImage) {
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
