package com.sgcore.sgportfolio.dto;

public class SectorDto {
    private int sectorId;
    private String sectorName;
    private byte[] sectorImage;

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
