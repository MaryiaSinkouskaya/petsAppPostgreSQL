package com.leverx.app.dto;

import com.leverx.app.dto.cat.CatDto;
import com.leverx.app.dto.dog.DogDto;
import com.leverx.app.dto.pet.PetDto;
import com.leverx.app.dto.user.UserDto;
import com.leverx.app.entity.cat.Cat;
import com.leverx.app.entity.dog.Dog;
import com.leverx.app.entity.pet.Pet;
import com.leverx.app.entity.user.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.*;

@NoArgsConstructor(access = PRIVATE)
public class DtoMapper {

    public static CatDto convert(Cat cat){
        return new CatDto(cat.isClippedClaws());
    }
    public static DogDto convert(Dog dog){
        return new DogDto(dog.getPawColour());
    }
    public static PetDto convert(Pet pet){
        return new PetDto(pet.getName(), convert(pet.getUser()));
    }

    public static UserDto convert(User user){
        return new UserDto(user.getName());
    }

}
