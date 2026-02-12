package uce.edu.web.api.interfaces;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import uce.edu.web.api.application.VehiculoService;
import uce.edu.web.api.application.representations.VehiculoRepresentation;

@Path ("/vehiculos")
public class VehiculoResource {
    @Inject
    private VehiculoService vehiculoService;

    @Path("")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void guardarVehiculo(VehiculoRepresentation representation) {
        this.vehiculoService.createVehiculo(representation);
    }




}
