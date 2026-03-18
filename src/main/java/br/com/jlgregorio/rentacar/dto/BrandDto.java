package br.com.jlgregorio.rentacar.dto;

import java.util.Date;

public record BrandDto(long id, String name, String description, Date createdAt, Date updatedAt) {

}