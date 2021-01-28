package com.example.project1.dto;

public class XeBusDTO {
    private String BKS;
    private Integer TT;
    private String Tuyen;
    private Integer Nam_SX;
    private Integer Nam_Lap_led;

    public XeBusDTO() {
    }

    public XeBusDTO(String BKS, Integer TT, String tuyen, Integer nam_SX, Integer nam_Lap_led) {
        this.BKS = BKS;
        this.TT = TT;
        Tuyen = tuyen;
        Nam_SX = nam_SX;
        Nam_Lap_led = nam_Lap_led;
    }

    public String getBKS() {
        return BKS;
    }

    public void setBKS(String BKS) {
        this.BKS = BKS;
    }

    public Integer getTT() {
        return TT;
    }

    public void setTT(Integer TT) {
        this.TT = TT;
    }

    public String getTuyen() {
        return Tuyen;
    }

    public void setTuyen(String tuyen) {
        Tuyen = tuyen;
    }

    public Integer getNam_SX() {
        return Nam_SX;
    }

    public void setNam_SX(Integer nam_SX) {
        Nam_SX = nam_SX;
    }

    public Integer getNam_Lap_led() {
        return Nam_Lap_led;
    }

    public void setNam_Lap_led(Integer nam_Lap_led) {
        Nam_Lap_led = nam_Lap_led;
    }
}


