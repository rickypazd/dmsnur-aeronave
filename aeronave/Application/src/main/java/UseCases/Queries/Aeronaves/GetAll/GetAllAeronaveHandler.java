package UseCases.Queries.Aeronaves.GetAll;

import java.util.List;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import mediator.RequestHandler;

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
