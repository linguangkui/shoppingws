package com.online.shopping.pojo;

import java.io.Serializable;
import java.util.List;

public class TbItemCat implements Serializable{
    private Long id;

    private Long parentId;

    private String name;

    private Long typeId;
    private List parentIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public List getParentIds() {
        return parentIds;
    }

    public void setParentIds(List parentIds) {
        this.parentIds = parentIds;
    }
}