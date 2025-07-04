package Busqueda.Busqueda.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import Busqueda.Busqueda.Controller.BusquedaControllerV2;
import Busqueda.Busqueda.Modelo.BusquedaModelo;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class BusquedaModeloAssemblers implements RepresentationModelAssembler<BusquedaModelo, EntityModel<BusquedaModelo>> {

    @Override
    public EntityModel<BusquedaModelo> toModel(BusquedaModelo busqueda) {
        return EntityModel.of(busqueda,
            linkTo(methodOn(BusquedaControllerV2.class).findByRut(busqueda.getRut())).withSelfRel(),
            linkTo(methodOn(BusquedaControllerV2.class).findAll()).withRel("all-busquedas"),
            linkTo(methodOn(BusquedaControllerV2.class).delete(busqueda.getRut())).withRel("delete"),
            linkTo(methodOn(BusquedaControllerV2.class).update(busqueda.getRut(), busqueda)).withRel("update")
        );
    }
}


