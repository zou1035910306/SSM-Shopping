package cn.zou.shopping.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static cn.zou.shopping.utils.JavaWebToken.verifyJavaWebToken;

/**
 * Created by 邹创基 on 2018/5/21 9:54
 *
 * @Description:
 */

public class AuthUtil {

    private static Map<String, Object> getClientLoginInfo(HttpServletRequest request) throws Exception {
        Map<String, Object> r = new HashMap<>();
        String sessionId = request.getHeader("sessionId");
        if (sessionId != null) {
            r = decodeSession(sessionId);
            return r;
        }
        throw new Exception("session解析错误");
    }

    public static Long getUserId(HttpServletRequest request) throws Exception {
        return  Long.valueOf((Integer)getClientLoginInfo(request).get("userId"));

    }

    /**
     * session解密
     */
    public static Map<String, Object> decodeSession(String sessionId) {
        try {
            return verifyJavaWebToken(sessionId);
        } catch (Exception e) {
            System.err.println("");
            return null;
        }
    }
}
