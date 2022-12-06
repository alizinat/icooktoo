package uk.ac.tees.aad.b1795086.Model;

public class UploadRecipeModel {

   String description;
   String dishName;
   String imagePath;
   String name;

    public UploadRecipeModel() {
    }

    public UploadRecipeModel(String description, String dishName, String imagePath, String name) {
        this.description = description;
        this.dishName = dishName;
        this.imagePath = imagePath;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
