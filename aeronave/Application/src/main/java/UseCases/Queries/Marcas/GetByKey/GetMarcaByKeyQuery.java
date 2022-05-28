package UseCases.Queries.Marcas.GetByKey;

import java.util.UUID;
import Dto.AeronaveDto;
import fourteam.mediator.Request;

public class GetMarcaByKeyQuery implements Request<AeronaveDto> {

    public GetMarcaByKeyQuery(UUID key) {
        this.key = key;
    }

    public UUID key;

}
