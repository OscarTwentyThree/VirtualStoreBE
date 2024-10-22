package com.virtualstore.virtualstore.dtos;

public class PrivilegeSummary {
    private Long id;
    private String name;

    public PrivilegeSummary() {
    }

    public PrivilegeSummary(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PrivilegeSummary setId(Long id) {
        this.id = id;
        return this;
    }

    public PrivilegeSummary setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "PrivilegeSummary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    
}
