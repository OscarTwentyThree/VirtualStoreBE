package com.virtualstore.virtualstore.dtos;

import java.util.List;

public class RoleSummary {

    private Long id;
    private String name;

    List<PrivilegeSummary> privilegeList;

    public RoleSummary() {
    }

    public RoleSummary(Long id, String name, List<PrivilegeSummary> privilegeList) {
        this.id = id;
        this.name = name;
        this.privilegeList = privilegeList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PrivilegeSummary> getPrivilegeList() {
        return privilegeList;
    }

    public RoleSummary setId(Long id) {
        this.id = id;
        return this;
    }

    public RoleSummary setName(String name) {
        this.name = name;
        return this;
    }

    public RoleSummary setPrivilegeList(List<PrivilegeSummary> privilegeList) {
        this.privilegeList = privilegeList;
        return this;
    }

    @Override
    public String toString() {
        return "RoleSummary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", privilegeList=" + privilegeList +
                '}';
    }
    
    
}
