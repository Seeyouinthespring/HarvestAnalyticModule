package com.example.HarvestAnalyticModule.models.server;

import java.util.List;

public class Type {
    private String _id;
    private int id;
    private List<String> children_ids;
    private List<Integer> childrenIds;
    private List<String> parent_ids;
    private List<Integer> parentIds;
    private String code;
    private DisplayName name;
    private List<Property> flattenProperties;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getChildren_ids() {
        return children_ids;
    }

    public void setChildren_ids(List<String> children_ids) {
        this.children_ids = children_ids;
    }

    public List<Integer> getChildrenIds() {
        return childrenIds;
    }

    public void setChildrenIds(List<Integer> childrenIds) {
        this.childrenIds = childrenIds;
    }

    public List<String> getParent_ids() {
        return parent_ids;
    }

    public void setParent_ids(List<String> parent_ids) {
        this.parent_ids = parent_ids;
    }

    public List<Integer> getParentIds() {
        return parentIds;
    }

    public void setParentIds(List<Integer> parentIds) {
        this.parentIds = parentIds;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DisplayName getName() {
        return name;
    }

    public void setName(DisplayName name) {
        this.name = name;
    }

    public List<Property> getFlattenProperties() {
        return flattenProperties;
    }

    public void setFlattenProperties(List<Property> flattenProperties) {
        this.flattenProperties = flattenProperties;
    }
}
