package hu.project.webfproject.service;

import hu.project.webfproject.dto.PetDTO;
import hu.project.webfproject.entities.Pet;

import java.util.List;

public interface PetService {

    List<PetDTO> getAllPets();

    void savePet(PetDTO pet);

    void deletePet(PetDTO pet);

    void updatePet(PetDTO pet);
}
