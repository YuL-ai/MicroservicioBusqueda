package Busqueda.Busqueda.Controller;

import Busqueda.Busqueda.Modelo.BusquedaModelo;
import Busqueda.Busqueda.Service.BusquedaService;
import Busqueda.Busqueda.assemblers.BusquedaModeloAssemblers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/busqueda")
public class BusquedaControllerV2 {

    @Autowired
    private BusquedaService busquedaService;

    @Autowired
    private BusquedaModeloAssemblers assembler;

    @GetMapping
    public CollectionModel<EntityModel<BusquedaModelo>> findAll() {
        List<EntityModel<BusquedaModelo>> busquedas = busquedaService.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(busquedas,
                linkTo(methodOn(BusquedaControllerV2.class).findAll()).withSelfRel());
    }

    @GetMapping("/{rut}")
    public EntityModel<BusquedaModelo> findByRut(@PathVariable String rut) {
        BusquedaModelo busqueda = busquedaService.findByRut(rut);
        return assembler.toModel(busqueda);
    }

    // Filtros por parámetros

    @GetMapping("/nombre-apaterno-amaterno")
    public CollectionModel<EntityModel<BusquedaModelo>> findByNombreAndApaternoAndAmaterno(
            @RequestParam String nombre,
            @RequestParam String apaterno,
            @RequestParam String amaterno) {
        List<EntityModel<BusquedaModelo>> resultado = busquedaService
                .findByNombreAndApaternoAndAmaterno(nombre, apaterno, amaterno)
                .stream().map(assembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(resultado);
    }

    @GetMapping("/tarifa")
    public CollectionModel<EntityModel<BusquedaModelo>> findByTarifa(@RequestParam int tarifa) {
        List<EntityModel<BusquedaModelo>> resultado = busquedaService.findByTarifa(tarifa)
                .stream().map(assembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(resultado);
    }

    @GetMapping("/direccion")
    public CollectionModel<EntityModel<BusquedaModelo>> findByDireccion(@RequestParam String direccion) {
        List<EntityModel<BusquedaModelo>> resultado = busquedaService.findByDireccion(direccion)
                .stream().map(assembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(resultado);
    }

    @GetMapping("/rating")
    public CollectionModel<EntityModel<BusquedaModelo>> findByRating(@RequestParam String rating) {
        List<EntityModel<BusquedaModelo>> resultado = busquedaService.findByRating(rating)
                .stream().map(assembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(resultado);
    }

    // Crear nuevo
    @PostMapping
    public ResponseEntity<EntityModel<BusquedaModelo>> create(@RequestBody BusquedaModelo busquedaModelo) {
        BusquedaModelo creado = busquedaService.save(busquedaModelo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(assembler.toModel(creado));
    }

    // Actualizar
    @PutMapping("/{rut}")
    public EntityModel<BusquedaModelo> update(@PathVariable String rut, @RequestBody BusquedaModelo nuevo) {
        BusquedaModelo existente = busquedaService.findByRut(rut);
        existente.setNombre(nuevo.getNombre());
        existente.setApaterno(nuevo.getApaterno());
        existente.setAmaterno(nuevo.getAmaterno());
        existente.setCorreo(nuevo.getCorreo());
        existente.setDireccion(nuevo.getDireccion());
        existente.setTelefono(nuevo.getTelefono());
        existente.setFechaNacimiento(nuevo.getFechaNacimiento());
        existente.setTarifa(nuevo.getTarifa());
        existente.setRating(nuevo.getRating());

        BusquedaModelo actualizado = busquedaService.save(existente);
        return assembler.toModel(actualizado);
    }

    // Eliminar
    @DeleteMapping("/{rut}")
    public ResponseEntity<?> delete(@PathVariable String rut) {
        busquedaService.delete(rut);
        return ResponseEntity.noContent().build();
    }
}
