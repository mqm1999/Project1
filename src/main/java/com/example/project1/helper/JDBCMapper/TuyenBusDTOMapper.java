package com.example.project1.helper.JDBCMapper;

import com.example.project1.dto.TuyenBusDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TuyenBusDTOMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        TuyenBusDTO tuyenBusDTO = new TuyenBusDTO();
        tuyenBusDTO.setTuyen(resultSet.getString("Tuyen"));
        tuyenBusDTO.setCty(resultSet.getString("cty"));
        tuyenBusDTO.setDon_vi(resultSet.getString("Don_vi"));
        tuyenBusDTO.setChung_loai(resultSet.getString("Chung_loai"));
        tuyenBusDTO.setID_ledDiemDung(resultSet.getInt("ID_ledDiemDungTT"));
        tuyenBusDTO.setID_ledTruoc(resultSet.getInt("ID_ledTruoc"));
        tuyenBusDTO.setID_ledSuon(resultSet.getInt("ID_ledSuon"));
        tuyenBusDTO.setID_ledSau(resultSet.getInt("ID_ledSau"));
        tuyenBusDTO.setID_ledTrong(resultSet.getInt("ID_ledTrong"));
        return tuyenBusDTO;
    }
}
