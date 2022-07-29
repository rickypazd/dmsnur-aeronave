import Controllers.AeronaveController;
import Controllers.MarcaController;
import fourteam.http.Rest;

public class WebApi {

  public static void AddControllers() {
    Rest.addController(AeronaveController.class);
    Rest.addController(MarcaController.class);
    Rest.start(8080);
    Rest.createSwagger();
  }
}
