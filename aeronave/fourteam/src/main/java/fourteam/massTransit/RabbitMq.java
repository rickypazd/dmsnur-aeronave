package fourteam.massTransit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMq {

  private IMassTransit massTransit;

  public String Host;
  public String User;
  public String Password;
  private Connection connection;
  private Channel channel;

  public RabbitMq(IMassTransit massTransit) {
    this.massTransit = massTransit;
    this.Host = "localhost";
    this.User = "guest";
    this.Password = "guest";
  }

  public void newConnection() throws IOException, TimeoutException {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(this.Host);
    factory.setUsername(this.User);
    factory.setPassword(this.Password);

    this.connection = factory.newConnection();
    this.channel = connection.createChannel();
    System.out.println("Conexion exitosa a rabbit");
  }

  public interface ReceiveEndpoint<E> {
    void run(E endpoint);
  }

  public void ReceiveEndpoint(String QueueName, ReceiveEndpoint<EndPoint> lambda) {
    lambda.run(new EndPoint());
  }

  public Connection getConnection() {
    return connection;
  }

  public Channel getChannel() {
    return channel;
  }
}
