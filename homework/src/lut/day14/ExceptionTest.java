package lut.day14;

public class ExceptionTest {
    public static void main(String[] args) throws indexException {
        try {
            new A().show();
        }catch (indexException d){
            System.out.println("数组越界异常");
        }
    }
}
class A{
    public void show () throws indexException {

        try{
            int [] a = new int[10];
            System.out.println(a[10]);

        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
           throw  new indexException();
        }

    }

}
class indexException extends Exception{
    indexException(){
      //new  IndexOutOfBoundsException().printStackTrace();
        System.out.println("数组越界异常");
    }
}
