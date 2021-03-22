package com.leverx.app.dto.dog;

import com.leverx.app.dto.pet.PetDto;
import com.leverx.app.entity.dog.Dog;
import com.leverx.app.entity.dog.enums.PawColour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DogDto  extends PetDto {

    private PawColour pawColour;

}
