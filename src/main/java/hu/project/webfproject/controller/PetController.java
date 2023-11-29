package hu.project.webfproject.controller;

import hu.project.webfproject.dto.PetDTO;
import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Pet;
import hu.project.webfproject.service.PetService;
import hu.project.webfproject.utils.PetMapper;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Data
public class PetController {

    @Autowired
    PetService petService;

    @Autowired
    PetMapper petMapper;

    List<PetDTO> dogs;

    List<OwnerDTO> owners;

    PetDTO petDTO;

    OwnerDTO ownerDTO;


    @PostConstruct
    public void getAllPets(){
        if(!this.getPets().isEmpty()){
            this.getPets().clear();
            this.getOwners().clear();
        }
        this.getPets().addAll(petService.getAllPets());
    }
    public List<PetDTO> getPets(){
        return null;
    }

    public void savePet(PetDTO petDTO){
        petService.savePet(petDTO);
    }
}
