package dmsnur.Application.UseCases.Queries.Marcas.GetByKey;

import dmsnur.Application.Dto.MarcaDto;
import dmsnur.Domain.Model.Marcas.Marca;
import dmsnur.Domain.Repositories.IMarcaRepository;
import dmsnur.SharedKernel.http.HttpStatus;
import dmsnur.SharedKernel.http.Exception.HttpException;
import dmsnur.SharedKernel.mediator.RequestHandler;

public class GetMarcaByKeyHandler implements RequestHandler<GetMarcaByKeyQuery, MarcaDto> {

    private IMarcaRepository _marcaRepository;

    public GetMarcaByKeyHandler(IMarcaRepository marcaRepository) {
        this._marcaRepository = marcaRepository;
    }

    @Override
    public MarcaDto handle(GetMarcaByKeyQuery request) throws HttpException {
        Marca marca = _marcaRepository.FindByKey(request.key);
        if (marca == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "marca no encontrada");
        }
        MarcaDto marcaDto = new MarcaDto();
        marcaDto.nombre = marca.nombre;
        return marcaDto;
    }
}
