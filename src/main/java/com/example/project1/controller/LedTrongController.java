package com.example.project1.controller;

import com.example.project1.dto.LedSuonDTO;
import com.example.project1.dto.LedTrongDTO;
import com.example.project1.helper.ResponseBuilder.ResponseForm;
import com.example.project1.service.LedTrongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ledtrong")
public class LedTrongController {
    @Autowired
    LedTrongService ledTrongService;

    @GetMapping("/all")
    public ResponseEntity<ResponseForm<List<LedTrongDTO>>> getAllLedTrong(@RequestParam Integer sortType) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledTrongService.getAllLedTrong(sortType), 1, "okokok"));
    }

    @GetMapping("/info")
    public ResponseEntity<ResponseForm<LedTrongDTO>> getLedTrongByID(@RequestParam Integer ID_ledTrong) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledTrongService.getLedTrongByID(ID_ledTrong), 1, "okokok"));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseForm<Boolean>> addLedTrong(@RequestBody LedTrongDTO ledTrongDTO) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledTrongService.addLedTrong(ledTrongDTO), 1, "okokok"));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseForm<Boolean>> updateLedTrong(@RequestBody LedTrongDTO ledTrongDTO) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledTrongService.updateLedTrong(ledTrongDTO), 1, "okokok"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseForm<Boolean>> deleteLedTrong(@RequestParam Integer ID_ledTrong) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(ledTrongService.deleteLedTrong(ID_ledTrong), 1, "okokok"));
    }
}
