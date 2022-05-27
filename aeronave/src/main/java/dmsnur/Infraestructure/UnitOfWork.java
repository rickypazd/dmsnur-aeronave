package dmsnur.Infraestructure;

import java.util.List;
import dmsnur.Domain.Repositories.IUnitOfWork;
import dmsnur.Infraestructure.Context.MongoDB.WriteDbContext;
import dmsnur.SharedKernel.core.DomainEvent;
import dmsnur.SharedKernel.http.Exception.HttpException;
import dmsnur.SharedKernel.mediator.Mediator;

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
