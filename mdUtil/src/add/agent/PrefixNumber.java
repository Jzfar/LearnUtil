package add.agent;

import com.sun.jdi.request.StepRequest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Classname: PrefixNumber
 * Package: add.agent
 * Discription:
 *
 * @Author Zhifar
 * @Time 2023/9/12 8:49
 * @Version 1.0
 */
public class PrefixNumber {
    boolean isNumberPoint(String line) {
        String regex = "^\\d+\\..*";
        return line.matches(regex);
    }

    void addAgentSymbol(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(filename));
        String newFile = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (isNumberPoint(line)) {
                line = "- [ ] " + line;
            }
            newFile = newFile + line+"\n";
        }
        scanner.close();

        try(FileWriter writer=new FileWriter(filename)){
            writer.write(newFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test() throws FileNotFoundException {
        new PrefixNumber().addAgentSymbol("C:\\Users\\Zhifar\\postgraduate\\Leetcode\\leetcode-master\\README.md");
    }
}
