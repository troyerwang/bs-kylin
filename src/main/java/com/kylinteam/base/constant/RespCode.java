package com.kylinteam.base.constant;

public class RespCode {

    public static final String SUCCESS = "00000000";
    public static final String SUCCESS_STR = "成功";

    public static final String ERROR_UNKNOWN = "90000001";
    public static final String ERROR_UNKNOWN_STR = "系统错误";

    public static final String ERROR_SERVICE_STOP = "90000002";
    public static final String ERROR_SERVICE_STOP_STR = "服务暂停使用";

    public static final String ERROR_PARAM = "10000001";
    public static final String ERROR_PARAM_STR = "请求参数错误";

    public static final String ERROR_USER_NO = "10000002";
    public static final String ERROR_USER_NO_STR = "用户不存在";

    public static final String ERROR_USER_ID = "10000003";
    public static final String ERROR_USER_ID_STR = "用户已存在";

    public static final String ERROR_USER_CHECK = "10000004";
    public static final String ERROR_USER_CHECK_STR = "用户登录认证失败";

    public static final String ERROR_USER_TOKEN_TIMEOUT = "10000005";
    public static final String ERROR_USER_TOKEN_TIMEOUT_STR = "用户登录认证失败，token过期";

    public static final String ERROR_USER_NO_PERMISSION = "10000006";
    public static final String ERROR_USER_NO_PERMISSION_STR = "没有访问权限";

}
