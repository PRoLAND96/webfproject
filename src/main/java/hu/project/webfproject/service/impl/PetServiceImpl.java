package hu.project.webfproject.service.impl;

import hu.project.webfproject.dto.PetDTO;
import hu.project.webfproject.entities.Pet;
import hu.project.webfproject.entities.Owner;
import hu.project.webfproject.repository.PetRepository;
import hu.project.webfproject.repository.OwnerRepository;
import hu.project.webfproject.service.PetService;
import hu.project.webfproject.utils.PetMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        try {
            Optional<Owner> tempOwner = ownerRepository.findById(pet.getPetOwner().getId());
            Pet newPet = petMapper.PetDtoToPet(pet);
            if (tempOwner.isPresent()) {
                Owner owner = tempOwner.get();
                newPet.setOwner(owner);
            }
            petRepository.save(newPet);
        }catch (RuntimeException e){
            throw new RuntimeException("exception!",e.getCause());
        }
    }

    @Override
    public void deletePet(PetDTO pet) {
        petRepository.deleteById(pet.getPetDtoId());
    }

    @Override
    public void updatePet(PetDTO pet) {
        Optional<Pet> pet1 = petRepository.findById(pet.getPetDtoId());

        if (pet1.isPresent()){
            Pet _pet = pet1.get();
            _pet.setGender(pet1.get().getGender());
            _pet.setRace(pet1.get().getRace());
            _pet.setOwner(pet1.get().getOwner());
            _pet.setName(pet1.get().getName());
        }
    }
}
