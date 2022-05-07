package Application.UseCases.Command.Marcas.Crear;

import Domain.Factories.IMarcaFactory;
import Domain.Model.Marcas.Marca;
import Domain.Repositories.IMarcaRepository;
import Domain.Repositories.IUnitOfWork;
import SharedKernel.http.Exception.HttpException;
import SharedKernel.mediator.RequestHandler;

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
