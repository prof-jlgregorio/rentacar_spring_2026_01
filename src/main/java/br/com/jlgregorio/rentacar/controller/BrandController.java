package br.com.jlgregorio.rentacar.controller;

import br.com.jlgregorio.rentacar.dto.BrandDto;
import br.com.jlgregorio.rentacar.exception.CustomExceptionResponse;
import br.com.jlgregorio.rentacar.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@Tag(name = "Brands (Marcas)", description = "Esse endpoint é específico para operações que envolvem Brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    @Operation(summary = "Cria um objeto BrandDto", responses = {
            @ApiResponse(description = "O objeto BrandDto criado", responseCode = "201", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = BrandDto.class)
            ))
    })
    public ResponseEntity<BrandDto> create(@RequestBody BrandDto brandModel){
        BrandDto created = brandService.create(brandModel);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna um objeto BrandDto mediante um id informado", responses = {
            @ApiResponse(description = "O objeto BrandDto", responseCode = "200", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = BrandDto.class)
            )),
            @ApiResponse(description = "Brand não encontrada", responseCode = "404", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CustomExceptionResponse.class)
            ))
    })
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
