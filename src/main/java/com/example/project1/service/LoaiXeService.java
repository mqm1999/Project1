package com.example.project1.service;

import com.example.project1.dto.LedTruocDTO;
import com.example.project1.dto.LoaiXeDTO;
import com.example.project1.repository.LoaiXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiXeService {
    @Autowired
    LoaiXeRepository loaiXeRepository;

    public List<LoaiXeDTO> getAllLoaiXe(Integer sortType) {
        try {
            if (sortType == null) {
                return loaiXeRepository.getAllLoaiXeASC();
            } else if (sortType == 1) {
                return loaiXeRepository.getAllLoaiXeDESC();
            } else {
                return loaiXeRepository.getAllLoaiXeASC();
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public LoaiXeDTO getLoaiXeByChungLoai(String Chung_loai) {
        return loaiXeRepository.getLoaiXeByChungLoai(Chung_loai);
    }

    public Boolean addLoaiXe(LoaiXeDTO loaiXeDTO) {
        if (!loaiXeRepository.checkLoaiXeExistedByChungLoai(loaiXeDTO.getChung_loai())) {
            if (loaiXeRepository.addLoaiXe(loaiXeDTO) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean updateLoaiXe(LoaiXeDTO loaiXeDTO) {
        LoaiXeDTO loaiXeDTOResponse= loaiXeRepository.getLoaiXeByChungLoai(loaiXeDTO.getChung_loai());
        if (loaiXeRepository.checkLoaiXeExistedByChungLoai(loaiXeDTOResponse.getChung_loai())) {
            if (loaiXeDTO.getSuc_chua() != null) {
                loaiXeDTOResponse.setSuc_chua(loaiXeDTO.getSuc_chua());
            }
            if (loaiXeRepository.updateLoaiXe(loaiXeDTOResponse) != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteLoaiXe(String Chung_loai) {
        try {
            if (loaiXeRepository.checkLoaiXeExistedByChungLoai(Chung_loai)) {
                if (loaiXeRepository.deleteLoaiXe(Chung_loai) != 0) {
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
