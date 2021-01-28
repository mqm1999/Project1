package com.example.project1.repository;

import com.example.project1.dto.LedSauDTO;
import com.example.project1.dto.LedSuonDTO;
import com.example.project1.helper.JDBCMapper.LedSauDTOMapper;
import com.example.project1.helper.JDBCMapper.LedSuonDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LedSuonRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<LedSuonDTO> getAllLedSuonASC() {
        String sql = "select * from led_suon order by ID_ledSuon ASC;";
        return jdbcTemplate.query(sql, new LedSuonDTOMapper());
    }

    public List<LedSuonDTO> getAllLedSuonDESC() {
        String sql = "select * from led_suon order by ID_ledSuon DESC;";
        return jdbcTemplate.query(sql, new LedSuonDTOMapper());
    }

    public Boolean checkLedSuonExistedByID(Integer ID_ledSuon) {
        String sql = "select existed (select * from led_suon where ID_ledSuon = ?);";
        Object[] params = {ID_ledSuon};
        return jdbcTemplate.queryForObject(sql, Boolean.class , params);
    }

    public LedSuonDTO getLedSuonByID(Integer ID_ledSuon) {
        String sql = "select * from led_suon where ID_ledSuon = ?;";
        Object[] params = {ID_ledSuon};
        return (LedSuonDTO) jdbcTemplate.query(sql, new LedSuonDTOMapper(), params);
    }

    public Integer addLedSuon(LedSuonDTO ledSuonDTO) {
        String sql = "insert into led_suon (ID_ledSuon, Ma_sp, NCC, KT, D, R, Ngay_BD, TG_BH, TG_con_lai) values (?,?,?,?,?,?,?,?,?);";
        Object[] params = {ledSuonDTO.getID_ledSuon(), ledSuonDTO.getMa_sp(), ledSuonDTO.getNCC(), ledSuonDTO.getKT(), ledSuonDTO.getD(), ledSuonDTO.getR(), ledSuonDTO.getNgay_BD(), ledSuonDTO.getTG_BH(), ledSuonDTO.getTG_con_lai()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer updateLedSuon(LedSuonDTO ledSuonDTO) {
        String sql = "update led_suon set Ma_sp = ?, NCC = ?, KT = ?, D = ?, R = ?, Ngay_BD = ?, TG_BH = ?, TG_con_lai = ? where ID_ledSuon = ?;";
        Object[] params = {ledSuonDTO.getMa_sp(), ledSuonDTO.getNCC(), ledSuonDTO.getKT(), ledSuonDTO.getD(), ledSuonDTO.getR(), ledSuonDTO.getNgay_BD(), ledSuonDTO.getTG_BH(), ledSuonDTO.getTG_con_lai(), ledSuonDTO.getID_ledSuon()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer deleteLedSuon(Integer ID_ledSuon) {
        String sql = "delete from led_suon where ID_ledSuon = ?;";
        Object[] params = {ID_ledSuon};
        return jdbcTemplate.update(sql, params);
    }
}
