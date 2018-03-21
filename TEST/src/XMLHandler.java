import java.io.FileOutputStream;
import java.io.StringReader;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.InputSource;

public class XMLHandler {

	public static String randomXML() {
		  String xml = "<windpark id=P001> <windrad id=001> <power> 88 </power> </windrad> </windpark>";
		  return xml;
	  }
		
	  public static void writeXML(String xml) {
		  try {
			FileOutputStream fs = new FileOutputStream("data.xml",true);
			byte[] strToBytes = xml.getBytes();
			fs.write(strToBytes);
			fs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  }
	  
	public static void main (String[] args) {
		String xml = randomXML();
		writeXML(xml);
	}

	
}
