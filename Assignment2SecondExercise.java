import java.util.Scanner;

public class Assignment2SecondExercise {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static boolean isCoprime(int a) {
        return gcd(a, 26) == 1;
    }

    public static int modInverse(int a) {

        for (int x = 1; x < 26; x++) {

            if ((a * x) % 26 == 1)
                return x;

        }
        return -1;
    }

    public static String Decryption(int a, int b, String ciphertext) {

        StringBuilder plaintext = new StringBuilder();
        int aInverse = modInverse(a);
        if (aInverse == -1) {

            System.out.println("Error:(((( 'a' does not have a multiplicative inverse modulo 26.");
            return "";

        }
        for (char ch : ciphertext.toCharArray()) {
            if (Character.isLetter(ch)) {

                int charIndex = Character.isUpperCase(ch) ? ch - 'A' : ch - 'a';
                int decryptedIndex = (aInverse * (charIndex - b + 26)) % 26;
                char decryptedChar = Character.isUpperCase(ch) ? (char) ('A' + decryptedIndex) : (char) ('a' + decryptedIndex);
                plaintext.append(decryptedChar);

            } else {

                plaintext.append(ch);

            }
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a = ");
        int a = scanner.nextInt();

        System.out.print("b = ");
        int b = scanner.nextInt();

        if (!isCoprime(a)) {
            System.out.println("Error: 'a' and 26 are not coprime:(((");
            return;
        }

        scanner.nextLine();

        System.out.print("ciphertext = ");
        String ciphertext = scanner.nextLine();

        String plaintext = Decryption(a, b, ciphertext);
        System.out.println("plaintext = " + plaintext);

        scanner.close();
    }
}
