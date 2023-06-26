/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import DAO.AgendaDAO;
import DAO.DAOFactory;
import Model.Agenda;
import Model.Consulta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jader.costa
 */
public class AgendaServicos {

    private AgendaDAO agendaDAO;

    public AgendaServicos() {
        agendaDAO = DAOFactory.AgendaDAO();
    }

    public void cadastrarAgenda(Agenda agenda) {
        try {
            agendaDAO.cadastrarAgendaDAO(agenda);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método

        }
    }

    public ArrayList<Agenda> listarAgendas() {
        try {
            return agendaDAO.listarAgendas();
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método

            return new ArrayList<>();
        }
    }

    public Agenda AgendaByDoc(int idAgenda) {
        try {
            return agendaDAO.AgendaByDoc(idAgenda);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
 
            return null;
        }
    }

    public void atualizarAgenda(Agenda agenda) {
        try {
            agendaDAO.atualizarAgendaDAO(agenda);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método

        }
    }

    public void deletarAgenda(int idAgenda) {
        try {
            agendaDAO.deletarAgendaDAO(idAgenda);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
 
        }
    }

    public ArrayList<Agenda> AgendasPorMedico(int idMedico) {
        try {
            return agendaDAO.AgendasPorMedico(idMedico);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método

            return new ArrayList<>();
        }
    }

    public ArrayList<Agenda> AgendasPorData(Date data) {
        try {
            return agendaDAO.AgendasPorData(data);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
 
            return new ArrayList<>();
        }
    }

    public boolean agendarConsulta(Consulta consulta) {
        try {
            return agendaDAO.agendarConsulta(consulta);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método

            return false;
        }
    }

    public List<Consulta> listarConsultas() {
        try {
            return agendaDAO.listarConsultas();
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método

            return new ArrayList<>();
        }
    }
    
}

