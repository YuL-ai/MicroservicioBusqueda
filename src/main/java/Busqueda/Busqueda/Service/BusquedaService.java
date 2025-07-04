package Busqueda.Busqueda.Service;

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
        return busquedaRepository.findById(rut)
        .orElseThrow(() -> new RuntimeException("No se encontró usuario con RUT: " + rut));
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
    public List<BusquedaModelo> findByFechaNacimiento(Date fechaNacimiento) {
        return busquedaRepository.findByFechaNacimiento(fechaNacimiento);
    }
    public List<BusquedaModelo> findByDireccion(String direccion) {
        return busquedaRepository.findByDireccion(direccion);
    }
    
    public List<BusquedaModelo> findByCorreo(String correo) {
        return busquedaRepository.findByCorreo(correo);
    }

    public List<BusquedaModelo> findByRating(String rating) {
        return busquedaRepository.findByRating(rating);
    }
    public void delete(String rut) {
        busquedaRepository.deleteById(rut);
    }
    public BusquedaModelo save(BusquedaModelo busqueda) {
        return busquedaRepository.save(busqueda);
    }

    public BusquedaModelo update(String rut, BusquedaModelo nuevosDatos) {
    BusquedaModelo existente = findByRut(rut);  // Reutiliza tu método existente
    if (existente == null) {
        throw new RuntimeException("No se encontró el registro con RUT: " + rut);
    }

    // Actualiza campos necesarios (ejemplo)
    existente.setNombre(nuevosDatos.getNombre());
    existente.setApaterno(nuevosDatos.getApaterno());
    existente.setAmaterno(nuevosDatos.getAmaterno());
    existente.setTarifa(nuevosDatos.getTarifa());
    existente.setCorreo(nuevosDatos.getCorreo());
    existente.setDireccion(nuevosDatos.getDireccion());
    existente.setFechaNacimiento(nuevosDatos.getFechaNacimiento());
    existente.setRating(nuevosDatos.getRating());

    return save(existente);  // Guarda el objeto actualizado
}
}