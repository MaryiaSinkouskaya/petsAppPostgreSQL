package com.leverx.app.entity.response.cat;

import com.leverx.app.entity.response.pet.PetResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatResponse extends PetResponse {

    private boolean clippedClaws;

}
