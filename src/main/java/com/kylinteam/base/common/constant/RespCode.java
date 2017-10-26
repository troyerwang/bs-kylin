package com.kylinteam.base.common.constant;

public interface RespCode {

    String SUCCESS = "00000000";
    String SUCCESS_STR = "成功";

    String ERROR_UNKNOWN = "90000001";
    String ERROR_UNKNOWN_STR = "系统错误";

    String ERROR_SERVICE_STOP = "90000002";
    String ERROR_SERVICE_STOP_STR = "服务暂停使用";

    String ERROR_PARAM = "10000001";
    String ERROR_PARAM_STR = "请求参数错误";

    String ERROR_USER_NO = "10000002";
    String ERROR_USER_NO_STR = "用户不存在";

    String ERROR_USER_ID = "10000003";
    String ERROR_USER_ID_STR = "用户已存在";

    String ERROR_USER_CHECK = "10000004";
    String ERROR_USER_CHECK_STR = "用户登录认证失败";

    String ERROR_USER_TOKEN_TIMEOUT = "10000005";
    String ERROR_USER_TOKEN_TIMEOUT_STR = "用户登录认证失败，token过期";

    String ERROR_USER_NO_PERMISSION = "10000006";
    String ERROR_USER_NO_PERMISSION_STR = "没有访问权限";

}
