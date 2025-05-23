package Busqueda.Busqueda.Modelo;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "busqueda")

public class BusquedaModelo {
    @Id
    @Column(unique = true, nullable = false, length = 13)
    private String rut;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable = false)
    private String apaterno;

    @Column (nullable = false)
    private String amaterno;

    @Column (unique = true, nullable  = false)
    private String correo;

    @Column (nullable = false)
    private String direccion;

    @Column (unique = true, nullable = false, length = 9)
    private int telefono;

    @Column (nullable = false)
    private Date fechaNacimiento;

    @Column (nullable = false)
    private int tarifa;

    @Column (nullable = false)
    private String rating;

    

}
