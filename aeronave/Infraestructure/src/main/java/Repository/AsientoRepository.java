package Repository;

import java.util.UUID;

import Model.Aeronaves.Asiento;
import Repositories.IAsientoRepository;
import Context.IWriteDbContext;
import fourteam.db.DbSet;

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
