package com.example.project1.helper.JDBCMapper;

import com.example.project1.dto.LoaiXeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoaiXeDTOMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        LoaiXeDTO loaiXeDTO = new LoaiXeDTO();
        loaiXeDTO.setChung_loai(resultSet.getString("Chung_loai"));
        loaiXeDTO.setSuc_chua(resultSet.getInt("Suc_chua"));
        return loaiXeDTO;
    }
}
