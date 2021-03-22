package com.leverx.app.dto.cat;

import com.leverx.app.dto.pet.PetDto;
import com.leverx.app.entity.cat.Cat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatDto extends PetDto {

    private boolean clippedClaws;

}
