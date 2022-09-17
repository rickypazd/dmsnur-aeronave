package IntegrationEvents;

import core.IntegrationEvent;

public class VentaCreado extends IntegrationEvent {

  private String keyVuelo;
  private int dni;
  private String nombre;
  private String apellido;

  public String getKeyVuelo() {
    return this.keyVuelo;
  }

  public void setKeyVuelo(String keyVuelo) {
    this.keyVuelo = keyVuelo;
  }

  public int getDni() {
    return this.dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return this.apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
}
