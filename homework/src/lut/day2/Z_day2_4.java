package lut.day2;

public class Z_day2_4 {
    public static void main(String [] arge){
        for(int i = 1;i<=9;i++){
            for(int j =1;j<=i;j++){
                 System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
        for(int i = 9 ;i>0;i--){
            for(int j = 1; j<=i;j++){
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
        for(int i = 1;i<=9;i++){
            for(int j = 1 ; j<=i ;j++){
                if(j==1){
                for(int z = 1;z<=(9-i);z++)
                    System.out.print("        ");}
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
        for(int i = 9;i>=1;i--) {
            for(int z = 1; z<=(9-i);z++ ){
                System.out.print("      \t");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
        for(int i = 9;i>=1;i--) {
            for (int j = 1; j <= i; j++) {
                if(j==1)
                    for(int z = 1;z<=(9-i);z++)
                        System.out.print("        ");
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
        for(int i = 1;i<=9;i++){
            for(int j = 1 ; j<=i ;j++){
                if(j==1){
                    for(int z = 1;z<=(9-i);z++)
                        System.out.print("   ");}
                System.out.print(j+"*"+i+"="+i*j);
            }
            System.out.println();
        }
        for(int i = 9;i>=1;i--) {
            for (int j = 1; j <= i; j++) {
                if(j==1)
                    for(int z = 1;z<=(9-i);z++)
                        System.out.print("   ");
                System.out.print(j+"*"+i+"="+i*j);
            }
            System.out.println();
        }
    }
}
