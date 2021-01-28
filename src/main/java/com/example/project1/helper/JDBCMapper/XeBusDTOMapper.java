package com.example.project1.helper.JDBCMapper;

import com.example.project1.dto.XeBusDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class XeBusDTOMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        XeBusDTO xeBusDTO = new XeBusDTO();
        xeBusDTO.setBKS(resultSet.getString("BKS"));
        xeBusDTO.setTT(resultSet.getInt("TT"));
        xeBusDTO.setTuyen(resultSet.getString("Tuyen"));
        xeBusDTO.setNam_SX(resultSet.getInt("Nam_SX"));
        xeBusDTO.setNam_Lap_led(resultSet.getInt("Nam_Lap_led"));
        return xeBusDTO;
    }
}
