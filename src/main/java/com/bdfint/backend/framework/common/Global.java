/*
 * Copyright &copy; <a href="http://www.zsteel.cc">zsteel</a> All rights reserved.
 */

package com.bdfint.backend.framework.common;

import com.bdfint.backend.framework.config.SystemProperties;
import com.bdfint.backend.framework.util.StringUtils;

/**
 * 全局常量
 *
 * @author lufengcheng
 * @date 2016-01-15 09:56:22
 */
public class Global {

    /**
     * 显示/隐藏
     */
    public static final String SHOW = "1";
    public static final String HIDE = "0";

    /**
     * 是/否
     */
    public static final String YES = "1";
    public static final String NO = "0";

    /**
     * 对/错
     */
    public static final String TRUE = "true";
    public static final String FALSE = "false";

    /**
     * 标准状态值（0：删除；1：正常；2：审核；3：锁定）
     */
    public static final int STATUS_DELETE = 0;
    public static final int STATUS_NORMAL = 1;
    public static final int STATUS_AUDIT = 2;
    public static final int STATUS_LOCK = 3;

    /**
     * 列表中每页默认显示条数
     */
    public static final int PAGE_SIZE = 10;

    private static SystemProperties systemProperties;

    public void setSystemProperties(SystemProperties systemProperties) {
        Global.systemProperties = systemProperties;
    }

    /**
     * 获取mvc视图前缀
     */
    public static String getViewPrefix() {
        return systemProperties.getViewProfix();
    }

    /**
     * 获取mvc视图后缀
     */
    public static String getViewSuffix() {
        return systemProperties.getViewSuffix();
    }

    /**
     * 获取当前系统部署目录
     *
     * @return 路径
     */
    public static String getSysRootPath() {
        String sysRootPath = System.getProperty("webapp.root");
        if (sysRootPath == null) {
            String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
            String temp = path.replaceFirst("file:/", "").replaceFirst("WEB-INF/classes/", "");
            String separator = System.getProperty("file.separator");
            sysRootPath = temp.replaceAll("/", separator + separator);
        }
        return sysRootPath;
    }

    /**
     * 获取上传文件的根目录
     */
    public static String getFileUploadPath() {
        String dir = systemProperties.getFileUploadPath();
        if (StringUtils.isBlank(dir)) {
            dir = getSysRootPath() + "/uploads/";
        }
        return dir;
    }

    /**
     * 获取文件服务器地址
     */
    public static String getFileAccessPath() {
        String url = systemProperties.getFileAccessPath();
        if (StringUtils.isBlank(url)) {
            url = "/uploads/";
        }
        return url;
    }

    /**
     * 获取管理端根路径
     */
    public static String getAdminPath() {
        String path = systemProperties.getAdminPath();
        if (StringUtils.isBlank(path)) {
            path = "/";
        }
        return path;
    }

    /**
     * 获取前端根路径
     */
    public static String getFrontPath() {
        String path = systemProperties.getFrontPath();
        if (StringUtils.isBlank(path)) {
            path = "/";
        }
        return path;
    }

    /**
     * 静态文件后缀
     */
    public static String getStaticFileSuffix() {
        return systemProperties.getStaticFileSuffix();
    }

    /**
     * 获取URL后缀
     */
    public static String getUrlSuffix() {
        return systemProperties.getUrlSuffix();
    }


}
