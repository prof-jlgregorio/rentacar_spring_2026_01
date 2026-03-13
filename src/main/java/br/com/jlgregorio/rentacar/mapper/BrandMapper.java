package br.com.jlgregorio.rentacar.mapper;

import br.com.jlgregorio.rentacar.dto.BrandDto;
import br.com.jlgregorio.rentacar.model.BrandModel;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BrandMapper {

    public  static BrandModel toModel(BrandDto brandDto){
        if(brandDto == null){
            return null;
        }
        return new BrandModel(brandDto.id(), brandDto.name(), brandDto.description(),
                brandDto.createdAt(), brandDto.updatedAt());
    }

    public static BrandDto toDto(BrandModel brandModel){
        if(brandModel == null){
            return null;
        }
        return new BrandDto(brandModel.getId(),brandModel.getDescription(), brandModel.getDescription(),
                brandModel.getCreatedAt(), brandModel.getUpdatedAt());
    }

    public static List<BrandModel> toModelList(List<BrandDto> dtoList){
        if(dtoList == null){
            return Collections.emptyList();
        }
        return dtoList.stream().map(BrandMapper::toModel).collect(Collectors.toList());
    }

    public static List<BrandDto> toDtoList(List<BrandModel> modelList ){
        if(modelList == null){
            return Collections.emptyList();
        }
        return modelList.stream().map(BrandMapper::toDto).collect(Collectors.toList());
    }

}
