package hu.project.webfproject.dto;

import hu.project.webfproject.entities.Owner;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.io.Serializable;

@Data
public class PetDTO implements Serializable {

    private Long petDtoId;

    private String petName;

    private Character petGender;

    private String petRace;

    private OwnerDTO petOwner;

    public Long getPetDtoId() {
        return petDtoId;
    }

    public void setPetDtoId(Long petDtoId) {
        this.petDtoId = petDtoId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Character getPetGender() {
        return petGender;
    }

    public void setPetGender(Character petGender) {
        this.petGender = petGender;
    }

    public String getPetRace() {
        return petRace;
    }

    public void setPetRace(String petRace) {
        this.petRace = petRace;
    }

    public OwnerDTO getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(Owner petOwner) {
        this.petOwner = petOwner;
    }
}
