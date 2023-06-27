/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author jader.costa
 */
public class Consulta {

    private int idConsulta;
    private Date data;
    private String horario;
    private Paciente paciente;
    private Medico medico;
    private LocalDate dataConsulta;
    private LocalTime horarioConsulta;

    public Consulta() {
    }

    public Consulta(String data, String horario, Paciente paciente, Medico medico) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.data = dateFormat.parse(data);
        } catch (ParseException e) {
            // Tratar exceção ou propagar para o chamador do construtor
        }
        this.horario = horario;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Consulta(LocalDate dataConsulta, LocalTime horarioConsulta, Paciente paciente, Medico medico) {
    this.dataConsulta = dataConsulta;
    this.horarioConsulta = horarioConsulta;
    this.paciente = paciente;
    this.medico = medico;
}

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
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

    @Override
    public String toString() {
        return "Consulta{" + "idConsulta=" + idConsulta + ", data=" + data + ", horario=" + horario + ", paciente=" + paciente + ", medico=" + medico + '}';
    }

}
