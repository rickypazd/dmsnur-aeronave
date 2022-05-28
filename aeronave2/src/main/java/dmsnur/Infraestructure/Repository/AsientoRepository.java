package dmsnur.Infraestructure.Repository;

import java.util.UUID;

import dmsnur.Domain.Model.Aeronaves.Asiento;
import dmsnur.Domain.Repositories.IAsientoRepository;
import dmsnur.Infraestructure.Context.IWriteDbContext;
import dmsnur.SharedKernel.db.DbSet;

public class AsientoRepository implements IAsientoRepository {

    private DbSet<Asiento> _asientos;

    public AsientoRepository(IWriteDbContext database) {
        _asientos = database.Asiento;
    }

    @Override
    public Asiento FindByKey(UUID key) {
        return null;
    }

    @Override
    public void Create(Asiento obj) {
        _asientos.Add(obj);
    }
}
