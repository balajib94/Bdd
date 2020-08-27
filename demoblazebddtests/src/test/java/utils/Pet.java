package utils;

import java.util.List;
import java.util.ArrayList;
public class Pet {

    private String id;
    private Category category;
    private String name;
    private String photoUrl;
    private List<Tag> tags = new ArrayList<>();
    private String status;
    private Pet() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrls() {
        return photoUrl;
    }

    public void setPhotoUrls(String photoUrls) {
        this.photoUrl = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + '\'' +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrl +
                ", tags=" + tags +
                ", status=" + status +
                '}';
    }

    public static class Builder {
        private String id;
        private Category category;
        private String name;
        private String photoUrl;
        private List<Tag> tags = new ArrayList<>();
        private String status;

        public Builder() {

        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder inCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPhotoUrls(String photoUrls) {
            this.photoUrl = photoUrls;
            return this;
        }

        public Builder withTags(List<Tag> tags) {
            this.tags = tags;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Pet build() {
            Pet pet = new Pet();
            pet.id = this.id;
            pet.name = this.name;
            pet.category = this.category;
            pet.photoUrl = this.photoUrl;
            pet.tags = this.tags;
            pet.status = this.status;
            return pet;
        }


    }
}
