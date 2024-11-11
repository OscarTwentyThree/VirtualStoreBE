package com.virtualstore.virtualstore.dtos;

public class StatusBasicInfo {

    private Long id;
    private String name;

    public StatusBasicInfo() {
    }

    public StatusBasicInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StatusBasicInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public StatusBasicInfo setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "StatusBasicInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    
}
