package Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public final class WrapFarsi {
    public static String getFarsiString(HttpServletRequest req, String parameter) throws UnsupportedEncodingException {
        String str = new String(req.getParameter(parameter).getBytes("8859_1"), "UTF-8");
        return str;
    }

}
