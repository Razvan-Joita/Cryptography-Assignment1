import java.util.Scanner;

public class Assignment3 {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static String Encryption(int c11, int c12, int c21, int c22, String plaintext) {

        String result = "";
        int determinant = c11 * c22 - c12 * c21;

        if (gcd(determinant, 26) != 1) {
            return "Error: Determinant is not coprime with 26";
        }

            if(plaintext.length()%2!=0){
                plaintext += 'a';
            }

            for(int i=0;i<plaintext.length();i+=2){

                int  l1 = c11 * ( plaintext.charAt(i) - 'a' ) + c12 * (plaintext.charAt(i+1)- 'a');
                int  l2 = c21 * ( plaintext.charAt(i) - 'a' ) + c22 * (plaintext.charAt(i+1)- 'a');

                result += (char)(l1%26 + 'a');
                result += (char)(l2%26 + 'a');

            }

            return result;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter c11:");
        int c11 = scanner.nextInt();
        System.out.println("Enter c12:");
        int c12 = scanner.nextInt();
        System.out.println("Enter c21:");
        int c21 = scanner.nextInt();
        System.out.println("Enter c22:");
        int c22 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter plaintext:");
        String plaintext = scanner.nextLine();

        String ciphertext = Encryption(c11, c12, c21, c22, plaintext);

        System.out.println("Ciphertext: " + ciphertext);

    }


}
