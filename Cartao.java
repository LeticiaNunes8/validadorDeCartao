package control;

public class Cartao {

    private String numCartao;
    private String nome;
    private String dtValidade;
    private String cod;

    public String getNumCartao() {
        return numCartao;
    }

    public String getDtValidade() {
        return dtValidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCod() {
        return cod;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDtValidade(String dtValidade) {
        this.dtValidade = dtValidade;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public String toString(){
        return "\n\nSegue abaixo os dados do seu cartão: \nNúmero: " + numCartao + "\nNome: " + nome + "\nData de Validade: " + dtValidade + "\nCVV: " + cod;
    }
}
