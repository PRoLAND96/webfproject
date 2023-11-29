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
    PetRepository dogRepository;

    @Override
    public List<Pet> getAllPets() {
        return null;
    }

    @Override
    public void savePet() {

    }

    @Override
    public void deletePet() {

    }
}
