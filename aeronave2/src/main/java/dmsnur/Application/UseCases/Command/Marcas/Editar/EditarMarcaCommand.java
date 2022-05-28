package dmsnur.Application.UseCases.Command.Marcas.Editar;

import java.util.UUID;

import dmsnur.Application.Dto.MarcaDto;
import dmsnur.SharedKernel.mediator.Request;

public class EditarMarcaCommand implements Request<MarcaDto> {

    public MarcaDto marca;

    public EditarMarcaCommand(UUID key) {
        this.marca = new MarcaDto();
        this.marca.key = key;
    }

}
