package br.com.jlgregorio.rentacar.service.v1;

import br.com.jlgregorio.rentacar.dto.v1.BrandDtoV1;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.model.BrandModel;
import br.com.jlgregorio.rentacar.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceV1 {

    @Autowired
    private BrandRepository brandRepository;

    public BrandDtoV1 findById(long id){
        var found = brandRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Marca não encontrada!"));
        return CustomModelMapper.parseObject(found, BrandDtoV1.class);
    }

    public List<BrandDtoV1> findAll(){
        var brands = brandRepository.findAll();
        return CustomModelMapper.parseObjectList(brands, BrandDtoV1.class);
    }

    public BrandDtoV1 create(BrandDtoV1 brandDto){
        BrandModel brandModel = CustomModelMapper.parseObject(brandDto, BrandModel.class);
        return CustomModelMapper.parseObject(brandRepository.save(brandModel), BrandDtoV1.class);
    }

    public BrandDtoV1 update(BrandDtoV1 brandDto){
        var found = brandRepository.findById(brandDto.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("Marca não encontrada!")
        );
        found.setName(brandDto.getName());
        found.setDescription(brandDto.getDescription());
        return CustomModelMapper.parseObject(brandRepository.save(found), BrandDtoV1.class);
    }

    public void delete(long id){
        BrandModel found = brandRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Marca não encontrada!")
        );
        brandRepository.delete(found);
    }

}
