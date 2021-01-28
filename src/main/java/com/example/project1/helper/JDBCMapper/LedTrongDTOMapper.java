package com.example.project1.helper.JDBCMapper;

import com.example.project1.dto.LedTrongDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LedTrongDTOMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        LedTrongDTO ledTrongDTO = new LedTrongDTO();
        ledTrongDTO.setID_ledTrong(resultSet.getInt("ID_ledTrong"));
        ledTrongDTO.setMa_sp(resultSet.getString("Ma_sp"));
        ledTrongDTO.setNCC(resultSet.getString("NCC"));
        ledTrongDTO.setKT(resultSet.getString("KT"));
        ledTrongDTO.setD(resultSet.getInt("D"));
        ledTrongDTO.setR(resultSet.getInt("R"));
        ledTrongDTO.setNgay_BD(resultSet.getString("Ngay_BD"));
        ledTrongDTO.setTG_BH(resultSet.getInt("TG_BH"));
        ledTrongDTO.setTG_con_lai(resultSet.getInt("TG_con_lai"));
        return ledTrongDTO;
    }
}
