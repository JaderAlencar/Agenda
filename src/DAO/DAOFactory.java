/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author jader.costa
 */
public class DAOFactory {

    private static PacienteDAO pDAO = new PacienteDAO();
    private static MedicoDAO mDAO = new MedicoDAO();
    public static ConsultaDAO cDAO = new ConsultaDAO();
    public static AgendaDAO aDAO = new AgendaDAO();

    public static PacienteDAO getPacienteDAO() {
        return pDAO;
    }

    public static MedicoDAO getMedicoDAO() {
        return mDAO;

    }

    public static ConsultaDAO ConsultaDAO() {
        return cDAO;
    }

    public static AgendaDAO AgendaDAO() {
        return aDAO;
    }

}
