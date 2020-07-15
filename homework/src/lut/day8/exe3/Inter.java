package lut.day8.exe3;

interface Inter {
	void show();
	//public abstract
}

class Outer {
	//补齐代码
	public static Inter method() {
		//子类对象 -- 子类匿名对象
		return new Inter() {
			public void show() {
				System.out.println("HelloWorld");
			}
		};
	}
}

class OuterDemo {
	public static void main(String[] args) {
		Outer.method().show();
	}
}