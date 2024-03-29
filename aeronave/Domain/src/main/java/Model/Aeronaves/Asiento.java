package Model.Aeronaves;

import core.Entity;
import java.util.UUID;

public class Asiento extends Entity<UUID> {

  public UUID keyAeronave;
  public int numero;
  public String clase;

  public Asiento(UUID keyAeronave, int numero, String clase) {
    key = UUID.randomUUID();
    this.keyAeronave = keyAeronave;
    this.numero = numero;

    this.clase = clase;
  }
}
