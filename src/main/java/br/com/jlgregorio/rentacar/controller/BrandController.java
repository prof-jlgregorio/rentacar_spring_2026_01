package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.model.BrandModel;
import br.com.jlgregorio.rentacar.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<BrandModel> create(@RequestBody BrandModel brandModel){
        BrandModel created = brandService.create(brandModel);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandModel> findById(@PathVariable("id") long id){
        BrandModel found = brandService.findById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

}
