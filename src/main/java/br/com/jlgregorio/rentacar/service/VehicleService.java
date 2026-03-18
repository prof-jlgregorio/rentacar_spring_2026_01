package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.dto.VehicleDto;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.mapper.VehicleMapper;
import br.com.jlgregorio.rentacar.model.VehicleModel;
import br.com.jlgregorio.rentacar.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    private final VehicleMapper vehicleMapper;

    public VehicleDto findById(long id){
        var found = vehicleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        return vehicleMapper.toDto(found);
    }

    public List<VehicleDto> findAll(){
        List<VehicleModel> vehicles = vehicleRepository.findAll();
        return vehicleMapper.toDtoList(vehicles);
    }

    public VehicleDto create(VehicleDto vehicleDto){
        VehicleModel vehicleModel = vehicleMapper.toModel(vehicleDto);
        return vehicleMapper.toDto(vehicleRepository.save(vehicleModel));
    }

    public VehicleDto update(VehicleDto vehicleDto){
        var found = vehicleRepository.findById(vehicleDto.id()).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        found.setName(vehicleDto.name());
        found.setYear(vehicleDto.year());
        found.setColor(vehicleDto.color());
        return vehicleMapper.toDto(vehicleRepository.save(found));
    }

    public void delete(long id){
        var found = vehicleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        vehicleRepository.delete(found);
    }






}
