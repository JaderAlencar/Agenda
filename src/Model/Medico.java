/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jader.costa
 */
public class Medico {
    
    private int idMedico;
    private String senha;
    private String nome;
    private String crm;
    private String especialidade;
    private String telefone;
    private String email;

    public Medico() {
    }

    public Medico(int idMedico, String senha, String nome, String crm, String especialidade, String telefone, String email) {
        this.idMedico = idMedico;
        this.senha = senha;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Medico{" + "idMedico=" + idMedico + ", senha=" + senha + ", nome=" + nome + ", crm=" + crm + ", especialidade=" + especialidade + ", telefone=" + telefone + ", email=" + email + '}';
    }
    
    
    
}
