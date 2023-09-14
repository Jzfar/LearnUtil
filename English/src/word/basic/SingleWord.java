package word.basic;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Classname: BasicWord
 * Package: word.basic
 * Discription:
 *
 * @Author Zhifar
 * @Time 2023/9/9 21:36
 * @Version 1.0
 */

public class SingleWord {
    String english;
    String meaning;
    String sentence;

    public SingleWord(String english, String meaning, String sentence) {
        this.english = english;
        this.meaning = meaning;
        this.sentence = sentence;
    }


    JSONObject toJsonMap() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("word", english);
        jsonObject.put("meaning", meaning);
        jsonObject.put("sentence", sentence);
        return jsonObject;
    }
}
