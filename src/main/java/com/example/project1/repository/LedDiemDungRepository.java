package com.example.project1.repository;

import com.example.project1.dto.LedDiemDungDTO;
import com.example.project1.helper.JDBCMapper.LedDiemDungDTOMapper;
import com.example.project1.helper.JDBCMapper.XeBusDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LedDiemDungRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<LedDiemDungDTO> getAllLedDiemDungASC() {
        String sql = "select * from led_diem_dung order by ID_ledDiemDung ASC;";
        return jdbcTemplate.query(sql, new LedDiemDungDTOMapper());
    }

    public List<LedDiemDungDTO> getAllLedDiemDungDESC() {
        String sql = "select * from led_diem_dung order by ID_ledDiemDung DESC;";
        return jdbcTemplate.query(sql, new LedDiemDungDTOMapper());
    }

    public Boolean checkLedDiemDungExistedByID(Integer ID_ledDiemDung) {
        String sql = "select existed (select * from led_diem_dung where ID_ledDiemDung = ?);";
        Object[] params = {ID_ledDiemDung};
        return jdbcTemplate.queryForObject(sql, Boolean.class , params);
    }

    public LedDiemDungDTO getLedDiemDungByID(Integer ID_ledDiemDungTT) {
        String sql = "select * from led_diem_dung where ID_ledDiemDungTT = ?;";
        Object[] params = {ID_ledDiemDungTT};
        return (LedDiemDungDTO) jdbcTemplate.query(sql, new LedDiemDungDTOMapper(), params);
    }

    public Integer addLedDiemDung(LedDiemDungDTO ledDiemDungDTO) {
        String sql = "insert into led_diem_dung (ID_ledDiemDungTT, Ma_sp, NCC, KT, D, R, Ngay_BD, TG_BH, TG_con_lai) values (?,?,?,?,?,?,?,?,?);";
        Object[] params = {ledDiemDungDTO.getID_ledDiemDungTT(), ledDiemDungDTO.getMa_sp(), ledDiemDungDTO.getNCC(), ledDiemDungDTO.getKT(), ledDiemDungDTO.getD(), ledDiemDungDTO.getR(), ledDiemDungDTO.getNgay_BD(), ledDiemDungDTO.getTG_BH(), ledDiemDungDTO.getTG_con_lai()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer updateLedDiemDung(LedDiemDungDTO ledDiemDungDTO) {
        String sql = "update led_diem_dung set Ma_sp = ?, NCC = ?, KT = ?, D = ?, R = ?, Ngay_BD = ?, TG_BH = ?, TG_con_lai = ? where ID_ledDiemDungTT = ?;";
        Object[] params = {ledDiemDungDTO.getMa_sp(), ledDiemDungDTO.getNCC(), ledDiemDungDTO.getKT(), ledDiemDungDTO.getD(), ledDiemDungDTO.getR(), ledDiemDungDTO.getNgay_BD(), ledDiemDungDTO.getTG_BH(), ledDiemDungDTO.getTG_con_lai(), ledDiemDungDTO.getID_ledDiemDungTT()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer deleteLedDiemDung(Integer ID_ledDiemDungTT) {
        String sql = "delete from led_diem_dung where ID_ledDiemDungTT = ?;";
        Object[] params = {ID_ledDiemDungTT};
        return jdbcTemplate.update(sql, params);
    }
}
