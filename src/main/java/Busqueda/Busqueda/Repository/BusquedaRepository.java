package Busqueda.Busqueda.Repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Busqueda.Busqueda.Modelo.BusquedaModelo;

public interface BusquedaRepository extends JpaRepository<BusquedaModelo, String> {

    List<BusquedaModelo> findByNombre(String nombre);

    List<BusquedaModelo> findByCorreo(String correo);

    List<BusquedaModelo> findByNombreAndApaterno (String nombre, String apaterno);

    List<BusquedaModelo> findByTarifa(int tarifa);

    List<BusquedaModelo> findByFechaNacimiento (Date fechNacimiento);

    List<BusquedaModelo> findByDireccion (String direccion);

    List<BusquedaModelo> findByNombreAndApaternoAndAmaterno (String nombre, String apaterno, String amaterno);


   
}
