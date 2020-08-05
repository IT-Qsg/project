package com.dfec.flink.kafka;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname MemoryUsageExtrator
 * @Date 2020/7/29 11:13
 * @Copyright DFEC
 **/
public class MemoryUsageExtrator {
    private static OperatingSystemMXBean mxBean =
            (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    /**
     * Get current free memory size in bytes
     * @return  free RAM size
     */
   /* public static long currentFreeMemorySizeInBytes() {
        return mxBean.get
    }*/
}
