package br.com.jlgregorio.rentacar.mapper;

import br.com.jlgregorio.rentacar.dto.VehicleDto;
import br.com.jlgregorio.rentacar.model.VehicleModel;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record VehicleMapper() {

    public static VehicleModel toModel(VehicleDto vehicleDto){
        return new VehicleModel(
                vehicleDto.id(), vehicleDto.name(), vehicleDto.color(), vehicleDto.year(),
                BrandMapper.toModel(vehicleDto.brand()),
                vehicleDto.createdAt(),
                vehicleDto.updatedAt()
        );
    }

    public static VehicleDto toDto(VehicleModel vehicleModel){
        return new VehicleDto(vehicleModel.getId(), vehicleModel.getName(), vehicleModel.getColor(),
                vehicleModel.getYear(), BrandMapper.toDto(vehicleModel.getBrand()),
                vehicleModel.getCreatedAt(), vehicleModel.getUpdatedAt());
    }

    public static List<VehicleModel> toModelList(List<VehicleDto> dtoList){
        if(dtoList == null){
            return Collections.emptyList();
        }
        return dtoList.stream().map(VehicleMapper::toModel).collect(Collectors.toList());
    }

    public static List<VehicleDto> toDtoList(List<VehicleModel> modelList){
        if(modelList == null){
            return Collections.emptyList();
        }
        return modelList.stream().map(VehicleMapper::toDto).collect(Collectors.toList());
    }

}
