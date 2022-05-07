package Application.UseCases.Queries.Marcas.GetByKey;

import java.util.UUID;
import Application.Dto.AeronaveDto;
import SharedKernel.mediator.Request;

public class GetMarcaByKeyQuery implements Request<AeronaveDto> {

    public GetMarcaByKeyQuery(UUID key) {
        this.key = key;
    }

    public UUID key;

}
