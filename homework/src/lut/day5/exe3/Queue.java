package lut.day5.exe3;

public class Queue {
    int numpoint;
    int [] n = new int [1024];
    public void in(int num){
        n[numpoint] = num;
        numpoint++;

    }
    public int out(){
        int num = n[0];
        for(int i = 0;i <numpoint-1;i++){
            n[i] = n[i+1];
        }
        numpoint--;
        return num;

    }

}
