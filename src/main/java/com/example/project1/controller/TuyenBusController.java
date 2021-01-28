package com.example.project1.controller;

import com.example.project1.dto.LoaiXeDTO;
import com.example.project1.dto.TuyenBusDTO;
import com.example.project1.helper.ResponseBuilder.ResponseForm;
import com.example.project1.service.TuyenBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tuyenbus")
public class TuyenBusController {
    @Autowired
    TuyenBusService tuyenBusService;

    @GetMapping("/all")
    public ResponseEntity<ResponseForm<List<TuyenBusDTO>>> getAllTuyenBus(@RequestParam Integer sortType) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(tuyenBusService.getAllTuyenBus(sortType), 1, "okokok"));
    }

    @GetMapping("/info")
    public ResponseEntity<ResponseForm<TuyenBusDTO>> getTuyenBusByTuyen(@RequestParam String Tuyen) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(tuyenBusService.getTuyenBusByTuyen(Tuyen), 1, "okokok"));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseForm<Boolean>> addTuyenBus(@RequestBody TuyenBusDTO tuyenBusDTO) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(tuyenBusService.addTuyenBus(tuyenBusDTO), 1, "okokok"));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseForm<Boolean>> updateTuyenBus(@RequestBody TuyenBusDTO tuyenBusDTO) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(tuyenBusService.updateTuyenBus(tuyenBusDTO), 1, "okokok"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseForm<Boolean>> deleteTuyenBus(@RequestParam String Tuyen) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(tuyenBusService.deleteTuyenBus(Tuyen), 1, "okokok"));
    }
}
