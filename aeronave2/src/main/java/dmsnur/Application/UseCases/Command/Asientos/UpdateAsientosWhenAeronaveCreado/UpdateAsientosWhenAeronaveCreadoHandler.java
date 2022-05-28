package dmsnur.Application.UseCases.Command.Asientos.UpdateAsientosWhenAeronaveCreado;

import dmsnur.Domain.Event.AeronaveCreado;
import dmsnur.Domain.Repositories.IAsientoRepository;
import dmsnur.SharedKernel.mediator.Notification;
import dmsnur.SharedKernel.mediator.NotificationHandler;

public class UpdateAsientosWhenAeronaveCreadoHandler implements NotificationHandler<AeronaveCreado> {

    private IAsientoRepository _asientoRepository;

    // private
    public UpdateAsientosWhenAeronaveCreadoHandler(IAsientoRepository asientoRepository) {
        this._asientoRepository = asientoRepository;
    }

    @Override
    public void handle(Notification notification) {
        System.out.println(notification);

    }

}
