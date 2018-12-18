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
public class Bataille {

    /**
     * @param args the command line arguments
     */
    
    
        
    public static void main(String[] args) {
        
        // On cree les deux joueurs

        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();
        
        // On initialise un paquet de 52 cartes
        
        Carte[] paquet = new Carte[52];
        
        for (int i = 0; i < Carte.couleurs.length; i++) {
            for (int j = 0; j < Carte.valeurs.length; j++) {
                Carte carte = new Carte(Carte.valeurs[j], Carte.couleurs[i]);
                paquet[i * 13 + j ] = carte;
            }
        }
        
        // On melange ce paquet
        
        for (int i = 0; i < paquet.length; i++) {
            int j = i + (int)(Math.random() * (paquet.length - i));
            Carte temp = paquet[j];
            paquet[j] = paquet[i];
            paquet[i] = temp;
        }
        
        // On distribue les cartes aux deux joueurs
        
        for (int i = 0; i < paquet.length; i+=2) {
            joueur1.ajouteCarte(paquet[i]);
            joueur2.ajouteCarte(paquet[i+1]);
        }
        
        // On commence la partie !
        
        while(joueur1.getNbCartes() != 0 && joueur2.getNbCartes() != 0) {
            
            // Chaque joueur tire une carte du haut de sa pile
            
            Carte carte1 = joueur1.tirerCarte();
            System.out.println("Le joueur 1 a tiré un " + carte1);
            Carte carte2 = joueur2.tirerCarte();
            System.out.println("Le joueur 2 a tiré un " + carte2);
            
            System.out.println();
            // S'il y a egalite et que les deux joueurs ont plus de deux cartes, il y a BATAILLE
            
            if (carte1.comparateur(carte2) == 1) {
                
                System.out.println("Il y a donc egalite");
                
                if(joueur1.getNbCartes() >= 2 && joueur2.getNbCartes() >= 2) {
                    
                    System.out.println("BATAILLE !");
                    
                    // Les deux joueurs tirent une carte et la pose face cachee, puis en tirent une autre et la comparent
                    
                    Carte carte3 = joueur1.tirerCarte();
                    Carte carte4 = joueur1.tirerCarte();
                    
                    Carte carte5 = joueur2.tirerCarte();
                    Carte carte6 = joueur2.tirerCarte();
                    
                    System.out.println(carte4 + " contre " + carte6);

                    if(carte4.comparateur(carte6) == 2) {
                        
                        System.out.println("Victoire du joueur 1 !");
                        
                        // Le joueur 1 gagne !
                        joueur1.ajouteCarte(carte1);
                        joueur1.ajouteCarte(carte2);
                        joueur1.ajouteCarte(carte3);
                        joueur1.ajouteCarte(carte4);
                        joueur1.ajouteCarte(carte5);
                        joueur1.ajouteCarte(carte6);
                        joueur1.win();
                    }
                    else if(carte4.comparateur(carte6) == 0) {
                        
                        System.out.println("Victoire du joueur 2 !");
                        
                        // Le joueur 2 gagne !
                        joueur2.ajouteCarte(carte5);
                        joueur2.ajouteCarte(carte6);
                        joueur2.ajouteCarte(carte1);
                        joueur2.ajouteCarte(carte2);
                        joueur2.ajouteCarte(carte3);
                        joueur2.ajouteCarte(carte4);
                        joueur2.win();
                    }
                    else {
                        // Il y a a nouveau egalite, une nouvelle carte et tiree puis comparee
                        
                        Carte carte7 = joueur1.tirerCarte();
                        Carte carte8 = joueur2.tirerCarte();
                        
                        System.out.println("Egalite, " + carte7 + " contre " + carte8);
                        
                        if (carte7.comparateur(carte8) == 2) {
                            System.out.println("Victoire du joueur 1 !");
                            
                            joueur1.ajouteCarte(carte1);
                            joueur1.ajouteCarte(carte2);
                            joueur1.ajouteCarte(carte3);
                            joueur1.ajouteCarte(carte4);
                            joueur1.ajouteCarte(carte5);
                            joueur1.ajouteCarte(carte6);
                            joueur1.ajouteCarte(carte7);
                            joueur1.ajouteCarte(carte8);
                            joueur1.win();
                        }
                        else {
                            System.out.println("Victoire du joueur 2 !");
                            
                            joueur2.ajouteCarte(carte1);
                            joueur2.ajouteCarte(carte2);
                            joueur2.ajouteCarte(carte3);
                            joueur2.ajouteCarte(carte4);
                            joueur2.ajouteCarte(carte5);
                            joueur2.ajouteCarte(carte6);
                            joueur2.ajouteCarte(carte7);
                            joueur2.ajouteCarte(carte8);
                            joueur2.win();
                        }
                        
                    }
                }
                else {
                    // Si un des deux joueurs n'a plus assez de carte pour la bataille
                    if(joueur1.getNbCartes() < 2) {
                        System.out.println("Le joueur 1 n'a plus assez de carte, victoire du joueur 2 par forfait.");
                        joueur2.win();
                    }
                    else {
                        System.out.println("Le joueur 2 n'a plus assez de carte, victoire du joueur 1 par forfait.");
                        joueur1.win();
                    }
                }
            }
            else if(carte1.comparateur(carte2) == 2) {
                System.out.println("Victoire du joueur 1 !");
                // Le joueur 1 gagne !
                joueur1.ajouteCarte(carte1);
                joueur1.ajouteCarte(carte2);
                joueur1.win();
            }
            else {
                System.out.println("Victoire du joueur 2 !");
                // Le joueur 2 gagne !
                joueur2.ajouteCarte(carte2);
                joueur2.ajouteCarte(carte1);
                joueur2.win();
            }
            System.out.println();
            System.out.println("Joueur 1: " + joueur1.getPoints());
            System.out.println("Joueur 2: " + joueur2.getPoints());
        }
        
        System.out.println();
        
        if (joueur1.getNbCartes() == 0) {
            
            System.out.println("Le joueur 2 remporte la partie !!");
        }
        else {
            System.out.println("Le joueur 1 remporte la partie !!");
        }
        
    }
    
}