package com.example.project1.helper.JDBCMapper;

import com.example.project1.dto.LedDiemDungDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LedDiemDungDTOMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        LedDiemDungDTO ledDiemDungDTO = new LedDiemDungDTO();
        ledDiemDungDTO.setID_ledDiemDungTT(resultSet.getInt("ID_ledDiemDungTT"));
        ledDiemDungDTO.setMa_sp(resultSet.getString("Ma_sp"));
        ledDiemDungDTO.setNCC(resultSet.getString("NCC"));
        ledDiemDungDTO.setKT(resultSet.getString("KT"));
        ledDiemDungDTO.setD(resultSet.getInt("D"));
        ledDiemDungDTO.setR(resultSet.getInt("R"));
        ledDiemDungDTO.setNgay_BD(resultSet.getString("Ngay_BD"));
        ledDiemDungDTO.setTG_BH(resultSet.getInt("TG_BH"));
        ledDiemDungDTO.setTG_con_lai(resultSet.getInt("TG_con_lai"));
        return ledDiemDungDTO;
    }
}
