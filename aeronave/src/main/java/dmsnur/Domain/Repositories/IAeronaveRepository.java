package dmsnur.Domain.Repositories;

import java.util.List;
import java.util.UUID;

import dmsnur.Domain.Model.Aeronaves.Aeronave;
import dmsnur.SharedKernel.core.IRepository;

public interface IAeronaveRepository extends IRepository<Aeronave, UUID> {

    public List<Aeronave> GetAll();

    public Aeronave Delete(Aeronave aeronave);

    public Aeronave Update(Aeronave aeronave);
}
