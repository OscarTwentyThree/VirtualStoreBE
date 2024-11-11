package com.virtualstore.virtualstore.dtos;

public class CategoryBasicInfo {
    
    private Long id;
    private String name;

    public CategoryBasicInfo() {
    }

    public CategoryBasicInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CategoryBasicInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryBasicInfo setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "CategoryBasicInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
