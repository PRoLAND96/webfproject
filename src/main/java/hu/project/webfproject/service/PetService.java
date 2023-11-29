package hu.project.webfproject.service;


import hu.project.webfproject.entities.Pet;

import java.util.List;

public interface PetService {

    List<Pet> getAllPets();

    void savePet();

    void deletePet();
}
