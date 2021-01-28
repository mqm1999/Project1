package com.example.project1.dto;

public class TuyenBusDTO {
    private String Tuyen;
    private String cty;
    private String Don_vi;
    private String Chung_loai;
    private Integer ID_ledDiemDung;
    private Integer ID_ledTruoc;
    private Integer ID_ledSuon;
    private Integer ID_ledSau;
    private Integer ID_ledTrong;

    public TuyenBusDTO() {
    }

    public TuyenBusDTO(String tuyen, String cty, String don_vi, String chung_loai, Integer ID_ledDiemDung, Integer ID_ledTruoc, Integer ID_ledSuon, Integer ID_ledSau, Integer ID_ledTrong) {
        Tuyen = tuyen;
        this.cty = cty;
        Don_vi = don_vi;
        Chung_loai = chung_loai;
        this.ID_ledDiemDung = ID_ledDiemDung;
        this.ID_ledTruoc = ID_ledTruoc;
        this.ID_ledSuon = ID_ledSuon;
        this.ID_ledSau = ID_ledSau;
        this.ID_ledTrong = ID_ledTrong;
    }

    public String getTuyen() {
        return Tuyen;
    }

    public void setTuyen(String tuyen) {
        Tuyen = tuyen;
    }

    public String getCty() {
        return cty;
    }

    public void setCty(String cty) {
        this.cty = cty;
    }

    public String getDon_vi() {
        return Don_vi;
    }

    public void setDon_vi(String don_vi) {
        Don_vi = don_vi;
    }

    public String getChung_loai() {
        return Chung_loai;
    }

    public void setChung_loai(String chung_loai) {
        Chung_loai = chung_loai;
    }

    public Integer getID_ledDiemDung() {
        return ID_ledDiemDung;
    }

    public void setID_ledDiemDung(Integer ID_ledDiemDung) {
        this.ID_ledDiemDung = ID_ledDiemDung;
    }

    public Integer getID_ledTruoc() {
        return ID_ledTruoc;
    }

    public void setID_ledTruoc(Integer ID_ledTruoc) {
        this.ID_ledTruoc = ID_ledTruoc;
    }

    public Integer getID_ledSuon() {
        return ID_ledSuon;
    }

    public void setID_ledSuon(Integer ID_ledSuon) {
        this.ID_ledSuon = ID_ledSuon;
    }

    public Integer getID_ledSau() {
        return ID_ledSau;
    }

    public void setID_ledSau(Integer ID_ledSau) {
        this.ID_ledSau = ID_ledSau;
    }

    public Integer getID_ledTrong() {
        return ID_ledTrong;
    }

    public void setID_ledTrong(Integer ID_ledTrong) {
        this.ID_ledTrong = ID_ledTrong;
    }
}
