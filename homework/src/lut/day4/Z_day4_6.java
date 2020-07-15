package lut.day4;

public class Z_day4_6 {
    /*
   * 1、创建一个称作Array2D 的类，在main()方法中声明一个称作twoD的变量，类型为int二维数组，第一维长度为4。
	2、创建一个元素类型为int的数组，该数组应包括4 个元素并被赋值到变量twoD[0]。
	3、编写两个嵌套for()循环语句以打印twoD 的全部值，以矩阵的格式输出。
	4、编译并运行程序。是不是发现此时出现了运行错误(空指针异常)，这是因为twoD[1]至twoD[3]未被初始化。
	5、分别创建包括5个、6个和7个元素的int数组，将这些数组的引用分别赋予twoD[1]，twoD[2]和twoD[3]；确认完成上述操作的代码位置是在第3步所描述的嵌套for()循环之前。
	6、编译并运行程序。应该看到一个零值的非矩形布局。
	7、赋予twoD数组的每个元素一个明显的非零值(提示：使用Math.random()以获得0~1之间的随机值，通过"*"将其放大100倍)。
	8、声明一个类型为int的一维数组oneD，长度为4，将该数组的引用赋予数组twoD[0]。对oneD中的元素赋值后，打印oneD和twoD数组。
	9.编译并运行程序。应该看到oneD中的数组元素和twoD中的部分元素是相同的。
     * */
    public static void main(String [] arge){
        int [][]twD;
        twD = new int[4][];
        int [] a = {1,2,3,4};
        int [] b = {1,2,3,4,5};
        int [] c = {1,2,3,4,5,6};
        int [] d = {1,2,3,4,5,6,7};
        twD[0]= a;
        twD[1]= b;
        twD[2]= c;
        twD[3]= d;
        for(int i = 0 ; i < twD.length ; i++){
            for(int j = 0 ;j < twD[i].length;j++){
                System.out.print(twD[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
