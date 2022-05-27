package dmsnur.Application.UseCases.Queries.Marcas.GetByKey;

import java.util.UUID;
import dmsnur.Application.Dto.AeronaveDto;
import dmsnur.SharedKernel.mediator.Request;

public class GetMarcaByKeyQuery implements Request<AeronaveDto> {

    public GetMarcaByKeyQuery(UUID key) {
        this.key = key;
    }

    public UUID key;

}
