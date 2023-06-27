/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.CConexao;
import Model.Agenda;
import Model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jader.costa
 */
public class MedicoDAO {

    public void cadastrarMedicoDAO(Medico mVO) {
        try {
            Connection con = CConexao.getConexao();
            String sql = "INSERT INTO medicos VALUES (null, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, mVO.getSenha());
            pst.setString(2, mVO.getNome());
            pst.setString(3, mVO.getCrm());
            pst.setString(4, mVO.getEspecialidade());
            pst.setString(5, mVO.getTelefone());
            pst.setString(6, mVO.getEmail());

            pst.executeUpdate();

            pst.close();
            con.close();

            System.out.println("Médico cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar médico: " + e.getMessage());
        }
    }

    public ArrayList<Medico> getMedicos() {
        ArrayList<Medico> medicos = new ArrayList<>();
        try {
            Connection con = CConexao.getConexao();
            String sql = "SELECT * FROM medicos";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Medico m = new Medico();
                m.setIdMedico(rs.getInt("idMedico"));
                m.setNome(rs.getString("nome"));
                m.setEspecialidade(rs.getString("especialidade"));
                m.setCrm(rs.getString("crm"));
                m.setTelefone(rs.getString("telefone"));
                medicos.add(m);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar médicos: " + e.getMessage());
        }
        return medicos;
    }

    public Medico getMedicoById(int idMedico) {
        Medico m = new Medico();
        try {
            Connection con = CConexao.getConexao();
            String sql = "SELECT * FROM medicos WHERE idMedico = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idMedico);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                m.setIdMedico(rs.getInt("idMedico"));
                m.setNome(rs.getString("nome"));
                m.setEspecialidade(rs.getString("especialidade"));
                m.setCrm(rs.getString("crm"));
                m.setTelefone(rs.getString("telefone"));
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar médico por ID: " + e.getMessage());
        }
        return m;
    }

    public void atualizarMedicoDAO(Medico mVO) {
        try {
            Connection con = CConexao.getConexao();
            String sql = "UPDATE medicos SET nome = ?, especialidade = ?, telefone = ?"
                    + " WHERE crm = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, mVO.getNome());
            pst.setString(2, mVO.getEspecialidade());
            pst.setString(3, mVO.getTelefone());
            pst.setString(4, mVO.getCrm());
            pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar médico: " + e.getMessage());
        }
    }

    public void deletarMedicoDAO(String crm) {
        try {
            Connection con = CConexao.getConexao();
            String sql = "DELETE FROM medicos WHERE crm = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, crm);
            pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar médico: " + e.getMessage());
        }
    }

    public Medico getMedicoByCRM(String crm) throws SQLException {
        Medico medico = null;
        String query = "SELECT * FROM medicos WHERE crm = ?";
        try (Connection connection = CConexao.getConexao(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, crm);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    medico = extractMedicoFromResultSet(resultSet);
                }
            }
        }
        return medico;
    }

    public List<Medico> listarMedicos() throws SQLException {
        List<Medico> medicos = new ArrayList<>();
        String query = "SELECT * FROM medicos";
        try (Connection connection = CConexao.getConexao(); PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Medico medico = extractMedicoFromResultSet(resultSet);
                medicos.add(medico);
            }
        }
        return medicos;
    }

    private Medico extractMedicoFromResultSet(ResultSet resultSet) throws SQLException {
        Medico medico = new Medico();
        medico.setIdMedico(resultSet.getInt("idMedico"));
        medico.setNome(resultSet.getString("nome"));
        medico.setEspecialidade(resultSet.getString("especialidade"));
        medico.setCrm(resultSet.getString("crm"));
        medico.setTelefone(resultSet.getString("telefone"));
        medico.setEmail(resultSet.getString("email"));
        return medico;
    }

    public List<Agenda> getAgendas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
