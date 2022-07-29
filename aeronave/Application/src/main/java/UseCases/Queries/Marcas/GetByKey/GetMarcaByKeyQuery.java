package UseCases.Queries.Marcas.GetByKey;

import Dto.AeronaveDto;
import fourteam.mediator.Request;
import java.util.UUID;

public class GetMarcaByKeyQuery implements Request<AeronaveDto> {

  public GetMarcaByKeyQuery(UUID key) {
    this.key = key;
  }

  public UUID key;
}
