package com.example.project1.repository;

import com.example.project1.dto.LedSuonDTO;
import com.example.project1.dto.LedTrongDTO;
import com.example.project1.helper.JDBCMapper.LedSuonDTOMapper;
import com.example.project1.helper.JDBCMapper.LedTrongDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LedTrongRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<LedTrongDTO> getAllLedTrongASC() {
        String sql = "select * from led_trong order by ID_ledTrong ASC;";
        return jdbcTemplate.query(sql, new LedTrongDTOMapper());
    }

    public List<LedTrongDTO> getAllLedTrongDESC() {
        String sql = "select * from led_trong order by ID_ledTrong DESC;";
        return jdbcTemplate.query(sql, new LedTrongDTOMapper());
    }

    public Boolean checkLedTrongExistedByID(Integer ID_ledTrong) {
        String sql = "select existed (select * from led_trong where ID_ledTrong = ?);";
        Object[] params = {ID_ledTrong};
        return jdbcTemplate.queryForObject(sql, Boolean.class , params);
    }

    public LedTrongDTO getLedTrongByID(Integer ID_ledTrong) {
        String sql = "select * from led_trong where ID_ledTrong = ?;";
        Object[] params = {ID_ledTrong};
        return (LedTrongDTO) jdbcTemplate.query(sql, new LedTrongDTOMapper(), params);
    }

    public Integer addLedTrong(LedTrongDTO ledTrongDTO) {
        String sql = "insert into led_trong (ID_ledTrong, Ma_sp, NCC, KT, D, R, Ngay_BD, TG_BH, TG_con_lai) values (?,?,?,?,?,?,?,?,?);";
        Object[] params = {ledTrongDTO.getID_ledTrong(), ledTrongDTO.getMa_sp(), ledTrongDTO.getNCC(), ledTrongDTO.getKT(), ledTrongDTO.getD(), ledTrongDTO.getR(), ledTrongDTO.getNgay_BD(), ledTrongDTO.getTG_BH(), ledTrongDTO.getTG_con_lai()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer updateLedTrong(LedTrongDTO ledTrongDTO) {
        String sql = "update led_trong set Ma_sp = ?, NCC = ?, KT = ?, D = ?, R = ?, Ngay_BD = ?, TG_BH = ?, TG_con_lai = ? where ID_ledTrong = ?;";
        Object[] params = {ledTrongDTO.getMa_sp(), ledTrongDTO.getNCC(), ledTrongDTO.getKT(), ledTrongDTO.getD(), ledTrongDTO.getR(), ledTrongDTO.getNgay_BD(), ledTrongDTO.getTG_BH(), ledTrongDTO.getTG_con_lai(), ledTrongDTO.getID_ledTrong()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer deleteLedTrong(Integer ID_ledTrong) {
        String sql = "delete from led_trong where ID_ledTrong = ?;";
        Object[] params = {ID_ledTrong};
        return jdbcTemplate.update(sql, params);
    }
}
