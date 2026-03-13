package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.dto.VehicleDto;
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
    public ResponseEntity<VehicleDto> create(@RequestBody VehicleDto vehicleDto){
        var created = vehicleService.create(vehicleDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> findById(@PathVariable long id){
        var found = vehicleService.findById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> findAll(){
       var vehicles = vehicleService.findAll();
       return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<VehicleDto> update(@RequestBody VehicleDto vehicleDto){
        var updated = vehicleService.update(vehicleDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(long id){
        vehicleService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
