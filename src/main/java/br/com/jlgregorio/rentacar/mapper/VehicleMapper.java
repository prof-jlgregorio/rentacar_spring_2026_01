package br.com.jlgregorio.rentacar.mapper;

import br.com.jlgregorio.rentacar.dto.VehicleDto;
import br.com.jlgregorio.rentacar.model.VehicleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BrandMapper.class})
public interface VehicleMapper {

    //model -> dto
    VehicleDto toDto(VehicleModel vehicleModel);

    List<VehicleDto> toDtoList(List<VehicleModel> models);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    VehicleModel toModel(VehicleDto dto);

    List<VehicleModel> toModelList(List<VehicleDto> dtos);

}
