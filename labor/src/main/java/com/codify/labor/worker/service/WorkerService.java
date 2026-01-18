package com.codify.labor.worker.service;

import com.codify.labor.worker.dto.WorkerRequestDTO;
import com.codify.labor.worker.dto.WorkerResponseDTO;
import com.codify.labor.worker.exceptions.WorkerNotFoundException;
import com.codify.labor.address.model.AddressModel;
import com.codify.labor.worker.model.WorkerModel;
import com.codify.labor.address.repository.AddressRepository;
import com.codify.labor.worker.repository.WorkerRepository;
import com.codify.labor.address.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    public List<WorkerResponseDTO> getAllWorkers() {
        return workerRepository.findAll().stream().map(WorkerResponseDTO::new)
                .toList();
    }


    public WorkerResponseDTO createWorker(WorkerRequestDTO workerRequestDTO) {
       return salvarClienteComCep(workerRequestDTO);
    }

    @Transactional
    public void deleteWorker(Long id) {
        WorkerModel deletedWorker = workerRepository.findById(id).orElseThrow(() -> new WorkerNotFoundException("Worker" +
                " " +
                "not found."));
        AddressModel address = deletedWorker.getAddress();
        workerRepository.delete(deletedWorker);
        if (address != null && !workerRepository.existsByAddress(address)) {
            addressRepository.delete(address);
        }
    }

    private WorkerResponseDTO salvarClienteComCep(WorkerRequestDTO workerRequestDTO) {
        String cep = workerRequestDTO.address().cep();

        AddressModel address = addressRepository.findById(cep)
                .orElseGet(() -> {
                    AddressModel newAddress = viaCepService.consultarCep(cep);
                    return addressRepository.save(newAddress);
                });

        WorkerModel worker = new WorkerModel();
        worker.setAllName(workerRequestDTO.allName());
        worker.setUsername(workerRequestDTO.username());
        worker.setCpf(workerRequestDTO.cpf());
        worker.setEmail(workerRequestDTO.email());
        worker.setPassword(workerRequestDTO.password());
        worker.setPhoto_url(workerRequestDTO.photo_url());
        worker.setAddress(address);

        WorkerModel workerSaved = workerRepository.save(worker);
        return new WorkerResponseDTO(workerSaved);
    }

}
