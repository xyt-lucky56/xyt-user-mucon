package com.xyt.usermucon.common;

import lh.toolclass.LhClass;

public class ToolUtils {
    public static String getPowerKey(short port) throws Exception {
        return LhClass.getPowerKey(port);
    }
}
