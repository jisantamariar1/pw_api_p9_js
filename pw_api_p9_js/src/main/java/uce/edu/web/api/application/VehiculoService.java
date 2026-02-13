package uce.edu.web.api.application;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.application.representations.VehiculoRepresentation;
import uce.edu.web.api.domain.Vehiculo;
import uce.edu.web.api.infraestructure.VehiculoRepository;

@ApplicationScoped
public class VehiculoService {
    @Inject
    private VehiculoRepository vehiculoRepository;

    public void createVehiculo(VehiculoRepresentation representation) {
        Vehiculo vehiculo = this.mapperToVehiculo(representation);
        this.vehiculoRepository.persist(vehiculo);
    }

    public List<VehiculoRepresentation> getAllVehiculos() {
        List<Vehiculo> vehiculos = this.vehiculoRepository.listAll();
        List<VehiculoRepresentation> vr = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            vr.add(this.mapperToVehiculoRepresentation(v));
        }
        return vr;
    }

    public VehiculoRepresentation mapperToVehiculoRepresentation(Vehiculo vehiculo) {
        VehiculoRepresentation representation = new VehiculoRepresentation();
        
        representation.marca = vehiculo.marca;
        representation.modelo = vehiculo.modelo;
        representation.chasis = vehiculo.chasis;
        representation.fechaFabricacion = vehiculo.fechaFabricacion;
        representation.fechaMatriculacion = vehiculo.fechaMatriculacion;
        return representation;
    }

    public Vehiculo mapperToVehiculo(VehiculoRepresentation representation) {
        Vehiculo vehiculo = new Vehiculo();
       
        vehiculo.marca = representation.marca;
        vehiculo.modelo = representation.modelo;
        vehiculo.chasis = representation.chasis;
        vehiculo.fechaFabricacion = representation.fechaFabricacion;
        vehiculo.fechaMatriculacion = representation.fechaMatriculacion;
        return vehiculo;
    }

}
