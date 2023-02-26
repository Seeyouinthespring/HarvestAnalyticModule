package com.example.HarvestAnalyticModule.services;

import com.example.HarvestAnalyticModule.models.server.Component;
import com.example.HarvestAnalyticModule.models.server.Type;
import com.example.HarvestAnalyticModule.models.view.Material;
import com.example.HarvestAnalyticModule.models.view.ObjectType;
import com.example.HarvestAnalyticModule.models.view.Statistic;
import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AnalyseService {
    RequestService service;

    public AnalyseService(){
        this.service = new RequestService();
    }

    public Statistic getAnalytic(String projectId) {

        List<Type> types = service.getTypes();
        Component component = service.getComponent(projectId);


        Type spacialType = types.stream().filter(x -> Objects.equals(x.getCode(), "TechnicalObject")).findFirst().orElse(null);
        Type technicalTypeType = types.stream().filter(x -> Objects.equals(x.getCode(), "Spatial Object")).findFirst().orElse(null);
        List<String> wrongIds = ListUtils.union(spacialType.getChildren_ids(), technicalTypeType.getChildren_ids());

        List<ObjectType> objectTypes = getObjects(new ArrayList<>(), component, wrongIds, types);
        List<Material> materials = getMaterials(new ArrayList<>(), component, wrongIds, types);


        Statistic s = new Statistic();
        s.setMaterials(materials);
        s.setObjects(objectTypes);
        s.countPercentages();
        return s;
    }

    List<ObjectType> getObjects (List<ObjectType> objects, Component component, List<String> wrongIds, List<Type> types){
        if (!wrongIds.contains(component.getType())){
            if (objects.stream().anyMatch(x -> x.getId().equals(component.getType()))){
                Objects.requireNonNull(objects.stream().filter(x -> Objects.equals(x.getId(), component.getType())).findFirst().orElse(null)).incrementNumber();
            } else {
                 objects.add(
                         new ObjectType(
                                 component.getType(),
                                 types.stream().filter(x -> Objects.equals(x.get_id(), component.getType())).findFirst().orElse(null).getName().getEn(),
                                 0,
                                 1
                         )
                 );
            }
        }

        if (component.getChildren() != null || !component.getChildren().isEmpty()){



            for (int i=0; i < component.getChildren().size() ;i++){
                objects = getObjects(objects, component.getChildren().get(i), wrongIds, types);
            }
        }

        return objects;
    }


    List<Material> getMaterials (List<Material> materials, Component component, List<String> wrongIds, List<Type> types) {
        Type type = types.stream().filter(x -> x.get_id().equals(component.getType())).findFirst().orElse(null);
        try {
            if (!wrongIds.contains(component.getType()) && type.getFlattenProperties().stream().anyMatch(x -> x.getId() == 1)){

                Map<String, Object> props = component.getPropertiesCumulated();

                int material_id = (int) props.get("1");
                int weight = Integer.parseInt((String) props.get("16"));


                if (materials.stream().anyMatch(x -> x.getId() == (material_id))){
                    Objects.requireNonNull(materials.stream().filter(x -> x.getId() == material_id).findFirst().orElse(null)).incrementNumber();
                    Objects.requireNonNull(materials.stream().filter(x -> x.getId() == material_id).findFirst().orElse(null)).addWeight(weight);
                } else {
                    materials.add(
                            new Material(
                                    type.getFlattenProperties().stream().filter(x -> x.getId() == 1).findFirst().orElse(null)
                                            .getValues().stream().filter(x -> x.getId() == material_id).findFirst().orElse(null).getId(),
                                    type.getFlattenProperties().stream().filter(x -> x.getId() == 1).findFirst().orElse(null)
                                            .getValues().stream().filter(x -> x.getId() == material_id).findFirst().orElse(null).getDisplayName().getEn(),
                                    weight,
                                    0,
                                    1
                            )
                    );
                }
            }
            if (component.getChildren() != null || !component.getChildren().isEmpty()){
                for (int i=0; i < component.getChildren().size() ;i++){
                    materials = getMaterials(materials, component.getChildren().get(i), wrongIds, types);
                }
            }

            return materials;
        } catch (Exception e){
            if (e instanceof NoSuchFieldException)
                System.out.println("Error no such field exception " + e.getMessage());
            if (e instanceof IllegalAccessException)
                System.out.println("Error illegal access exception " + e.getMessage());
        }
        return materials;
    }
}
