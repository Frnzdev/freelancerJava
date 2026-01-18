package com.codify.labor.enterprise.controller;

import com.codify.labor.enterprise.dto.EnterpriseRequestDTO;
import com.codify.labor.enterprise.dto.EnterpriseResponseDTO;
import com.codify.labor.enterprise.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping
    public List<EnterpriseResponseDTO> getEnterprise(){
        return enterpriseService.getAllEnterprises();
    }

    @PostMapping
    public EnterpriseResponseDTO createEnterprise(@RequestBody EnterpriseRequestDTO enterpriseRequestDTO){
        return enterpriseService.createEnterprise(enterpriseRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEnterprise(@PathVariable Long id){
        enterpriseService.deleteEnterprise(id);
    }
}
