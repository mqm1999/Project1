package com.example.project1.service;

import com.example.project1.dto.LedTrongDTO;
import com.example.project1.dto.LedTruocDTO;
import com.example.project1.repository.LedTruocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedTruocService {
    @Autowired
    LedTruocRepository ledTruocRepository;

    public List<LedTruocDTO> getAllLedTruoc(Integer sortType) {
        try {
            if (sortType == null) {
                return ledTruocRepository.getAllLedTruocASC();
            } else if (sortType == 1) {
                return ledTruocRepository.getAllLedTruocDESC();
            } else {
                return ledTruocRepository.getAllLedTruocASC();
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public LedTruocDTO getLedTruocByID(Integer ID_ledTruoc) {
        return ledTruocRepository.getLedTruocByID(ID_ledTruoc);
    }

    public Boolean addLedTruoc(LedTruocDTO ledTruocDTO) {
        if (!ledTruocRepository.checkLedTruocExistedByID(ledTruocDTO.getID_ledTruoc())) {
            if (ledTruocRepository.addLedTruoc(ledTruocDTO) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean updateLedTruoc(LedTruocDTO ledTruocDTO) {
        LedTruocDTO ledTruocDTOResponse = ledTruocRepository.getLedTruocByID(ledTruocDTO.getID_ledTruoc());
        if (ledTruocRepository.checkLedTruocExistedByID(ledTruocDTOResponse.getID_ledTruoc())) {
            if (ledTruocDTO.getMa_sp() != null) {
                ledTruocDTOResponse.setMa_sp(ledTruocDTO.getMa_sp());
            }
            if (ledTruocDTO.getNCC() != null) {
                ledTruocDTOResponse.setNCC((ledTruocDTO.getNCC()));
            }
            if (ledTruocDTO.getKT() != null) {
                ledTruocDTOResponse.setKT(ledTruocDTO.getKT());
            }
            if (ledTruocDTO.getD() != null) {
                ledTruocDTOResponse.setD(ledTruocDTO.getD());
            }
            if (ledTruocDTO.getR() != null) {
                ledTruocDTOResponse.setR(ledTruocDTO.getR());
            }
            if (ledTruocDTO.getNgay_BD() != null) {
                ledTruocDTOResponse.setNgay_BD(ledTruocDTO.getNgay_BD());
            }
            if (ledTruocDTO.getTG_BH() != null) {
                ledTruocDTOResponse.setTG_BH(ledTruocDTO.getTG_BH());
            }
            if (ledTruocDTO.getTG_con_lai() != null) {
                ledTruocDTOResponse.setTG_con_lai(ledTruocDTO.getTG_con_lai());
            }
            if (ledTruocRepository.updateLedTruoc(ledTruocDTOResponse) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteLedTruoc(Integer ID_ledTruoc) {
        try {
            if (ledTruocRepository.checkLedTruocExistedByID(ID_ledTruoc)) {
                if (ledTruocRepository.deleteLedTruoc(ID_ledTruoc) != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
