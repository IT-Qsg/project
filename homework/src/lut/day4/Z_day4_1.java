package lut.day4;

public class Z_day4_1 {
    public  static void main(String [] arge){
        for(int i=0;i<6;i++){
                for(int j=0;j<6;j++){
                    System.out.print(j);

                }
                System.out.println();
            }


        for(int i=0;i<6;i++){
                for(int j=0;j<6;j++){
                    System.out.print(j);
                    if(j==3){
                        break;
                    }
                }
                System.out.println();
        }
        System.out.println("---------------");
        f1:for(int i=0;i<6;i++){
                for(int j=0;j<6;j++){
                    System.out.print(j);
                    if(j==3){
                         break f1;
                    }
                }
                System.out.println();
        }
    }
}
