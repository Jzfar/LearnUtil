package ChinaIDNumber;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classname: age
 * Package: ChinaIDNumber
 * Discription:
 *
 * @Author Zhifar
 * @Time 2023/9/13 12:31
 * @Version 1.0
 */
public class AgeGender {
    void getAgeGender(String inputFilename,String outputFilename) throws IOException {
        Scanner scanner = new Scanner(new FileReader(inputFilename));
        ArrayList<ID> ids = new ArrayList<ID>();
        while (scanner.hasNext()) {
            String idNumber = scanner.nextLine();
            if (idNumber.length() == 0) {
                continue;
            }
            ids.add(new ID(idNumber));
        }
        scanner.close();
        FileWriter fileWriter = new FileWriter(outputFilename);
        for (ID id : ids) {
            fileWriter.write(id.genderName + "," + id.birthday.age + "\n");
        }
        fileWriter.close();
    }
    @Test
    public void test(){
        /*
        解析C:\Users\Zhifar\IdeaProjects\LearnUtil\ExcelUtil\data\IDnumbers中的身份证号，得到性别和年龄
         */
        try {
            new AgeGender().getAgeGender("C:\\Users\\Zhifar\\IdeaProjects\\LearnUtil\\ExcelUtil\\data\\IDnumbers","C:\\Users\\Zhifar\\IdeaProjects\\LearnUtil\\ExcelUtil\\data\\output\\idInfo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
