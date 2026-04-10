package br.com.jlgregorio.rentacar.controller.v2;

import br.com.jlgregorio.rentacar.dto.v2.VehicleDtoV2;
import br.com.jlgregorio.rentacar.service.v2.VehicleServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/vehicles")
public class VehicleControllerV2 {

    @Autowired
    private VehicleServiceV2 vehicleService;

    @PostMapping
    public ResponseEntity<VehicleDtoV2> create(@RequestBody VehicleDtoV2 vehicleDto){
        var created = vehicleService.create(vehicleDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDtoV2> findById(@PathVariable long id){
        var found = vehicleService.findById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDtoV2>> findAll(){
       var vehicles = vehicleService.findAll();
       return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<VehicleDtoV2> update(@RequestBody VehicleDtoV2 vehicleDto){
        var updated = vehicleService.update(vehicleDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(long id){
        vehicleService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
