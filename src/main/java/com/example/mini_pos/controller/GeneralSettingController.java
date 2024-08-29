package com.example.mini_pos.controller;

import com.example.mini_pos.mapper.GeneralSettingMapper;
import com.example.mini_pos.model.entity.GeneralSetting;
import com.example.mini_pos.model.request.GeneralSettingRequest;
import com.example.mini_pos.model.response.GeneralSettingResponse;
import com.example.mini_pos.service.GeneralSettingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("setting")
public class GeneralSettingController {

    @Autowired
    private GeneralSettingService generalSettingService;

    @Autowired
    private GeneralSettingMapper generalSettingMapper;

    @PostMapping
    public ResponseEntity<GeneralSettingResponse> createGeneralSetting(@Valid @RequestBody GeneralSettingRequest requestBody){
        GeneralSetting generalSetting = generalSettingMapper.toEntity(requestBody);
        GeneralSetting newData = generalSettingService.create(generalSetting);

        GeneralSettingResponse response = generalSettingMapper.toDTO(newData);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<GeneralSettingResponse> getByIdGeneralSetting(@PathVariable Long id){
        GeneralSetting generalSetting = generalSettingService.getById(id);
        GeneralSettingResponse response = generalSettingMapper.toDTO(generalSetting);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<GeneralSettingResponse> updateGeneralSetting(@PathVariable Long id, @RequestBody GeneralSettingRequest request){
        GeneralSetting generalSetting = generalSettingMapper.toEntity(request);
        GeneralSetting newData = generalSettingService.update(id, generalSetting);

        GeneralSettingResponse response = generalSettingMapper.toDTO(newData);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<GeneralSettingResponse>> listAllGeneralSetting() {
        List<GeneralSettingResponse> generalSettingResponses = generalSettingService.listAll();
        return ResponseEntity.ok(generalSettingResponses);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGeneralSetting(@PathVariable Long id){
        generalSettingService.deleteById(id);
        return ResponseEntity.ok("Delete success!!!");
    }
}
