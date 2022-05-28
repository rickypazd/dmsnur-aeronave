
import Repositories.*;
import extensions.IServiceCollection;
import Context.IWriteDbContext;
import Repository.*;

public class Infraestructure {
    public static void AddInfraestructure() {
        
        IServiceCollection.AddMediator();
        IServiceCollection.AddScoped(IWriteDbContext.class, Context.MongoDB.WriteDbContext.class);
        IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
        IServiceCollection.AddScoped(IAeronaveRepository.class, AeronaveRepository.class);
        IServiceCollection.AddScoped(IAsientoRepository.class, AsientoRepository.class);
        IServiceCollection.AddScoped(IMarcaRepository.class, MarcaRepository.class);

        Application.AddApplication();
    }
}
