package WebApi;

import SharedKernel.http.Rest;
import WebApi.Controllers.AeronaveController;
import WebApi.Controllers.MarcaController;

public class Extensions {
    public static void AddControllers() {
        Rest.addController(AeronaveController.class);
        Rest.addController(MarcaController.class);
        Rest.start(80);
    }
}
