package exe2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/18 19:47
 * @describe
 **/
public class SortString {
    /*
    * str1:排序规则
    * str2:被排序字符串
    * */
    public String sortStr(String str1,String str2){
        String s = "";
        //将规则字符串按顺序分割
        int strlength = str1.length();
        char [] c1 = new char[strlength];
        for(int i = 0;i<strlength;i++){
            c1[i] = str1.charAt(i);
        }
        /*
        * 将被排序字符串拆分然后安顺序输出
        * */
        char[] chars = str2.toCharArray();
        /*for(int i = 0;i<c1.length;i++)
            for(int j = 0;j<chars.length;j++){

            }*/
        List<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(aChar);
        }
        //创建一个集合，存储相等字符的索引
        List<Integer> lis = new ArrayList<>();
        for(int i = 0;i<c1.length;i++){
            for(int j = 0;j<list.size();j++){
                if(list.get(j)==c1[i]){
                    s = s+list.get(j);
                    lis.add(j);
                }
            }
        }
        //删除相等字符
        for (Integer li : lis) {
            list.remove((int)li);

        }
        if(!list.isEmpty())
        for (Character character : list) {
            s = s+character;
        }

       /* ListIterator<Character> chara = list.listIterator();
        for(int i = 0;i<c1.length;i++) {
            while (chara.hasNext()) {
                if (chara.next() == c1[i]){
                    s=chara.next()+s;
                    chara.remove();
                    continue;
                }else
                    s=chara.next()+s;
            }
        }*/
       /* for(int i = 0;i<c1.length;i++)
        {
           for(char ca : list){
               if(c1[i]==ca){
                   s=ca+s;
                   list.remove((Character)(ca));
               }else
                   s=ca+s;
           }
        }*/
        /*if(!list.isEmpty()){
            for(char ca : list){
                    s=ca+s;
                    list.remove((Character)(ca));
                }
            }*/
        return s;
    }

    public static void main(String[] args) {
       String S = "dcba";
       String T = "abcd";
        String s = new SortString().sortStr(S, T);
        System.out.println(s);
    }
}
