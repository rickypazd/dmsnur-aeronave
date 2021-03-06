package Context.MongoDB;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import Model.Aeronaves.Aeronave;

public class WriteDbContext_Test {

    @Test
    public void constructor_accept() {
        WriteDbContext context = new WriteDbContext();
        Assert.assertNotNull(context);
    }

    @Test
    public void FindByKey_accept() {
        // Mockito.verify(_aeronaves).Single(obj -> obj.key.equals(UUID.randomUUID()));
        // Aeronave a = new Aeronave();
        // when(_aeronaves.Single(any())).thenReturn(a);
        WriteDbContext context = new WriteDbContext();
        ArgumentCaptor<Aeronave> captor = ArgumentCaptor.forClass(Aeronave.class);
        Assert.assertNotNull(context);
    }
}
