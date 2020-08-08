package com.wuhan.mall.util;
import org.apache.commons.lang.StringUtils;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;



/**
 *
 * @author stenio
 *
 */
public abstract class StringUtil {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	private static final String HMAC_SHA1 = "HmacSHA1";

	public static String getRandomNumber(int length) {
		int[] source = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			int random = r.nextInt(source.length - 1);
			sb.append(source[random]);
		}
		return sb.toString();
	}

	public static String md5(String source) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] digest = md5.digest(source.getBytes());
			return byte2Hex(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getSignature(String data, String key) {

		byte[] keyBytes = key.getBytes();
		// 根据给定的字节数组构造一个密钥。
		SecretKeySpec signingKey = new SecretKeySpec(keyBytes, HMAC_SHA1);
		Mac mac = null;
		try {
			mac = Mac.getInstance(HMAC_SHA1);
			mac.init(signingKey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		byte[] rawHmac = mac.doFinal(data.getBytes());

		String hexBytes = byte2Hex(rawHmac);
		return hexBytes;
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	public static boolean isNumber(String str) {
		if (isEmpty(str)) {
			return false;
		}
		return Pattern.matches("^\\d+$", str);
	}

	private static String byte2Hex(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String valueOf(String value) {
		if (value == null) {
			return "";
		}
		return value;
	}

	public static String valueOf(Integer value) {
		if (value == null) {
			return "";
		}
		return String.valueOf(value);
	}

	public static String valueOf(Long value) {
		if (value == null) {
			return "";
		}
		return String.valueOf(value);
	}

	public static String valueOf(Float value) {
		if (value == null) {
			return "";
		}
		return String.valueOf(value);
	}

	public static String valueOf(Double value) {
		if (value == null) {
			return "";
		}
		return String.valueOf(value);
	}

	public static String valueOf(Character value) {
		if (value == null) {
			return "";
		}
		return String.valueOf(value);
	}

	public static String valueOf(Byte value) {
		if (value == null) {
			return "";
		}
		return String.valueOf(value);
	}

	public static String valueOf(Boolean value) {
		if (value == null) {
			return "";
		}
		if (value) {
			return "1";
		}
		return "0";
	}

	/**
	 * 判断字符串是否为IP地址
	 * 
	 * @param ipAddr
	 *            IP地址
	 * @return true为是IP地址
	 */
	public static boolean isIP(String ipAddr) {
		if (StringUtils.isBlank(ipAddr) || ipAddr.length() < 7 || ipAddr.length() > 15) {
			return false;
		}
		Pattern pat = Pattern.compile(GlobalConstant.REGEX_IP);
		Matcher mat = pat.matcher(ipAddr);
		boolean ipAddress = mat.find();
		return ipAddress;
	}

	/**
	 * 校验手机号
	 * 
	 * @param mobile
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isMobile(String mobile) {
		return Pattern.matches(GlobalConstant.REGEX_MOBILE, mobile);
	}

}
