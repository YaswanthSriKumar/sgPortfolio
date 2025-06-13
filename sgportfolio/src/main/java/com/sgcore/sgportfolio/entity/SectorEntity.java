package com.sgcore.sgportfolio.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sector")
public class SectorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sectorId;
    private String sectorName;
    @Lob
    private byte[] sectorImage;
    @OneToMany(mappedBy = "sectorEntity", cascade = CascadeType.ALL)
    private List<PortfolioEntity> portfolios;
 

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public byte[] getSectorImage() {
        return sectorImage;
    }

    public void setSectorImage(byte[] sectorImage) {
        this.sectorImage = sectorImage;
    }

    
}
