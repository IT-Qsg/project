package lut.day4.dom_opt;

import lut.day4.bean.Student;
import org.w3c.dom.*;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/26 14:38
 * @describe
 **/
public class Dom_test {
    public static void main(String[] args) {
       /* List<Student> list = new Dom_test().select();
        for (Student student : list) {
            System.out.println(student);
        }*/
      Student stu = new Student(1,"lisi",30);
//       new Dom_test().add(stu);
//        new Dom_test().delete(1);
        new Dom_test().update(stu);
    }
    public void add(Student stu){
        DocumentBuilderFactory factor = DocumentBuilderFactory.newInstance();
        factor.setNamespaceAware(true);
        try {
            DocumentBuilder builder = factor.newDocumentBuilder();
            Document document = builder.parse("src/lut/day4/Student");
            Element root = document.getDocumentElement();

            Element er = document.createElement("student");
            er.setAttribute("id",stu.getId()+"");
            //……
            Element san_name = document.createElement("name");
            san_name.setTextContent(stu.getName());
            Element san_age = document.createElement("age");
            san_age.setTextContent(stu.getAge()+"");

            er.appendChild(san_name);
            er.appendChild(san_age);

            root.appendChild(er);
            //写回xml文件
            TransformerFactory tran = TransformerFactory.newInstance();
            //传输方式
            Transformer transformer = tran.newTransformer();
            //设置传输格式
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.transform(new DOMSource(document),new StreamResult("src/lut/day4/Student"));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
    public void update(Student stu){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src\\lut\\day4\\Student");
//            Element root = doc.getDocumentElement();
            NodeList list = doc.getElementsByTagName("student");
            for(int i = 0;i<list.getLength();i++){
                Node node = list.item(i);
                //根据id修改学生能，获取id
                String id = node.getAttributes().getNamedItem("id").getNodeValue();
                if(Long.parseLong(id)==stu.getId()){
                    NodeList san = node.getChildNodes();
                    for(int j = 0;j < san.getLength();j++){
                        Node node1 = san.item(j);
//                        if(node1.getNodeType()==1){
                        if(node1.getNodeType()==Node.ELEMENT_NODE){
                            String nodeName = node1.getNodeName();
                            if("name".equals(nodeName)){
                                node1.setTextContent(stu.getName());
                            }else {
                                node1.setTextContent(stu.getAge()+"");
                            }
                        }
                    }
                }
            }
            TransformerFactory trans = TransformerFactory.newInstance();
            Transformer tran = trans.newTransformer();
            tran.transform(new DOMSource(doc),new StreamResult("src\\lut\\day4\\Student"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    public void delete(long id){
        DocumentBuilderFactory factor = DocumentBuilderFactory.newInstance();
        factor.setNamespaceAware(true);
        try {
            DocumentBuilder builder = factor.newDocumentBuilder();
            Document document = builder.parse("src/lut/day4/Student");
            NodeList list = document.getElementsByTagName("student");
            for(int i = 0; i< list.getLength();i++){
                Node node = list.item(i);
                String nodeValue = node.getAttributes().getNamedItem("id").getNodeValue();
                if(Long.parseLong(nodeValue)==id){
                    node.getParentNode().removeChild(node);
                    System.out.println(Long.parseLong(nodeValue)==id);
                    break;
                }
            }
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer trans = factory.newTransformer();
            trans.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            trans.setOutputProperty(OutputKeys.INDENT,"yes");
            trans.transform(new DOMSource(document),new StreamResult("src/lut/day4/Student"));
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public List<Student>  select(){
        DocumentBuilderFactory factor =DocumentBuilderFactory.newInstance();
        //默认不支持命名空间
        factor.setNamespaceAware(true);
        ArrayList<Student> list = new ArrayList<>();
        try {
            DocumentBuilder builder = factor.newDocumentBuilder();
            //忽略dtd,解析到dtd不找dtd中的路径，直接返回字符串
            builder.setEntityResolver(new EntityResolver() {
                @Override
                public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                   byte[] b="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>".getBytes();
                    return new InputSource(new ByteArrayInputStream(b));
                }
            });
            //读取xml文件并获得文档对象
            Document document = builder.parse("src/lut/day4/Student");
            //获得根标签
            Element root = document.getDocumentElement();
           // [students: null]
            System.out.println(root);
            NodeList child_Nodes = root.getChildNodes();
            int length = child_Nodes.getLength();
            for(int i = 0;i<length;i++){
                Node node = child_Nodes.item(i);
                //判断获取节点类型
                if(node.getNodeType()==Node.ELEMENT_NODE) {
                    Student stu = new Student();
                    //获取标签中的属性
                    //<标签名字，Node>
                    NamedNodeMap attr_map = node.getAttributes();
                    //获取属性节点
                    Node attr_node = attr_map.getNamedItem("id");
                    String node_Value = attr_node.getNodeValue();
                    System.out.println(node_Value);
                    stu.setId(Long.parseLong(node_Value));
                    Node attr_node2 = attr_map.getNamedItem("name");
                    String node_Value2 = attr_node2.getNodeValue();
                    System.out.println(node_Value2);
                    NodeList third_node = node.getChildNodes();
                    for(int j = 0;j<third_node.getLength();j++){
                        Node third_no = third_node.item(j);
                        if(third_no.getNodeType()==Node.ELEMENT_NODE){
                            String name = third_no.getNodeName();
                            //String var = third_no.getChildNodes().item(0).getTextContent();
                            String var = third_no.getTextContent();
                            if("name".equals(name)){
                                stu.setName(var);

                            }else{
                                stu.setAge(Integer.parseInt(var));
                            }
                        }
                    }list.add(stu);
                }
            }
//            System.out.println(length);
//            System.out.println(child_Nodes.item(0));
//            System.out.println(child_Nodes.item(1));
//            System.out.println(child_Nodes.item(2));
//            System.out.println(child_Nodes.item(3));
//            System.out.println(child_Nodes.item(4));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
