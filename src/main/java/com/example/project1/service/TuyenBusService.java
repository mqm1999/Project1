package com.example.project1.service;

import com.example.project1.dto.LoaiXeDTO;
import com.example.project1.dto.TuyenBusDTO;
import com.example.project1.repository.TuyenBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuyenBusService {
    @Autowired
    TuyenBusRepository tuyenBusRepository;

    public List<TuyenBusDTO> getAllTuyenBus(Integer sortType) {
        try {
            if (sortType == null) {
                return tuyenBusRepository.getAllTuyenBusASC();
            } else if (sortType == 1) {
                return tuyenBusRepository.getAllTuyenBusDESC();
            } else {
                return tuyenBusRepository.getAllTuyenBusASC();
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public TuyenBusDTO getTuyenBusByTuyen(String Tuyen) {
        return tuyenBusRepository.getTuyenBusByTuyen(Tuyen);
    }

    public Boolean addTuyenBus(TuyenBusDTO tuyenBusDTO) {
        if (!tuyenBusRepository.checkTuyenBusExistedByTuyen(tuyenBusDTO.getTuyen())) {
            if (tuyenBusRepository.addTuyenBus(tuyenBusDTO) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean updateTuyenBus(TuyenBusDTO tuyenBusDTO) {
        TuyenBusDTO tuyenBusDTOResponse= tuyenBusRepository.getTuyenBusByTuyen(tuyenBusDTO.getTuyen());
        if (tuyenBusRepository.checkTuyenBusExistedByTuyen(tuyenBusDTOResponse.getTuyen())) {
            if (tuyenBusDTO.getCty() != null) {
                tuyenBusDTOResponse.setCty(tuyenBusDTO.getCty());
            }
            if (tuyenBusDTO.getDon_vi() != null) {
                tuyenBusDTOResponse.setDon_vi(tuyenBusDTO.getDon_vi());
            }
            if (tuyenBusDTO.getChung_loai() != null) {
                tuyenBusDTOResponse.setChung_loai(tuyenBusDTO.getChung_loai());
            }
            if (tuyenBusDTO.getID_ledDiemDung() != null) {
                tuyenBusDTOResponse.setID_ledDiemDung(tuyenBusDTO.getID_ledDiemDung());
            }
            if (tuyenBusDTO.getID_ledTruoc() != null) {
                tuyenBusDTOResponse.setID_ledTruoc(tuyenBusDTO.getID_ledTruoc());
            }
            if (tuyenBusDTO.getID_ledSuon() != null) {
                tuyenBusDTOResponse.setID_ledSuon(tuyenBusDTO.getID_ledSuon());
            }
            if (tuyenBusDTO.getID_ledSau() != null) {
                tuyenBusDTOResponse.setID_ledSau(tuyenBusDTO.getID_ledSau());
            }
            if (tuyenBusDTO.getID_ledTrong() != null) {
                tuyenBusDTOResponse.setID_ledTrong(tuyenBusDTO.getID_ledTrong());
            }
            if (tuyenBusRepository.updateTuyenBus(tuyenBusDTOResponse) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteTuyenBus(String Tuyen) {
        try {
            if (tuyenBusRepository.checkTuyenBusExistedByTuyen(Tuyen)) {
                if (tuyenBusRepository.deleteTuyenBus(Tuyen) != 0) {
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
