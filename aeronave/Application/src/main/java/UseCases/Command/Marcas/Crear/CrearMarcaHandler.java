package UseCases.Command.Marcas.Crear;

import Factories.IMarcaFactory;
import Model.Marcas.Marca;
import Repositories.IMarcaRepository;
import Repositories.IUnitOfWork;
import http.Exception.HttpException;
import mediator.RequestHandler;

public class CrearMarcaHandler implements RequestHandler<CrearMarcaCommand, Marca> {

    private IMarcaFactory _marcaFactory;
    private IMarcaRepository _marcaRepository;
    private IUnitOfWork _unitOfWork;

    public CrearMarcaHandler(IMarcaFactory marcaFactory, IMarcaRepository marcaRepository,
            IUnitOfWork _unitOfWork) {
        this._marcaFactory = marcaFactory;
        this._marcaRepository = marcaRepository;
        this._unitOfWork = _unitOfWork;
    }

    @Override
    public Marca handle(CrearMarcaCommand request) throws HttpException {
        Marca marca = _marcaFactory.Create(request.nombre);
        _marcaRepository.Create(marca);
        _unitOfWork.commit();
        return marca;

    }

}
