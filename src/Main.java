import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        Permutation permutation = new Permutation(scanner.nextLine());
        permutation.run();
        permutation.print();
        System.out.println("valid: " + permutation.isResultValid());
    }
}
