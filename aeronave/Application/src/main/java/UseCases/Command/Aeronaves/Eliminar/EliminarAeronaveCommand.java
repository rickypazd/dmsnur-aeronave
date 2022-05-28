package UseCases.Command.Aeronaves.Eliminar;

import java.util.UUID;

import Dto.AeronaveDto;
import fourteam.mediator.Request;

public class EliminarAeronaveCommand implements Request<AeronaveDto> {

    AeronaveDto aeronave;
    public EliminarAeronaveCommand(UUID key) {
        this.aeronave = new AeronaveDto();
        this.aeronave.key = key;
    }

}
