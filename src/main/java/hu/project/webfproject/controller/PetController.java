package hu.project.webfproject.controller;

import hu.project.webfproject.dto.PetDTO;
import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Owner;
import hu.project.webfproject.service.PetService;
import hu.project.webfproject.utils.PetMapper;
import hu.project.webfproject.utils.OwnerMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestScope
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private PetMapper petMapper;

    @Autowired
    private OwnerMapper ownerMapper;

    private String actionLabel;

    private List<PetDTO> pets;

    private List<OwnerDTO> owners;

    private PetDTO petDTO;

    private OwnerDTO ownerDTO;


    @PostConstruct
    public void getAllPets() {
        if (!this.getPets().isEmpty()) {
            this.getPets().clear();
            this.getOwners().clear();
        }
        this.getPets().addAll(petService.getAllPets());
        this.setActionLabel("Add");
        getPetDTO();
        this.petDTO.setPetDtoId(null);

    }

    public void savePet() {
        petService.savePet(this.getPetDTO());
        getAllPets();
    }

    public void deletePet(PetDTO tobeDeleted) {
        petService.deletePet(tobeDeleted);
        getAllPets();
    }

    public void updatePet(PetDTO toBeUpdated) {

        this.petDTO.setPetDtoId(toBeUpdated.getPetDtoId());
        this.petDTO.setPetRace(toBeUpdated.getPetRace());
        this.petDTO.setPetGender(toBeUpdated.getPetGender());
        this.petDTO.setPetName(toBeUpdated.getPetName());
        this.petDTO.setPetOwner(toBeUpdated.getPetOwner());
        setActionLabel("Update");
    }

    public PetService getPetService() {
        return petService;
    }

    public void setPetService(PetService petService) {
        this.petService = petService;
    }

    public PetMapper getPetMapper() {
        return petMapper;
    }

    public void setPetMapper(PetMapper petMapper) {
        this.petMapper = petMapper;
    }

    public OwnerMapper getOwnerMapper() {
        return ownerMapper;
    }

    public void setOwnerMapper(OwnerMapper ownerMapper) {
        this.ownerMapper = ownerMapper;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public List<PetDTO> getPets() {
        if(null == pets){
            pets = new ArrayList<PetDTO>();
        }
        return pets;
    }

    public void setPets(List<PetDTO> pets) {
        this.pets = pets;
    }

    public List<OwnerDTO> getOwners() {
        if(null == owners){
            owners = new ArrayList<OwnerDTO>();
        }
        return owners;
    }

    public void setOwners(List<OwnerDTO> owners) {
        this.owners = owners;
    }

    public PetDTO getPetDTO() {
        if (null == petDTO){
            petDTO = new PetDTO();
            petDTO.setPetOwner(new Owner());
        }
        return petDTO;
    }

    public void setPetDTO(PetDTO petDTO) {
        this.petDTO = petDTO;
    }

    public OwnerDTO getOwnerDTO() {
        if (null == ownerDTO){
            ownerDTO = new OwnerDTO();
        }
        return ownerDTO;
    }

    public void setOwnerDTO(OwnerDTO ownerDTO) {
        this.ownerDTO = ownerDTO;
    }
}