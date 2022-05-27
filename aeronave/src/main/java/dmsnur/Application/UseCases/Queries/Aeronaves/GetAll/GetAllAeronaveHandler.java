package dmsnur.Application.UseCases.Queries.Aeronaves.GetAll;

import java.util.List;
import dmsnur.Domain.Model.Aeronaves.Aeronave;
import dmsnur.Domain.Repositories.IAeronaveRepository;
import dmsnur.SharedKernel.mediator.RequestHandler;

public class GetAllAeronaveHandler implements RequestHandler<GetAllAeronaveQuery, List<Aeronave>> {

    private IAeronaveRepository _aeronaveRepository;

    public GetAllAeronaveHandler(IAeronaveRepository aeronaveRepository) {
        this._aeronaveRepository = aeronaveRepository;
    }

    @Override
    public List<Aeronave> handle(GetAllAeronaveQuery request) {
        return _aeronaveRepository.GetAll();
    }
}
