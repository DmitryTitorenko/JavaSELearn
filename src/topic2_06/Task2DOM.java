package topic2_06;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author Dmitry Titorenko on 02.03.2018
 * <p>
 * 3.2 Использование технологии DOM*
 * <p>
 * Подготовить XML-документ с данными о студентах академической группы.
 * С помощью технологии DOM осуществить чтение данных из XML-документа, модификацию данных и запись их в новый документ.
 */
public class Task2DOM {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File file = new File("D:\\Program Files\\IdeaProjects\\JavaSELearn\\src\\topic2_06\\Group.xml");

        Document document = builder.parse(file);

        Element root = document.getDocumentElement(); // Return the root element
        System.out.println(root.getTagName());

        int id = 10; // change ID in student
        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);

            System.out.println(child.getTextContent());// previous data

            if (child.getNodeName().equals("studentID")) {
                child.setTextContent("" + id);
                id++;
            } else if (child.getNodeName().equals("Name")) {
                child.setTextContent("newName");
            }
            System.out.println("Changed: " + child.getTextContent()); // new data
        }

        //write to file
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(document),
                new StreamResult(new FileOutputStream(new File("HelloDOM2.xml"))));
    }
}
