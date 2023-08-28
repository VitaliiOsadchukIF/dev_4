package org.example;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static boolean loggingEnabled = true;

    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.example:type=Logging");
        Logging mbean = new Logging();
        mbs.registerMBean(mbean, name);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введіть рядок: ");
            String input = scanner.nextLine();
            String output = IntStream.range(0, input.length())
                    .mapToObj(i -> (i % 2 == 0) ? Character.toUpperCase(input.charAt(i)) :
                    Character.toLowerCase(input.charAt(i)))
                            .map(String::valueOf)
                            .collect(Collectors.joining());
            System.out.println("Результат: " + output);
            if (loggingEnabled) {
                System.out.println("Логування: " + output);

            }
        }

    }
}
