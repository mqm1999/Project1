package com.example.project1.repository;

import com.example.project1.dto.XeBusDTO;
import com.example.project1.helper.JDBCMapper.XeBusDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class XeBusRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // lay theo thu tu BKS tang dan
    public List<XeBusDTO> getAllBusASC() {
        String sql = "select * from xe_bus order by BKS ASC;";
        return jdbcTemplate.query(sql, new XeBusDTOMapper());
    }

    // lay theo thu tu BKS giam dan
    public List<XeBusDTO> getAllBusDESC() {
        String sql = "select * from xe_bus order by BKS DESC;";
        return jdbcTemplate.query(sql, new XeBusDTOMapper());
    }

    // lay bus theo bks
    public XeBusDTO getBusByBKS(String BKS) {
        String sql = "select * from xe_bus where lower(BKS) = lower(?);";
        Object[] params = {BKS};
        return (XeBusDTO) jdbcTemplate.queryForObject(sql, new XeBusDTOMapper(), params);
    }

    // lay bus theo TT
    public List<XeBusDTO> getBusByTT(Integer TT) {
        String sql = "select * from xe_bus where TT = ?;";
        Object[] params = {TT};
        return jdbcTemplate.query(sql, new XeBusDTOMapper(), params);
    }

    // check ton tai bus theo BKS
    public Boolean checkBusExistedByBKS(String BKS) {
        String sql = "select exists (select * from xe_bus where lower(BKS) = lower(?));";
        Object[] params = {BKS};
        return jdbcTemplate.queryForObject(sql, Boolean.class, params);
    }

    // check ton tai bus theo tuyen
    public Boolean checkBusExistedByTuyen(String Tuyen) {
        String sql = "select exists (select * from tuyen_bus where Tuyen = ?);";
        Object[] params = {Tuyen};
        return jdbcTemplate.queryForObject(sql, Boolean.class, params);
    }

    // them bus
    public Integer addBus(XeBusDTO xeBusDTO) {
        String sql = "insert into xe_bus(BKS, TT, Tuyen, Nam_Sx, Nam_Lap_led) values (?,?,?,?,?)";
        Object[] params = {xeBusDTO.getBKS(), xeBusDTO.getTT(), xeBusDTO.getTuyen(), xeBusDTO.getNam_SX(), xeBusDTO.getNam_Lap_led()};
        return jdbcTemplate.update(sql, params);
    }


    // update bus
    public Integer updateBus(XeBusDTO xeBusDTO) {
        String sql = "update xe_bus set TT = ?, Tuyen = ?, Nam_Sx = ?, Nam_Lap_led = ? where BKS = ?;";
        return jdbcTemplate.update(sql, xeBusDTO.getTT(), xeBusDTO.getTuyen(), xeBusDTO.getNam_SX(), xeBusDTO.getNam_Lap_led(), xeBusDTO.getBKS());
    }

    // delete bus
    public Integer deleteBus(String BKS) {
        String sql = "delete from xe_bus where BKS = ?;";
        Object[] params = {BKS};
        return jdbcTemplate.update(sql, params);
    }

}
