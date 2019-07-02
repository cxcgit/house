package com.k9501.house.util;



/**  
 * @Title: http://www.smschinese.cn/api.shtml
 * @date 2011-3-22
 * @version V1.2  
 */
public class SmsUtil {
	//用户名
	private static String Uid = "c菜菜c";
	
	//接口安全秘钥
	private static String Key = "d41d8cd98f00b204e980";
	
	//手机号码，多个号码如13800000000,13800000001,13800000002
	//private static String smsMob = "13800000000";

	//短信内容
	//private static String smsText = "验证码：8888";

	public static int sendMsg(String telephone,String smsText) {
		HttpClientUtil client = HttpClientUtil.getInstance();
		return client.sendMsgUtf8(Uid, Key, smsText, telephone);
	}
}
