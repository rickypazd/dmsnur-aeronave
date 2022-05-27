package dmsnur.Application.UseCases.Command.Marcas.Eliminar;

import java.util.UUID;

import dmsnur.Application.Dto.MarcaDto;
import dmsnur.SharedKernel.mediator.Request;

public class EliminarMarcaCommand implements Request<MarcaDto> {

    MarcaDto marca;

    public EliminarMarcaCommand(UUID key) {
        this.marca = new MarcaDto();
        this.marca.key = key;
    }

}
