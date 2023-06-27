/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

/**
 *
 * @author jader.costa
 */
public class ServicosFactory {
    private static PacienteServicos paciente = new PacienteServicos();
    private static MedicoServicos medico = new MedicoServicos();
    private static ConsultaServicos consulta = new ConsultaServicos();
    private static AgendaServicos agenda = new AgendaServicos();

    public static PacienteServicos getPacienteServicos() {
        return paciente;
    }

    public static MedicoServicos getMedicoServicos() {
        return medico;
    }

    public static ConsultaServicos getConsultaServicos() {
        return consulta;
    }

    public static AgendaServicos getAgendaServicos() {
        return agenda;
    }
}

