package br.com.jlgregorio.rentacar.dto.v2;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class BrandDtoV2 {

    private long id;
    private String name;
    private String description;
    //private Date createdAt;
    //private Date updatedAt;

    public String toString(){
        return name + " - " + description;
    }


}
