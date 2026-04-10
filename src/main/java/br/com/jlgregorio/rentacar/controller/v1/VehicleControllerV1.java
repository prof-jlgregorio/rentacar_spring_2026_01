package br.com.jlgregorio.rentacar.controller.v1;

import br.com.jlgregorio.rentacar.dto.v1.VehicleDtoV1;
import br.com.jlgregorio.rentacar.service.v1.VehicleServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vehicles")
public class VehicleControllerV1 {

    @Autowired
    private VehicleServiceV1 vehicleService;

    @PostMapping
    public ResponseEntity<VehicleDtoV1> create(@RequestBody VehicleDtoV1 vehicleDto){
        var created = vehicleService.create(vehicleDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDtoV1> findById(@PathVariable long id){
        var found = vehicleService.findById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDtoV1>> findAll(){
       var vehicles = vehicleService.findAll();
       return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<VehicleDtoV1> update(@RequestBody VehicleDtoV1 vehicleDto){
        var updated = vehicleService.update(vehicleDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(long id){
        vehicleService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
