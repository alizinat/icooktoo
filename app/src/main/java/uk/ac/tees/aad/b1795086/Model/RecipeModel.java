package uk.ac.tees.aad.b1795086.Model;

public class RecipeModel {

    String ImageSource;
    String Description;

    public RecipeModel(String imageSource, String description) {
        ImageSource = imageSource;
        Description = description;
    }

    public String getImageSource() {
        return ImageSource;
    }

    public void setImageSource(String imageSource) {
        ImageSource = imageSource;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
