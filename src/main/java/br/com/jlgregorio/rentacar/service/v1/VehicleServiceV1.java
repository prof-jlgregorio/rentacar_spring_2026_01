package br.com.jlgregorio.rentacar.service.v1;

import br.com.jlgregorio.rentacar.dto.v1.VehicleDtoV1;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.model.VehicleModel;
import br.com.jlgregorio.rentacar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceV1 {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleDtoV1 findById(long id){
        var found = vehicleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        return CustomModelMapper.parseObject(found, VehicleDtoV1.class);
    }

    public List<VehicleDtoV1> findAll(){
        List<VehicleModel> vehicles = vehicleRepository.findAll();
        return CustomModelMapper.parseObjectList(vehicles, VehicleDtoV1.class);
    }

    public VehicleDtoV1 create(VehicleDtoV1 vehicleDto){
        VehicleModel vehicleModel = CustomModelMapper.parseObject(vehicleDto, VehicleModel.class);
        return CustomModelMapper.parseObject(vehicleRepository.save(vehicleModel), VehicleDtoV1.class);
    }

    public VehicleDtoV1 update(VehicleDtoV1 vehicleModel){
        var found = vehicleRepository.findById(vehicleModel.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        found.setName(vehicleModel.getName());
        found.setYear(vehicleModel.getYear());
        found.setColor(vehicleModel.getColor());
        return CustomModelMapper.parseObject(vehicleRepository.save(found), VehicleDtoV1.class);
    }

    public void delete(long id){
        var found = vehicleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        vehicleRepository.delete(found);
    }






}
