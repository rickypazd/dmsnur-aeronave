package dmsnur.Application.UseCases.Queries.Aeronaves.GetByKey;

import java.util.UUID;
import dmsnur.Application.Dto.AeronaveDto;
import dmsnur.SharedKernel.mediator.Request;

public class GetAeronaveByKeyQuery implements Request<AeronaveDto> {


    public GetAeronaveByKeyQuery(UUID key) {
        this.key = key;
    }

    public UUID key;

}
