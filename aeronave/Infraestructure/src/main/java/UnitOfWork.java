import java.util.List;
import Repositories.IUnitOfWork;
import Context.MongoDB.WriteDbContext;
import core.DomainEvent;
import http.Exception.HttpException;
import mediator.Mediator;

public class UnitOfWork implements IUnitOfWork {

    private WriteDbContext _context;
    private Mediator _mediator;

    public UnitOfWork(WriteDbContext context, Mediator mediator) {
        _context = context;
        _mediator = mediator;
    }

    @Override
    public void commit() throws HttpException {
        List<DomainEvent> events = _context.getDomainEvents();
        for (DomainEvent domainEvent : events) {
            _mediator.notify(domainEvent);
        }
        _context.Commit();
    }
}
