package UseCases.Command.Aeronaves.Crear;

import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.RequestHandler;

public class CrearAeronaveHandler implements RequestHandler<CrearAeronaveCommand, Aeronave> {

    private IAeronaveFactory _aeronaveFactory;
    private IAeronaveRepository _aeronaveRepository;
    private IUnitOfWork _unitOfWork;

    public CrearAeronaveHandler(IAeronaveFactory aeronaveFactory, IAeronaveRepository aeronaveRepository,
            IUnitOfWork _unitOfWork) {
        this._aeronaveFactory = aeronaveFactory;
        this._aeronaveRepository = aeronaveRepository;
        this._unitOfWork = _unitOfWork;
    }

    @Override
    public Aeronave handle(CrearAeronaveCommand request) throws HttpException {
        Aeronave aeronave = _aeronaveFactory.Create(request.matricula);
        aeronave.eventCreado();
        _aeronaveRepository.Create(aeronave);
        _unitOfWork.commit();
        return aeronave;

    }

}
