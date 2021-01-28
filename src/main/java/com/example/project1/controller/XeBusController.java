package com.example.project1.controller;

import com.example.project1.dto.XeBusDTO;
import com.example.project1.helper.ResponseBuilder.ResponseForm;
import com.example.project1.service.XeBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class XeBusController {
    @Autowired
    XeBusService xeBusService;

    // lay tat ca
    @GetMapping("/all")
    public ResponseEntity<ResponseForm<List<XeBusDTO>>> getAllBus(@RequestParam Integer sortType) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(xeBusService.getAllBus(sortType), 1, "okokok"));
    }

    // lay theo bks
    @GetMapping("/info")
    public ResponseEntity<ResponseForm<XeBusDTO>> getBusByBKS(@RequestParam String BKS) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(xeBusService.getBusByBKS(BKS), 1, "okokok"));
    }

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<ResponseForm<Boolean>> addBus(@RequestBody XeBusDTO xeBusDTO) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(xeBusService.addBus(xeBusDTO), 1, "okokok"));
    }

    @PutMapping("/update")
    public @ResponseBody ResponseEntity<ResponseForm<Boolean>> updateBus(@RequestBody XeBusDTO xeBusDTO) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(xeBusService.updateBus(xeBusDTO), 1, "okokok"));
    }

    @DeleteMapping("/delete")
    public @ResponseBody ResponseEntity<ResponseForm<Boolean>> deleteBus(@RequestParam String BKS) {
        return ResponseEntity.ok(ResponseForm.buildCustomResponse(xeBusService.deleteBus(BKS), 1, "okokok"));
    }
}
