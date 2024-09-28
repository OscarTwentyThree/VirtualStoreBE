package com.virtualstore.virtualstore.entities;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "privilege")

public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    @ManyToMany(mappedBy = "privilegeList", fetch = FetchType.LAZY)
    private List<Role> roleList;

    public Privilege() {
    }

    public Privilege(Long id, String name, List<Role> roleList) {
        this.id = id;
        this.name = name;
        this.roleList = roleList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roleList=" + roleList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Privilege)) return false;

        Privilege privilege = (Privilege) o;

        if (getId() != null ? !getId().equals(privilege.getId()) : privilege.getId() != null) return false;
        if (getName() != null ? !getName().equals(privilege.getName()) : privilege.getName() != null) return false;
        return getRoleList() != null ? getRoleList().equals(privilege.getRoleList()) : privilege.getRoleList() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getRoleList() != null ? getRoleList().hashCode() : 0);
        return result;
    }
}
