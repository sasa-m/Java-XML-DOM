
package xmldom;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XmlDom {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse("sweets.xml");

        Element root = doc.getDocumentElement();

        //NodeList list = root.getElementsByTagName("sweet");
        //Element d = (Element) list.item(1);
        //NodeList atr = d.getElementsByTagName("type");
        //Element v = (Element) atr.item(0);
        //System.out.println(v.getTextContent());
        
        NodeList list = root.getChildNodes();
        int length = list.getLength();
        for (int i = 0; i < length; i++) {
            if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element ele = (Element) list.item(i);
                if (ele.getNodeName().contains("sweet")) {
                    String type = ele.getElementsByTagName("type").item(0).getTextContent();
                    String price = ele.getElementsByTagName("price").item(0).getTextContent();
                    
                    System.out.println("The price of " + type + " is " + price);
                    
                }
            }
        }

    }
}
