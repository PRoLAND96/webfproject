package hu.project.webfproject.utils;

import hu.project.webfproject.dto.PetDTO;
import hu.project.webfproject.entities.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface PetMapper {

    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    @Mapping(source ="id" ,target ="petDtoId" )
    @Mapping(source ="name" ,target ="petName" )
    @Mapping(source ="race" ,target ="petRace" )
    @Mapping(source ="gender" ,target ="petGender" )
    @Mapping(source ="owner" ,target ="petOwner" )
    PetDTO PettoPetDto(Pet pet);

    @Mapping(source ="petDtoId" ,target ="id" )
    @Mapping(source ="petName" ,target ="name" )
    @Mapping(source ="petRace" ,target ="race" )
    @Mapping(source ="petGender" ,target ="gender" )
    @Mapping(source ="petOwner" ,target ="owner" )
    Pet PetDtoToPet(PetDTO petDto);

    @Mapping(source ="id" ,target ="petDtoId" )
    @Mapping(source ="name" ,target ="petName" )
    @Mapping(source ="race" ,target ="petRace" )
    @Mapping(source ="gender" ,target ="petGender" )
    @Mapping(source ="owner" ,target ="petOwner" )
    List<PetDTO> PetListToPetDtoList(List<Pet> pets);

    @Mapping(source ="petDtoId" ,target ="id" )
    @Mapping(source ="petName" ,target ="name" )
    @Mapping(source ="petRace" ,target ="race" )
    @Mapping(source ="petGender" ,target ="gender" )
    @Mapping(source ="petOwner" ,target ="owner" )
    List<Pet> PetDtoListToPetList(List<PetDTO> petDtos);
}
