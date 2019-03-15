package com.accp.action.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092800614331";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCELBjClPK0KvSmpsYbuhLL71PXkSfhcIS/oyCaKXfbdksS50p2KVRJ5JT0e/kjauwTPHNWnP0r5PzSns6CtX9tVQNRdjo3cSn+fRwUlZlfkfzFghA5x3DmbxkaptIagVqyQUmlxTXPndX3O2vb3iIW6aQNRWwb7Hsq6c8rdl7fr1BIwbmaJAIdZl1XpTggD64xTS3Bnw7lwadMlHDGeL2hY45fyFoX2AbNziSPXOCN/+BOh6MA0T56MqiEeO9/G2O2948bW9o0iROB1PGKXiGszBc3NpHBhZXl4qPEnDHpSTcZnkQQaErDbQdPnskg7CyZoW7WreTY+nzrrG7a/E0VAgMBAAECggEAeqg9lh4KGh8fCaUNhl+o3+7LHOsNWo5D82AcelRvcZAW3YUdOgjiuuxRO43tR+wLB1L7Km7oGBsacQ+FUBHFHp5dRPT108vGD/Dk5UlrmyBstpIcIrKuWHrTjkMwCf7vPyuNgDRC2th730MatmEvu5m5b8N0L3nHV6zBYHEqXGQM8ZIQQQD61uMS3SHD9aC/VxTr8aoGweQiXhr2CXR19GMDaT3pJWTFYMzBdCXZH7fnc1raMjZ9muN91PQR3sBHHkPcUUVhnJqx5Ps2Enwr9hlhxKIw582wCxizlaQE8DZW+x7WrE9TaXkJLYKw11rHZ4b2qunuQyCIrxUnIvMkhQKBgQC/E7KHvKKDHlGoX6GFu44fSY0d2OwOp6wSjv/Mm+SEJd4hjVX15a0giUoWCMZoqJn/BZ36j9wjhXHegxfvITRc/u/EZKBhaJyQqLl3C7GHXsPqxcUEoCNqy3HJbreZNunPDRgu1uAo5/WNAzisY1Uokt9smmKm6U/VfXntD45BbwKBgQCxFLyehYP4xPownzba7x7vwXdj16bsRjzteVKbSHu84uQhBG4LvPVPC41R9Su/Mp66meAo4GoZ4H1SISAMwm0bZGkMJCbqqx2xk214MH/ux0Blh0S7yh6soDXryihAvXigkXoGPlfIP40rVNJyjKNs7VQVmTFhOu2cWWZ4AxMPuwKBgEtJGYi93FJJOedbdqrYkVDmjAF8nNXRXs0ZJtSZf9pJiVIy+/GdAy/UqCoyXuqRs8t1jR9SW2xrgcgoYt/Hd3hEwnfhJgf7TeT5dcngA5zQy+TO86e06P+FFVpGk3R83HbGNAcQhtXXPzrGUCgsIzuPUxTZZ5FYUCpP/CBZhrVlAoGBAKVTygJqf1tMdJXeoDVpmUWZKCF0Xukrboj8g45s7vHcF8dnvmKBKbqB+5AwSYa5+Q4YyfsAAq9kMzzxpl2jTICNj7IBMsBXwGJhVYwoI9lH+CySTS7Sty7OaWlaFZjUDQJEsFuR6x0PkHqLN+wwuAfj0GRV4Y94mA0oPo3/uNUvAoGAGUzSDxqyLTnPEnaLS6w/6PXyZ1VoRYUeef8Si1WN1TyFZDKmoHxrPuacsNrqwDpyYeKU3/54vseTm8fk45fjlay1rzEjXzjWTrm5vnVBZh84LA5c46XJCHNw2putrHOQjomp6vyMdwSWdY2QfVRcHmKoYH9nnEZPj/ANz8BD7HY=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA22QyYOo2wGr4lTKyye2HE7+yuTcFAkVZivb17baNzANpRkQDljh2N8rqkGr5Pn7o5G1+Cs+ZQVDpsY5jCYjCtBwbeRnqFjDu6mpI+g04wNP5LpPBTSan8prylnje+xZ+HEmRbXBoaw26djiZuLpNsyy+tvHeF+vGi4eh11UDOY9wc8URBEzAkKG/T+8AP2cDpD/OO1/7kQeXzKX+zFOLVJCG0ipV1PrFdWrQWg6XGHJX659MIxERnKQ8SFFo/04cgs65FjvdWpU84InyYGRk5/HHp7gaSb+LBbsoMulnmwrH164QNOXVFlo0fsDoqPjLSMkwNIB/FtR0HD/VJNJE8wIDAQAB";
    
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://127.0.0.1:7777/ylh/c/notify_url";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1:7777/ylh/c/return_url";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl="https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
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

