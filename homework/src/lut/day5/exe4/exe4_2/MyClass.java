package lut.day5.exe4.exe4_2;

class MyClass {
	int a;
	static int b;
	void fa(){}
	static void fb(){}
	public void m1(){
		System.out.println(a); //1
		System.out.println(b); //2
		fa(); //3
		fb(); //4
	}
	public static void m2(){
		//System.out.println(a); //5
		System.out.println(b); //6
		//fa(); //7
		fb(); //8
	}
}