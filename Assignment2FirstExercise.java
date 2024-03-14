import java.util.Scanner;

public class Assignment2FirstExercise {

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static boolean isCoPrime(int a){
        return gcd(a,26)==1;
    }

    public static String Encryption(int a,int b,String plainText){

        StringBuilder cipherText = new StringBuilder();

        for(char ch:plainText.toCharArray()){

            if(Character.isLetter(ch)){

                int charIndex = Character.isUpperCase(ch) ? ch - 'A' : ch - 'a';
                int encryptedIndex = (a * charIndex + b) % 26;
                char encryptedChar = Character.isUpperCase(ch) ? (char) ('A' + encryptedIndex) : (char) ('a' + encryptedIndex);

                cipherText.append(encryptedChar);

            }
            else {
                cipherText.append(ch);
            }

        }

        return cipherText.toString();

    }

    public static void main(String []args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("a= ");
        int a = scanner.nextInt();

        System.out.println("b= ");
        int b = scanner.nextInt();

        if(!isCoPrime(a)){
            System.out.println("Error:((( 'a' and 26 are not coprime");
            return;
        }

        scanner.nextLine();

        System.out.println("plainText is = ");
        String plainText = scanner.nextLine();

        String cipherText = Encryption(a,b,plainText);
        System.out.println("cipherText is = " + cipherText);

        scanner.close();


    }

}
