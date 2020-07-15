package lut.day5.exe4.exe4_7;

public class TestFinal{
	public static void main(String args[]){
		final MyValue mv = new MyValue();
		mv.value = 100;
		mv.value = 200;

		System.out.println(mv.value);
	}
}