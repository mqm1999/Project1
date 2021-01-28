package com.example.project1.helper.JDBCMapper;

import com.example.project1.dto.LedSauDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LedSauDTOMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        LedSauDTO ledSauDTO = new LedSauDTO();
        ledSauDTO.setID_ledSau(resultSet.getInt("ID_ledSau"));
        ledSauDTO.setMa_SP(resultSet.getString("Ma_sp"));
        ledSauDTO.setNCC(resultSet.getString("NCC"));
        ledSauDTO.setKT(resultSet.getString("KT"));
        ledSauDTO.setD(resultSet.getInt("D"));
        ledSauDTO.setR(resultSet.getInt("R"));
        ledSauDTO.setNgay_BD(resultSet.getString("Ngay_BD"));
        ledSauDTO.setTG_BH(resultSet.getInt("TG_BH"));
        ledSauDTO.setTG_con_lai(resultSet.getInt("TG_con_lai"));
        return ledSauDTO;
    }
}
