package BLUE;

import java.util.Scanner;

/**
 * @author sc
 * @date 2020/8/20
 **/


/*	把每个单词的首字母变为大写。
        2.	把数字与字母之间用下划线字符（_）分开，使得更清晰
        3.	把单词中间有多个空格的调整为1个空格。
        例如：
        用户输入：
        you and     me what  cpp2005program
        则程序输出：
        You And Me What Cpp_2005_program
        用户输入：
        this is     a      99cat
        则程序输出：
        This Is A 99_cat*/


public class newtest {//

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String temp = in.nextLine();
        System.out.println("输入结束");


        int len = temp.length();
        boolean blankflag = true;//表明前方有空格，第一个单词需要大写   false为前方无空格
        boolean numflag = false;//   检测当前是否为数字
        boolean letterflag= false;
        StringBuffer ret = new StringBuffer();

        for (int i = 0; i < len; i++) {
            char chtemp = temp.charAt(i);
            if (Character.isLetter(chtemp)){
                letterflag = true;
                if (blankflag){
                    ret.append(Character.toUpperCase(chtemp));
                    blankflag = false;
                    numflag = false;
                    continue;
                }
                else if (numflag){
                    ret.append('_');
                    ret.append(chtemp);
                    numflag = false;
                }else {
                    ret.append(chtemp);
                }

            }
            else if (Character.isDigit(temp.charAt(i))){
                if (letterflag){
                    ret.append('_');
                    letterflag=false;
                }
                numflag = true;
                blankflag = false;
                ret.append(chtemp);
            }
            else {
                letterflag=false;
                if (blankflag){
                    continue;
                }else {
                    blankflag = true;
                    ret.append(chtemp);
                }
            }
        }

        String result = ret.toString();
        System.out.println(result);
    }

}
