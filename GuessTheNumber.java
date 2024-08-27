import java.util.*;

public class GuessTheNumber {
    public List<Integer> historicoChutes = new ArrayList<>();

    public void palpiteMaiorMenor(int numeroEscolhido, int numeroAleatorio, int tentativas){
        if(numeroEscolhido < numeroAleatorio){
            System.out.println("O número aleatório é maior do que " + numeroEscolhido);
            if((numeroAleatorio % 2) == 0){
                System.out.println("O número aleatório é par!");
            } else{
                System.out.println("O número aleatório é ímpar!");
            }
            System.out.println("O seu histório de números é: " + historicoChutes(numeroEscolhido));
        }
        else if(numeroEscolhido > numeroAleatorio){
            System.out.println("Onúmero aleatório é menor do que " + numeroEscolhido);
            if((numeroAleatorio % 2) == 0){
                System.out.println("O número aleatório é par!");
            } else{
                System.out.println("O número aleatório é ímpar!");
            }
            System.out.println("O seu histório de números é: " + historicoChutes(numeroEscolhido));
        }
        else{
            String palavraTentativa = tentativas > 1 ? "tentativas" : "tentativa";
            System.out.println("Parabéns, você adivinhou o número aleatório em " + tentativas + " " + palavraTentativa + "!");
            System.out.println(pontuacao(tentativas));
        }
    }

    public String pontuacao(int tentativas){
        int pontuacao = 100 - (tentativas - 1) * 5;

        if (pontuacao < 20) {
            pontuacao = 20;
        }
    
        if (pontuacao == 100) {
            return "Sua pontuação foi de incríveis " + pontuacao + " pontos! Parabéns!";
        } else if (pontuacao >= 80) {
            return "Sua pontuação foi de " + pontuacao + " pontos! Continue assim!";
        } else if (pontuacao >= 50) {
            return "Sua pontuação foi de " + pontuacao + " pontos! Vamos tentar de novo?";
        } else {
            return "Você atingiu apenas " + pontuacao + " pontos, que pena!";
        }
    }

    public String historicoChutes(int numeroEscolhido){
        historicoChutes.add(numeroEscolhido);
        return historicoChutes.toString();
    }
}
