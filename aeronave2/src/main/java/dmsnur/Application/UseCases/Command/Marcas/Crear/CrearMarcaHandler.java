package dmsnur.Application.UseCases.Command.Marcas.Crear;

import dmsnur.Domain.Factories.IMarcaFactory;
import dmsnur.Domain.Model.Marcas.Marca;
import dmsnur.Domain.Repositories.IMarcaRepository;
import dmsnur.Domain.Repositories.IUnitOfWork;
import dmsnur.SharedKernel.http.Exception.HttpException;
import dmsnur.SharedKernel.mediator.RequestHandler;

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
