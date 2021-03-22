package com.leverx.app.entity.response.pet;

import com.leverx.app.entity.response.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetResponse {

    private String name;

    private UserResponse user;

}
