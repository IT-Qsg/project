package lut.day5.exe4.exe4_4;

class MyClass{
	static int i = 10;
	static {
		i = 20;
		System.out.println("In Static");
	}
	public MyClass(){
		//i = 30;
		System.out.println("MyClass()");
	}
	public MyClass(int i){
		System.out.println("MyClass(int)");
		this.i = i;
	}
}