package com.virtualstore.virtualstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import com.virtualstore.virtualstore.entities.Status;
import com.virtualstore.virtualstore.repositories.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public void createStatus(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void updateStatus(Long id, Status status) {
        Status statusToUpdate = statusRepository.findById(id).get();
        statusToUpdate.setName(status.getName());
        statusToUpdate.setBills(status.getBills());
        statusRepository.save(statusToUpdate);
    }

    @Override
    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }

    @Override
    public Collection<Status> getStates() {
        return statusRepository.findAll();
    }

    @Override
    public Status getStatus(Long id) {
        if(statusRepository.findById(id) == null){
            return null;
        }else{
            return statusRepository.findById(id).get();
        }
    }

    public Status getStatusByName(String name) {
        if(statusRepository.findByName(name) == null){
           return null;
        }else{
            return statusRepository.findByName(name);
        }
    }
    
}
