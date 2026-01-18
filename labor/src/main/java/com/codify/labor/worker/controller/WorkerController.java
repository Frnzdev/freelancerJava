package com.codify.labor.worker.controller;


import com.codify.labor.worker.dto.WorkerRequestDTO;
import com.codify.labor.worker.dto.WorkerResponseDTO;
import com.codify.labor.worker.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping
    public List<WorkerResponseDTO> getWorkers() {
        return workerService.getAllWorkers();
    }

    @PostMapping
    public ResponseEntity<WorkerResponseDTO> createWorker(@RequestBody WorkerRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(workerService.createWorker(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkerResponseDTO> deleteWorker(@PathVariable Long id){
        workerService.deleteWorker(id);
        return ResponseEntity.noContent().build();
    }

}
