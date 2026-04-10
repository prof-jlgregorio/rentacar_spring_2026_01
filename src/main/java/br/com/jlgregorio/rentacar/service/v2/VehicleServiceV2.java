package br.com.jlgregorio.rentacar.service.v2;

import br.com.jlgregorio.rentacar.dto.v2.VehicleDtoV2;
import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.model.VehicleModel;
import br.com.jlgregorio.rentacar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceV2 {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleDtoV2 findById(long id){
        var found = vehicleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        return CustomModelMapper.parseObject(found, VehicleDtoV2.class);
    }

    public List<VehicleDtoV2> findAll(){
        List<VehicleModel> vehicles = vehicleRepository.findAll();
        return CustomModelMapper.parseObjectList(vehicles, VehicleDtoV2.class);
    }

    public VehicleDtoV2 create(VehicleDtoV2 vehicleDto){
        VehicleModel vehicleModel = CustomModelMapper.parseObject(vehicleDto, VehicleModel.class);
        return CustomModelMapper.parseObject(vehicleRepository.save(vehicleModel), VehicleDtoV2.class);
    }

    public VehicleDtoV2 update(VehicleDtoV2 vehicleModel){
        var found = vehicleRepository.findById(vehicleModel.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        found.setName(vehicleModel.getName());
        found.setYear(vehicleModel.getYear());
        found.setColor(vehicleModel.getColor());
        found.setObservations(vehicleModel.getObservations());
        return CustomModelMapper.parseObject(vehicleRepository.save(found), VehicleDtoV2.class);
    }

    public void delete(long id){
        var found = vehicleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        vehicleRepository.delete(found);
    }






}
