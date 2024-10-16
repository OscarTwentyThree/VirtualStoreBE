package com.virtualstore.virtualstore.services;
import java.util.Collection;

import com.virtualstore.virtualstore.entities.Status;
public interface StatusService {

    public abstract void createStatus(Status status);
    public abstract void updateStatus(Long id, Status status);
    public abstract void deleteStatus(Long id);
    public abstract Collection<Status> getStates();
    public abstract Status getStatus(Long id);
    
}
