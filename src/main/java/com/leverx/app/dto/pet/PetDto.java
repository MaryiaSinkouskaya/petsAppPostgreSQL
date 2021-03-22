package com.leverx.app.dto.pet;

import com.leverx.app.dto.user.UserDto;
import com.leverx.app.entity.pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {

    private String name;

    private UserDto user;

}
