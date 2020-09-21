package algo_Demo.interesting;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author sc
 * @date 2020/8/26
 **/

//施工中~~~
//读英语文档，找顾卓凡所要的乱序单词

public class File_world {


    static List<String> data = new ArrayList<>();

    public static void main(String[] args) {

    }

    private static <T> void wirteString(String path, List<T> data) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(path));

        Iterator<T> iterator = data.iterator();

        while (iterator.hasNext()) {
            fileWriter.write((char[]) iterator.next());
            fileWriter.write("\n");
            fileWriter.flush();
        }

    }

    private static void read() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(new File("E:\\fileTest\\kaoyan.txt"));
        FileReader fileReader = new FileReader("E:\\fileTest\\kaoyan.txt");
        System.out.println("开始读入~~~");
        Scanner filein = new Scanner(fis);
        while (filein.hasNext()) {
            String temp = filein.nextLine();
            StringBuffer temp1 = new StringBuffer();
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == ' ') {
                    //System.out.println(temp1.toString());
                    data.add(temp1.toString());
                    break;
                } else {
                    temp1.append(Character.toLowerCase(temp.charAt(i)));
                }
            }

        }
    }

}
