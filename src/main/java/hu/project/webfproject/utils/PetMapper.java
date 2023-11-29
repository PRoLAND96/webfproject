package hu.project.webfproject.utils;

import hu.project.webfproject.dto.PetDTO;
import hu.project.webfproject.entities.Pet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PetMapper {

    PetDTO PettoPetDto(Pet pet);

    Pet PetDtoToPet(PetDTO petDto);

    List<PetDTO> PetListToPetDtoList(List<Pet> pets);

    List<Pet> PetDtoListToPetList(List<PetDTO> petDtos);
}
