/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import DAO.DAOFactory;
import DAO.MedicoDAO;
import Model.Medico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jader.costa
 */

public class MedicoServicos {

    /**
     * Realiza o cadastro de um novo médico.
     *
     * @param mVO O objeto Medico a ser cadastrado.
     */
    public void cadastrarMedico(Medico mVO) {
        try {
            MedicoDAO mDAO = DAOFactory.getMedicoDAO();
            mDAO.cadastrarMedicoDAO(mVO);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
        }
    }

    /**
     * Obtém a lista de todos os médicos cadastrados.
     *
     * @return A lista de médicos.
     */
    public ArrayList<Medico> getMedicos() {
        try {
            MedicoDAO mDAO = DAOFactory.getMedicoDAO();
            return mDAO.getMedicos();
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return new ArrayList<>();
        }
    }

    /**
     * Obtém um médico com base no seu ID.
     *
     * @param idMedico O ID do médico a ser buscado.
     * @return O objeto Medico correspondente ao ID informado.
     */
    public Medico getMedicoById(int idMedico) {
        try {
            MedicoDAO mDAO = DAOFactory.getMedicoDAO();
            return mDAO.getMedicoById(idMedico);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return null;
        }
    }

    /**
     * Atualiza as informações de um médico.
     *
     * @param mVO O objeto Medico com as informações atualizadas.
     */
    public void atualizarMedico(Medico mVO) {
        try {
            MedicoDAO mDAO = DAOFactory.getMedicoDAO();
            mDAO.atualizarMedicoDAO(mVO);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
        }
    }

    /**
     * Deleta um médico com base no seu CRM.
     *
     * @param crm O CRM do médico a ser deletado.
     */
    public void deletarMedico(String crm) {
        try {
            MedicoDAO mDAO = DAOFactory.getMedicoDAO();
            mDAO.deletarMedicoDAO(crm);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
        }
    }

    public Medico getMedicoByCRM(String crm) {
        try {
            MedicoDAO mDAO = DAOFactory.getMedicoDAO();
            return mDAO.getMedicoByCRM(crm);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return null;
        }
    }

    public List<Medico> listarMedicos() {
        try {
            MedicoDAO mDAO = DAOFactory.getMedicoDAO();
            return mDAO.listarMedicos();
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return new ArrayList<>();
        }
    }
}
