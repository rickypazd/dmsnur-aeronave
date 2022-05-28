package dmsnur.Application.UseCases.Command.Aeronaves.Editar;

import java.util.UUID;

import dmsnur.Application.Dto.AeronaveDto;
import dmsnur.SharedKernel.mediator.Request;

public class EditarAeronaveCommand implements Request<AeronaveDto> {

    public AeronaveDto aeronave;

    public EditarAeronaveCommand(UUID key) {
        this.aeronave = new AeronaveDto();
        this.aeronave.key = key;
    }

}
