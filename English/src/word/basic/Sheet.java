package word.basic;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classname: Sheet
 * Package: word.basic
 * Discription:
 *
 * @Author Zhifar
 * @Time 2023/9/9 22:35
 * @Version 1.0
 */
public class Sheet {
    String decs;
    HashMap<String, JSONObject> mp = new HashMap<>();


    Sheet(String decs) {
        this.decs = decs;
    }

    void addWord(String word, String meaning, String sentence) {
        /*
        向map中写入新单词，并计入列表
         */
        mp.put(word, new SingleWord(word, meaning, sentence).toJsonMap());
    }

    void delWord() {

    }

    void editWord() {

    }

    void getWord() {

    }

    void store(String filename, boolean append) {
        JSONObject jsonInfo=new JSONObject();
        jsonInfo.put("descrition",decs);
        jsonInfo.put("vocaculary",new JSONObject(mp));
        String data = jsonInfo.toString();

        File file = new File(filename);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), append);
            BufferedWriter bf = new BufferedWriter(fileWriter);
            bf.write(data);
            bf.close();
            System.out.println("单词列表存储到了路径：" + file.getAbsoluteFile());
        } catch (IOException e) {
            System.out.println("没能存储单词列表到路径：" + file.getAbsoluteFile());
            throw new RuntimeException(e);
        }
    }


}
