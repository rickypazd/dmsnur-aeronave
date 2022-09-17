package IntegrationEvents;

import core.IntegrationEvent;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class VueloCreado extends IntegrationEvent {

  private String keyVuelo;
  private String nroVuelo;
  private String ciudadOrigen;
  private String ciudadDestino;
  private List<Asiento> asiento;
  private Date fechaSalida;
  private Date fechaArribe;

  public String getNroVuelo() {
    return this.nroVuelo;
  }

  public void setNroVuelo(String nroVuelo) {
    this.nroVuelo = nroVuelo;
  }

  public Date getFechaSalida() {
    return this.fechaSalida;
  }

  public void setFechaSalida(Date fechaSalida) {
    this.fechaSalida = fechaSalida;
  }

  public Date getFechaArribe() {
    return this.fechaArribe;
  }

  public void setFechaArribe(Date fechaArribe) {
    this.fechaArribe = fechaArribe;
  }

  public String getKeyVuelo() {
    return this.keyVuelo;
  }

  public void setKeyVuelo(String keyVuelo) {
    this.keyVuelo = keyVuelo;
  }

  public String getCiudadOrigen() {
    return this.ciudadOrigen;
  }

  public void setCiudadOrigen(String ciudadOrigen) {
    this.ciudadOrigen = ciudadOrigen;
  }

  public String getCiudadDestino() {
    return this.ciudadDestino;
  }

  public void setCiudadDestino(String ciudadDestino) {
    this.ciudadDestino = ciudadDestino;
  }

  public List<Asiento> getAsiento() {
    return this.asiento;
  }

  public void setAsiento(List<Asiento> asiento) {
    this.asiento = asiento;
  }

  public class Asiento {

    private UUID key;
    private String numero;
    private int disponibilidad;

    public void setKey(UUID key) {
      this.key = key;
    }

    public UUID getKey() {
      return key;
    }

    public void setNumero(String numero) {
      this.numero = numero;
    }

    public String getNumero() {
      return numero;
    }

    public void setDisponibilidad(int disponibilidad) {
      this.disponibilidad = disponibilidad;
    }

    public int getDisponibilidad() {
      return disponibilidad;
    }
  }
}
