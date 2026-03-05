package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.model.VehicleModel;
import br.com.jlgregorio.rentacar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleModel> create(@RequestBody VehicleModel vehicleModel){
        var created = vehicleService.create(vehicleModel);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleModel> findById(@PathVariable long id){
        var found = vehicleService.findById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleModel>> findAll(){
       var vehicles = vehicleService.findAll();
       return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<VehicleModel> update(@RequestBody VehicleModel vehicleModel){
        var updated = vehicleService.update(vehicleModel);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(long id){
        vehicleService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
