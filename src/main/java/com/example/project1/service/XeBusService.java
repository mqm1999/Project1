package com.example.project1.service;

import com.example.project1.dto.XeBusDTO;
import com.example.project1.exception.ResourceAlreadyExistException;
import com.example.project1.exception.ResourceNotFoundException;
import com.example.project1.repository.XeBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XeBusService {
    @Autowired
    XeBusRepository xeBusRepository;

    public List<XeBusDTO> getAllBus(Integer sortType) {
        try {
            if (sortType == null) {
                return xeBusRepository.getAllBusASC();
            } else if (sortType == 1) {
                return xeBusRepository.getAllBusDESC();
            } else {
                return xeBusRepository.getAllBusASC();
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public XeBusDTO getBusByBKS(String BKS) {
        return xeBusRepository.getBusByBKS(BKS);
    }

    public Boolean addBus(XeBusDTO xeBusDTO) {
        if (!xeBusRepository.checkBusExistedByBKS(xeBusDTO.getBKS()) && xeBusRepository.checkBusExistedByTuyen(xeBusDTO.getTuyen())) {
            if (xeBusRepository.addBus(xeBusDTO) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (!xeBusRepository.checkBusExistedByTuyen(xeBusDTO.getTuyen())) {
            throw new ResourceNotFoundException(xeBusDTO.getTuyen());
        } else {
            throw new ResourceAlreadyExistException(xeBusDTO.getBKS());
        }
    }

    public Boolean updateBus(XeBusDTO xeBusDTO) {
        XeBusDTO xeBusDTOResponse = xeBusRepository.getBusByBKS(xeBusDTO.getBKS());
        if (xeBusRepository.checkBusExistedByBKS(xeBusDTO.getBKS()) && xeBusRepository.checkBusExistedByTuyen(xeBusDTO.getTuyen())) {
            if (xeBusDTO.getTT() != null) {
                xeBusDTOResponse.setTT(xeBusDTO.getTT());
            }
            if (xeBusDTO.getTuyen() != null) {
                xeBusDTOResponse.setTuyen(xeBusDTO.getTuyen());
            }
            if (xeBusDTO.getNam_SX() != null) {
                xeBusDTOResponse.setNam_SX(xeBusDTO.getNam_SX());
            }
            if (xeBusDTO.getNam_Lap_led() != null) {
                xeBusDTOResponse.setNam_Lap_led(xeBusDTO.getNam_Lap_led());
            }
            if (xeBusRepository.updateBus(xeBusDTOResponse) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (!xeBusRepository.checkBusExistedByTuyen(xeBusDTO.getTuyen())) {
            throw new ResourceNotFoundException(xeBusDTO.getTuyen());
        } else {
            throw new ResourceNotFoundException(xeBusDTO.getBKS());
        }
    }

    public Boolean deleteBus(String BKS) {
        try {
            if (xeBusRepository.checkBusExistedByBKS(BKS)) {
                if (xeBusRepository.deleteBus(BKS) != 0) {
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
