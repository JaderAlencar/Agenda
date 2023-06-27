/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.CConexao;
import Model.Consulta;
import Model.Medico;
import Model.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jader.costa
 */
public class ConsultaDAO {

    public void cadastrarConsultaDAO(Consulta cVO) {
        try {
            Connection con = CConexao.getConexao();
            String sql = "INSERT INTO consultas (data, horario, idPaciente, idMedico) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setDate(1, new Date(cVO.getData().getTime()));
            pst.setString(2, cVO.getHorario());
            pst.setInt(3, cVO.getPaciente().getIdPaciente());
            pst.setInt(4, cVO.getMedico().getIdMedico());

            pst.executeUpdate();

            pst.close();
            con.close();

            System.out.println("Consulta cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar consulta: " + e.getMessage());
        }
    }

    public ArrayList<Consulta> listarConsultas(int idMedico) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        try {
            Connection con = CConexao.getConexao();
            String sql = "SELECT * FROM consultas";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Consulta c = new Consulta();
                c.setIdConsulta(rs.getInt("idConsulta"));
                c.setData(rs.getDate("data"));
                c.setHorario(rs.getString("horario"));

                PacienteDAO pacienteDAO = new PacienteDAO();
                Paciente paciente = pacienteDAO.getPacienteById(rs.getInt("idPaciente"));
                c.setPaciente(paciente);

                MedicoDAO medicoDAO = new MedicoDAO();
                Medico medico = medicoDAO.getMedicoById(rs.getInt("idMedico"));
                c.setMedico(medico);

                consultas.add(c);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar consultas: " + e.getMessage());
        }
        return consultas;
    }

    public Consulta getConsultaById(int idConsulta) {
        Consulta c = new Consulta();
        try {
            Connection con = CConexao.getConexao();
            String sql = "SELECT * FROM consultas WHERE idConsulta = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idConsulta);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                c.setIdConsulta(rs.getInt("idConsulta"));
                c.setData(rs.getDate("data"));
                c.setHorario(rs.getString("horario"));

                PacienteDAO pacienteDAO = new PacienteDAO();
                Paciente paciente = pacienteDAO.getPacienteById(rs.getInt("idPaciente"));
                c.setPaciente(paciente);

                MedicoDAO medicoDAO = new MedicoDAO();
                Medico medico = medicoDAO.getMedicoById(rs.getInt("idMedico"));
                c.setMedico(medico);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar consulta por ID: " + e.getMessage());
        }
        return c;
    }

    public void atualizarConsultaDAO(Consulta cVO) {
        try {
            Connection con = CConexao.getConexao();
            String sql = "UPDATE consultas SET data = ?, horario = ?, idPaciente = ?, idMedico = ? WHERE idConsulta = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new Date(cVO.getData().getTime()));
            pst.setString(2, cVO.getHorario());
            pst.setInt(3, cVO.getPaciente().getIdPaciente());
            pst.setInt(4, cVO.getMedico().getIdMedico());
            pst.setInt(5, cVO.getIdConsulta());
            pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar consulta: " + e.getMessage());
        }
    }

    public void deletarConsultaDAO(int idConsulta) {
        try {
            Connection con = CConexao.getConexao();
            String sql = "DELETE FROM consultas WHERE idConsulta = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idConsulta);
            pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar consulta: " + e.getMessage());
        }
    }

    public void agendarConsultaDAO(Consulta cVO) {
        try {
            Connection con = CConexao.getConexao();
            String sql = "INSERT INTO consultas (data, horario, idPaciente, idMedico) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setDate(1, new Date(cVO.getData().getTime()));
            pst.setString(2, cVO.getHorario());
            pst.setInt(3, cVO.getPaciente().getIdPaciente());
            pst.setInt(4, cVO.getMedico().getIdMedico());

            pst.executeUpdate();

            pst.close();
            con.close();

            System.out.println("Consulta agendada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao agendar consulta: " + e.getMessage());
        }
    }

    public ArrayList<Consulta> getConsultasPorData(java.util.Date data) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        try {
            Connection con = CConexao.getConexao();
            String sql = "SELECT * FROM consultas WHERE data = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new Date(data.getTime()));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Consulta c = new Consulta();
                c.setIdConsulta(rs.getInt("idConsulta"));
                c.setData(rs.getDate("data"));
                c.setHorario(rs.getString("horario"));

                PacienteDAO pacienteDAO = new PacienteDAO();
                Paciente paciente = pacienteDAO.getPacienteById(rs.getInt("idPaciente"));
                c.setPaciente(paciente);

                MedicoDAO medicoDAO = new MedicoDAO();
                Medico medico = medicoDAO.getMedicoById(rs.getInt("idMedico"));
                c.setMedico(medico);

                consultas.add(c);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar consultas por data: " + e.getMessage());
        }
        return consultas;
    }

    public ArrayList<Consulta> getConsultasPorPaciente(int idPaciente) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        try {
            Connection con = CConexao.getConexao();
            String sql = "SELECT * FROM consultas WHERE idPaciente = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idPaciente);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Consulta c = new Consulta();
                c.setIdConsulta(rs.getInt("idConsulta"));
                c.setData(rs.getDate("data"));
                c.setHorario(rs.getString("horario"));

                PacienteDAO pacienteDAO = new PacienteDAO();
                Paciente paciente = pacienteDAO.getPacienteById(rs.getInt("idPaciente"));
                c.setPaciente(paciente);

                MedicoDAO medicoDAO = new MedicoDAO();
                Medico medico = medicoDAO.getMedicoById(rs.getInt("idMedico"));
                c.setMedico(medico);

                consultas.add(c);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar consultas por paciente: " + e.getMessage());
        }
        return consultas;
    }

    public ArrayList<Consulta> getConsultas() {
        ArrayList<Consulta> consultas = new ArrayList<>();
        try {
            Connection con = CConexao.getConexao();
            String sql = "SELECT * FROM consultas";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Consulta c = new Consulta();
                c.setIdConsulta(rs.getInt("idConsulta"));
                c.setData(rs.getDate("data"));
                c.setHorario(rs.getString("horario"));

                PacienteDAO pacienteDAO = new PacienteDAO();
                Paciente paciente = pacienteDAO.getPacienteById(rs.getInt("idPaciente"));
                c.setPaciente(paciente);

                MedicoDAO medicoDAO = new MedicoDAO();
                Medico medico = medicoDAO.getMedicoById(rs.getInt("idMedico"));
                c.setMedico(medico);

                consultas.add(c);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar consultas: " + e.getMessage());
        }
        return consultas;
    }

    public ArrayList<Consulta> Consultas(int idPaciente) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        try {
            Connection con = CConexao.getConexao();
            String sql = "SELECT * FROM consultas WHERE idPaciente = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idPaciente);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Consulta c = new Consulta();
                c.setIdConsulta(rs.getInt("idConsulta"));
                c.setData(rs.getDate("data"));
                c.setHorario(rs.getString("horario"));

                PacienteDAO pacienteDAO = new PacienteDAO();
                Paciente paciente = pacienteDAO.getPacienteById(rs.getInt("idPaciente"));
                c.setPaciente(paciente);

                MedicoDAO medicoDAO = new MedicoDAO();
                Medico medico = medicoDAO.getMedicoById(rs.getInt("idMedico"));
                c.setMedico(medico);

                consultas.add(c);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar consultas por paciente: " + e.getMessage());
        }
        return consultas;
    }

    public Consulta ConsultaByDoc(int idConsulta) {
        Consulta c = new Consulta();
        try {
            Connection con = CConexao.getConexao();
            String sql = "SELECT * FROM consultas WHERE idConsulta = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idConsulta);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                c.setIdConsulta(rs.getInt("idConsulta"));
                c.setData(rs.getDate("data"));
                c.setHorario(rs.getString("horario"));

                PacienteDAO pacienteDAO = new PacienteDAO();
                Paciente paciente = pacienteDAO.getPacienteById(rs.getInt("idPaciente"));
                c.setPaciente(paciente);

                MedicoDAO medicoDAO = new MedicoDAO();
                Medico medico = medicoDAO.getMedicoById(rs.getInt("idMedico"));
                c.setMedico(medico);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar consulta por ID: " + e.getMessage());
        }
        return c;
    }

    public ArrayList<Consulta> Consulta(Consulta ConsultaByDoc) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        try {
            Connection con = CConexao.getConexao();
            String sql = "SELECT * FROM consultas WHERE idMedico = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, ConsultaByDoc.getMedico().getIdMedico());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Consulta c = new Consulta();
                c.setIdConsulta(rs.getInt("idConsulta"));
                c.setData(rs.getDate("data"));
                c.setHorario(rs.getString("horario"));

                PacienteDAO pacienteDAO = new PacienteDAO();
                Paciente paciente = pacienteDAO.getPacienteById(rs.getInt("idPaciente"));
                c.setPaciente(paciente);

                MedicoDAO medicoDAO = new MedicoDAO();
                Medico medico = medicoDAO.getMedicoById(rs.getInt("idMedico"));
                c.setMedico(medico);

                consultas.add(c);
            }
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar consultas por médico: " + e.getMessage());
        }
        return consultas;
    }
}
