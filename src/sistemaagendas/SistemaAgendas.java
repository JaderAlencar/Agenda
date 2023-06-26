/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaagendas;

import Controller.CMedico;
import Controller.CPaciente;
import Model.Consulta;
import Model.Medico;
import Model.Paciente;
import Servicos.AgendaServicos;
import Servicos.MedicoServicos;
import Servicos.PacienteServicos;
import Servicos.ServicosFactory;
import Util.Validadores;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jader.costa
 */
public class SistemaAgendas {

    private static List<Paciente> pacientes;
    private static List<Medico> medicos;
    private static AgendaServicos agendaServicos;
    private static Scanner scanner;
    
    public static PacienteServicos cadPaciente = new PacienteServicos();
    public static MedicoServicos cadMedico = new MedicoServicos();
    
    
    



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        agendaServicos = ServicosFactory.getAgendaServicos();
        scanner = new Scanner(System.in);

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
                    agendarConsulta();
                    break;
                case 4:
                    listarConsultas();
                    break;
                case 5:
                    listarPacientes();
                    break;
                case 6:
                    listarMedicos();
                    break;
                case 0:
                    System.out.println("Obrigado por usar o sistema. Ate mais!");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("-- Sistema de Agendamento --");
        System.out.println("1 - Cadastrar Paciente");
        System.out.println("2 - Cadastrar Medico");
        System.out.println("3 - Agendar Consulta");
        System.out.println("4 - Listar Consultas");
        System.out.println("5 - Listar Pacientes");
        System.out.println("6 - Listar Medicos");
        System.out.println("0 - Sair");
        System.out.print("Digite a opcao desejada: ");
    }

    private static int lerOpcao() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Opcao invalida. Tente novamente.");
            scanner.nextLine(); // Limpar o buffer do scanner
            return lerOpcao();
        }
    }

    private static void cadastrarPaciente() {
        scanner.nextLine(); // Limpar o buffer do scanner
        PacienteServicos pacienteServicos = ServicosFactory.PacienteServicos();

        System.out.println("-- Cadastro de Paciente --");

        System.out.println("ID Paciente: ");
        int idPaciente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        String cpf;
        boolean cpfValido = false;
        boolean cpfCadastrado = false;
        do {
            System.out.println("CPF: ");
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

        System.out.println("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        Paciente paciente = new Paciente(idPaciente, senha, nome, idade, cpf, telefone, email);
        pacienteServicos.cadastrarPaciente(paciente);

        System.out.println("Paciente cadastrado com sucesso!");
        System.out.println();
    }

    private static void cadastrarMedico() {
        scanner.nextLine(); // Limpar o buffer do scanner
        MedicoServicos medicoServicos = ServicosFactory.MedicoServicos();

        System.out.println("-- Cadastro de Medico --");

        System.out.println("ID Medico: ");
        int idMedico = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("CRM: ");
        String crm = scanner.nextLine();

        System.out.println("Especialidade: ");
        String especialidade = scanner.nextLine();

        System.out.println("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        Medico medico = new Medico(idMedico, senha, nome, crm, especialidade, telefone, email);
        medicoServicos.cadastrarMedico(medico);

        System.out.println("Medico cadastrado com sucesso!");
        System.out.println();
    }

    private static void agendarConsulta() {
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("-- Agendamento de Consulta --");

        System.out.print("Data da Consulta (dd/mm/aaaa): ");
        String data = scanner.next();

        System.out.print("Horario da Consulta (hh:mm): ");
        String horario = scanner.next();

        System.out.print("CPF do Paciente: ");
        String cpf = scanner.next();

        System.out.print("CRM do Medico: ");
        String crm = scanner.next();

        Paciente paciente = cadPaciente.getPacientePorCPF(cpf);
        Medico medico = cadMedico.getMedicoByCRM(crm);

        if (paciente == null) {
            System.out.println("Paciente nao encontrado. Verifique o CPF.");
        } else if (medico == null) {
            System.out.println("Medico nao encontrado. Verifique o CRM.");
        } else {
            Consulta consulta = new Consulta(data, horario, paciente, medico);
            if (agendaServicos.agendarConsulta(consulta)) {
                System.out.println("Consulta agendada com sucesso!");
            } else {
                System.out.println("Horario indisponivel para agendamento.");
            }

        }

        System.out.println();
    }

    private static void listarConsultas() {
        System.out.println("-- Lista de Consultas --");
        List<Consulta> consultas = agendaServicos.listarConsultas();

        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
        } else {
            for (Consulta consulta : consultas) {
                System.out.println("Data: " + consulta.getData());
                System.out.println("Horario: " + consulta.getHorario());
                System.out.println("Paciente: " + consulta.getPaciente().getNome());
                System.out.println("Medico: " + consulta.getMedico().getNome());
                System.out.println("---------------------------");
            }
        }

        System.out.println();
    }

    private static void listarPacientes() {
    System.out.println("-- Lista de Pacientes --");

    PacienteServicos pacienteServicos = new PacienteServicos();
    ArrayList<Paciente> pacientes = pacienteServicos.listarPacientes();

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
        System.out.println("-- Lista de Medicos --");

        List<Medico> medicos = cadMedico.listarMedicos();

        if (medicos.isEmpty()) {
            System.out.println("Nenhum medico cadastrado.");
        } else {
            for (Medico medico : medicos) {
                System.out.println("ID Medico: " + medico.getIdMedico());
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

}
