package br.com.jlgregorio.rentacar.mapper;

import br.com.jlgregorio.rentacar.dto.BrandDto;
import br.com.jlgregorio.rentacar.model.BrandModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    //model -> dto
    BrandDto toDto(BrandModel model);
    List<BrandDto> toDtoList(List<BrandModel> models);

    //dto -> model
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    BrandModel toModel(BrandDto dto);

    List<BrandModel> toModelList(List<BrandDto> dtos);




}
