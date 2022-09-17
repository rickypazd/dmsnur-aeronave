package IntegrationEvents;

import core.IntegrationEvent;
import java.util.List;
import java.util.UUID;

public class AeronaveCreado extends IntegrationEvent {

  public UUID keyAeronave;
  public String matricula;
  public String keyModelo;
  public List<AsientoDto> asientos;

  public UUID getKeyAeronave() {
    return keyAeronave;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setKeyAeronave(UUID keyAeronave) {
    this.keyAeronave = keyAeronave;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public List<AsientoDto> getAsientos() {
    return this.asientos;
  }

  public void setAsientos(List<AsientoDto> asientos) {
    this.asientos = asientos;
  }

  public class AsientoDto {

    public UUID key;
    public UUID keyAeronave;
    public int numero;
    public String clase;

    public UUID getKey() {
      return key;
    }

    public UUID getKeyAeronave() {
      return keyAeronave;
    }

    public String getClase() {
      return clase;
    }

    public int getNumero() {
      return numero;
    }

    public void setClase(String clase) {
      this.clase = clase;
    }

    public void setKey(UUID key) {
      this.key = key;
    }

    public void setKeyAeronave(UUID keyAeronave) {
      this.keyAeronave = keyAeronave;
    }

    public void setNumero(int numero) {
      this.numero = numero;
    }
  }
}
