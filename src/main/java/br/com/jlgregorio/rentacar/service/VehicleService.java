package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.dto.VehicleDto;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.mapper.VehicleMapper;
import br.com.jlgregorio.rentacar.model.VehicleModel;
import br.com.jlgregorio.rentacar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleDto findById(long id){
        var found = vehicleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        return VehicleMapper.toDto(found);
    }

    public List<VehicleDto> findAll(){
        List<VehicleModel> vehicles = vehicleRepository.findAll();
        return VehicleMapper.toDtoList(vehicles);
    }

    public VehicleDto create(VehicleDto vehicleDto){
        VehicleModel vehicleModel = VehicleMapper.toModel(vehicleDto);
        return VehicleMapper.toDto(vehicleRepository.save(vehicleModel));
    }

    public VehicleDto update(VehicleDto vehicleModel){
        var found = vehicleRepository.findById(vehicleModel.id()).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        found.setName(vehicleModel.name());
        found.setYear(vehicleModel.year());
        found.setColor(vehicleModel.color());
        return VehicleMapper.toDto(found);
    }

    public void delete(long id){
        var found = vehicleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        vehicleRepository.delete(found);
    }






}
