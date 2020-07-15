package lut.day5.exe3;

public class Test
{
	public static void main(String[] args) 
	{
		/*Stack stack = new Stack();
		//stack.pop();
		for(int i=1; i<=200; i++){
			stack.push(i);
		}
		for(int i=1; i<=100; i++){
			System.out.println("pop:" + i);
			if(!stack.empty())
			System.out.println("pop:" + stack.pop()+" =="+(201-i));
		}
		System.out.println("--------------------");
		for(int i=201; i<=300; i++){
			stack.push(i);
		}
		for(int i=1; i<=200; i++){
			if(!stack.empty())
			System.out.println("pop:" + stack.pop());
		}*/

		Queue queue = new Queue();
		//queue.out();
		for(int i=1; i<=200; i++){
			queue.in(i);
		}
		for(int i=1; i<=100; i++){
			System.out.println("out:" + queue.out());
		}
		for(int i=201; i<=300; i++){
			queue.in(i);
		}
		for(int i=1; i<=200; i++){
			System.out.println("out:" + queue.out());
		}
	}
}