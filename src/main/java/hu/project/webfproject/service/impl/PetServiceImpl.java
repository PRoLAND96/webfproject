package hu.project.webfproject.service.impl;

import hu.project.webfproject.entities.Pet;
import hu.project.webfproject.repository.PetRepository;
import hu.project.webfproject.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void deletePet(Pet pet) {
        petRepository.delete(pet);
    }
}
