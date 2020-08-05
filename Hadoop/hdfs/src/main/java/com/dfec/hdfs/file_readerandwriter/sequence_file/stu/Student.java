package com.dfec.hdfs.file_readerandwriter.sequence_file.stu;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname Student
 * @Date 2020/7/23 16:35
 * @Copyright DFEC
 **/
public class Student implements Writable {
    //hadoop 序列化对象
    private Long id;
    private String name;
    private int age;
    //必须提供无参构造函数
    public Student() {
    }
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.getId());
        dataOutput.writeUTF(this.getName());
        dataOutput.writeInt(this.age);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readLong();
        this.name = dataInput.readUTF();
        this.age = dataInput.readInt();
    }

    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
