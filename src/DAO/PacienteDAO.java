/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.CConexao;
import Model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jader.costa
 */
public class PacienteDAO {

    public void cadastrarPacienteDAO(Paciente pVO) {
        try (Connection con = CConexao.getConexao(); PreparedStatement pst = con.prepareStatement("INSERT INTO pacientes VALUES (null, ?, ?, ?, ?, ?, ?)")) {

            pst.setString(1, pVO.getSenha());
            pst.setString(2, pVO.getNome());
            pst.setInt(3, pVO.getIdade());
            pst.setString(4, pVO.getCpf());
            pst.setString(5, pVO.getTelefone());
            pst.setString(6, pVO.getEmail());

            pst.executeUpdate();

            System.out.println("Paciente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar paciente: " + e.getMessage());
        }
    }

    public ArrayList<Paciente> getPacientes() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try (Connection con = CConexao.getConexao(); PreparedStatement pst = con.prepareStatement("SELECT * FROM pacientes"); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Paciente p = new Paciente();
                p.setIdPaciente(rs.getInt("idPaciente"));
                p.setSenha(rs.getString("senha"));
                p.setNome(rs.getString("nome"));
                p.setIdade(rs.getInt("idade"));
                p.setCpf(rs.getString("cpf"));
                p.setTelefone(rs.getString("telefone"));
                p.setEmail(rs.getString("email"));
                pacientes.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pacientes: " + e.getMessage());
        }
        return pacientes;
    }

    public Paciente getPacienteByDoc(String cpf) {
        Paciente p = null;
        try (Connection con = CConexao.getConexao(); PreparedStatement pst = con.prepareStatement("SELECT * FROM pacientes WHERE cpf = ?")) {

            pst.setString(1, cpf);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    p = new Paciente();
                    p.setIdPaciente(rs.getInt("idPaciente"));
                    p.setSenha(rs.getString("senha"));
                    p.setNome(rs.getString("nome"));
                    p.setIdade(rs.getInt("idade"));
                    p.setCpf(rs.getString("cpf"));
                    p.setTelefone(rs.getString("telefone"));
                    p.setEmail(rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar paciente por CPF: " + e.getMessage());
        }
        return p;
    }

    public void atualizarPacienteDAO(Paciente pVO) {
        try (Connection con = CConexao.getConexao(); PreparedStatement pst = con.prepareStatement("UPDATE pacientes SET senha = ?, nome = ?, idade = ?, telefone = ?, email = ?, endereco = ? WHERE cpf = ?")) {

            pst.setString(1, pVO.getSenha());
            pst.setString(2, pVO.getNome());
            pst.setInt(3, pVO.getIdade());
            pst.setString(4, pVO.getTelefone());
            pst.setString(5, pVO.getEmail());
            pst.setString(6, pVO.getCpf());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar paciente: " + e.getMessage());
        }
    }

    public void deletarPacienteDAO(String cpf) {
        try (Connection con = CConexao.getConexao(); PreparedStatement pst = con.prepareStatement("DELETE FROM pacientes WHERE cpf = ?")) {

            pst.setString(1, cpf);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar paciente: " + e.getMessage());
        }
    }

    public Paciente getPacienteById(int idPaciente) {
        Paciente p = null;
        try (Connection con = CConexao.getConexao(); PreparedStatement pst = con.prepareStatement("SELECT * FROM pacientes WHERE idPaciente = ?")) {

            pst.setInt(1, idPaciente);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    p = new Paciente();
                    p.setIdPaciente(rs.getInt("idPaciente"));
                    p.setSenha(rs.getString("senha"));
                    p.setNome(rs.getString("nome"));
                    p.setIdade(rs.getInt("idade"));
                    p.setCpf(rs.getString("cpf"));
                    p.setTelefone(rs.getString("telefone"));
                    p.setEmail(rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar paciente por ID: " + e.getMessage());
        }
        return p;
    }
}
