package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.dto.BrandDto;
import br.com.jlgregorio.rentacar.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<BrandDto> create(@RequestBody BrandDto brandDto){
        BrandDto created = brandService.create(brandDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> findById(@PathVariable("id") long id){
        BrandDto found = brandService.findById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> findAll(){
        var brands = brandService.findAll();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BrandDto> update(@RequestBody BrandDto brandDto){
        BrandDto updated = brandService.update(brandDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        brandService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }


}
