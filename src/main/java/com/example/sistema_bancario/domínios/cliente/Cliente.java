package com.example.sistema_bancario.domínios.cliente;

import com.example.sistema_bancario.domínios.Banco;
import com.example.sistema_bancario.domínios.contas.Conta;
import com.example.sistema_bancario.exceptions.LoginInvalidoexception;

import java.util.Objects;

import static com.example.sistema_bancario.domínios.Banco.cadastroContas;

public class Cliente {
    private String nome;
    private String email;
    private String CPF;
    private String senha;

    public Cliente(String nome, String email, String CPF, String senha) {
        this.nome = nome;

        if (!validarEmail(email)){
            throw new LoginInvalidoexception("Email Inválido.");
        }

        this.email = email;

        if (CPF.length() != 11){
            throw new LoginInvalidoexception("CPF com menos ou mais de 11 caracteres.");
        }
        this.CPF = CPF;

        if (senha.length() < 8){
            throw new LoginInvalidoexception("Senha com menos de 8 caracteres");
        }
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!validarEmail(email)){
            throw new LoginInvalidoexception("Email inválido.");
        }
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        if (CPF.length() < 11){
            throw new LoginInvalidoexception("CPF com menos de 11 caracteres.");
        }
        this.CPF = CPF;
    }

    public String getSenha() {
        if (senha.length() < 8){
            throw new LoginInvalidoexception("Senha com menos de 8 caracteres.");
        }
        return senha;
    }

    public void setSenha(String senha, Banco conta) {
        this.senha = senha;
    }

    public boolean validarEmail(String email){

        if (Objects.isNull(email)){
            return false;
        }

        if (email.length() < 15){
            return false;
        }

        if (!email.endsWith("@gmail.com") && !email.endsWith("@hotmail.com")){
            return false;
        }

        return true;

     }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(CPF, cliente.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(CPF);
    }
}
