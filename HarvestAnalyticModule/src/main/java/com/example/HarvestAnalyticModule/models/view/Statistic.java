
package com.example.HarvestAnalyticModule.models.view;

        import java.util.List;

public class Statistic {
    private List<Material> materials;
    private List<ObjectType> objects;

    public List<ObjectType> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectType> objects) {
        this.objects = objects;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public void countPercentages (){
        for (int i=0; i<this.getObjects().size(); i++){
            this.getObjects().get(i).setPercentage(
                    this.getObjects().get(i).getNumber() * 100 / (float)this.getObjects().stream().mapToInt(ObjectType::getNumber).sum()
            );
        }

        for (int i=0; i<this.getMaterials().size(); i++){
            this.getMaterials().get(i).setPercentage(
                    this.getMaterials().get(i).getWeight() * 100 / (float)this.getMaterials().stream().mapToInt(Material::getWeight).sum()
            );
        }
    }
}