
public class WindParkStarter {
	
	
	public static int parkid = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JMSChatSender jms = new JMSChatSender(parkid);
		jms.start();
		parkid++;
		JMSChatSender jms2 = new JMSChatSender(parkid);
		jms2.start();
		parkid++;
		JMSChatSender jms3 = new JMSChatSender(parkid);
		jms3.start();
		parkid++;
		JMSChatSender jms4 = new JMSChatSender(parkid);
		jms4.start();
		parkid++;
	}

}
