package com.example.project1.helper.JDBCMapper;

import com.example.project1.dto.LedSauDTO;
import com.example.project1.dto.LedSuonDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LedSuonDTOMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        LedSuonDTO ledSuonDTO = new LedSuonDTO();
        ledSuonDTO.setID_ledSuon(resultSet.getInt("ID_ledSuon"));
        ledSuonDTO.setMa_sp(resultSet.getString("Ma_sp"));
        ledSuonDTO.setNCC(resultSet.getString("NCC"));
        ledSuonDTO.setKT(resultSet.getString("KT"));
        ledSuonDTO.setD(resultSet.getInt("D"));
        ledSuonDTO.setR(resultSet.getInt("R"));
        ledSuonDTO.setNgay_BD(resultSet.getString("Ngay_BD"));
        ledSuonDTO.setTG_BH(resultSet.getInt("TG_BH"));
        ledSuonDTO.setTG_con_lai(resultSet.getInt("TG_con_lai"));
        return ledSuonDTO;
    }
}
