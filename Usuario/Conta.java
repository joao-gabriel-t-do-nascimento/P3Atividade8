package P3Atividade8.Usuario;

public class Conta {
    private String nome, senha, cpf;
    private double saldo = 0;
    private int numero = 0;

    public Conta(String nome, String senha, String cpf) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        if (nome != null) {
            for (char ch : nome.toCharArray()) {
                numero = (int) ch + numero;
            }
        }

    }

    public void depositar(double deposito) {
        this.saldo = saldo + deposito;
    }

    public void sacar(double saque) {
        if (saque > saldo) {
            System.out.println("Não é possível sacar esse valor");
        } else {
            saldo = saldo - saque;
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getSenha() {
        return senha;
    }
}
