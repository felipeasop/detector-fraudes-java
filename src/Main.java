import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Gerando dados de teste...");
        List<Transacao> transacoes = GeradorDados.gerarTransacoes(5000);
        System.out.println("Dados de transações gerados.");

        // Processamento sequencial
        System.out.println("Realizando processamento sequencial:");
        long inicioSequencial = System.currentTimeMillis();

        // Utilizando stream para processamento
        List<Transacao> suspeitasSequencial = transacoes.stream()
                .filter(ValidadorFraude::ehSuspeita)
                .collect(Collectors.toList());

        long tempoSequencialMs = System.currentTimeMillis() - inicioSequencial;
        double tempoSequencialSeg = tempoSequencialMs / 1000.0;

        System.out.println("- Tempo sequencial: " + String.format("%.3f", tempoSequencialSeg) + " segundos\n");

        // Processamento sequencial
        System.out.println("Realizando processamento paralelo...");
        long inicioParalelo = System.currentTimeMillis();

        // Utilizando parallelStream para processamento
        List<Transacao> suspeitasParalelo = transacoes.parallelStream()
                .filter(ValidadorFraude::ehSuspeita)
                .collect(Collectors.toList());

        long tempoParaleloMs = System.currentTimeMillis() - inicioParalelo;
        double tempoParaleloSeg = tempoParaleloMs / 1000.0;

        System.out.println("- Tempo paralelo: " + String.format("%.3f", tempoParaleloSeg) + " segundos\n");
    }
}