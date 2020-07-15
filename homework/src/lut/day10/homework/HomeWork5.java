package lut.day10.homework;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HomeWork5 {
    int startNum,stopnum;
    /*
    * 1--浦东软件园
	2--中创软件
	3--创业大厦
	4--托普学院
	5--阳澄湖庄
	6--湖滨路大禹路
	7--文豪花园
	8--蟹市场
	9--湖滨路迎宾路
	10--玫瑰园
	11--城北西路湖亭路
	12--葡萄研究所
	13--望河桥
	14--黄泥山村
	15--登云学院
	16--马鞍山路思常路
	17--森林公园
	18--森林半岛
	19--马鞍山路鹿城路
	20--长虹大桥 */
    public Map<Integer,String> addBusStop(){
        Map<Integer,String> map = new TreeMap<>();
        map.put(1,"浦东软件园"); map.put(6,"湖滨路大禹路"); map.put(11,"城北西路湖亭路"); map.put(16,"马鞍山路思常路");
        map.put(2,"中创软件"); map.put(7,"文豪花园"); map.put(12,"葡萄研究所"); map.put(17,"森林公园");
        map.put(3,"创业大厦"); map.put(8,"蟹市场"); map.put(13,"望河桥"); map.put(18,"森林半岛");
        map.put(4,"托普学院"); map.put(9,"湖滨路迎宾路"); map.put(14,"黄泥山村"); map.put(19,"马鞍山路鹿城路");
        map.put(5,"阳澄湖庄"); map.put(10,"玫瑰园"); map.put(15,"登云学院"); map.put(20,"长虹大桥");
        return map;
    }
    /*
    * 4站内：1元
		 4站以上不超过8站（包含8站）：2元
		 8站以上12站以内（包含12站）：3元
		 12站以上16站以内（包含16站）：4元
		 16站以上每多一站加1元；
    * */
    public int money(int start,int stop){
        int mon = 0;
        if(((stop-start)+1)<=4)
            mon = 1;
        if(4<((stop-start)+1)&&((stop-start)+1)<=8)
            mon = 2;
        if(8<((stop-start)+1)&&((stop-start)+1)<=12)
            mon = 3;
        if(12<((stop-start)+1)&&((stop-start)+1)<=16)
            mon = 4;
        if(16<((stop-start)+1))
            mon = 4+(stop-start)+1-16;
        return mon;
    }
    /*（键盘录入上车站点名和到达站点名，如果没有该站，提示：您上错车了！）
		例如：请输入上车站：浦东软件园
			 请输入到达站：托普学院

			 输出：从浦东软件园到托普学院共经过4站，收费1元
			 */
    public int selestBusStop(Map<Integer,String> map,String inputBusStop){

        int  sel = 0;
       /* Set<Map.Entry<Integer,String>> entr = map.entrySet();
        for(Map.Entry<Integer,String> entry : entr){……}*/
        f1:for(Map.Entry entry : map.entrySet()){
            if(inputBusStop.equals(entry.getValue())){
                sel = (int)entry.getKey();
                break f1;}
        }
            return  sel;
    }
    public void inputBusStop(){
       try{
           System.out.println("起始站：");
           BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
           String start = in.readLine();
           if(selestBusStop(addBusStop(),start) == 0){
               System.out.println("不存在该站，请重新输入！");
               inputBusStop();
           }else
               startNum = selestBusStop(addBusStop(),start);

           System.out.println("到达站：");
           BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
           String stop = in2.readLine();
           if(selestBusStop(addBusStop(),stop)==0){
               System.out.println("不存在该站，请重新输入！");
               inputBusStop();
           }else
               stopnum = selestBusStop(addBusStop(),stop);

           if(comp(start,stop)){
               System.out.println("您自:"+start+"--------->>"+stop+"  总共需要："+ money(startNum,stopnum)+"￥");
               System.exit(0);
           }else{
               System.out.println("起点站与终点站重复，请重新输入");
               inputBusStop();
           }


       } catch (IOException e){
           e.printStackTrace();
       }finally {
           System.out.println("系统异常！！！！！！");
       }

    }
    public boolean comp(String start,String stop){
        if(start.equals(stop)) {
            return  false;
        }else
            return true;
    }
    public static void main(String[] args) {
        new HomeWork5().inputBusStop();
    }
}
