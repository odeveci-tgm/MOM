import javax.jms.MessageConsumer;
import javax.jms.TextMessage;

public class ParkThread implements Runnable {
	MessageConsumer consumer;
	public ParkThread(MessageConsumer consumer,int queueid) {
		this.consumer = consumer;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				TextMessage message = (TextMessage) consumer.receive();
				String output = message.getText();
				XMLHandler.writeXML(output);
	      if ( message != null ) {
	      	System.out.println("Message received: " + output);
	      	message.acknowledge();
	      }
		  
				
		  } catch (Exception e) {
		  	
		    System.out.println("[MessageConsumer] Caught: " + e);
		    e.printStackTrace();
		
		  
		   // end main
	      
	  }
		
	}
		
	}
}
	
