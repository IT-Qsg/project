package lut.day16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadTest {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        ProduceThread produceThread = new ProduceThread("生产者",publisher);
        ConsumeThread consumeThread = new ConsumeThread("消费者",publisher);
        ProduceThread produceThread1 = new ProduceThread("生产者",publisher);
        ConsumeThread consumeThread1 = new ConsumeThread("消费者",publisher);

        produceThread.start();
        consumeThread.start();
        produceThread1.start();
        consumeThread1.start();

    }
}
class ProduceThread extends Thread{
    private Publisher  p;

    public ProduceThread(String name,Publisher p) {
        super(name);
        this.p = p;
    }

    @Override
    public void run() {
        p.produce();

    }
}class ConsumeThread extends Thread{
    private Publisher  p;

    public ConsumeThread(String name,Publisher p) {
        super(name);
        this.p = p;
    }
    @Override
    public void run() {
        p.consume();
    }
}
class Publisher{
    private List<Book> list = new ArrayList<>();
    private static final String[] BOOKS={"java","c++","C#","R","Scala"};
    public synchronized void produce(){
        while(true){
            while(!list.isEmpty()){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random random = new Random();
            int nextInt = random.nextInt(BOOKS.length);
            Book book = new Book(BOOKS[nextInt]);
            list.add(book);
            String name = Thread.currentThread().getName();
            System.out.println(name+"应刷了"+list);
            notify();

        }
    }
    public synchronized void consume(){
        while(true){
            while(list.isEmpty()){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Book book = list.get(0);
            String name = Thread.currentThread().getName();
            System.out.println(name+"售出了"+book);
            list.remove(0);
            notify();

        }
    }
}

class Book{
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
