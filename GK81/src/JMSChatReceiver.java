
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class JMSChatReceiver {

  private static String user = ActiveMQConnection.DEFAULT_USER;
  private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
  private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
  private static String subject = "QueuePark";
  public static int queuecount = 1;
  
  
	
  public static void main( String[] args ) {
		
	  // Create the connection.
	  Session session = null;
	  Connection connection = null;
	  MessageConsumer consumer = null;
	  Destination destination = null;
	  
	 
	  try {
	    	
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
			connection = connectionFactory.createConnection();
			connection.start();
		
			// Create the session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			destination = session.createQueue( subject+String.valueOf(queuecount) );
			// Create the consumer
			consumer = session.createConsumer( destination );	
			while(true) {
			
			// Recieve in Endless Loop
			TextMessage message = (TextMessage) consumer.receive();
			String output = message.getText();
			XMLHandler.writeXML(output);
			
			if ( message != null ) {
			      		System.out.println("Message received: " + output);
			      		message.acknowledge();
			 }			
			}
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
  }
}
  
  
						
			// Start receiving
  

  
  
