package com.example.project1.service;

import com.example.project1.dto.LedTrongDTO;
import com.example.project1.repository.LedTrongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedTrongService {
    @Autowired
    LedTrongRepository ledTrongRepository;

    public List<LedTrongDTO> getAllLedTrong(Integer sortType) {
        try {
            if (sortType == null) {
                return ledTrongRepository.getAllLedTrongASC();
            } else if (sortType == 1) {
                return ledTrongRepository.getAllLedTrongDESC();
            } else {
                return ledTrongRepository.getAllLedTrongASC();
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public LedTrongDTO getLedTrongByID(Integer ID_ledTrong) {
        return ledTrongRepository.getLedTrongByID(ID_ledTrong);
    }

    public Boolean addLedTrong(LedTrongDTO ledTrongDTO) {
        if (!ledTrongRepository.checkLedTrongExistedByID(ledTrongDTO.getID_ledTrong())) {
            if (ledTrongRepository.addLedTrong(ledTrongDTO) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean updateLedTrong(LedTrongDTO ledTrongDTO) {
        LedTrongDTO ledTrongDTOResponse = ledTrongRepository.getLedTrongByID(ledTrongDTO.getID_ledTrong());
        if (ledTrongRepository.checkLedTrongExistedByID(ledTrongDTOResponse.getID_ledTrong())) {
            if (ledTrongDTO.getMa_sp() != null) {
                ledTrongDTOResponse.setMa_sp(ledTrongDTO.getMa_sp());
            }
            if (ledTrongDTO.getNCC() != null) {
                ledTrongDTOResponse.setNCC((ledTrongDTO.getNCC()));
            }
            if (ledTrongDTO.getKT() != null) {
                ledTrongDTOResponse.setKT(ledTrongDTO.getKT());
            }
            if (ledTrongDTO.getD() != null) {
                ledTrongDTOResponse.setD(ledTrongDTO.getD());
            }
            if (ledTrongDTO.getR() != null) {
                ledTrongDTOResponse.setR(ledTrongDTO.getR());
            }
            if (ledTrongDTO.getNgay_BD() != null) {
                ledTrongDTOResponse.setNgay_BD(ledTrongDTO.getNgay_BD());
            }
            if (ledTrongDTO.getTG_BH() != null) {
                ledTrongDTOResponse.setTG_BH(ledTrongDTO.getTG_BH());
            }
            if (ledTrongDTO.getTG_con_lai() != null) {
                ledTrongDTOResponse.setTG_con_lai(ledTrongDTO.getTG_con_lai());
            }
            if (ledTrongRepository.updateLedTrong(ledTrongDTOResponse) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteLedTrong(Integer ID_ledTrong) {
        try {
            if (ledTrongRepository.checkLedTrongExistedByID(ID_ledTrong)) {
                if (ledTrongRepository.deleteLedTrong(ID_ledTrong) != 0) {
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
