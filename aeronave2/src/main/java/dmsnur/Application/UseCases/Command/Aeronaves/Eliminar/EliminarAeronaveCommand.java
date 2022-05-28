package dmsnur.Application.UseCases.Command.Aeronaves.Eliminar;

import java.util.UUID;

import dmsnur.Application.Dto.AeronaveDto;
import dmsnur.SharedKernel.mediator.Request;

public class EliminarAeronaveCommand implements Request<AeronaveDto> {

    AeronaveDto aeronave;
    public EliminarAeronaveCommand(UUID key) {
        this.aeronave = new AeronaveDto();
        this.aeronave.key = key;
    }

}
