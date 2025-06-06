package Busqueda.Busqueda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Busqueda.Busqueda.Modelo.BusquedaModelo;
import Busqueda.Busqueda.Service.BusquedaService;

@RestController
@RequestMapping("/api/v1/busqueda")
public class BusquedaController {
    @Autowired
    private BusquedaService busquedaService;

    @GetMapping
   public List<BusquedaModelo> findAll() {
       return busquedaService.findAll();
   }

    @GetMapping("/nombre-apaterno-amaterno")
    public List<BusquedaModelo> findByNombreAndApaternoAndAmaterno(String nombre, String apaterno, String amaterno) {
        return busquedaService.findByNombreAndApaternoAndAmaterno(nombre, apaterno, amaterno);
    }

    @GetMapping("/tarifa")
    public List<BusquedaModelo> findByTarifa(int tarifa) {
        return busquedaService.findByTarifa(tarifa);
    }

    @GetMapping("/direccion")
    public List<BusquedaModelo> findByDireccion(String direccion) {
        return busquedaService.findByDireccion(direccion);
    }

    @GetMapping("/rating")
    public List<BusquedaModelo> findByRating(String rating) {
        return busquedaService.findByRating(rating);
    }
    
    @PostMapping()
    public ResponseEntity<BusquedaModelo> createBusqueda(@RequestBody BusquedaModelo busquedaModelo) {
        BusquedaModelo newbusqueda = busquedaService.save(busquedaModelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newbusqueda);
    }
    @PutMapping("/rut")
    public ResponseEntity<BusquedaModelo> updateBusqueda(@PathVariable String rut, @RequestBody BusquedaModelo busquedaModelo) {
        try {
            BusquedaModelo newBusqueda = busquedaService.findByRut(rut);
            newBusqueda.setNombre(busquedaModelo.getNombre());
            newBusqueda.setApaterno(busquedaModelo.getApaterno());
            newBusqueda.setAmaterno(busquedaModelo.getAmaterno());
            newBusqueda.setCorreo(busquedaModelo.getCorreo());
            newBusqueda.setDireccion(busquedaModelo.getDireccion());
            newBusqueda.setTelefono(busquedaModelo.getTelefono());
            newBusqueda.setFechaNacimiento(busquedaModelo.getFechaNacimiento());
            newBusqueda.setTarifa(busquedaModelo.getTarifa());
            newBusqueda.setRating(busquedaModelo.getRating());
            return ResponseEntity.ok(busquedaModelo);
              
        } catch (Exception e) {
            
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<Void> deleteBusqueda(@PathVariable String rut) {
        busquedaService.delete(rut);
        return ResponseEntity.noContent().build();
           
    }

}
