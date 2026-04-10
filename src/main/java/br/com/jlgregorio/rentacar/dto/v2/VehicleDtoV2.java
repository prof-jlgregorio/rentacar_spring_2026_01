package br.com.jlgregorio.rentacar.dto.v2;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class VehicleDtoV2 {

    private long id;
    private String name;
    private String color;
    private int year;
    private BrandDtoV2 brand;
    private String observations;

}
