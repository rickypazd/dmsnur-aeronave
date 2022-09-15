package UseCases.DomainEventHandler.Aeronave;

import Event.AeronaveCreado;
import core.ConfirmedDomainEvent;
import core.DomainEvent;
import core.IntegrationEvent;
import fourteam.mediator.Notification;
import fourteam.mediator.NotificationHandler;

public class PublishIntegrationEventWhenAeronaveCreadoHandler
  implements NotificationHandler<ConfirmedDomainEvent<AeronaveCreado>> {

  @Override
  public void handle(Notification notification) {
    ConfirmedDomainEvent event = (ConfirmedDomainEvent) notification;
    AeronaveCreado aeronave = (AeronaveCreado) event.DomainEvent;
    IntegrationEvents.AeronaveCreado evento = new IntegrationEvents.AeronaveCreado();
    evento.setKeyAeronave(aeronave.getKey());
    evento.setMatricula(aeronave.getMatricula());
    // evento.setKeyAeronave();

  }
}
// package UseCases.Command.Asientos.UpdateAsientosWhenAeronaveCreado;
// import Event.AeronaveCreado;
// import Repositories.IAsientoRepository;
// import fourteam.mediator.Notification;
// import fourteam.mediator.NotificationHandler;
// public class UpdateAsientosWhenAeronaveCreadoHandler
// implements NotificationHandler<AeronaveCreado> {
// private IAsientoRepository _asientoRepository;
// // private
// public UpdateAsientosWhenAeronaveCreadoHandler(
// IAsientoRepository asientoRepository
// ) {
// this._asientoRepository = asientoRepository;
// }
// @Override
// public void handle(Notification notification) {
// System.out.println(notification);
// }
// }
