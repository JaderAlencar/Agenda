/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Consulta;
import Model.Medico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jader.costa
 */
public class CAgenda {

    private List<Consulta> consultas;

    public CAgenda() {
        consultas = new ArrayList<>();
    }

    public void agendarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void cancelarConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

    public List<Consulta> listarConsultas() {
        return new ArrayList<>(consultas);
    }

    public List<Consulta> buscarConsultasPorMedico(String medico) {
        List<Consulta> consultasPorMedico = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().getNome().equals(medico)) {
                consultasPorMedico.add(consulta);
            }
        }
        return consultasPorMedico;
    }

    public List<Consulta> buscarConsultasPorPaciente(String paciente) {
        List<Consulta> consultasPorPaciente = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().getNome().equals(paciente)) {
                consultasPorPaciente.add(consulta);
            }
        }
        return consultasPorPaciente;
    }
}
