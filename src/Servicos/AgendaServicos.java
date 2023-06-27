/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import DAO.AgendaDAO;
import DAO.DAOFactory;
import Model.Agenda;
import Model.Consulta;
import Model.Medico;
import Model.Paciente;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sistemaagendas.SistemaAgendas;

/**
 *
 * @author jader.costa
 */
public class AgendaServicos {

    private Scanner scanner = new Scanner(System.in);
    private AgendaDAO agendaDAO;

    public AgendaServicos() {
        agendaDAO = DAOFactory.getAgendaDAO();
    }

    public void cadastrarAgendaParaTodosMedicos() {
        List<Medico> medicos = SistemaAgendas.cadMedico.listarMedicos();

        LocalTime horarioInicio = LocalTime.of(8, 0);
        LocalTime horarioFim = LocalTime.of(18, 0);
        Duration intervaloConsulta = Duration.ofMinutes(30);

        LocalDate dataConsulta = LocalDate.now(); // Defina a data desejada para as consultas

        for (Medico medico : medicos) {
            Agenda agenda = new Agenda();
            agenda.setMedico(medico);

            LocalTime horarioAtual = horarioInicio;

            while (horarioAtual.isBefore(horarioFim)) {
                Consulta consulta = new Consulta(dataConsulta, horarioAtual, null, medico);
                agenda.getConsultas().add(consulta);

                horarioAtual = horarioAtual.plus(intervaloConsulta);
            }

            agendaDAO.cadastrarAgendaDAO(agenda); // Salvar a agenda no banco de dados
        }
    }
    

    public void agendarConsultas() {
        System.out.println("-- Agendamento de Consultas --");
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("CPF do Paciente: ");
        String cpf = scanner.nextLine();

        System.out.print("CRM do Médico: ");
        String crm = scanner.nextLine();

        Paciente paciente = SistemaAgendas.cadPaciente.getPacientePorCPF(cpf);
        Medico medico = SistemaAgendas.cadMedico.getMedicoByCRM(crm);

        if (paciente == null) {
            System.out.println("Paciente não encontrado. Verifique o CPF.");
        } else if (medico == null) {
            System.out.println("Médico não encontrado. Verifique o CRM.");
        } else {
            System.out.print("Quantidade de consultas a agendar: ");
            int quantidadeConsultas = scanner.nextInt();

            for (int i = 0; i < quantidadeConsultas; i++) {
                System.out.println("Agendamento da consulta " + (i + 1));

                LocalDate dataConsulta = LocalDate.now(); // Defina a data desejada para a consulta

                System.out.print("Horário da Consulta (hh:mm): ");
                String horarioInput = scanner.next();
                LocalTime horarioConsulta = LocalTime.parse(horarioInput);

                Consulta consulta = new Consulta(dataConsulta, horarioConsulta, paciente, medico);
                agendaDAO.agendarConsulta(consulta); // Salvar a consulta no banco de dados
            }
        }

        System.out.println();
    }

    public ArrayList<Agenda> listarConsultas() {
        try {
            return agendaDAO.listarAgendas();
        } catch (Exception e) {
            // Tratar exceção ou propagar para o chamador do método
            return new ArrayList<>();
        }
    }

    public boolean removerConsulta(String data, String horario) {
        // Implemente a remoção de uma consulta com base na data e horário
        return false;
    }

    public boolean agendarConsulta(Consulta consulta) {
        // Implemente o agendamento de uma consulta
        return false;
    }

}