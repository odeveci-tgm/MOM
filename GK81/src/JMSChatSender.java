
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class JMSChatSender {

  private static String user = ActiveMQConnection.DEFAULT_USER;
  private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
  private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
  private static String subject = "QueuePark";
  public static int queueid = 1;
  public int id;
  
  public JMSChatSender(int id) {
	  this.id = id;
  }
  
  public void start() {
	// Create the connection.
		  Session session = null;
		  Connection connection = null;
		  MessageProducer producer = null;
		  Destination destination = null;
				
		  try {
		    	
				ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( user, password, url );
				connection = connectionFactory.createConnection();
				connection.start();
			
				// Create the session
				session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				String finalsubj = subject + String.valueOf(queueid);
				destination = session.createQueue(finalsubj);
				// Create the producer.
				producer = session.createProducer(destination);
				producer.setDeliveryMode( DeliveryMode.NON_PERSISTENT );
				
				// Create the message
				TextMessage message = session.createTextMessage(XMLHandler.randomXML(id));
				producer.send(message);
				System.out.println( message.getText() );
				connection.stop();
		      
		  } catch (Exception e) {
		  	
		  	System.out.println("[MessageProducer] Caught: " + e);
		  	e.printStackTrace();
		  	
		  } finally {
		  	
				try { producer.close(); } catch ( Exception e ) {}
				try { session.close(); } catch ( Exception e ) {}
				try { connection.close(); } catch ( Exception e ) {}
				
		  }
	      
	  } // end main
  
}