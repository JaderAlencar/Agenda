/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaagendas;

import Model.Consulta;
import Model.Medico;
import Model.Paciente;
import Servicos.MedicoServicos;
import Servicos.PacienteServicos;
import Servicos.ServicosFactory;
import Util.Validadores;
import Servicos.AgendaServicos;
import Servicos.ConsultaServicos;

/**
 *
 * @author jader.costa
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaAgendas {

    private static List<Paciente> pacientes;
    private static List<Medico> medicos;
    private static AgendaServicos agendaServicos;
    private static Scanner scanner;

    public static PacienteServicos cadPaciente = new PacienteServicos();
    public static MedicoServicos cadMedico = new MedicoServicos();

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        SistemaAgendas sistema = new SistemaAgendas();
        

        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        agendaServicos = ServicosFactory.getAgendaServicos();

        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerOpcao();
            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;

                case 2:
                    cadastrarMedico();
                    break;

                case 3:
                    cadastrarAgenda();
                    break;

                case 4:
                    agendarConsulta();
                    break;

                case 5:
                    listarConsultas();
                    break;

                case 6:
                    listarPacientes();
                    break;

                case 7:
                    listarMedicos();
                    break;

                case 8:
                    removerMedico();
                    break;
                case 9:
                    removerConsulta();
                    break;

                case 0:
                    System.out.println("Obrigado por usar o sistema. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("-- Sistema de Agendamento --");
        System.out.println("1 - Cadastrar Paciente");
        System.out.println("2 - Cadastrar Medico");
        System.out.println("3 - Cadastrar Agenda");
        System.out.println("4 - Agendar Consulta");
        System.out.println("5 - Listar Consultas");
        System.out.println("6 - Listar Pacientes");
        System.out.println("7 - Listar Medicos");
        System.out.println("8 - Remover Medico");
        System.out.println("9 - Remover Consulta");
        System.out.println("0 - Sair");
        System.out.print("Digite a opção desejada: ");
    }

    private static int lerOpcao() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Opção inválida. Tente novamente.");
            scanner.nextLine(); // Limpar o buffer do scanner
            return lerOpcao();
        }
    }

    private static void cadastrarPaciente() {
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("-- Cadastro de Paciente --");

        System.out.print("ID Paciente: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        String cpf;
        boolean cpfValido = false;
        boolean cpfCadastrado = false;
        do {
            System.out.print("CPF: ");
            cpf = scanner.nextLine();
            cpfValido = Validadores.isCPF(cpf);

            if (!cpfValido) {
                System.out.println("CPF inválido! Por favor, informe um CPF válido.");
            } else {
                cpfCadastrado = cadPaciente.getPacientePorCPF(cpf) != null;
                if (cpfCadastrado) {
                    System.out.println("CPF já cadastrado! Por favor, informe um CPF diferente.");
                }
            }
        } while (!cpfValido || cpfCadastrado);

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Paciente paciente = new Paciente(idPaciente, senha, nome, idade, cpf, telefone, email);
        cadPaciente.cadastrarPaciente(paciente);

        System.out.println("Paciente cadastrado com sucesso!");
        System.out.println();
    }

    private static void cadastrarMedico() {
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("-- Cadastro de Medico --");

        System.out.print("ID Medico: ");
        int idMedico = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CRM: ");
        String crm = scanner.nextLine();

        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Medico medico = new Medico(idMedico, senha, nome, crm, especialidade, telefone, email);
        cadMedico.cadastrarMedico(medico);

        System.out.println("Medico cadastrado com sucesso!");
        System.out.println();
    }

    public static void cadastrarAgenda() {
        if (agendaServicos == null) {
            agendaServicos = ServicosFactory.getAgendaServicos();
        }
        agendaServicos.cadastrarAgendaParaTodosMedicos();
        System.out.println("Agenda cadastrada com sucesso!");
    }

    

    private static void listarConsultas() {
        System.out.println("-- Lista de Consultas --");
        agendaServicos.listarConsultas();
    }

    private static void listarPacientes() {
        System.out.println("-- Lista de Pacientes --");

        List<Paciente> pacientes = cadPaciente.listarPacientes();

        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            for (Paciente paciente : pacientes) {
                System.out.println("ID Paciente: " + paciente.getIdPaciente());
                System.out.println("Senha: " + paciente.getSenha());
                System.out.println("Nome: " + paciente.getNome());
                System.out.println("Idade: " + paciente.getIdade());
                System.out.println("CPF: " + paciente.getCpf());
                System.out.println("Telefone: " + paciente.getTelefone());
                System.out.println("Email: " + paciente.getEmail());
                System.out.println("---------------------------");
            }
        }

        System.out.println();
    }

    private static void listarMedicos() {
        System.out.println("-- Lista de Médicos --");

        List<Medico> medicos = cadMedico.listarMedicos();

        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
        } else {
            for (Medico medico : medicos) {
                System.out.println("ID Médico: " + medico.getIdMedico());
                System.out.println("Senha: " + medico.getSenha());
                System.out.println("Nome: " + medico.getNome());
                System.out.println("CRM: " + medico.getCrm());
                System.out.println("Especialidade: " + medico.getEspecialidade());
                System.out.println("Telefone: " + medico.getTelefone());
                System.out.println("Email: " + medico.getEmail());
                System.out.println("---------------------------");
            }
        }

        System.out.println();
    }

    private static void removerMedico() {
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("-- Remover Médico --");
        System.out.print("CRM do Médico: ");
        String crm = scanner.nextLine();

        if (cadMedico.removerMedico(crm)) {
            System.out.println("Médico removido com sucesso!");
        } else {
            System.out.println("Médico não encontrado. Verifique o CRM.");
        }

        System.out.println();
    }

    private static void removerConsulta() {
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("-- Remover Consulta --");
        System.out.print("Data da Consulta (dd/mm/aaaa): ");
        String data = scanner.nextLine();
        System.out.print("Horário da Consulta (hh:mm): ");
        String horario = scanner.nextLine();

        if (agendaServicos.removerConsulta(data, horario)) {
            System.out.println("Consulta removida com sucesso!");
        } else {
            System.out.println("Consulta não encontrada. Verifique a data e horário.");
        }

        System.out.println();
    }

    private static void agendarConsulta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
