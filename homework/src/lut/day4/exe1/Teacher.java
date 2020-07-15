package lut.day4.exe1;
public class Teacher
{
	public String name;		//姓名
	public int age;			//年龄
	public double salary;	//薪水

	public Teacher() {
	}

	public Teacher(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	//用于年龄增加的方法
	public void increaseAge(){
		age++;
	}

}
