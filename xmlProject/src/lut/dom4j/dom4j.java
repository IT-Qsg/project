package lut.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/27 9:24
 * @describe
 **/
public class dom4j {
    public static void main(String[] args) {
        new dom4j().add();
    }

    private void add() {
        /*SAXReader read = new SAXReader();
        try {
            Document document = read.read("src\\lut\\day4\\Student");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
*/
        //创建空白文档对象
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("teacher");
        root.attributeValue("id","1002");
        Element tea = root.addElement("tea");
        tea.setText("ceshi");
        Element tea2 = root.addElement("tea");
        tea2.setText("lisi");
     /*
        doc.add(root);
        root.add(tea);
        root.add(tea2);*/

        //写到文件
        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream(new File("src\\lut\\dom4j\\teacher.xml")), OutputFormat.createPrettyPrint());
            writer.write(doc);
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void select() {
        SAXReader read = new SAXReader();
        try {
            Document document = read.read("src\\lut\\day4\\Student");

            Element root = document.getRootElement();
            //忽略空白文档节点
            List<Element> ers = root.elements();
            for (Element er : ers) {
                String er_name = er.getName();
                String id = er.attributeValue("id");
                System.out.println(id);
                List<Element> third_element = er.elements();
                for (Element element : third_element) {
                    String name = element.getName();
                   // String value = element.getText().trim();
//                    String value = element.getText();
//                    String value = element.getTextTrim();
                    Object value = element.getData();

                    System.out.println(name+value);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


}
