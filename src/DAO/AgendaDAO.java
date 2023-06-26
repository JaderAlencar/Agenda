/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.CConexao;
import Model.Agenda;
import Model.Consulta;
import Model.Medico;
import Model.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jader.costa
 */
public class AgendaDAO {
    
    

    public void cadastrarAgendaDAO(Agenda aVO) {
        try {
            Connection con = CConexao.getConexao();
            String sql = "INSERT INTO agendas VALUES (null, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setDate(1, new Date(aVO.getData().getTime()));
            pst.setString(2, aVO.getHorario());
            pst.setInt(3, aVO.getPaciente().getIdPaciente());
            pst.setInt(4, aVO.getMedico().getIdMedico());

            pst.executeUpdate();

            pst.close();
            con.close();

            System.out.println("Agenda cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar agenda: " + e.getMessage());
        }
    }

    public ArrayList<Agenda> listarAgendas() {
        ArrayList<Agenda> agendas = new ArrayList<>();
        try {
            Connection con = CConexao.getConexao();
            String sql = "SELECT * FROM agendas";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Agenda a = new Agenda();
                a.setIdAgenda(rs.getInt("idAgenda"));
                a.setData(rs.getDate("data"));
                a.setHorario(rs.getString("horario"));

                PacienteDAO pacienteDAO = new PacienteDAO();
                Paciente paciente = pacienteDAO.getPacienteById(rs.getInt("idPaciente"));
                a.setPaciente(paciente);

                MedicoDAO medicoDAO = new MedicoDAO();
                Medico medico = medicoDAO.getMedicoById(rs.getInt("idMedico"));
                a.setMedico(medico);

                agendas.add(a);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar agendas: " + e.getMessage());
        }
        return agendas;
    }

    public Agenda AgendaByDoc(int idAgenda) {
        Agenda a = new Agenda();
        try {
            Connection con = CConexao.getConexao();
            String sql = "SELECT * FROM agendas WHERE idAgenda = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idAgenda);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                a.setIdAgenda(rs.getInt("idAgenda"));
                a.setData(rs.getDate("data"));
                a.setHorario(rs.getString("horario"));

                PacienteDAO pacienteDAO = new PacienteDAO();
                Paciente paciente = pacienteDAO.getPacienteById(rs.getInt("idPaciente"));
                a.setPaciente(paciente);

                MedicoDAO medicoDAO = new MedicoDAO();
                Medico medico = medicoDAO.getMedicoById(rs.getInt("idMedico"));
                a.setMedico(medico);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar agenda por ID: " + e.getMessage());
        }
        return a;
    }

    public void atualizarAgendaDAO(Agenda aVO) {
        try {
            Connection con = CConexao.getConexao();
            String sql = "UPDATE agendas SET data = ?, horario = ?, idPaciente = ?, idMedico = ?"
                    + " WHERE idAgenda = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new Date(aVO.getData().getTime()));
            pst.setString(2, aVO.getHorario());
            pst.setInt(3, aVO.getPaciente().getIdPaciente());
            pst.setInt(4, aVO.getMedico().getIdMedico());
            pst.setInt(5, aVO.getIdAgenda());
            pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar agenda: " + e.getMessage());
        }
    }

    public void deletarAgendaDAO(int idAgenda) {
        try {
            Connection con = CConexao.getConexao();
            String sql = "DELETE FROM agendas WHERE idAgenda = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idAgenda);
            pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar agenda: " + e.getMessage());
        }
    }

    public ArrayList<Agenda> getAgendasPorMedico(int idMedico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Agenda> AgendasPorData(java.util.Date data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Agenda> AgendasPorMedico(int idMedico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean agendarConsulta(Consulta consulta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Consulta> listarConsultas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
