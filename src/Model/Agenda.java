/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jader.costa
 */
public class Agenda {

    private int idAgenda;
    private Date data;
    private String horario;
    private Paciente paciente;
    private Medico medico;
    private List<Consulta> consultas;

    // Construtores, getters, setters e métodos adicionais...
    public Agenda() {
    }

    public Agenda(Date data, String horario, Paciente paciente, Medico medico, List<Consulta> consultas) {

        this.data = data;
        this.horario = horario;
        this.paciente = paciente;
        this.medico = medico;
        this.consultas = consultas;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public boolean adicionarConsulta(Consulta consulta) {
        if (consultas == null) {
            consultas = new ArrayList<>();
        }
        return consultas.add(consulta);
    }

    @Override
    public String toString() {
        return "Agenda{" + "idAgenda=" + idAgenda + ", data=" + data + ", horario=" + horario + ", paciente=" + paciente + ", medico=" + medico + ", consultas=" + consultas + '}';
    }
}
