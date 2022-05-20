package Application;

import Application.UseCases.Command.Aeronaves.Crear.CrearAeronaveHandler;
import Application.UseCases.Command.Aeronaves.Editar.EditarAeronaveHandler;
import Application.UseCases.Command.Aeronaves.Eliminar.EliminarAeronaveCommand;
import Application.UseCases.Command.Aeronaves.Eliminar.EliminarAeronaveHandler;
import Application.UseCases.Command.Asientos.UpdateAsientosWhenAeronaveCreado.UpdateAsientosWhenAeronaveCreadoHandler;
import Application.UseCases.Command.Marcas.Crear.CrearMarcaHandler;
import Application.UseCases.Command.Marcas.Editar.EditarMarcaHandler;
import Application.UseCases.Command.Marcas.Eliminar.EliminarMarcaHandler;
import Application.UseCases.Queries.Aeronaves.GetAll.GetAllAeronaveHandler;
import Application.UseCases.Queries.Aeronaves.GetByKey.GetAeronaveByKeyHandler;
import Application.UseCases.Queries.Marcas.GetAll.GetAllMarcaHandler;
import Application.UseCases.Queries.Marcas.GetByKey.GetMarcaByKeyHandler;
import Domain.Factories.AeronaveFactory;
import Domain.Factories.IAeronaveFactory;
import Domain.Factories.IMarcaFactory;
import Domain.Factories.MarcaFactory;
import SharedKernel.extensions.IServiceCollection;
import SharedKernel.mediator.IMediator;

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
