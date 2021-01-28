package com.example.project1.service;

import com.example.project1.dto.LedDiemDungDTO;
import com.example.project1.exception.ResourceNotFoundException;
import com.example.project1.repository.LedDiemDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedDiemDungService {
    @Autowired
    LedDiemDungRepository ledDiemDungRepository;

    public List<LedDiemDungDTO> getAllLedDiemDung(Integer sortType) {
        try {
            if (sortType == null) {
                return ledDiemDungRepository.getAllLedDiemDungASC();
            } else if (sortType == 1) {
                return ledDiemDungRepository.getAllLedDiemDungDESC();
            } else {
                return ledDiemDungRepository.getAllLedDiemDungASC();
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public LedDiemDungDTO getLedDiemDungByID(Integer ID_ledDiemDungTT) {
        return ledDiemDungRepository.getLedDiemDungByID(ID_ledDiemDungTT);
    }

    public Boolean addLedDiemDung(LedDiemDungDTO ledDiemDungDTO) {
        if (!ledDiemDungRepository.checkLedDiemDungExistedByID(ledDiemDungDTO.getID_ledDiemDungTT())) {
            if (ledDiemDungRepository.addLedDiemDung(ledDiemDungDTO) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean updateLedDiemDung(LedDiemDungDTO ledDiemDungDTO) {
        LedDiemDungDTO ledDiemDungDTOResponse = ledDiemDungRepository.getLedDiemDungByID(ledDiemDungDTO.getID_ledDiemDungTT());
        if (ledDiemDungRepository.checkLedDiemDungExistedByID(ledDiemDungDTOResponse.getID_ledDiemDungTT())) {
            if (ledDiemDungDTO.getMa_sp() != null) {
                ledDiemDungDTOResponse.setMa_sp(ledDiemDungDTO.getMa_sp());
            }
            if (ledDiemDungDTO.getNCC() != null) {
                ledDiemDungDTOResponse.setNCC((ledDiemDungDTO.getNCC()));
            }
            if (ledDiemDungDTO.getKT() != null) {
                ledDiemDungDTOResponse.setKT(ledDiemDungDTO.getKT());
            }
            if (ledDiemDungDTO.getD() != null) {
                ledDiemDungDTOResponse.setD(ledDiemDungDTO.getD());
            }
            if (ledDiemDungDTO.getR() != null) {
                ledDiemDungDTOResponse.setR(ledDiemDungDTO.getR());
            }
            if (ledDiemDungDTO.getNgay_BD() != null) {
                ledDiemDungDTOResponse.setNgay_BD(ledDiemDungDTO.getNgay_BD());
            }
            if (ledDiemDungDTO.getTG_BH() != null) {
                ledDiemDungDTOResponse.setTG_BH(ledDiemDungDTO.getTG_BH());
            }
            if (ledDiemDungDTO.getTG_con_lai() != null) {
                ledDiemDungDTOResponse.setTG_con_lai(ledDiemDungDTO.getTG_con_lai());
            }
            if (ledDiemDungRepository.updateLedDiemDung(ledDiemDungDTOResponse) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteLedDiemDung(Integer ID_ledDiemDungTT) {
        try {
            if (ledDiemDungRepository.checkLedDiemDungExistedByID(ID_ledDiemDungTT)) {
                if (ledDiemDungRepository.deleteLedDiemDung(ID_ledDiemDungTT) != 0) {
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
