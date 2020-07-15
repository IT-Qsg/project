package lut.day9.AvgAndClass;

import java.util.ArrayList;
import java.util.List;

public class TestStudent {
    List list = new ArrayList<Student>();
    float sumAvg;

    public List addStudent(Student s){
            list.add(s);
        return list;
    }
    public float avg(List<Student> list,String grade){
        //System.out.println(list.size());
        float sum = 0,i=0;
        for(Student s : list){
           if(s.getGrade()==grade) {
              // System.out.println(s.getName());
               sum += s.getScore();i++;
           }else
               continue;
        }
        sumAvg = sum;
        return sum/i;
    }
    public static void main(String[] args) {
        TestStudent s = new TestStudent();
        s.addStudent(new Student("张三","三班",80));
        s.addStudent(new Student("liser","三班",90));
        s.addStudent(new Student("李四","四班",80));
        s.addStudent(new Student("王麻子","四班",85));
        System.out.println(s.list);
        System.out.println("三班平均成绩"+s.avg(s.list,"三班")+"总分"+s.sumAvg);
        System.out.println("四班平均成绩"+s.avg(s.list,"四班")+"总分"+s.sumAvg);

    }

}
