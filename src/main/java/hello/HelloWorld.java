package hello;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class HelloWorld {
    public static void main(String[] args) {
//        Greeter greeter = new Greeter();
//        System.out.println(greeter.sayHello());

        LocalDateTime ldt = new LocalDateTime();

        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy, MM dd, HH:mm:ss");
        String str = fmt.print(ldt);

        System.out.println(str);
    }
}
