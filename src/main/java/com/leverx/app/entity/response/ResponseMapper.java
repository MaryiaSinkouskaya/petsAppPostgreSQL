package com.leverx.app.entity.response;

import com.leverx.app.entity.response.cat.CatResponse;
import com.leverx.app.entity.response.dog.DogResponse;
import com.leverx.app.entity.response.pet.PetResponse;
import com.leverx.app.entity.response.user.UserResponse;
import com.leverx.app.entity.request.cat.CatRequest;
import com.leverx.app.entity.request.dog.DogRequest;
import com.leverx.app.entity.request.pet.PetRequest;
import com.leverx.app.entity.request.user.UserRequest;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ResponseMapper {

    public static CatResponse convert(CatRequest cat) {
        return new CatResponse(cat.isClippedClaws());
    }

    public static DogResponse convert(DogRequest dog) {
        return new DogResponse(dog.getPawColour());
    }

    public static PetResponse convert(PetRequest pet) {
        return new PetResponse(pet.getName(), convert(pet.getUser()));
    }

    public static UserResponse convert(UserRequest user) {
        return new UserResponse(user.getName());
    }

}
