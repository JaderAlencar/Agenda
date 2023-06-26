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
    private static PacienteServicos pacienteS = new PacienteServicos();
    private static MedicoServicos medicoS = new MedicoServicos();
    private static ConsultaServicos consultaS = new ConsultaServicos();
    private static AgendaServicos agendaS = new AgendaServicos();
    
    public static PacienteServicos PacienteServicos (){
        return pacienteS;
    }
    public static MedicoServicos MedicoServicos(){
        return medicoS;
    }
    public static ConsultaServicos getConsultaServicos(){
        return consultaS;
    }
    public static AgendaServicos getAgendaServicos (){
        return agendaS;
    }
    
}
