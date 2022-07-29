package UseCases.Command.Marcas.Eliminar;

import Dto.MarcaDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class EliminarMarcaCommand implements Request<MarcaDto> {

  MarcaDto marca;

  public EliminarMarcaCommand(UUID key) {
    this.marca = new MarcaDto();
    this.marca.key = key;
  }
}
