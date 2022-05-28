package dmsnur.Infraestructure.Context;

import dmsnur.Domain.Model.Aeronaves.Aeronave;
import dmsnur.Domain.Model.Aeronaves.Asiento;
import dmsnur.Domain.Model.Marcas.Marca;
import dmsnur.SharedKernel.db.DbContext;
import dmsnur.SharedKernel.db.DbSet;

public abstract class IWriteDbContext extends DbContext {

    public IWriteDbContext(Class dbContextClass) {
        super(dbContextClass);
    }

    public DbSet<Aeronave> Aeronave;
    public DbSet<Asiento> Asiento;
    public DbSet<Marca> Marca;
}
