package hu.project.webfproject.service.impl;

import hu.project.webfproject.dto.PetDTO;
import hu.project.webfproject.dto.OwnerDTO;
import hu.project.webfproject.entities.Pet;
import hu.project.webfproject.entities.Owner;
import hu.project.webfproject.repository.PetRepository;
import hu.project.webfproject.repository.OwnerRepository;
import hu.project.webfproject.service.PetService;
import hu.project.webfproject.utils.PetMapper;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.faces.application.FacesMessage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    OwnerRepository ownerRepository;


    @Autowired
    PetMapper petMapper;

    @Override
    public List<PetDTO> getAllPets() {
        List<Pet> pets = petRepository.findAll();
        List<PetDTO> dtos = new ArrayList<>();
        dtos = petMapper.PetListToPetDtoList(pets);

        return dtos;

    }

    @Override
    public void savePet(PetDTO pet) {

        Optional<Owner> tempOwner = ownerRepository.findById(pet.getPetOwner().getId());
        if(pet.getPetDtoId() == null){
            Pet newPet = petMapper.PetDtoToPet(pet);
            if (tempOwner.isPresent()) {
                Owner owner = tempOwner.get();
                newPet.setOwner(owner);
                petRepository.save(newPet);
            }else{
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Owner notice", "Owner with the given ID does not exist!");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        }else {
            Optional<Pet> pet1 = petRepository.findById(pet.getPetDtoId());
            Pet existingPet = pet1.get();
            if (tempOwner.isPresent()) {
                existingPet.setOwner(pet.getPetOwner());
                existingPet.setName(pet.getPetName());
                existingPet.setRace(pet.getPetRace());
                existingPet.setGender(pet.getPetGender());
                petRepository.save(existingPet);
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Owner notice", "Owner with the given ID does not exist!");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        }
    }

    @Override
    public void deletePet(PetDTO pet) {
        petRepository.deleteById(pet.getPetDtoId());
    }

}
