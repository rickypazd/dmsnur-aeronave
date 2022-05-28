package dmsnur.Application;

import dmsnur.Application.UseCases.Command.Aeronaves.Crear.CrearAeronaveHandler;
import dmsnur.Application.UseCases.Command.Aeronaves.Editar.EditarAeronaveHandler;
import dmsnur.Application.UseCases.Command.Aeronaves.Eliminar.EliminarAeronaveHandler;
import dmsnur.Application.UseCases.Command.Asientos.UpdateAsientosWhenAeronaveCreado.UpdateAsientosWhenAeronaveCreadoHandler;
import dmsnur.Application.UseCases.Command.Marcas.Crear.CrearMarcaHandler;
import dmsnur.Application.UseCases.Command.Marcas.Editar.EditarMarcaHandler;
import dmsnur.Application.UseCases.Command.Marcas.Eliminar.EliminarMarcaHandler;
import dmsnur.Application.UseCases.Queries.Aeronaves.GetAll.GetAllAeronaveHandler;
import dmsnur.Application.UseCases.Queries.Aeronaves.GetByKey.GetAeronaveByKeyHandler;
import dmsnur.Application.UseCases.Queries.Marcas.GetAll.GetAllMarcaHandler;
import dmsnur.Application.UseCases.Queries.Marcas.GetByKey.GetMarcaByKeyHandler;
import dmsnur.Domain.Factories.AeronaveFactory;
import dmsnur.Domain.Factories.IAeronaveFactory;
import dmsnur.Domain.Factories.IMarcaFactory;
import dmsnur.Domain.Factories.MarcaFactory;
import dmsnur.SharedKernel.extensions.IServiceCollection;
import dmsnur.SharedKernel.mediator.IMediator;

public class Extensions {

    public static void AddApplication() {
        // INFO:Usamos el IMediator del kernel en cambio del MediatR de Spring
        IMediator.registerHandler(GetAllAeronaveHandler.class);
        IMediator.registerHandler(GetAeronaveByKeyHandler.class);
        IMediator.registerHandler(CrearAeronaveHandler.class);
        IMediator.registerHandler(EliminarAeronaveHandler.class);
        IMediator.registerHandler(EditarAeronaveHandler.class);
        // MARCA
        IMediator.registerHandler(GetAllMarcaHandler.class);
        IMediator.registerHandler(GetMarcaByKeyHandler.class);
        IMediator.registerHandler(CrearMarcaHandler.class);
        IMediator.registerHandler(EliminarMarcaHandler.class);
        IMediator.registerHandler(EditarMarcaHandler.class);
        IMediator.registerHandler(UpdateAsientosWhenAeronaveCreadoHandler.class);
        IServiceCollection.AddTransient(IAeronaveFactory.class, AeronaveFactory.class);
        IServiceCollection.AddTransient(IMarcaFactory.class, MarcaFactory.class);
    }
}
