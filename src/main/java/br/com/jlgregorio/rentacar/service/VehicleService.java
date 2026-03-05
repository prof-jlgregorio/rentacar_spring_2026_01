package br.com.jlgregorio.rentacar.service;

import br.com.jlgregorio.rentacar.exception.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.model.VehicleModel;
import br.com.jlgregorio.rentacar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleModel findById(long id){
        var found = vehicleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        return found;
    }

    public List<VehicleModel> findAll(){
        List<VehicleModel> vehicles = vehicleRepository.findAll();
        return vehicles;
    }

    public VehicleModel create(VehicleModel vehicleModel){
        return vehicleRepository.save(vehicleModel);
    }

    public VehicleModel update(VehicleModel vehicleModel){
        var found = vehicleRepository.findById(vehicleModel.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        found.setName(vehicleModel.getName());
        found.setYear(vehicleModel.getYear());
        found.setColor(vehicleModel.getColor());
        return vehicleRepository.save(found);
    }

    public void delete(long id){
        var found = vehicleRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Veículo não encontrado!")
        );
        vehicleRepository.delete(found);
    }






}
