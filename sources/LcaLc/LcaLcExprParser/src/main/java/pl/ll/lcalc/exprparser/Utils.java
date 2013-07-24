package pl.ll.lcalc.exprparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lucjan
 */
public class Utils {


    public static String onlyNumbers(String tekst) {
        String nieLiczby = "[^0-9]";
        Pattern rrr = Pattern.compile(nieLiczby);
        Matcher mmm = rrr.matcher(tekst);
        return mmm.replaceAll("");
    }

}
