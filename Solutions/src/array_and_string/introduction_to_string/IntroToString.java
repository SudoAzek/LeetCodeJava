package array_and_string.introduction_to_string;

// A String is actually an array of unicode characters. It's possible to perform almost all the operations we used in an array.

public class IntroToString {
    public static void main(String[] args) {
        // Compare function - String has its own compare function
        // Initialize
        String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");

        // Compare using ==
        System.out.println("Compared by '==':");
        // True since string is immutable and s1 is bind to "Hello World"
    }
}
