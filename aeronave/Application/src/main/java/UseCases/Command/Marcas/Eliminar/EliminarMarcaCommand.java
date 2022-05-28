package UseCases.Command.Marcas.Eliminar;

import java.util.UUID;

import Dto.MarcaDto;
import mediator.Request;

public class EliminarMarcaCommand implements Request<MarcaDto> {

    MarcaDto marca;

    public EliminarMarcaCommand(UUID key) {
        this.marca = new MarcaDto();
        this.marca.key = key;
    }

}
