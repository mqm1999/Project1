package com.example.project1.repository;

import com.example.project1.dto.LoaiXeDTO;
import com.example.project1.helper.JDBCMapper.LoaiXeDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoaiXeRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<LoaiXeDTO> getAllLoaiXeASC() {
        String sql = "select * from loai_xe order by Chung_loai ASC;";
        return jdbcTemplate.query(sql, new LoaiXeDTOMapper());
    }

    public List<LoaiXeDTO> getAllLoaiXeDESC() {
        String sql = "select * from loai_xe order by Chung_loai DESC;";
        return jdbcTemplate.query(sql, new LoaiXeDTOMapper());
    }

    public Boolean checkLoaiXeExistedByChungLoai(String Chung_loai) {
        String sql = "select existed (select * from loai_xe where lower(Chung_loai) = lower(?));";
        Object[] params = {Chung_loai};
        return jdbcTemplate.queryForObject(sql, Boolean.class , params);
    }

    public LoaiXeDTO getLoaiXeByChungLoai(String Chung_loai) {
        String sql = "select * from loai_xe where lower(Chung_loai) = lower(?);";
        Object[] params = {Chung_loai};
        return (LoaiXeDTO) jdbcTemplate.query(sql, new LoaiXeDTOMapper(), params);
    }

    public Integer addLoaiXe(LoaiXeDTO loaiXeDTO) {
        String sql = "insert into loai_xe (Chung_loai, Suc_chua) values (?,?);";
        Object[] params = {loaiXeDTO.getChung_loai(), loaiXeDTO.getSuc_chua()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer updateLoaiXe(LoaiXeDTO loaiXeDTO) {
        String sql = "update loai_xe set Suc_chua = ? where Chung_loai = ?;";
        Object[] params = {loaiXeDTO.getSuc_chua(), loaiXeDTO.getChung_loai()};
        return jdbcTemplate.update(sql, params);
    }

    public Integer deleteLoaiXe(String Chung_loai) {
        String sql = "delete from loai_xe where lower(Chung_loai) = lower(?);";
        Object[] params = {Chung_loai};
        return jdbcTemplate.update(sql, params);
    }
}
