package dmsnur.Application.UseCases.Queries.Marcas.GetAll;

import java.util.List;

import dmsnur.Domain.Model.Marcas.Marca;
import dmsnur.Domain.Repositories.IMarcaRepository;
import dmsnur.SharedKernel.mediator.RequestHandler;

public class GetAllMarcaHandler implements RequestHandler<GetAllMarcaQuery, List<Marca>> {

    private IMarcaRepository _marcaRepository;

    public GetAllMarcaHandler(IMarcaRepository marcaRepository) {
        this._marcaRepository = marcaRepository;
    }

    @Override
    public List<Marca> handle(GetAllMarcaQuery request) {
        return _marcaRepository.GetAll();
    }
}
