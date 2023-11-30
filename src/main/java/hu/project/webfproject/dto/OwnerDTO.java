package hu.project.webfproject.dto;

import hu.project.webfproject.entities.Pet;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OwnerDTO implements Serializable {

    private Long id;

    private String name;

    private Character gender;

    private Integer age;

    private List<Pet> pets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
