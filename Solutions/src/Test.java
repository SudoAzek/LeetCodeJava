import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        System.out.println(Math.ceil(8.2));
        int a = 8, b = 7, c = 6;
        System.out.println(Math.max(c, Math.abs(Math.min(-a, -b))));
        String dataAsText = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1561554154352L));
        System.out.println(dataAsText);

        StringBuilder sb = new StringBuilder("Good Morning");
        sb.insert(1, "Friend ");
        System.out.println(sb.toString());

        // Regex TODO: Learn about regex -- email address checking regex :  ^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$

        System.out.println(vowelOnly("Udacity Course"));

    }

    public static String vowelOnly(String input) {
        String vowel = "aeiou";
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (vowel.contains(String.valueOf(c).toLowerCase())) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
