package rikkei.academy.model;

import org.springframework.web.multipart.MultipartFile;

public class DTO {
    private int id;
    private String name;
    private int age;
    private MultipartFile image;

    public DTO() {
    }

    public DTO(int id, String name, int age, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "DTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", image=" + image +
                '}';
    }
}
