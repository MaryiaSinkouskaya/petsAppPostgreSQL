package com.leverx.app.entity.response.dog;

import com.leverx.app.entity.response.pet.PetResponse;
import com.leverx.app.entity.request.dog.enums.PawColour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DogResponse extends PetResponse {

    private PawColour pawColour;

}
