package com.example.project1.repository;

import com.example.project1.dto.LedSauDTO;
import com.example.project1.helper.JDBCMapper.LedSauDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LedSauRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<LedSauDTO> getAllLedSauASC() {
        String sql = "select * from led_sau order by ID_ledSau ASC;";
        return jdbcTemplate.query(sql, new LedSauDTOMapper());
    }

    public List<LedSauDTO> getAllLedSauDESC() {
        String sql = "select * from led_sau order by ID_ledSau DESC;";
        return jdbcTemplate.query(sql, new LedSauDTOMapper());
    }

    public Boolean checkLedSauExistedByID(Integer ID_ledSau) {
        String sql = "select existed (select * from led_sau where ID_ledSau = ?);";
        Object[] params = {ID_ledSau};
        return jdbcTemplate.queryForObject(sql, Boolean.class , params);
    }

    public LedSauDTO getLedSauByID(Integer ID_ledSau) {
        String sql = "select * from led_sau where ID_ledSau = ?;";
        Object[] params = {ID_ledSau};
        return (LedSauDTO) jdbcTemplate.query(sql, new LedSauDTOMapper(), params);
    }

    public Integer addLedSau(LedSauDTO ledSauDTO) {
        String sql = "insert into led_sau (ID_ledSau, Ma_sp, NCC, KT, D, R, Ngay_BD, TG_BH, TG_con_lai) values (?,?,?,?,?,?,?,?,?);";
        Object[] params = {ledSauDTO.getID_ledSau(), ledSauDTO.getMa_SP(), ledSauDTO.getNCC(), ledSauDTO.getKT(), ledSauDTO.getD(), ledSauDTO.getR(), ledSauDTO.getNgay_BD(), ledSauDTO.getTG_BH(), ledSauDTO.getTG_con_lai()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer updateLedSau(LedSauDTO ledSauDTO) {
        String sql = "update led_sau set Ma_sp = ?, NCC = ?, KT = ?, D = ?, R = ?, Ngay_BD = ?, TG_BH = ?, TG_con_lai = ? where ID_ledSau = ?;";
        Object[] params = {ledSauDTO.getMa_SP(), ledSauDTO.getNCC(), ledSauDTO.getKT(), ledSauDTO.getD(), ledSauDTO.getR(), ledSauDTO.getNgay_BD(), ledSauDTO.getTG_BH(), ledSauDTO.getTG_con_lai(), ledSauDTO.getID_ledSau()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer deleteLedSau(Integer ID_ledSau) {
        String sql = "delete from led_sau where ID_ledSau = ?;";
        Object[] params = {ID_ledSau};
        return jdbcTemplate.update(sql, params);
    }
}
