/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Model.Medico;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jader.costa
 */
public class HorarioDisponivel {

    private Date data;
    private String horario;
    private Medico medico;

    public HorarioDisponivel(Date data, String horario, Medico medico) {
        this.data = data;
        this.horario = horario;
        this.medico = medico;
    }

    // Getters e setters
    // toString() para exibir os horários disponíveis de forma legível
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(data);
        return "Data: " + dataFormatada + ", Horário: " + horario + ", Médico: " + medico.getNome();
    }
}
