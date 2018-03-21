
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
  private static String subject = "VSDBChat";
  public static int queuecount = 0;
  
  
	
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
			for (int i =0;i<=queuecount;i++) {
				destination = session.createQueue( subject+String.valueOf(queuecount) );
				// Create the consumer
				consumer = session.createConsumer( destination );	
				ParkThread pt = new ParkThread(consumer,queuecount);
				pt.run();
			}
			
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
  }
  }
						
			// Start receiving
  

  
  
