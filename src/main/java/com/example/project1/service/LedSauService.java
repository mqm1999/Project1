package com.example.project1.service;

import com.example.project1.dto.LedSauDTO;
import com.example.project1.repository.LedSauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedSauService {
    @Autowired
    LedSauRepository ledSauRepository;

    public List<LedSauDTO> getAllLedSau(Integer sortType) {
        try {
            if (sortType == null) {
                return ledSauRepository.getAllLedSauASC();
            } else if (sortType == 1) {
                return ledSauRepository.getAllLedSauDESC();
            } else {
                return ledSauRepository.getAllLedSauASC();
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public LedSauDTO getLedSauByID(Integer ID_ledSau) {
        return ledSauRepository.getLedSauByID(ID_ledSau);
    }

    public Boolean addLedSau(LedSauDTO ledSauDTO) {
        if (!ledSauRepository.checkLedSauExistedByID(ledSauDTO.getID_ledSau())) {
            if (ledSauRepository.addLedSau(ledSauDTO) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean updateLedSau(LedSauDTO ledSauDTO) {
        LedSauDTO ledSauDTOResponse = ledSauRepository.getLedSauByID(ledSauDTO.getID_ledSau());
        if (ledSauRepository.checkLedSauExistedByID(ledSauDTOResponse.getID_ledSau())) {
            if (ledSauDTO.getMa_SP() != null) {
                ledSauDTOResponse.setMa_SP(ledSauDTO.getMa_SP());
            }
            if (ledSauDTO.getNCC() != null) {
                ledSauDTOResponse.setNCC((ledSauDTO.getNCC()));
            }
            if (ledSauDTO.getKT() != null) {
                ledSauDTOResponse.setKT(ledSauDTO.getKT());
            }
            if (ledSauDTO.getD() != null) {
                ledSauDTOResponse.setD(ledSauDTO.getD());
            }
            if (ledSauDTO.getR() != null) {
                ledSauDTOResponse.setR(ledSauDTO.getR());
            }
            if (ledSauDTO.getNgay_BD() != null) {
                ledSauDTOResponse.setNgay_BD(ledSauDTO.getNgay_BD());
            }
            if (ledSauDTO.getTG_BH() != null) {
                ledSauDTOResponse.setTG_BH(ledSauDTO.getTG_BH());
            }
            if (ledSauDTO.getTG_con_lai() != null) {
                ledSauDTOResponse.setTG_con_lai(ledSauDTO.getTG_con_lai());
            }
            if (ledSauRepository.updateLedSau(ledSauDTOResponse) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteLedSau(Integer ID_ledSau) {
        try {
            if (ledSauRepository.checkLedSauExistedByID(ID_ledSau)) {
                if (ledSauRepository.deleteLedSau(ID_ledSau) != 0) {
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
