package com.example.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tuyen_bus {
    private String Tuyen;
    private String cty;
    private String Don_vi;
    private String Chung_loai;
    private int ID_ledDiemDung;
    private int ID_ledTruoc;
    private int ID_ledSuon;
    private int ID_ledSau;
    private int ID_ledTrong;
}
