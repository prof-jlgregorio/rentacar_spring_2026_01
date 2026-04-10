package br.com.jlgregorio.rentacar.controller.v2;

import br.com.jlgregorio.rentacar.dto.v2.BrandDtoV2;
import br.com.jlgregorio.rentacar.exception.CustomExceptionResponse;
import br.com.jlgregorio.rentacar.service.v2.BrandServiceV2;
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
@RequestMapping("/v2/brands")
@Tag(name = "Brands (Marcas)", description = "Esse endpoint é específico para operações que envolvem Brand")
public class BrandControllerV2 {

    @Autowired
    private BrandServiceV2 brandService;

    @PostMapping
    @Operation(summary = "Cria um objeto BrandDto", responses = {
            @ApiResponse(description = "O objeto BrandDto criado", responseCode = "201", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = BrandDtoV2.class)
            ))
    })
    public ResponseEntity<BrandDtoV2> create(@RequestBody BrandDtoV2 brandDto){
        BrandDtoV2 created = brandService.create(brandDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna um objeto BrandDto mediante um id informado", responses = {
            @ApiResponse(description = "O objeto BrandDto", responseCode = "200", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = BrandDtoV2.class)
            )),
            @ApiResponse(description = "Brand não encontrada", responseCode = "404", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CustomExceptionResponse.class)
            ))
    })
    public ResponseEntity<BrandDtoV2> findById(@PathVariable("id") long id){
        BrandDtoV2 found = brandService.findById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BrandDtoV2>> findAll(){
        var brands = brandService.findAll();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BrandDtoV2> update(@RequestBody BrandDtoV2 brandDto){
        BrandDtoV2 updated = brandService.update(brandDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        brandService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }


}
