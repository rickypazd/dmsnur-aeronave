package dmsnur.Infraestructure;

import dmsnur.Domain.Repositories.*;
import dmsnur.SharedKernel.extensions.IServiceCollection;
import dmsnur.Infraestructure.Context.IWriteDbContext;
import dmsnur.Infraestructure.Repository.*;

public class Extensions {
    public static void AddInfraestructure() {
        dmsnur.Application.Extensions.AddApplication();
        IServiceCollection.AddMediator();

        IServiceCollection.AddScoped(IWriteDbContext.class, dmsnur.Infraestructure.Context.MongoDB.WriteDbContext.class);
        IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
        IServiceCollection.AddScoped(IAeronaveRepository.class, AeronaveRepository.class);
        IServiceCollection.AddScoped(IAsientoRepository.class, AsientoRepository.class);
        IServiceCollection.AddScoped(IMarcaRepository.class, MarcaRepository.class);
    }
}
