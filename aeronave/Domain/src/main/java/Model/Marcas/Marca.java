package Model.Marcas;

import core.Entity;
import java.util.UUID;

public class Marca extends Entity<UUID> {

  public String nombre;

  public Marca(String nombre) {
    key = UUID.randomUUID();
    this.nombre = nombre;
  }
}
