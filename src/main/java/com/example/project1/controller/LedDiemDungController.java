package com.example.project1.controller;

import com.example.project1.dto.LedDiemDungDTO;
import com.example.project1.helper.ResponseBuilder.ResponseForm;
import com.example.project1.service.LedDiemDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@RestController
@RequestMapping("/leddiemdung")
public class LedDiemDungController {
    @Autowired
    LedDiemDungService ledDiemDungService;

    @GetMapping("/all")
    public ResponseEntity<ResponseForm<List<LedDiemDungDTO>>> getAllLedDiemDung(@RequestParam Integer sortType) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledDiemDungService.getAllLedDiemDung(sortType), 1, "okokok"));
    }

    @GetMapping("/info")
    public ResponseEntity<ResponseForm<LedDiemDungDTO>> getLedDiemDungByID(@RequestParam Integer ID_ledDiemDungTT) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledDiemDungService.getLedDiemDungByID(ID_ledDiemDungTT), 1, "okokok"));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseForm<Boolean>> addLedDiemDung(@RequestBody LedDiemDungDTO ledDiemDungDTO) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledDiemDungService.addLedDiemDung(ledDiemDungDTO), 1, "okokok"));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseForm<Boolean>> updateLedDiemDung(@RequestBody LedDiemDungDTO ledDiemDungDTO) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledDiemDungService.updateLedDiemDung(ledDiemDungDTO), 1, "okokok"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseForm<Boolean>> deleteLedDiemDung(@RequestParam Integer ID_ledDiemDungTT) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledDiemDungService.deleteLedDiemDung(ID_ledDiemDungTT), 1, "okokok"));
    }
}
