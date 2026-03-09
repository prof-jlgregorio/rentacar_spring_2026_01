package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.dto.BrandDto;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.model.BrandModel;
import br.com.jlgregorio.rentacar.repository.BrandRepository;
import org.modelmapper.ModelMapper;
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
        return CustomModelMapper.parseObject(found, BrandDto.class);
    }

    public List<BrandDto> findAll(){
        var brands = brandRepository.findAll();
        return CustomModelMapper.parseObjectList(brands, BrandDto.class);
    }

    public BrandDto create(BrandDto brandDto){
        BrandModel brandModel = CustomModelMapper.parseObject(brandDto, BrandModel.class);
        return CustomModelMapper.parseObject(brandRepository.save(brandModel), BrandDto.class);
    }

    public BrandDto update(BrandDto brandDto){
        var found = brandRepository.findById(brandDto.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("Marca não encontrada!")
        );
        found.setName(brandDto.getName());
        found.setDescription(brandDto.getDescription());
        return CustomModelMapper.parseObject(brandRepository.save(found), BrandDto.class);
    }

    public void delete(long id){
        BrandModel found = brandRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Marca não encontrada!")
        );
        brandRepository.delete(found);
    }

}
