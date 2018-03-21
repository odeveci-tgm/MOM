import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.Random;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.InputSource;

public class XMLHandler {
	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	
	public static double randomValue(int Low, int High) {
		double result = (Math.random() * (High - Low)) + Low;
		double rounded = round(result,2);
		return rounded;
	}
	
	  public static String randomXML(int id) {
		  String xml = "<windpark id=\""+id+"\"> <windrad id=\"001\"> <power>"+randomValue(10, 200)+"</power> <blindpower>382.54 kWh</blindpower>\n"+ 
			  		"<windspeed>40.54 km/h</windspeed>\n"+ 
			  		"<rotationspeed>0.42 m/s</rotationspeed>\n"+ 
			  		"<temperature>25.8 C</temperature>\n" + 
			  		"<bladeposition>25.8 deg</bladeposition>\n"+ 
			  		"<transfertime>850 ms</transfertime> </windrad> </windpark>";
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
	
}
