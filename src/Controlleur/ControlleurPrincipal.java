/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlleur;

import Controlleur.*;
import Vue.VueListeCritique;
import Vue.VueConnexion;
import javax.swing.JOptionPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Victor
 */
public class ControlleurPrincipal {

    private ControlleurConnexion CtrlConnexion;
    private ControlleurListeCritique CrtlCritique;
    private ControlleurDate CrtlControlleurDate;
    private EntityManager em;
    
    //instanciation
    //accesseur et mutateurs
    public ControlleurConnexion getCtrlConnexion() {
        return CtrlConnexion;
    }

    public void setCtrlConnexion(ControlleurConnexion CtrlConnexion) {
        this.CtrlConnexion = CtrlConnexion;
    }

    public void setCrtlControlleurDate(ControlleurDate CrtlControlleurDate) {
        this.CrtlControlleurDate = CrtlControlleurDate;
    }

    public ControlleurDate getCrtlControlleurDate() {
        return CrtlControlleurDate;
    }
    
    

    public ControlleurListeCritique getCrtlCritique() {
        return CrtlCritique;
    }

    public void setCrtlCritique(ControlleurListeCritique CrtlCritique) {
        this.CrtlCritique = CrtlCritique;
    }

    //methodes Customs
    public void AfficheVueCritique() {
        this.CtrlConnexion.getVue().setVisible(false);
        this.CrtlCritique.getVue().setVisible(true);
        this.CrtlCritique.getVue().getModelCritique();

    }

    public void afficherVueConnection() {
        this.CrtlCritique.getVue().setVisible(false);
        this.CtrlConnexion.getVue().setVisible(true);

    }

    public void quitterVueCommentaire() {
        int rep = JOptionPane.showConfirmDialog(null, "Vous allez être deconnecté \nEtes-vous sûr(e) ? ", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            afficherVueConnection();
            EntityTransaction tx = em.getTransaction();
            tx.commit();
        }

    }

    public void quitterApp() {
        int rep = JOptionPane.showConfirmDialog(null, "Quitez l'application ? \nEtes-vous sûr(e) ? ", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            System.exit(0);
            EntityTransaction tx = em.getTransaction();
            tx.commit();
        }
    }
    
    public void AfficheVueDate() {
      
        this.CtrlConnexion.getVue().setVisible(false);
        this.CrtlCritique.getVue().setVisible(true);
        this.CrtlCritique.getVue().getModelCritique();
        this.CrtlControlleurDate.getVue().setVisible(true);

    }
    
    public void cachéVueDate() {
      
        this.CtrlConnexion.getVue().setVisible(false);
        this.CrtlCritique.getVue().setVisible(true);
        this.CrtlCritique.getVue().getModelCritique();
        this.CrtlControlleurDate.getVue().setVisible(false);

    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
