package Busqueda.Busqueda.Modelo;
import java.util.Date;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "busqueda")

public class BusquedaModelo {
    @Id
    @Column(unique = true, nullable = false, lenght = 13)
    private String rut;

    @Column (nullabel = false)
    private String nombre;

    @Column (nullabel = false)
    private String apaterno;

    @Column (nullabel = false)
    private String amaterno;

    @Column (unique = true, nullabel = false)
    private String correo;

    @Column (nullabel = false)
    private String direccion;

    @Column (unique = true, nullabel = false, lenght = 9)
    private int telefono;

    @Column (nullabel = false)
    private Date fechNacimiento;

    @Column (nullabel = false)
    private int tarifa;

}
