package br.com.jlgregorio.rentacar.dto;

import java.util.Date;

public record VehicleDto(
        long id,
        String name,
        String color,
        int year,
        BrandDto brand,
        Date createdAt,
        Date updatedAt
) {

}