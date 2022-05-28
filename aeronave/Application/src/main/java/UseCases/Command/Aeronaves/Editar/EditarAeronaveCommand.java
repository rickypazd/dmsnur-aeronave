package UseCases.Command.Aeronaves.Editar;

import java.util.UUID;

import Dto.AeronaveDto;
import mediator.Request;

public class EditarAeronaveCommand implements Request<AeronaveDto> {

    public AeronaveDto aeronave;

    public EditarAeronaveCommand(UUID key) {
        this.aeronave = new AeronaveDto();
        this.aeronave.key = key;
    }

}
