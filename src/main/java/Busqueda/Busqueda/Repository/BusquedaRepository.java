// Define el paquete donde se encuentra esta interfaz
package Busqueda.Busqueda.Repository;

// Importaciones necesarias
import java.sql.Date; // Para manejar fechas (versión SQL)
import java.util.List; // Para trabajar con colecciones

import org.springframework.data.jpa.repository.JpaRepository;// Interfaz base de Spring Data JPA
import org.springframework.stereotype.Repository; // Para marcar esta interfaz como un componente Repository

import Busqueda.Busqueda.Modelo.BusquedaModelo; // Importa la entidad que será gestionada
@Repository  // Marca esta interfaz como un componente de repositorio de Spring
public interface BusquedaRepository extends JpaRepository<BusquedaModelo, String> {
    
    // Métodos personalizados para buscar por diferentes campos
    List<BusquedaModelo> findByNombre(String nombre);

    List<BusquedaModelo> findByCorreo(String correo);

    List<BusquedaModelo> findByTarifa(int tarifa);

    List<BusquedaModelo> findByFechaNacimiento (Date fechaNacimiento);

    List<BusquedaModelo> findByDireccion (String direccion);

    List<BusquedaModelo> findByNombreAndApaternoAndAmaterno (String nombre, String apaterno, String amaterno);

    List<BusquedaModelo> findByRating (String rating);

}
