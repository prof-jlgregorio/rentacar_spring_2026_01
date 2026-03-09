package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.dto.VehicleDto;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
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
        return CustomModelMapper.parseObject(found, VehicleDto.class);
    }

    public List<VehicleDto> findAll(){
        List<VehicleModel> vehicles = vehicleRepository.findAll();
        return CustomModelMapper.parseObjectList(vehicles, VehicleDto.class);
    }

    public VehicleDto create(VehicleDto vehicleDto){
        VehicleModel vehicleModel = CustomModelMapper.parseObject(vehicleDto, VehicleModel.class);
        return CustomModelMapper.parseObject(vehicleRepository.save(vehicleModel), VehicleDto.class);
    }

    public VehicleDto update(VehicleDto vehicleModel){
        var found = vehicleRepository.findById(vehicleModel.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        found.setName(vehicleModel.getName());
        found.setYear(vehicleModel.getYear());
        found.setColor(vehicleModel.getColor());
        return CustomModelMapper.parseObject(vehicleRepository.save(found), VehicleDto.class);
    }

    public void delete(long id){
        var found = vehicleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        vehicleRepository.delete(found);
    }






}
