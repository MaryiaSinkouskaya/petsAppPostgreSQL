package com.leverx.app.entity.request.dog;

import com.leverx.app.entity.request.dog.enums.PawColour;
import com.leverx.app.entity.request.pet.PetRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dog", schema = "pet_schema")
public class DogRequest extends PetRequest {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "paw_colour")
    @Enumerated(EnumType.STRING)
    private PawColour pawColour;
}
