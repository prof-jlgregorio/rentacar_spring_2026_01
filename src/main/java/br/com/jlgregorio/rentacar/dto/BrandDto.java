package br.com.jlgregorio.rentacar.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class BrandDto {

    private long id;
    private String name;
    private String description;
    //private Date createdAt;
    //private Date updatedAt;

    public String toString(){
        return name + " - " + description;
    }


}
