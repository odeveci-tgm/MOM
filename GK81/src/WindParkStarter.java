
public class WindParkStarter {
	
public static void main(String[] args) {	
for (int i=0;i<=5;i++) {
	JMSChatSender jms = new JMSChatSender(i);
	jms.start();
}

}

}