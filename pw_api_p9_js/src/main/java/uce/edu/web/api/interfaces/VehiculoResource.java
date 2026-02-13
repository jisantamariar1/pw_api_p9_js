package uce.edu.web.api.interfaces;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
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
    @RolesAllowed("admin")
    public void guardarVehiculo(VehiculoRepresentation representation) {
        this.vehiculoService.createVehiculo(representation);
    }

    @Path("")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin", "user"})
    public List<VehiculoRepresentation> getAllVehiculos() {
        return this.vehiculoService.getAllVehiculos();
    }




}
