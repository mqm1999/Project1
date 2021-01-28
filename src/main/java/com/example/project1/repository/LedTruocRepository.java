package com.example.project1.repository;

import com.example.project1.dto.LedTruocDTO;
import com.example.project1.helper.JDBCMapper.LedTruocDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LedTruocRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<LedTruocDTO> getAllLedTruocASC() {
        String sql = "select * from led_truoc order by ID_ledTruoc ASC;";
        return jdbcTemplate.query(sql, new LedTruocDTOMapper());
    }

    public List<LedTruocDTO> getAllLedTruocDESC() {
        String sql = "select * from led_trong order by ID_ledTruoc DESC;";
        return jdbcTemplate.query(sql, new LedTruocDTOMapper());
    }

    public Boolean checkLedTruocExistedByID(Integer ID_ledTruoc) {
        String sql = "select existed (select * from led_truoc where ID_ledTruoc = ?);";
        Object[] params = {ID_ledTruoc};
        return jdbcTemplate.queryForObject(sql, Boolean.class , params);
    }

    public LedTruocDTO getLedTruocByID(Integer ID_ledTruoc) {
        String sql = "select * from led_truoc where ID_ledTruoc = ?;";
        Object[] params = {ID_ledTruoc};
        return (LedTruocDTO) jdbcTemplate.query(sql, new LedTruocDTOMapper(), params);
    }

    public Integer addLedTruoc(LedTruocDTO ledTruocDTO) {
        String sql = "insert into led_truoc (ID_ledTruoc, Ma_sp, NCC, KT, D, R, Ngay_BD, TG_BH, TG_con_lai) values (?,?,?,?,?,?,?,?,?);";
        Object[] params = {ledTruocDTO.getID_ledTruoc(), ledTruocDTO.getMa_sp(), ledTruocDTO.getNCC(), ledTruocDTO.getKT(), ledTruocDTO.getD(), ledTruocDTO.getR(), ledTruocDTO.getNgay_BD(), ledTruocDTO.getTG_BH(), ledTruocDTO.getTG_con_lai()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer updateLedTruoc(LedTruocDTO ledTruocDTO) {
        String sql = "update led_truoc set Ma_sp = ?, NCC = ?, KT = ?, D = ?, R = ?, Ngay_BD = ?, TG_BH = ?, TG_con_lai = ? where ID_ledTrong = ?;";
        Object[] params = {ledTruocDTO.getMa_sp(), ledTruocDTO.getNCC(), ledTruocDTO.getKT(), ledTruocDTO.getD(), ledTruocDTO.getR(), ledTruocDTO.getNgay_BD(), ledTruocDTO.getTG_BH(), ledTruocDTO.getTG_con_lai(), ledTruocDTO.getID_ledTruoc()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer deleteLedTruoc(Integer ID_ledTruoc) {
        String sql = "delete from led_truoc where ID_ledTruoc = ?;";
        Object[] params = {ID_ledTruoc};
        return jdbcTemplate.update(sql, params);
    }
}
