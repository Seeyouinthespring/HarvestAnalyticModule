package com.example.HarvestAnalyticModule.models.server;

import java.util.List;
import java.util.Map;

public class Component {

    private ServiceData serviceData;
    private String _id;
    private boolean hasChildren;
    private String type;
    private List<String> parentIds;
    private Map<String, Object> propertiesCumulated;
    private List<Component> children;
    private String objectTypeId;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ServiceData getServiceData() {
        return serviceData;
    }

    public void setServiceData(ServiceData serviceData) {
        this.serviceData = serviceData;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public List<String> getParentIds() {
        return parentIds;
    }

    public void setParentIds(List<String> parentIds) {
        this.parentIds = parentIds;
    }

    public List<Component> getChildren() {
        return children;
    }

    public Map<String, Object> getPropertiesCumulated() {
        return propertiesCumulated;
    }
}
