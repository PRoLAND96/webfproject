package hu.project.webfproject.controller;

import hu.project.webfproject.dto.PetDTO;
import hu.project.webfproject.entities.Pet;
import hu.project.webfproject.service.PetService;
import hu.project.webfproject.utils.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetController {

    @Autowired
    PetService petService;

    @Autowired
    PetMapper petMapper;

    List<PetDTO> dogs;
}
