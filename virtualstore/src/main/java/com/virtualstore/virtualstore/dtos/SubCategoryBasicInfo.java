package com.virtualstore.virtualstore.dtos;

public class SubCategoryBasicInfo {

    private Long id;
    private String name;

    public SubCategoryBasicInfo() {
    }

    public SubCategoryBasicInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SubCategoryBasicInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public SubCategoryBasicInfo setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "SubCategoryBasicInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    
    
}
