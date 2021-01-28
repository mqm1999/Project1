package com.example.project1.helper.JDBCMapper;

import com.example.project1.dto.LedTrongDTO;
import com.example.project1.dto.LedTruocDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LedTruocDTOMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        LedTruocDTO ledTruocDTO = new LedTruocDTO();
        ledTruocDTO.setID_ledTruoc(resultSet.getInt("ID_ledTruoc"));
        ledTruocDTO.setMa_sp(resultSet.getString("Ma_sp"));
        ledTruocDTO.setNCC(resultSet.getString("NCC"));
        ledTruocDTO.setKT(resultSet.getString("KT"));
        ledTruocDTO.setD(resultSet.getInt("D"));
        ledTruocDTO.setR(resultSet.getInt("R"));
        ledTruocDTO.setNgay_BD(resultSet.getString("Ngay_BD"));
        ledTruocDTO.setTG_BH(resultSet.getInt("TG_BH"));
        ledTruocDTO.setTG_con_lai(resultSet.getInt("TG_con_lai"));
        return ledTruocDTO;
    }
}
