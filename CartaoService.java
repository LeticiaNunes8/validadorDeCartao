package control;

import java.util.Calendar;
import java.util.Scanner;

public class CartaoService {

    String usuarioNum;
    String usuarioNome;
    String usuarioDtValidade;
    String usuarioCod;

    // Obtém o ano atual
    int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
    int anoAtualUltimos2Digitos = anoAtual % 100;

    Scanner scanner = new Scanner(System.in);
    Cartao cartao = new Cartao();

    public void obterNumeroDoCartao(){
        while(true){
            System.out.printf("Digite o numero do seu cartão: ");
            usuarioNum = scanner.nextLine();

            if(usuarioNum.length() != 16){
                System.out.println("Número do cartão inválido! \nSão necessários 16 dígitos!");
                continue;
            }

            if(!usuarioNum.matches("\\d+")){
                System.out.println("Número do cartão inválido! \n Digite novamente apenas números!");
                continue;
            }
            break;
        }
        cartao.setNumCartao(usuarioNum);
    }

    public void obterNomeDoCartao(){
        System.out.printf("Digite o nome presente no seu cartão: ");
        usuarioNome = scanner.nextLine();
        cartao.setNome(usuarioNome);
    }

    public void obterDataDoCartao(){
        while(true){
            System.out.printf("Digite a data de validade do seu cartão usando o formato MM/AA: ");
            usuarioDtValidade = scanner.nextLine();

            if(usuarioDtValidade.length() != 5){
                System.out.println("data inválida! \nA data deve ser digitada usando o formato MM/AA");
                continue;
            }

            // Verifica se a data está no formato correto
            if (usuarioDtValidade.matches("\\d{2}/\\d{2}")) {
                // Separa o mês e o ano
                String[] partes = usuarioDtValidade.split("/");
                int mes = Integer.parseInt(partes[0]);
                int ano = Integer.parseInt(partes[1]);

                // Verifica se o mês é válido
                if (mes >= 1 && mes <= 12) {
                    // Torna o ano para 4 dígitos
                    int anoCompleto = (ano >= anoAtualUltimos2Digitos) ? (anoAtual / 100) * 100 + ano : (anoAtual / 100) * 100 + ano + 100;

                    // Verifica se o ano é maior que o ano atual
                    if (anoCompleto > anoAtual) {
                        System.out.println("Ano digitado: " + anoCompleto);
                        break;
                    } else {
                        System.out.println("Ano inválido. Deve ser maior que o ano atual.");
                    }
                } else {
                    System.out.println("Mês inválido. Deve ser entre 01 e 12.");
                }
            } else {
                System.out.println("Formato inválido. Use o formato MM/YY.");
            }
        }
        cartao.setDtValidade(usuarioDtValidade);
    }

    public void obterCVVDoCartao(){
        while(true){
            System.out.printf("Digite o CVV do seu cartão: ");
           usuarioCod = scanner.nextLine();

            if(usuarioCod.length() != 3){
                System.out.println("CVV inválido! \nSão necessários 3 dígitos!");
                continue;
            }
            if(!usuarioCod.matches("\\d+")){
                System.out.println("CVV inválido! \n Digite novamente apenas números!");
                continue;
            }
            break;
        }
        cartao.setCod(usuarioCod);
    }
}
