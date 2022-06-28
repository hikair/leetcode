package com.other.middle;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

/**
 * TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
 *
 * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
 *
 * 实现 Solution 类：
 *
 * Solution() 初始化 TinyURL 系统对象。
 * String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
 * String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
 *  
 *
 * 示例：
 *
 * 输入：url = "https://leetcode.com/problems/design-tinyurl"
 * 输出："https://leetcode.com/problems/design-tinyurl"
 *
 * 解释：
 * Solution obj = new Solution();
 * string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
 * string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
 *  
 *
 * 提示：
 *
 * 1 <= url.length <= 10^4
 * 题目数据保证 url 是一个有效的 URL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/encode-and-decode-tinyurl
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TinyURL {

    MCrypt mc = new MCrypt("leetcode20220000");

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int i = longUrl.lastIndexOf("/");
        return String.format("%s/%s", longUrl.substring(0, i), mc.encrypt(longUrl.substring(i + 1)));
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int i = shortUrl.lastIndexOf("/");
        return String.format("%s/%s", shortUrl.substring(0, i), mc.decrypt(shortUrl.substring(i + 1)));
    }

    public static class MCrypt {

        private static String iv = "fedcba9876543210";
        private IvParameterSpec ivspec;
        private SecretKeySpec keyspec;
        private Cipher cipher;

        private static String SecretKey = "qianqianqianqian";
        private static final char PADDING_CHAR = ' ';
        private static final int PADDING_SIZE = 16;

        public MCrypt() {
            this(iv, SecretKey);
        }

        public MCrypt(String salt) {
            this(salt, SecretKey);
        }

        public MCrypt(String salt, String key) {
            ivspec = new IvParameterSpec(salt.getBytes());

            keyspec = new SecretKeySpec(key.getBytes(), "AES");

            try {
                cipher = Cipher.getInstance("AES/CBC/NoPadding");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String encrypt(String text) {
            byte[] encrypted;

            try {
                cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);

                encrypted = cipher.doFinal(padString(text).getBytes());
            } catch (Exception e) {
                return text;
            }

            return bytesToHex(encrypted);
        }

        public String decrypt(String code) {
            if (code == null || code.length() == 0){
                return code;
            }

            byte[] decrypted;

            try {
                cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

                decrypted = cipher.doFinal(hexToBytes(code));
            } catch (Exception e) {
                return code;
            }
            return new String(decrypted).trim();
        }

        public static String bytesToHex(byte[] data) {
            if (data == null) {
                return null;
            }

            StringBuilder str = new StringBuilder();
            for (byte aData : data) {
                if ((aData & 0xFF) < 16) {
                    str.append("0").append(Integer.toHexString(aData & 0xFF));
                } else {
                    str.append(Integer.toHexString(aData & 0xFF));
                }
            }
            return str.toString();
        }

        public static byte[] hexToBytes(String str) {
            if (str == null) {
                return null;
            } else if (str.length() < 2) {
                return null;
            } else {
                int len = str.length() / 2;
                byte[] buffer = new byte[len];
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
                }
                return buffer;
            }
        }

        private static String padString(String source) {
            byte[] ss = source.getBytes();
            int x = ss.length % PADDING_SIZE;
            if (x == 0) {
                return source;
            }
            int padLength = PADDING_SIZE - x;
            byte[] cs = Arrays.copyOf(ss, ss.length + padLength);
            for (int i = ss.length; i < cs.length; i++) {
                cs[i] = PADDING_CHAR;
            }
            return new String(cs);
        }
    }
}
