package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.model.BrandModel;
import br.com.jlgregorio.rentacar.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public BrandModel findById(long id){
        return brandRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Marca não encontrada!"));
    }

    public List<BrandModel> findAll(){
        return brandRepository.findAll();
    }

    public BrandModel create(BrandModel brandModel){
        return brandRepository.save(brandModel);
    }

    public BrandModel update(BrandModel brandModel){
        BrandModel found = brandRepository.findById(brandModel.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("Marca não encontrada!")
        );
        found.setName(brandModel.getName());
        found.setDescription(brandModel.getDescription());
        return brandRepository.save(found);
    }

    public void delete(long id){
        BrandModel found = brandRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Marca não encontrada!")
        );
        brandRepository.delete(found);
    }

}
