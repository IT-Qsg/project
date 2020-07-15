package lut.day4.sax;

import lut.day4.bean.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/26 16:53
 * @describe
 **/
public class Sax_Test {

    public static void main(String[] args) {
        new Sax_Test().parse();
    }

    //封装student对象
    private void parse() {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        try {
            SAXParser pa = factory.newSAXParser();
            pa.parse(new File("src/lut/day4/Student"),new DefaultHandler(){
                Student stu;
                private String tagName;
                ArrayList<Student> stus = new ArrayList<>();
                @Override
                public void startDocument() throws SAXException {
                    //super.startDocument();
                    System.out.println("开始标签");
                }

                @Override
                public void endDocument() throws SAXException {
                  //  super.endDocument();
                    System.out.println("结束标签");
                    print();
                }
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    //super.startElement(uri, localName, qName, attributes);
                    //System.out.println(uri);
                    //System.out.println(localName);
                    //System.out.println(qName);
                    if(localName.equals("student")){
                        stu = new Student();
                        String id = attributes.getValue("id");
                        stu.setId(Long.parseLong(id));
                    }else if(localName.equals("name")){
                        tagName = localName;
                    }else if(localName.equals("age")){
                        tagName = localName;
                    }

                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                 //   super.characters(ch, start, length);
                   // System.out.println(new String(ch,start,length));
                    if("name".equals(tagName)){
                        stu.setName(new String(ch,start,length));
                    }else if("age".equals(tagName)){
                        stu.setAge(Integer.parseInt(new String(ch,start,length)));
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                   // super.endElement(uri, localName, qName);
                    if(localName.equals("student")){
                        stus.add(stu);
                    }else{
                        tagName=null;
                    }
                }
                public void print(){
                    stus.forEach(System.out::println);
                }
            });
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
