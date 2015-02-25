import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by eric on 15-2-25.
 */
public class EmitLogTopic {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // declare exchange 'topic'
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String routingKey = getRouting(args);
        String message = getMessage(args);

        channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
        System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

        connection.close();
    }

    private static String getRouting(String[] args) {
        return null;
    }

    private static String getMessage(String[] args) {
        return null;
    }
}
