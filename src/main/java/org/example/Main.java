package org.example;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Main {


    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.example:type=Logging");
        Logging mbean = new Logging();
        mbs.registerMBean(mbean, name);
        App.camelApp();


    }
}
