package word.basic;

import org.json.JSONObject;

import java.io.*;
import java.util.Scanner;

/**
 * Classname: Reader
 * Package: word.basic
 * Discription:
 *
 * @Author Zhifar
 * @Time 2023/9/9 21:36
 * @Version 1.0
 */
public class Reader {
    Reader(String outputfile, boolean writeFlag) {
        /*
        从标准输入中读取一个单词列表，保存单词的英文-中文（在该分类中的意思）对照
         */
        System.out.println("请输入列表的描述；");
        Scanner scanner = new Scanner(System.in);
        String decs = scanner.nextLine();
        Sheet sheet = new Sheet(decs);
        boolean stopFlag = false;
        do {
            System.out.println("输入单词（stop为停止）：");
            String word = scanner.nextLine();
            if ("stop".compareToIgnoreCase(word) == 0) {
                stopFlag = true;
            } else {
                System.out.println("输入释义");
                String meaning = scanner.nextLine();
                System.out.println("输入例句");
                String sentence = scanner.nextLine();
                sheet.addWord(word, meaning, sentence);
            }
        } while (!stopFlag);
        scanner.close();
        sheet.store(outputfile, writeFlag);
    }


    Reader(String inputJsonFile) {
        File file = new File(inputJsonFile);
        try {
            FileInputStream fileInputStream = new FileInputStream(inputJsonFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            String str = "";
            while ((tempString = reader.readLine()) != null) {
                str+=tempString;
            }
            JSONObject demo=new JSONObject(str);
            System.out.println(demo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
