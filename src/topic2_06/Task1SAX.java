package topic2_06;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @author Dmitry Titorenko on 02.03.2018
 * <p>
 * 3.1 Использование технологии SAX*
 * <p>
 * Подготовить XML-документ с данными о студентах академической группы.
 * С помощью технологии SAX осуществить чтение данных из XML-документа и вывод данных на консоль
 */
public class Task1SAX extends DefaultHandler {
    public static void main(String[] args) {
        SAXParser parser = null;
        try {
            parser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        if (parser != null) {
            InputSource input = new InputSource("D:\\Program Files\\IdeaProjects\\JavaSELearn\\src\\topic2_06\\Group.xml");
            try {
                parser.parse(input, new Task1SAX());
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        System.out.println("Opening tag: " + qName);

        if (attributes.getLength() > 0) {
            System.out.println("Атрибуты: ");
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("  " + attributes.getQName(i) + ": "
                        + attributes.getValue(i));
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch).substring(start, start + length).trim();
        if (s.length() > 0) {
            System.out.println(s);
        }
    }
}
