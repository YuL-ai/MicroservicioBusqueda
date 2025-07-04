package Busqueda.Busqueda;

import Busqueda.Busqueda.Modelo.BusquedaModelo;
import Busqueda.Busqueda.Repository.BusquedaRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private BusquedaRepository busquedaRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            BusquedaModelo usuario = new BusquedaModelo();

            usuario.setRut(faker.idNumber().valid().replaceAll("[^0-9kK]", "").substring(0, 8)); // Ajustar largo si es necesario
            usuario.setNombre(faker.name().firstName());
            usuario.setApaterno(faker.name().lastName());
            usuario.setAmaterno(faker.name().lastName());
            usuario.setCorreo(faker.internet().emailAddress());
            usuario.setDireccion(faker.address().fullAddress());
            usuario.setTelefono(faker.number().numberBetween(100000000, 999999999));
            usuario.setFechaNacimiento(faker.date().birthday(18, 60)); // Personas entre 18 y 60 años
            usuario.setTarifa(faker.number().numberBetween(10000, 50000)); // Tarifa simulada
            usuario.setRating(faker.options().option("Excelente", "Bueno", "Regular", "Malo"));

            busquedaRepositorio.save(usuario);
        }
    }
}

