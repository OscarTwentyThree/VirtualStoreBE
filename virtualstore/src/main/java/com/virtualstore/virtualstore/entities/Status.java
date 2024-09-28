package com.virtualstore.virtualstore.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
public class Status {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = false, mappedBy = "status")
    private List<Bill> bills;

    public Status() {
    }

    public Status(Long id, String name, List<Bill> bills) {
        this.id = id;
        this.name = name;
        this.bills = bills;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bills=" + bills +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        return id != null ? id.equals(status.id) : status.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    

    


    
}
