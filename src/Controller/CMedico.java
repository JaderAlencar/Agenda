/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Medico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jader.costa
 */
public class CMedico {

    ArrayList<Medico> medicos = new ArrayList();
    int idMedico = 1;

    public int geraID() {
        return this.idMedico++;

    }

    public void addMedico(Medico m) {
        this.medicos.add(m);
    }

    public void removeMedico(Medico med) {
        this.medicos.remove(med);
    }

    public ArrayList<Medico> listarMedicos() {
        return this.medicos;
    }

    public Medico MedicoCRM(String CRM) {
        Medico m = null;
        for (Medico med : medicos) {
            if (med.getCrm().equals(CRM)) {
                m = med;
                break;
            }
        }

        return m;

    }
}


