package Busqueda.Busqueda.Repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Busqueda.Busqueda.Modelo.BusquedaModelo;
@Repository
public interface BusquedaRepository extends JpaRepository<BusquedaModelo, String> {
    
    
    List<BusquedaModelo> findByNombre(String nombre);

    List<BusquedaModelo> findByCorreo(String correo);

    List<BusquedaModelo> findByTarifa(int tarifa);

    List<BusquedaModelo> findByFechaNacimiento (Date fechaNacimiento);

    List<BusquedaModelo> findByDireccion (String direccion);

    List<BusquedaModelo> findByNombreAndApaternoAndAmaterno (String nombre, String apaterno, String amaterno);

    List<BusquedaModelo> findByRating (String rating);

}
