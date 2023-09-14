package word.basic;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Classname: ReaderTest
 * Package: word.basic
 * Discription:
 *
 * @Author Zhifar
 * @Time 2023/9/9 22:57
 * @Version 1.0
 */
public class ReaderTest {


    @Test
    public void testStore() {
        // 创建一个 HashMap 对象并添加一些数据
        Sheet sheet=new Sheet("environment");
        sheet.addWord("apple","sweet food","good apple");
        sheet.addWord("banana","food","good banana");
        sheet.store("C:\\Users\\Zhifar\\IdeaProjects\\LearnUtil\\English\\data\\vocabulary\\environment",false);

    }

    @Test
    public void testReadInput(){
        Reader reader=new Reader("C:\\Users\\Zhifar\\IdeaProjects\\LearnUtil\\English\\data\\vocabulary\\environment");
    }




}
