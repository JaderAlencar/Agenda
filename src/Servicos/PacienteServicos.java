/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import DAO.DAOFactory;
import DAO.PacienteDAO;
import Model.Medico;
import Model.Paciente;
import java.util.ArrayList;

/**
 * Classe responsável pelos serviços relacionados aos pacientes. Realiza
 * operações como cadastro, busca, atualização e exclusão de pacientes. Utiliza
 * a classe PacienteDAO para acessar os dados do paciente.
 */
public class PacienteServicos {

    private PacienteServicos pacienteServicos;
    private MedicoServicos medicoServicos;
    private PacienteDAO pacienteDAO;

    public PacienteServicos() {
        pacienteDAO = DAOFactory.getPacienteDAO();
    }

    public ArrayList<Paciente> listarPacientes() {
        try {
            return pacienteDAO.getPacientes();
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return new ArrayList<>();
        }
    }

    /**
     * Realiza o cadastro de um novo paciente.
     *
     * @param pVO O objeto Paciente a ser cadastrado.
     */
    public void cadastrarPaciente(Paciente pVO) {
        try {
            pacienteDAO.cadastrarPacienteDAO(pVO);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
        }
    }

    /**
     * Obtém um paciente com base no seu ID.
     *
     * @param idPaciente O ID do paciente a ser buscado.
     * @return O objeto Paciente correspondente ao ID informado.
     */
    public Paciente getPacientePorId(int idPaciente) {
        try {
            return pacienteDAO.getPacienteById(idPaciente);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return null;
        }
    }

    /**
     * Atualiza as informações de um paciente.
     *
     * @param pVO O objeto Paciente com as informações atualizadas.
     */
    public void atualizarPaciente(Paciente pVO) {
        try {
            pacienteDAO.atualizarPacienteDAO(pVO);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
        }
    }

    /**
     * Deleta um paciente com base no seu CPF.
     *
     * @param cpf O CPF do paciente a ser deletado.
     */
    public void deletarPaciente(String cpf) {
        try {
            pacienteDAO.deletarPacienteDAO(cpf);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
        }
    }

    /**
     * Obtém um paciente com base no seu CPF.
     *
     * @param cpf O CPF do paciente a ser buscado.
     * @return O objeto Paciente correspondente ao CPF informado.
     */
    public Paciente getPacientePorCPF(String cpf) {
        try {
            return pacienteDAO.getPacienteByDoc(cpf);
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return null;
        }
    }

    public void agendarPaciente(String cpf) {
        // Exemplo de uso do serviço de paciente
        Paciente paciente = pacienteServicos.getPacientePorCPF(cpf);
        if (paciente != null) {
            // Restante do código para agendar o paciente...
            // Exemplo: Agendar paciente com um médico específico
            Medico medico = medicoServicos.getMedicoById(1); // Exemplo: Obter médico com ID 1
            if (medico != null) {

                System.out.println("Consulta agendada com sucesso!");
            } else {
                System.out.println("Médico não encontrado.");
            }
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}
