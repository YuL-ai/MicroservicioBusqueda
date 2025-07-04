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

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v1/busqueda")
public class BusquedaController {

    @Autowired
    private BusquedaService busquedaService;

    @Autowired
    private BusquedaModeloAssemblers assembler;

    // Obtener todos
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<BusquedaModelo>>> getAll() {
        List<BusquedaModelo> lista = busquedaService.findAll();
        List<EntityModel<BusquedaModelo>> modelos = lista.stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                CollectionModel.of(modelos,
                        linkTo(methodOn(BusquedaController.class).getAll()).withSelfRel())
        );
    }

    // Buscar por RUT
    @GetMapping("/{rut}")
    public ResponseEntity<EntityModel<BusquedaModelo>> getByRut(@PathVariable String rut) {
        BusquedaModelo modelo = busquedaService.findByRut(rut);
        return ResponseEntity.ok(assembler.toModel(modelo));
    }

    // Buscar por nombre
    @GetMapping("/buscar/nombre")
    public ResponseEntity<CollectionModel<EntityModel<BusquedaModelo>>> findByNombre(@RequestParam String nombre) {
        List<BusquedaModelo> resultados = busquedaService.findByNombre(nombre);
        return buildCollectionModel(resultados);
    }

    // Buscar por nombre + apellidos
    @GetMapping("/buscar/nombre-completo")
    public ResponseEntity<CollectionModel<EntityModel<BusquedaModelo>>> findByNombreCompleto(
            @RequestParam String nombre,
            @RequestParam String apaterno,
            @RequestParam String amaterno) {
        List<BusquedaModelo> resultados = busquedaService.findByNombreAndApaternoAndAmaterno(nombre, apaterno, amaterno);
        return buildCollectionModel(resultados);
    }

    // Buscar por tarifa
    @GetMapping("/buscar/tarifa")
    public ResponseEntity<CollectionModel<EntityModel<BusquedaModelo>>> findByTarifa(@RequestParam int tarifa) {
        List<BusquedaModelo> resultados = busquedaService.findByTarifa(tarifa);
        return buildCollectionModel(resultados);
    }

    // Buscar por fecha de nacimiento
    @GetMapping("/buscar/fecha-nacimiento")
    public ResponseEntity<CollectionModel<EntityModel<BusquedaModelo>>> findByFechaNacimiento(@RequestParam Date fechaNacimiento) {
        List<BusquedaModelo> resultados = busquedaService.findByFechaNacimiento(fechaNacimiento);
        return buildCollectionModel(resultados);
    }

    // Buscar por dirección
    @GetMapping("/buscar/direccion")
    public ResponseEntity<CollectionModel<EntityModel<BusquedaModelo>>> findByDireccion(@RequestParam String direccion) {
        List<BusquedaModelo> resultados = busquedaService.findByDireccion(direccion);
        return buildCollectionModel(resultados);
    }

    // Buscar por correo
    @GetMapping("/buscar/correo")
    public ResponseEntity<CollectionModel<EntityModel<BusquedaModelo>>> findByCorreo(@RequestParam String correo) {
        List<BusquedaModelo> resultados = busquedaService.findByCorreo(correo);
        return buildCollectionModel(resultados);
    }

    // Buscar por rating
    @GetMapping("/buscar/rating")
    public ResponseEntity<CollectionModel<EntityModel<BusquedaModelo>>> findByRating(@RequestParam String rating) {
        List<BusquedaModelo> resultados = busquedaService.findByRating(rating);
        return buildCollectionModel(resultados);
    }

    // Crear nuevo
    @PostMapping
    public ResponseEntity<EntityModel<BusquedaModelo>> create(@RequestBody BusquedaModelo busqueda) {
        BusquedaModelo creado = busquedaService.save(busqueda);
        return new ResponseEntity<>(assembler.toModel(creado), HttpStatus.CREATED);
    }

    // Actualizar por RUT
    @PutMapping("/{rut}")
    public ResponseEntity<EntityModel<BusquedaModelo>> update(@PathVariable String rut, @RequestBody BusquedaModelo busqueda) {
        BusquedaModelo actualizado = busquedaService.update(rut, busqueda);
        return ResponseEntity.ok(assembler.toModel(actualizado));
    }

    // Eliminar por RUT
    @DeleteMapping("/{rut}")
    public ResponseEntity<Void> delete(@PathVariable String rut) {
        busquedaService.delete(rut);
        return ResponseEntity.noContent().build();
    }

    // Utilidad para construir listas con HATEOAS
    private ResponseEntity<CollectionModel<EntityModel<BusquedaModelo>>> buildCollectionModel(List<BusquedaModelo> lista) {
        List<EntityModel<BusquedaModelo>> modelos = lista.stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(
                CollectionModel.of(modelos,
                        linkTo(methodOn(BusquedaController.class).getAll()).withRel("todos"))
        );
    }
}
