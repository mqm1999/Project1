package com.example.project1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Led_Diem_Dung {
    private int ID_ledDiemDungTT;
    private String Ma_sp;
    private String NCC;
    private String KT;
    private int D;
    private int R;
    private String Ngay_BD;
    private int TG_BH;
    private int TG_con_lai;
}
