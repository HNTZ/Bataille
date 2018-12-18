/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataille;

import java.util.ArrayDeque;

/**
 *
 * @author Lucas
 */
public class Joueur {
    private ArrayDeque<Carte> paquet;
    private int points;
    
    public Joueur() {
        this.paquet = new ArrayDeque<Carte>(26);
        this.points = 0;
    }
    
    public void ajouteCarte(Carte carte) {
        this.paquet.addLast(carte);
    }
    
    public Carte tirerCarte() {
        return this.paquet.pollFirst();
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public void win() {
        this.points++;
    }
    
    public int getNbCartes() {
        return this.paquet.size();
    }
    
    public ArrayDeque<Carte> getCartes() {
        return this.paquet;
    }
}
