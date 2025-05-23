package Busqueda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
