package ChinaIDNumber;

import org.junit.jupiter.api.Test;

import java.net.IDN;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 * Classname: ID
 * Package: ChinaIDNumber
 * Discription:
 *
 * @Author Zhifar
 * @Time 2023/9/13 12:31
 * @Version 1.0
 */
class Birthday {
    int age;
    LocalDate birthday;

    Birthday(String birthday) {
        /*
        输入长度为8的字符串yyyy-mm-dd
         */
        int year, month, day;
        year = Integer.parseInt(birthday.substring(0, 4));
        month = Integer.parseInt(birthday.substring(4, 6));
        day = Integer.parseInt(birthday.substring(6, 8));
        this.birthday = LocalDate.of(year, month, day);
        Period period = Period.between(this.birthday, LocalDate.now());
        age = period.getYears();
    }


}
class TestC{
    @Test
    public void test() {
        /*
        测试Birthday类计算年龄的功能
         */
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).matches("0000.*")) {
            System.out.println(new Birthday(input).age);
        }
    }
}
public class ID {
    String IDNumber;
    Birthday birthday;
    boolean gender;
    String genderName;

    public ID(String IDNumber) {
        this.IDNumber = IDNumber;
        birthday = new Birthday(IDNumber.substring(6, 14));
        gender = (IDNumber.charAt(16) - '0') % 2 == 1 ? true : false;
        genderName = gender ? "男" : "女";
    }

}
