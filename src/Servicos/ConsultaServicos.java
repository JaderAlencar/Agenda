/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import DAO.ConsultaDAO;
import DAO.DAOFactory;
import Model.Consulta;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jader.costa
 */
public class ConsultaServicos {

    /**
     * Realiza o agendamento de uma nova consulta.
     *
     * @param cVO O objeto Consulta a ser agendado.
     */
    public void agendarConsulta(Consulta cVO) {
        try {
            ConsultaDAO cDAO = DAOFactory.ConsultaDAO();
            cDAO.agendarConsultaDAO(cVO);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
        }
    }

    /**
     * Obtém a lista de todas as consultas agendadas.
     *
     * @return A lista de consultas agendadas.
     */
   public ArrayList<Consulta> Consultas() {
        try {
            ConsultaDAO cDAO = DAOFactory.ConsultaDAO();
            return cDAO.Consulta(ConsultaByDoc(1));
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return new ArrayList<>();
        }
    }

    /**
     * Obtém uma consulta com base no seu ID.
     *
     * @param idConsulta O ID da consulta a ser buscada.
     * @return O objeto Consulta correspondente ao ID informado.
     */
    public Consulta ConsultaByDoc(int idConsulta) {
        try {
            ConsultaDAO cDAO = DAOFactory.ConsultaDAO();
            return cDAO.ConsultaByDoc(idConsulta);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return null;
        }
    }

    /**
     * Atualiza as informações de uma consulta.
     *
     * @param cVO O objeto Consulta com as informações atualizadas.
     */
    public void atualizarConsulta(Consulta cVO) {
        try {
            ConsultaDAO cDAO = DAOFactory.ConsultaDAO();
            cDAO.atualizarConsultaDAO(cVO);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
        }
    }

    /**
     * Deleta uma consulta com base no seu ID.
     *
     * @param idConsulta O ID da consulta a ser deletada.
     */
    public void deletarConsulta(int idConsulta) {
        try {
            ConsultaDAO cDAO = DAOFactory.ConsultaDAO();
            cDAO.deletarConsultaDAO(idConsulta);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
        }
    }

    /**
     * Busca as consultas agendadas para um médico específico.
     *
     * @param idMedico O ID do médico.
     * @return A lista de consultas agendadas para o médico.
     */
    public ArrayList<Consulta> ConsultasPorMedico(int idMedico) {
        try {
            ConsultaDAO cDAO = DAOFactory.ConsultaDAO();
            return cDAO.listarConsultas(idMedico);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return new ArrayList<>();
        }
    }

    /**
     * Busca as consultas agendadas para um paciente específico.
     *
     * @param idPaciente O ID do paciente.
     * @return A lista de consultas agendadas para o paciente.
     */
    public ArrayList<Consulta> ConsultasPorPaciente(int idPaciente) {
        try {
            ConsultaDAO cDAO = DAOFactory.ConsultaDAO();
            return cDAO.Consultas(idPaciente);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return new ArrayList<>();
        }
    }

    /**
     * Busca as consultas agendadas em uma data específica.
     *
     * @param data A data das consultas a serem buscadas.
     * @return A lista de consultas agendadas para a data especificada.
     */
    public ArrayList<Consulta> ConsultasPorData(Date data) {
        try {
            ConsultaDAO cDAO = DAOFactory.ConsultaDAO();
            return cDAO.getConsultasPorData(data);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return new ArrayList<>();
        }
    }
}
