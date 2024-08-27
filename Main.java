import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int limiteTentativas;
    static String dificuldade;

    static int numeroMinimo = 1;
    static int numeroMaximo;
    public static void main(String[] args) {
        System.out.println("""
        -----------------------------------------------------------------
        Bem-vindo ao jogo do número aleatório!
        Você terá um número limite de tentativas!
        Não atinja o limite, ou perderá.
        -----------------------------------------------------------------
        """);

        escolherDificuldade();
        advinharNumero();
    }

    public static void escolherDificuldade(){
        System.out.println("""
        -----------------------------------------------------------------
        Você pode escolher entre três dificuldades
        (F) - Fácil, limite tentativas = 5, número entre 1 e 10;
        (M) - Médio, limite tentativas = 10, número entre 1 e 50;
        (D) - Difícil, limite tentativas = 15, número entre 1 e 100;
        -----------------------------------------------------------------
        Informe a dificuldade abaixo:
        """);
        dificuldade = scanner.nextLine();

        switch (dificuldade) {
            case "F", "f":
                numeroMaximo = 10;
                limiteTentativas = 5;
                break;

            case "M", "m":
                numeroMaximo = 50;
                limiteTentativas = 10;
                break;

            case "D", "d":
                numeroMaximo = 100;
                limiteTentativas = 15;
                break;
            default:
                System.out.println("Dificuldade inválida!");
        }
    }

    public static int gerarNumero(){
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(numeroMinimo, numeroMaximo);
        return numeroAleatorio;
    }

    public static void advinharNumero(){
        GuessTheNumber adivinhar = new GuessTheNumber();

        int numeroAleatorio = gerarNumero();
        int numeroEscolhido;
        int tentativas = 1;

        System.out.printf("\nDigite um número entre 1 e " + numeroMaximo + ": ");
        numeroEscolhido = scanner.nextInt();

        adivinhar.palpiteMaiorMenor(numeroEscolhido, numeroAleatorio, tentativas);

        while (numeroEscolhido != numeroAleatorio) {
            tentativas++;
            System.out.printf("\nDigite um número entre 1 e " + numeroMaximo + ": ");
            numeroEscolhido = scanner.nextInt();

            adivinhar.palpiteMaiorMenor(numeroEscolhido, numeroAleatorio, tentativas);

            if (tentativas == limiteTentativas && numeroEscolhido != numeroAleatorio) {
                System.out.println("\nVocê atingiu o número máximo de tentativas e perdeu!\nO número aleatório era: " + numeroAleatorio);
                break;
            }
        }
        
    } 
}
