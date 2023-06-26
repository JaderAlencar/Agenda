/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jader.costa
 */
public class CPaciente {

    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private int idPaciente = 1;

    public int gerarId() {
        return idPaciente++;
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void removerPaciente(Paciente paciente) {
        pacientes.remove(paciente);
    }

    public ArrayList<Paciente> getPacientes() {
        return new ArrayList<>(pacientes);
    }

    public Paciente getPacientePorCPF(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    public void editarPaciente(String cpf, Paciente novoPaciente) {
        Paciente pacienteExistente = getPacientePorCPF(cpf);
        if (pacienteExistente != null) {
            int index = pacientes.indexOf(pacienteExistente);
            pacientes.set(index, novoPaciente);
        }
    }

    public void atualizarPaciente(String cpf, String novoNome, String novoTelefone) {
        Paciente pacienteExistente = getPacientePorCPF(cpf);
        if (pacienteExistente != null) {
            pacienteExistente.setNome(novoNome);
            pacienteExistente.setTelefone(novoTelefone);
        }
    }
}
