import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorDados {
    public static List<Transacao> gerarTransacoes(int quantidade) {
        List<Transacao> lista = new ArrayList<>();
        Random random = new Random(67); // seed fixo para reprodutibilidade

        for (int i = 0; i < quantidade; i++) {
            double valor = 1 + (10000) * random.nextDouble(); // Valores entre 1 e 10000

            String cpf;
            if (i % 10 == 0) {
                cpf = "000" + (10000000 + random.nextInt(90000000));
            } else {
                cpf = String.valueOf(100000000 + random.nextInt(900000000));
            }

            lista.add(new Transacao("ID-" + i, valor, cpf));
        }
        return lista;
    }
}