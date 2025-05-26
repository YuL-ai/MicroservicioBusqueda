package Busqueda.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Busqueda.Busqueda.Modelo.BusquedaModelo;
import Busqueda.Busqueda.Repository.BusquedaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class BusquedaService {
    @Autowired
    private BusquedaRepository busquedaRepository;

    public List<BusquedaModelo> findAll() {
        return busquedaRepository.findAll();
    }

    public BusquedaModelo findByRut(String rut) {
        return busquedaRepository.findById(rut).get();
    }

    public List<BusquedaModelo> findByNombre(String nombre) {
        return busquedaRepository.findByNombre(nombre);
    }

    public List<BusquedaModelo> findByNombreAndApaternoAndAmaterno(String nombre, String apaterno, String amaterno) {
        return busquedaRepository.findByNombreAndApaternoAndAmaterno(nombre, apaterno, amaterno);
    }
    
    public List<BusquedaModelo> findByTarifa(int tarifa) {
        return busquedaRepository.findByTarifa(tarifa);
    }
    public List<BusquedaModelo> findByFechaNacimiento(Date fechNacimiento) {
        return busquedaRepository.findByFechaNacimiento(fechNacimiento);
    }
    public List<BusquedaModelo> findByDireccion(String direccion) {
        return busquedaRepository.findByDireccion(direccion);
    }
    
    public List<BusquedaModelo> findByCorreo(String correo) {
        return busquedaRepository.findByCorreo(correo);
    }

    public List<BusquedaModelo> findByRating(String rating) {
        return busquedaRepository.finByrating(rating);
    }
    public void delete(String rut) {
        busquedaRepository.deleteById(rut);
    }
}