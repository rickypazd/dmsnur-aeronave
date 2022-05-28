package UseCases.Queries.Aeronaves.GetByKey;

import java.util.UUID;
import Dto.AeronaveDto;
import mediator.Request;

public class GetAeronaveByKeyQuery implements Request<AeronaveDto> {


    public GetAeronaveByKeyQuery(UUID key) {
        this.key = key;
    }

    public UUID key;

}
