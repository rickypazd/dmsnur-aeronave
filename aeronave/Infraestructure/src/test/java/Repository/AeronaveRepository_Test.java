package Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Context.IWriteDbContext;
import Model.Aeronaves.Aeronave;
import fourteam.db.DbSet;

public class AeronaveRepository_Test {

    IWriteDbContext _database = Mockito.mock(IWriteDbContext.class);
    DbSet<Aeronave> _aeronaves = Mockito.mock(DbSet.class);

    @Before
    public void setUp() {
        _database.Aeronave = _aeronaves;

    }

    @Test
    public void constructor_accept() {
        AeronaveRepository repository = new AeronaveRepository(_database);
        Assert.assertNotNull(repository);
    }

    @Test
    public void GetAll_accept() {
        AeronaveRepository repository = new AeronaveRepository(_database);
        repository.GetAll();
        Assert.assertNotNull(repository);
    }
    @Test
    public void Create_accept() {
        AeronaveRepository repository = new AeronaveRepository(_database);
        repository.Create(new Aeronave());
        Assert.assertNotNull(repository);
    }
}
