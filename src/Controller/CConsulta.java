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
public class CConsulta {

    private List<Consulta> consultas;

    public CConsulta() {
        consultas = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void removerConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

    public List<Consulta> listarConsultas() {
        return consultas;
    }

    public List<Consulta> buscarConsultasPorPaciente(String paciente) {
        List<Consulta> consultasPorPaciente = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().equalsIgnoreCase(paciente)) {
                consultasPorPaciente.add(consulta);
            }
        }
        return consultasPorPaciente;
    }
}
