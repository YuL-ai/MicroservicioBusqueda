package Busqueda.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/busqueda")

public class BusquedaController {
    // @Autowired
    // private BusquedaService busquedaService;
    // 
    // @GetMapping("/busqueda")
    // public List<BusquedaModelo> getAll() {
    //     return busquedaService.findAll();
    // }
    // 
    // @GetMapping("/busqueda/nombre/{nombre}")
    // public List<BusquedaModelo> getByNombre(@PathVariable String nombre) {
    //     return busquedaService.findByNombre(nombre);
    // }
    // 
    // @GetMapping("/busqueda/nombre/{nombre}/apaterno/{apaterno}")
    // public List<BusquedaModelo> getByNombreAndApaterno(@PathVariable String nombre, @PathVariable String apaterno) {
    //     return busquedaService.findByNombreAndApaterno(nombre, apaterno);
    // }
}
