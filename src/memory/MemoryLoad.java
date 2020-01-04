package memory;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;


/**
 * @description: 查看内存占用
 * @author: shan junwei
 * @create: 2019-08-12 17:18
 **/

public class MemoryLoad {

    private static OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();


    public static int memoryLoad() {
        double totalvirtualMemory = osmxb.getTotalPhysicalMemorySize();
        double freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();

        double value = freePhysicalMemorySize / totalvirtualMemory;
        int percentMemoryLoad = (int) ((1 - value) * 100);
        return percentMemoryLoad;
    }


    public static void main(String[] args) {
        System.out.println(memoryLoad());
    }

}
