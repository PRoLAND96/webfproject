package hu.project.webfproject.service.impl;

import hu.project.webfproject.dto.PetDTO;
import hu.project.webfproject.entities.Pet;
import hu.project.webfproject.repository.PetRepository;
import hu.project.webfproject.service.PetService;
import hu.project.webfproject.utils.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;


    @Autowired
    PetMapper petMapper;

    @Override
    public List<PetDTO> getAllPets() {
        List<Pet> dogs = petRepository.findAll();
        List<PetDTO> dtos = new ArrayList<>();
        dtos = petMapper.PetListToPetDtoList(dogs);

        return dtos;

    }

    @Override
    public void savePet(PetDTO pet) {
        Pet newPet = petMapper.PetDtoToPet(pet);
        petRepository.save(newPet);
    }

    @Override
    public void deletePet(PetDTO pet) {
        petRepository.deleteById(pet.getId());
    }
}
