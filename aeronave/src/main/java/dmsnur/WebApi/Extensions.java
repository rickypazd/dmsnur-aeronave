package dmsnur.WebApi;

import dmsnur.SharedKernel.http.Rest;
import dmsnur.WebApi.Controllers.AeronaveController;
import dmsnur.WebApi.Controllers.MarcaController;

public class Extensions {
    public static void AddControllers() {
        Rest.addController(AeronaveController.class);
        Rest.addController(MarcaController.class);
        Rest.start(80);
    }
}
