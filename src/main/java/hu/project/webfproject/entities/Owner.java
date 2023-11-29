package hu.project.webfproject.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Data
public class Owner {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Column(name = "NAME")
    private String name;

    @Getter
    @Column(name = "GENDER")
    private Character gender;

    @Getter
    @Column(name = "AGE")
    private Integer age;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "PET_ID")
    private List<Pet> pets;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
