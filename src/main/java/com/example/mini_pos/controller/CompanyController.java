package com.example.mini_pos.controller;

import com.example.mini_pos.mapper.CompanyMapper;
import com.example.mini_pos.model.entity.Company;
import com.example.mini_pos.model.request.CompanyRequest;
import com.example.mini_pos.model.response.CompanyResponse;
import com.example.mini_pos.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @PostMapping
    public ResponseEntity<CompanyResponse> saveData(@Valid @RequestBody CompanyRequest dto){
       //map from c.request to c.entity
        Company company = companyMapper.toEntity(dto);
        Company saveData = companyService.saveData(company);

        //response to client
        CompanyResponse response = companyMapper.toDTO(saveData);
        System.out.println("response"+ response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<CompanyResponse> getByIdEntity(@PathVariable Long id) {
        Company company = companyService.getById(id);

        CompanyResponse response = companyMapper.toDTO(company);
        return  ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<CompanyResponse> updateCompany(@PathVariable Long id, @RequestBody CompanyRequest request){
        Company company = companyMapper.toEntity(request);
        Company updated = companyService.updated(id, company);

        CompanyResponse response = companyMapper.toDTO(updated);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllCompany() {
        List<CompanyResponse> responses = companyService.getAll();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CompanyResponse> deleteCompany(@PathVariable Long id){
        Company company = companyService.deleteById(id);

        CompanyResponse response = companyMapper.toDTO(company);
        return ResponseEntity.ok(response);
    }

}
