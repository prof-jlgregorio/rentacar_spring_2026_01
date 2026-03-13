package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.dto.BrandDto;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.BrandMapper;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.model.BrandModel;
import br.com.jlgregorio.rentacar.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public BrandDto findById(long id){
        var found = brandRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Marca não encontrada!"));
        return BrandMapper.toDto(found);
    }

    public List<BrandDto> findAll(){
        var brands = brandRepository.findAll();
        return BrandMapper.toDtoList(brands);
    }

    public BrandDto create(BrandDto brandDto){
        BrandModel brandModel = CustomModelMapper.parseObject(brandDto, BrandModel.class);
        return BrandMapper.toDto(brandModel);
    }

    public BrandDto update(BrandDto brandDto){
        var found = brandRepository.findById(brandDto.id()).orElseThrow(
                ()-> new ResourceNotFoundException("Marca não encontrada!")
        );
        found.setName(brandDto.name());
        found.setDescription(brandDto.description());
        return BrandMapper.toDto(found);
    }

    public void delete(long id){
        BrandModel found = brandRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Marca não encontrada!")
        );
        brandRepository.delete(found);
    }

}
