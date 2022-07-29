package UseCases.Command.Aeronaves.Crear;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import fourteam.mediator.Request;
import java.util.List;

public class CrearAeronaveCommand implements Request<AeronaveDto> {

  public CrearAeronaveCommand(AeronaveDto ero) {
    this.matricula = ero.matricula;
  }

  public String matricula;
}
