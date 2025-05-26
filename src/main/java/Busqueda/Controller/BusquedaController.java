package Busqueda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Busqueda.Busqueda.Modelo.BusquedaModelo;
import Busqueda.Service.BusquedaService;

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

    @PutMapping("/rut")
    public ResponseEntity<BusquedaModelo> updateBusqueda(@PathVariable String rut, @RequestBody BusquedaModelo busquedaModelo) {
        try {
            BusquedaModelo newBusqueda = BusquedaService.findById(rut);
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
            // TODO: handle exception
        }
    }

}
