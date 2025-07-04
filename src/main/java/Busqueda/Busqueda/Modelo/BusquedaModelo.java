// Define el paquete donde se encuentra esta clase
package Busqueda.Busqueda.Modelo;

// Importaciones necesarias
import java.util.Date; // Para manejar fechas

import jakarta.persistence.*; // Anotaciones de JPA para persistencia
import lombok.AllArgsConstructor; // Genera constructor con todos los campos
import lombok.Data; // Genera getters, setters, toString, equals y hashCode
import lombok.NoArgsConstructor; // Genera constructor vacío

@Data // Anotación de Lombok para generar métodos getter, setter, toString, etc.
@AllArgsConstructor // Genera un constructor con todos los argumentos
@NoArgsConstructor // Genera un constructor sin argumentos (requerido por JPA)
@Entity // Indica que esta clase es una entidad JPA
@Table(name = "busqueda") // Especifica el nombre de la tabla en la base de datos

public class BusquedaModelo {
    @Id // Campo que actuará como clave primaria

    // Configuración de columna: único, no nulo y con longitud máxima de 13 caracteres
    @Column(unique = true, nullable = false, length = 13)
    private String rut;

    // Nombre del usuario - campo obligatorio
    @Column (nullable = false)
    private String nombre;

    // Apellido paterno - campo obligatorio
    @Column (nullable = false)
    private String apaterno;

    // Apellido materno - campo obligatorio
    @Column (nullable = false)
    private String amaterno;

    // Correo electrónico - debe ser único y obligatorio
    @Column (unique = true, nullable  = false)
    private String correo;

    // Dirección física - campo obligatorio
    @Column (nullable = false)
    private String direccion;

    // Número de teléfono - único, obligatorio y de exactamente 9 dígitos
    // NOTA: Usar int puede eliminar ceros iniciales. 
    @Column (unique = true, nullable = false, length = 9)
    private int telefono;

    // Fecha de nacimiento - campo obligatorio
    @Column (nullable = false)
    private Date fechaNacimiento;

    // Tarifa del servicio - campo obligatorio (valor numérico)
    @Column (nullable = false)
    private int tarifa;

    // Calificación/valoración - campo obligatorio
    @Column (nullable = false)
    private String rating;

    

}
