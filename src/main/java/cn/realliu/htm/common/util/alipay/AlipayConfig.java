package cn.realliu.htm.common.util.alipay;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/15
 * @Time: 15:11
 * @Description：支付宝配置类
 */

public class AlipayConfig {

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092500593744";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC1zPKrKOBy/3lJTJX5PQeFuFcYTgm4Ie+QAoJxNHnj/6VIf40pdrk83qJdx4R82/GoZ+G6LmZ+v1JzZ0r+htHMLgZQmRSTetb9H2c7VxFiWjoiEpBCCxM5W2iFedfRukUiuNJvIThrNiB3VcFVNmQ4YhsZS6yqQqX2ff4SzVcSEBBH7EzvBLfgJtmAsLdLLIuZvmXEy0SGHlrPPkYbTiLl/l5E+kbfu3LLVwOL4/ax8beS//qN7+hUi4fQezMCA9wjwGlKOb3YqDuz/KnShM8RXee4YUSvJrIoJDfSTirP2WA1ztMBsWD334MfKeXISWv8p68ZJq0vnqldPOpEq2ltAgMBAAECggEBAJ2+jB0pZb9CntmUA1l0s+86KRAkvlgv0e7xzn8tmknTy3Vhf3mn00jWoKmgcfvo2AFYycrDchmuJnuN98tr7eQtVztd6DWjU6HkOq2JecMOKPzhgJxdgbu17bZLJ5GJ/20GU0kr2QlluLvzA8LNZB5sObk0KUi+dcSwQ+HKnC9FnAljMaS8AkMR9bJs1iVGMroUPLFqddK3WVDIijTSYsO4wbkyIvmF1Qv8oWRuOoK7qaGPEVvlxk5jGMwt0BNm71AVlBT+Dvx51shnZrj57T3j7IRoQWmYeE/iABrsvt9UvhMruDHLDjPjjhHynjPoSU5yVUc9QsEOC8B4l6aa20ECgYEA4y7ZuDGhXPnYfjvRJefKN42WmW1R0JsKJgULrZ6yFgnhlM9iJk0mKOxn6CiFc9Ot6AwYijq9mjmrPm3zEfQy8OqGtaJRdU+y7HK0YXhQL1oCmD/Ji3BTf6hb3if80/m7gadlQjF3xs/XBPsmCZoRXXfm1+Vrpv6aC2848XA2NzECgYEAzNxtNDTB3ibie7eIuCmZzPQY9yt0Sb5n6OMqcDKdJDzWdNePfels7TIbnrZog8FZNN0QBhABU/9KjY5HQ8WGUb2RZdoFkp7FS7cmZ8PNsRJkpmfUIqKlXAOVQ0qPBmfABEFpt5OsZ6eIRSPWHsUn+Zl31a/WFKCrmhZZ1N0JPv0CgYAragyZMoLPrb89gFjbkYwHSbt53nZAEyDBWz18FFOb+o9tTKRJBX1BXMwOhY/bLpyRN56I6+jHzDV5XLGSwMPrXiYYF8jRTkW3AcSOy9sm8WCFj8sIJpMOVjIYJjQenh7DDCZBnApzp8xDW2tNcm/XGM64e1MzOnxdqweKvBLgQQKBgGYjZGMKBrqfAn6SVB0VyLPR4/yf8rutrhsD363O3mAp4PaiXs11KzTbrb+kzFkcdkCQEyQiqLbbaq1HCar1eXGZpTt1xx+B/3Yvm3tSuWQWeo4o6DBYjT9iHfJN4x9bbPXyMyYu/18yvRNTubbfr32XkZK9t2vTa5tIl4M0rR51AoGBAMVJaagCwkTwIAWVFy7cgy/nzguStMnYIOBAuV/Al+yCg53DB9/W7fuNxiGqsj9yc6sTzAHbH55eDWUQvOlyOXLlVcVSNUMEQXhEYHN2vfzdxYjnI6sz1hHbCC643N0/yHWk2HmpghgcJh6syjbyAMOWcrEwJxvMPVK78y+g03jf";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlIXp18EcdXtqy3hUFyec/jRmlKSsMENHEdROcyUzMZynKMIwjaZFVNGTWgLDeIGAmo/Ser+e44cueuYknfV3frJdU6kwWXBefrnvHoZaQryG343Jk0B4f1TwQqRdXeaaFAZyeVaCqFXoudzPhF9cayISwt9hJzsWg1eXo8jPF2rElaizJsurWHLcF5OQT04pkUxoZ2cdvlKHsX1AiuKejelaSv+LM6LzySMnfo+dgcm9X+SFDlejs1xd9J8IlNO2npO0W2g1GyaHA/5LFL0n4+HVKzbRC0hYxcifngCwJXQJQ4DuthUVbgBzYY/ZURpL33vz8Qc27aiwxUizbva/TQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8088/alipay/alipayNotifyNotice";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8088/alipay/alipayReturnNotice";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 日志路径
	public static String log_path = "C:\\";


    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

