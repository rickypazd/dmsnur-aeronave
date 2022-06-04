import org.junit.Assert;
import org.junit.Test;

public class SharedKernel_Test {

    @Test
    public void constructor_accert() {
        SharedKernel sharedKernel = new SharedKernel();
        Assert.assertNotNull(sharedKernel);
    }
}
