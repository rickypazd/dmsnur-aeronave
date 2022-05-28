package UseCases.Command.Marcas.Editar;

import java.util.UUID;

import Dto.MarcaDto;
import mediator.Request;

public class EditarMarcaCommand implements Request<MarcaDto> {

    public MarcaDto marca;

    public EditarMarcaCommand(UUID key) {
        this.marca = new MarcaDto();
        this.marca.key = key;
    }

}
