package hu.project.webfproject.dto;

import hu.project.webfproject.entities.Owner;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.io.Serializable;

@Data
public class PetDTO implements Serializable {

    private Long petDtoId;

    private String name;

    private Character gender;

    private String race;

    private OwnerDTO owner;

    public Long getPetDtoId() {
        return petDtoId;
    }

    public void setPetDtoId(Long petDtoId) {
        this.petDtoId = petDtoId;
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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }
}
