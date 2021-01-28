package com.example.project1.service;

import com.example.project1.dto.LedSauDTO;
import com.example.project1.dto.LedSuonDTO;
import com.example.project1.repository.LedSuonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedSuonService {
    @Autowired
    LedSuonRepository ledSuonRepository;

    public List<LedSuonDTO> getAllLedSuon(Integer sortType) {
        try {
            if (sortType == null) {
                return ledSuonRepository.getAllLedSuonASC();
            } else if (sortType == 1) {
                return ledSuonRepository.getAllLedSuonDESC();
            } else {
                return ledSuonRepository.getAllLedSuonASC();
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public LedSuonDTO getLedSuonByID(Integer ID_ledSuon) {
        return ledSuonRepository.getLedSuonByID(ID_ledSuon);
    }

    public Boolean addLedSuon(LedSuonDTO ledSuonDTO) {
        if (!ledSuonRepository.checkLedSuonExistedByID(ledSuonDTO.getID_ledSuon())) {
            if (ledSuonRepository.addLedSuon(ledSuonDTO) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean updateLedSuon(LedSuonDTO ledSuonDTO) {
        LedSuonDTO ledSuonDTOResponse = ledSuonRepository.getLedSuonByID(ledSuonDTO.getID_ledSuon());
        if (ledSuonRepository.checkLedSuonExistedByID(ledSuonDTOResponse.getID_ledSuon())) {
            if (ledSuonDTO.getMa_sp() != null) {
                ledSuonDTOResponse.setMa_sp(ledSuonDTO.getMa_sp());
            }
            if (ledSuonDTO.getNCC() != null) {
                ledSuonDTOResponse.setNCC((ledSuonDTO.getNCC()));
            }
            if (ledSuonDTO.getKT() != null) {
                ledSuonDTOResponse.setKT(ledSuonDTO.getKT());
            }
            if (ledSuonDTO.getD() != null) {
                ledSuonDTOResponse.setD(ledSuonDTO.getD());
            }
            if (ledSuonDTO.getR() != null) {
                ledSuonDTOResponse.setR(ledSuonDTO.getR());
            }
            if (ledSuonDTO.getNgay_BD() != null) {
                ledSuonDTOResponse.setNgay_BD(ledSuonDTO.getNgay_BD());
            }
            if (ledSuonDTO.getTG_BH() != null) {
                ledSuonDTOResponse.setTG_BH(ledSuonDTO.getTG_BH());
            }
            if (ledSuonDTO.getTG_con_lai() != null) {
                ledSuonDTOResponse.setTG_con_lai(ledSuonDTO.getTG_con_lai());
            }
            if (ledSuonRepository.updateLedSuon(ledSuonDTOResponse) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteLedSuon(Integer ID_ledSuon) {
        try {
            if (ledSuonRepository.checkLedSuonExistedByID(ID_ledSuon)) {
                if (ledSuonRepository.deleteLedSuon(ID_ledSuon) != 0) {
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
