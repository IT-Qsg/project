package lut.day20.homework2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import static java.lang.System.out;
public class H2 { }
/*
*
*使用TCP网络编程完成用户登录功能：客户端输入用户名和密码，向服务器发出登录请求；
	服务器接收数据并进行判断，如果用户名和密码均是briup，则登录成功，否则登录失败，
	返回相应响应信息；客户端接收响应信息并输出登录结果。
  	(1) 用户User类已提供构造方法 public User(String username,String password)。
  	(2) 客户端采用ObjectOutputStream发送封装了用户名和密码的User对象。
* */

//建立客户端

class ClientUser{
    public static void main(String[] args) throws IOException {
        Socket sc = new Socket("127.0.0.1",10);
        //User user = input();
        OutputStream outputStream = sc.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream,true);
        //printWriter.println(user.getName()+","+user.getPassword());

        InputStream inputStream = sc.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        while(true){
            User user = input();
            printWriter.println(user.getName()+","+user.getPassword());
            String s = bufferedReader.readLine();

        if("true".equals(s)){
            //封装对象发送
            oos.writeObject(user);
            break;
        }else{
            out.println(s);
            //main(null);
            continue;
        }

        }
    }
    public static User input() throws IOException {
        User u ;
        BufferedReader bufferedReader1 =
                new BufferedReader(
                        new InputStreamReader(System.in));
        while(true){
            out.println("请输入用户名：");
            String s = bufferedReader1.readLine();
            out.println("请输入密码：");
            String s1 = bufferedReader1.readLine();
            u=new User(s,s1);
            break;
        }
        return u;
    }
}
//建立服务端
class ServerUPuser{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(10);
        Socket sc = serverSocket.accept();
        out.println(sc.getInetAddress().getHostAddress());
        OutputStream outputStream = sc.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream,true);

        InputStream inputStream = sc.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ObjectInputStream oin = new ObjectInputStream(inputStream);
        while(true) {
            String s = bufferedReader.readLine();
            String[] user = s.split(",");
            //out.println(user[0]);
            if (!"briup".equals(user[0]) && !"briup".equals(user[1])) {
                printWriter.println("用户名 || 密码 错误");
               // main(null);
                continue;
            }else {
                printWriter.println("true");
                Object o = oin.readObject();
                User u = (User) o;
                out.println(u);
                break;
            }
        }
//        printWriter.println("请输入用户名：");

//        if("briup".equals(s))printWriter.println("请输入密码：");
//        else printWriter.println("用户名不存在");
    }
}
class User implements Serializable {
    private final static long serialVersionUid = 1L;
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+"@"+Integer.toHexString(this.hashCode())+"::User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}