import Context.IWriteDbContext;
import Repositories.*;
import Repository.*;
import UseCases.Consumers.CheckInCreadoConsumer;
import fourteam.extensions.IServiceCollection;

public class Infraestructure {

  public static void AddInfraestructure() {
    IServiceCollection.AddMediator();
    IServiceCollection.AddScoped(IWriteDbContext.class, Context.MongoDB.WriteDbContext.class);
    IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
    IServiceCollection.AddScoped(IAeronaveRepository.class, AeronaveRepository.class);
    IServiceCollection.AddScoped(IAsientoRepository.class, AsientoRepository.class);
    IServiceCollection.AddScoped(IMarcaRepository.class, MarcaRepository.class);
    Application.AddApplication();
    AddRabbitMq();
  }

  private static void AddRabbitMq() {
    IServiceCollection.AddMassTransit(config -> {
      // config.AddConsumer(CheckInCreadoConsumer.class).Endpoint(endpoint -> {
      // endpoint.Name = CheckInCreadoConsumer.QueueName;
      // });
      config.AddConsumer(CheckInCreadoConsumer.class);

      config.UsingRabbitMq((context, cfg) -> {
        cfg.Host = "147.182.209.156";
        cfg.User = "admin";
        cfg.Password = "admin";
        // cfg.ReceiveEndpoint(CheckInCreadoConsumer.QueueName, endpoint -> {
        //   endpoint.ConfigureConsumer(CheckInCreadoConsumer.class);
        // });
      });
    });
  }
}
