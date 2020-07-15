package lut.day5.exe3;

public class Stack {
    private static final int DEFAULT_SIZE = 10;
    private  int arraysize;
    private int [] stack  ;
    public Stack(){

        stack = new int [DEFAULT_SIZE];
    }
    public void push(int value){
        if(arraysize>=stack.length-1){
            int[] temp = new int [stack.length*2];
            System.arraycopy(stack,0,temp,0,stack.length-1);
            stack = temp;
        }else{
            stack [arraysize ++] = value;

        }

    }
    public boolean empty(){
        return (arraysize == 0);
    }
    public int pop(){
        return  stack[--arraysize];
    }
}
