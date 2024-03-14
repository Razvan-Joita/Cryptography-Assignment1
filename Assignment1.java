import java.util.Scanner;

public class Assignment1 {

    public static String Decryption(int Key, String cipherText) {

        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {

            char ch = cipherText.charAt(i);

            if (Character.isUpperCase(ch)) {

                char decryptedChar = (char) (((ch - 'A' - Key + 26) % 26) + 'A');
                plainText.append(decryptedChar);


            } else if (Character.isLowerCase(ch)) {

                char decryptedChar = (char) (((ch - 'a' - Key + 26) % 26) + 'a');
                plainText.append(decryptedChar);

            } else {

                plainText.append(ch);

            }
        }
        return plainText.toString();

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose K = ");
        int key = scanner.nextInt();
        scanner.nextLine();

        System.out.print("The cipherText is: ");
        String ciphertext = scanner.nextLine();

        String plaintext = Decryption(key, ciphertext);
        System.out.println("Decrypted plainText: " + plaintext);

        scanner.close();

    }


}
