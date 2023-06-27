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

    private int Agenda;
    private Date data;
    private String horario;
    private Paciente paciente;
    private Medico medico;
    private List<Consulta> consultasA;

    // Construtores, getters, setters e métodos adicionais...

    public Agenda() {
    }

    private List<Consulta> consultas;
    {
        consultas = new ArrayList<>();
    }

    public Agenda(int Agenda, Date data, String horario, Paciente paciente, Medico medico, List<Consulta> consultas) {
        this.Agenda = Agenda;
        this.data = data;
        this.horario = horario;
        this.paciente = paciente;
        this.medico = medico;
        this.consultas = consultas;
    }

    public int getAgenda() {
        return Agenda;
    }

    public void setAgenda(int Agenda) {
        this.Agenda = Agenda;
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

    @Override
    public String toString() {
        return "Agenda{" + "Agenda=" + Agenda + ", data=" + data + ", horario=" + horario + ", paciente=" + paciente + ", medico=" + medico + ", consultas=" + consultas + '}';
    }
    
}

    