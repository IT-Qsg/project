package lut.day4.exe1;

public class StudentTest
{
	public static void main(String[] args)
	{
		//创建对象
		Student s = new Student("steven","male",30);

		//输出对象的属性
		System.out.println("name=" + s.getName());
		System.out.println("gender=" + s.getGender());
		System.out.println("age=" + s.getAge());
	}
}

