package Model.Marcas;

import java.util.UUID;

import core.Entity;

public class Marca extends Entity<UUID> {

    public String nombre;

    public Marca(String nombre) {
        key = UUID.randomUUID();
        this.nombre = nombre;
    }

}
