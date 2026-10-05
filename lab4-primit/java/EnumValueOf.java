import java.util.Scanner;

/**
 * EnumValueOf.java
 *
 * Minimal, self-contained demonstration of the one-liner:
 *
 *     result = Enum.valueOf(HouseCategory.class, stdin.next().toUpperCase());
 *
 * ... which converts a string the user typed into an enum constant.
 *
 * Compile and run from this folder with:
 *
 *     bash compile-run-java.sh EnumValueOf.java
 *
 * Then type one of:
 *
 *     DETACHED
 *     SEMIDETACHED
 *     TERRACE
 *
 * ... in ANY case (the .toUpperCase() handles mixed-case input).
 *
 * Try typing something invalid (e.g. "mansion") to see the
 * IllegalArgumentException that Enum.valueOf throws when the
 * supplied name does not match any constant of the enum.
 *
 * Compare to Enume.java in the same folder, which wraps the same
 * call in a retry-loop helper; this file strips that away so the
 * one-liner is the focus.
 */
public class EnumValueOf
{
    // The enum we will parse user input into.
    // Named constants only - no values stored against them.
    enum HouseCategory { DETACHED, SEMIDETACHED, TERRACE }

    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);

        System.out.print("Input house category (DETACHED / SEMIDETACHED / TERRACE): ");

        // --- THE LINE OF INTEREST ---------------------------------------------
        //
        // Enum.valueOf is a static generic method on java.lang.Enum:
        //
        //     public static <T extends Enum<T>> T valueOf(Class<T> enumType,
        //                                                 String name)
        //
        // It takes two arguments:
        //
        //   1. HouseCategory.class
        //      The Class<T> object of the enum type to parse INTO.
        //      This is how the method knows which enum to look up constants
        //      against; it also tells the compiler the return type is
        //      HouseCategory (type inference via the <T> type parameter).
        //
        //   2. stdin.next().toUpperCase()
        //      - stdin.next() reads ONE whitespace-delimited token from input
        //      - .toUpperCase() normalises it to uppercase so "detached",
        //        "Detached", "DETACHED" all become "DETACHED", which is the
        //        exact spelling Java expects (enum constant names are
        //        case-sensitive by convention and defined in UPPERCASE here)
        //
        // Returns: the matching HouseCategory constant.
        //
        // Throws:
        //   - IllegalArgumentException if the string does not name any constant
        //   - NullPointerException if either argument is null
        //
        HouseCategory result = Enum.valueOf(HouseCategory.class,
                                            stdin.next().toUpperCase());
        // ----------------------------------------------------------------------

        // Show what we got back, three different ways:
        System.out.println();
        System.out.println("Parsed enum constant : " + result);                        // uses .name() implicitly via toString()
        System.out.println("As .name()           : " + result.name());                 // explicit - the constant's declared name
        System.out.println("As .ordinal()        : " + result.ordinal());              // 0 for DETACHED, 1 for SEMIDETACHED, 2 for TERRACE
        System.out.println("Enum class           : " + result.getClass().getSimpleName());

        // One more thing worth seeing: a switch over the parsed value.
        // Because `result` is typed as HouseCategory (not int, not String),
        // the compiler knows the enum's full set of constants and will warn
        // if you forget one. This is one of the reasons `Enum.valueOf` is
        // preferable to parsing the string yourself: downstream code gets to
        // use the Java type system properly.
        String code;
        switch (result)
        {
            case DETACHED:
                code = "D";
                break;
            case SEMIDETACHED:
                code = "S";
                break;
            case TERRACE:
                code = "T";
                break;
            default:
                // Unreachable in practice because the switch covers every constant.
                code = "?";
        }
        System.out.println("One-letter code      : " + code);
    }
}
