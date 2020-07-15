package lut.day4.exe1;

public class TeacherTest
{
	public static void main(String[] args)
	{
		//创建对象
		Teacher t = new Teacher();

		//为对象的属性赋值
		t.name = "George";
		t.age = 30;
		t.salary = 10000;

		//输出对象的属性
		System.out.println("name=" + t.name);
		System.out.println("age=" + t.age);
		System.out.println("salary=" + t.salary);

		//调用使年龄增加的方法并输出增加后的年龄
		t.increaseAge();
		System.out.println("new age=" + t.age);
	}
}
