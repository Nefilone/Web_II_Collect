package utils;

public class Printer {

    public static void printHeader(String title) {
        System.out.println();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  " + title);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    public static void printSubHeader(String subtitle) {
        System.out.println();
        System.out.println("▶ " + subtitle);
    }

    public static void printSeparator() {
        System.out.println("────────────────────────────────────────");
    }

    public static void printCodeExample(String description, String code) {
        System.out.println("  " + description + ": " + code);
    }
}