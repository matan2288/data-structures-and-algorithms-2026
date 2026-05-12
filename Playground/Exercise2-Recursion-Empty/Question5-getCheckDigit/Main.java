public class Main {

    // Q5: Complete the method to compute the last (check) digit of a credit card
    // or ID number using Luhn's algorithm.
    // The number (excluding the last digit) is passed as a string n of digits
    // '0'-'9'.
    // Returns a character in the range '0'-'9'.
    //
    // Algorithm (example with "3823"):
    // 1. Number digits from the right starting at 1.
    // 2. Double every odd-numbered digit.
    // 3. If the doubled value >= 10, subtract 9.
    // 4. Sum all resulting digits.
    // 5. The check digit is what makes the total a multiple of 10.
    // e.g. sum=18 → check digit is 2 (since 18+2=20)
    public static char getCheckDigit(String n) {
        if (n.length() > 1) {

            int last_index = n.length() - 1;

            // get second to last char as int
            int scnd_last_char_int_value = n.charAt(last_index - 1) - '0';

            // multiplie scnd_last_char_int_value by 2
            scnd_last_char_int_value = scnd_last_char_int_value * 2;

            // check if we multiplie scnd_char_int_value * 2 we get more then 9
            if (scnd_last_char_int_value > 9) {
                // if scnd_char_int_value subtract - 9 and re-assing it as scnd_char_int_value
                scnd_last_char_int_value = scnd_last_char_int_value - 9;
            }

            // get last index char int value
            int last_char_int_value = n.charAt(last_index) - '0';

            // sum last and second to last int values
            int sum = scnd_last_char_int_value + last_char_int_value;

            // convert it from ascii number to char value
            char int_char_value = (char) (sum + '0');

            // put the new char on the second last index
            n = n.replace(n.charAt(last_index - 1), int_char_value);

            // remove the last char from n
            n = n.substring(0, last_index);

            // repeat
            return getCheckDigit(n);
        }

        // module % 10 check(Luhan)
        int modulo_10_check = (int) (n.charAt(0) % 10);
        char res = (char) modulo_10_check;

        if (modulo_10_check == 0) {
            System.out.println("The number is valid! Luhan test passed!");
        } else {
            System.out.println("The number is invalid! Luhan test FAILED!");
        }
        return res;
    }

    public static void main(String[] args) {
        char c = 'C';

        int char_int_value = Integer.valueOf(c);
        char int_char_value = Character.valueOf((char) 65);

        // char print = getCheckDigit("84327");
        char print = getCheckDigit("84");
        System.out.println((int) (print));
    }
}
