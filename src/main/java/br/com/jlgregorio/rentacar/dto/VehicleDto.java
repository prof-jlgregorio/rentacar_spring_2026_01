package br.com.jlgregorio.rentacar.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class VehicleDto {

    private long id;
    private String name;
    private String color;
    private int year;
    private BrandDto brand;

}
