package exe1;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author qsg
 * @version 1.0
 * @Date 2019/9/17 11:31
 * @describe
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库
 * class Solution {
 *     public String addStrings(String num1, String num2) {
 *     }
 * }
 **/
public class Solution {
    //解题思路
    /*
    每次只计算最后一个字符相加
    * */
    public String addStrings(String num1,String num2){
        if(num1==null || num2==null || num1.length()==0 || num2.length()==0 ){
            return "";
        }
        String s = "";//返回的字符串
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        int num;//各个为数字之和
        int result = 0;//如果和大于9，进位
        while(len1>=0||len2>=0){
            if(len1>=0&&len2>=0){
                num = num1.charAt(len1)+result+num2.charAt(len2)-2*'0';
                if(num>9){
                    result = 1;
                    s = String.valueOf(num%10)+s;
                }else {
                    result = 0;
                    s = String.valueOf(num)+s;
                }
            }
            if(len1< 0&&len2>=0){//num2还没有加完
                num = result+num2.charAt(len2)-'0';
                if(result!=0){
                    if(num>9){
                        result = 1;
                        s = String.valueOf(num%10)+s;
                    }else {
                        result = 0;
                        s = String.valueOf(num)+s;
                    }

                }else {
                     s = num2.substring(0,len2+1)+s;
                     result = 0;
                     break;
                }
            }if(len1>=0&&len2<0){//num1还没有加完
                num = result+num1.charAt(len2)-'0';
                if(result!=0){
                    if(num>9){
                        result = 1;
                        s = String.valueOf(num%10)+s;
                    }else {
                        result = 0;
                        s = String.valueOf(num)+s;
                    }

                }else {
                     s = num1.substring(0,len1+1)+s;
                     result = 0;
                     break;
                }
            }
            len1--;
            len2--;
        }
        if(result!=0){
            s = Integer.toString(result)+s;
        }
        return s;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int [] quernum = new int [queries.length];//存储字符串数组中的最小字母出现次数
        int [] wordnum = new int [words.length];//存储单词数组最小字母的出现的次数
        for(int i = 0;i<queries.length;i++){
            int num = num(queries[i]);
            quernum[i]=num;
        }for(int i = 0;i<words.length;i++){
            int num = num(words[i]);
            wordnum[i]=num;
        }
        int [] answer = new int [queries.length];
        for(int i = 0;i<quernum.length;i++){
            int k = 0;
            for(int j = 0;j<wordnum.length;j++){
                if(quernum[i]<wordnum[j])
                {
                    k++;
                }
        }
            answer[i] = k;
        }
        return answer;
    }
    public int num(String s){
        int i = 0;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char value = chars[0];
        for(int j = 0; j<chars.length;j++){
            if(chars[j]==value){
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().addStrings("55","52"));

        String [] q= {"bbb","cc"};
        String [] w= {"a","aa","aaa","aaaa","hsdhfjddd"};
        for (int i : new Solution().numSmallerByFrequency(q, w)) {
            System.out.println(i);
        }

    }
}
class MajorityChecker {
    private int []arr;

    public MajorityChecker(int[] arr) {
        this.arr = arr;
    }
    public int query(int left, int right, int threshold) {

        int value = -1;
        if(2*threshold>(right - left + 1)){
            Map<Integer,Integer> num = num(left, right);
            if(!num.isEmpty()){
                Set<Integer> set = num.keySet();
                for(Integer integer: set){
                    if(threshold == num.get(integer)){
                        value = integer;
                        break;
                    }
                }
            }
        }
        return value;
    }
    public Map<Integer,Integer> num(int left,int right){
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = left;i<=right;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int a []= {1,1,2,2,1,1};
        MajorityChecker majorityChecker = new MajorityChecker(a);

        int query = majorityChecker.query(0, 5, 4);// 返回 1
        int query1 = majorityChecker.query(0, 3, 3);// 返回 -1
        int query2 = majorityChecker.query(2, 3, 2);// 返回 2
        System.out.println(query);
        System.out.println(query1);
        System.out.println(query2);
    }
}
