package com.example.project1.dto;

public class LoaiXeDTO {
    private String Chung_loai;
    private Integer Suc_chua;

    public LoaiXeDTO() {
    }

    public LoaiXeDTO(String chung_loai, Integer suc_chua) {
        Chung_loai = chung_loai;
        Suc_chua = suc_chua;
    }

    public String getChung_loai() {

        return Chung_loai;
    }

    public void setChung_loai(String chung_loai) {
        Chung_loai = chung_loai;
    }

    public Integer getSuc_chua() {
        return Suc_chua;
    }

    public void setSuc_chua(Integer suc_chua) {
        Suc_chua = suc_chua;
    }

    @Override
    public String toString() {
        return "LoaiXeDTO{" +
                "Chung_loai='" + Chung_loai + '\'' +
                ", Suc_chua=" + Suc_chua +
                '}';
    }
}
