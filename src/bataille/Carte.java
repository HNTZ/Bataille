/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataille;

/**
 *
 * @author Lucas
 */
public class Carte {
    
    public static String[] couleurs = new String[] {"Coeur", "Trefle", "Pique", "Carreau"};
    public static int[] valeurs = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13};
    
    private String couleur;
    private int valeur;
    
    public Carte(int valeur, String couleur) {
        this.valeur = valeur;  
        this.couleur = couleur;
    }
    
    public int getValeur() {
        return this.valeur;
    }
    
    public String getCouleur() {
        return this.couleur;
    }
    
    public String toString() {
        String valeur;
        
        switch(this.valeur) {
            case(1) : valeur = "As"; break;
            case(11) : valeur = "Valet"; break;
            case(12) : valeur = "Dame"; break;
            case(13) : valeur = "Roi"; break;
            default : valeur = Integer.toString(this.valeur);
        }
        
        return valeur + " de " + this.couleur;
    }
    
    public int comparateur(Carte carte) {
        if (this.valeur == carte.getValeur()) {
            return 1;
        }
        else if (this.valeur == 1) {
            return 2;
        }
        else if (carte.getValeur() == 1) {
            return 0;
        }
        else if (this.valeur > carte.getValeur()) {
            return 2;
        }
        else {
            return 0;
        }
    }
}
