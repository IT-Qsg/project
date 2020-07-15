package insert;

public class Insert {
    static public int [] insert(int... a){
        int ins[] = a;
        for(int i = 0;i<ins.length-1;i++)
            for(int j = 0;j < ins.length-1;j++){
                if(ins[j]<ins[j+1]){
                    ins[j]  =   ins[j+1]^ins[j];
                    ins[j+1]= ins[j+1]^ins[j];
                    ins[j]  =   ins[j+1]^ins[j];
                }
            }
        return ins;
    }

    public static void main(String[] args) {
        int[] s ={5,9,946,6,7,32,57,6};
        for (int i : insert(s)) {
            System.out.println(i);
        }
    }
}
