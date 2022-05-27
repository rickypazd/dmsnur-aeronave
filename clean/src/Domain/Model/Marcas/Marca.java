package Domain.Model.Marcas;

import java.util.UUID;

import SharedKernel.core.Entity;

public class Marca extends Entity<UUID> {

    public String nombre;

    public Marca(String nombre) {
        key = UUID.randomUUID();
        this.nombre = nombre;
    }

}
