package br.com.jlgregorio.rentacar.dto.v1;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class VehicleDtoV1 {

    private long id;
    private String name;
    private String color;
    private int year;
    private BrandDtoV1 brand;


}
