package lut.day7.exe1;

abstract class Animal{
	protected int legs;
	protected Animal(int legs){
		this.legs = legs;
	}
	public void walk(){
		System.out.println("动物都会走");
	}
	public abstract void eat();
}