package hu.project.webfproject.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class PetDTO implements Serializable {

    private Long id;

    private String name;

    private String race;


}
