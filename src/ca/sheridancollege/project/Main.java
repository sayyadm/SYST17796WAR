/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author franc
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] arg){
        
        Scanner sc = new Scanner(System.in);
        String firstPlayer;
        String secondPlayer;
        String roundwinner = "";
        String gamewinner = "";
        
        int temp;
        int play = 1;
        
        while (play != 1){
            boolean winner = false;
            
            Deck deck = new Deck();
            deck.Shuffle();
            
            //create array lists
            ArrayList<Card> Deck1 = new ArrayList<>(56);
            ArrayList<Card> Deck2 = new ArrayList<>(56);
            ArrayList<Card> warDeck = new ArrayList<>(9);
            
            for(int x= 0; x<26; x++){
                System.out.println("Getting from shuffled deck: Position:"+x+","+(x+26));
                Deck1.add(deck.getFromShuffledDeck(x));
                Deck2.add(deck.getFromShuffledDeck(x+26));
                
            }
            //Welcome users, prompts for names
            System.out.println("Welcome to WAR CARD GAME! Lets Play!\n");
            System.out.println("Enter the First player's name");
            firstPlayer = sc.nextLine();
            System.out.println("Enter the Second player's name");
            secondPlayer = sc.nextLine();
            
            // display header
            System.out.println(firstPlayer+"\t\t\t#Cards\t\t" +secondPlayer+ "\t\t\t#Cards\t\tWinner");
            while(!winner){
                //show the first card of deck 1 and deck2
                System.out.print(Deck1.get(0)+ "\t" + Deck1.size()+"\t\t" +Deck2.get(0)+ "\t" + Deck2.size() + "\t\t");
                int x = Deck1.get(0).isGreater(Deck2.get(0));
                /*
                *if one of the cards has a greater value than the other
                *program will add the first card of Both decks to the end and then
                *remove thw first card of Both decks
                */
                //Deck1 first card is greater than first card in Deck2
                if(x==1){
                    Deck1.add(Deck2.get(0));
                    Deck1.add(Deck1.get(0));
                    Deck1.remove(0);
                    Deck2.remove(0);
                    
                    roundwinner = firstPlayer;
                }
                // //Deck2 first card is greater than first card in Deck1
                if(x==2){
                    Deck2.add(Deck1.get(0));
                    Deck1.add(Deck2.get(0));
                    Deck2.remove(0);
                    Deck1.remove(0);
                    
                    roundwinner = secondPlayer;
                }
                // no winner in this round
                if(x==3){
                    roundwinner = "WAR!";
                }
                System.out.println(roundwinner);
                
                if(x==3){
                    war();
                    System.out.print(Deck1.get(0)+ "\t" + Deck1.size()+ "\t\t" + Deck2.get(0)+ "\t"+ Deck2.size() + "\t\t");
                    
                    /*
                    *if either player has 4 cards or less, then they do not have enough cards
                    *to go to war, and the winner will automatically be the other person
                    */
                    
                    if(Deck1.size()<=4){
                        roundwinner = secondPlayer;
                        System.out.println(roundwinner);
                        System.out.println("\t\t\t"+ firstPlayer + "does not have enough cards to go to war.");
                        endwar();
                        gamewinner = secondPlayer;
                        break;
                    }
                    else if(Deck2.size() <= 4){
                        roundwinner = firstPlayer;
                        System.out.println(roundwinner);
                        System.out.println("\t\t\t" + secondPlayer + "does not have enough cards to go to war");
                        
                        System.out.println("********************************END WAR*********************************");
                        
                        gamewinner = firstPlayer;
                        break;
                    }
                    
                    //Adds 4 cards to the war deck from each player
                    for(int y=0; y<4 && Deck1.size()<48; y++){
                        warDeck.add(Deck1.get(0));
                        Deck1.remove(0);
                    }
                    for(int y=0; y<4 && Deck2.size()<48; y++){
                        warDeck.add(Deck2.get(0));
                        Deck2.remove(0);
                    }
                    // evaluate to see who the war winner is
                    temp = warDeck.get(3).isGreater(warDeck.get(7));
                    if(temp == 1){
                        while (warDeck.size()!=0){
                            Deck1.add(warDeck.get(0));
                            warDeck.remove(0);
                            roundwinner = firstPlayer;
                        }
                    }
                    else if(temp==2){
                        while(warDeck.size()!=0){
                            Deck2.add(warDeck.get(0));
                            warDeck.remove(0);
                            roundwinner = secondPlayer;
                        }
                    }
                    // in case there is another war the system will test
                    // test to see if there is a winner by shiffting right
                    else{
                        shift(warDeck);
                        temp = warDeck.get(3).isGreater(warDeck.get(7));
                        if(temp ==1){
                            while(warDeck.size()!=0){
                                Deck1.add(warDeck.get(0));
                                warDeck.remove(0);
                                roundwinner = firstPlayer;
                            }
                        }
                        else if(temp==2){
                            while(warDeck.size()!=0){
                                Deck2.add(warDeck.get(0));
                                warDeck.remove(0);
                                roundwinner = secondPlayer;
                            }
                        }
                    }
                    System.out.println(roundwinner);
                    endwar();
                }
                // if any of the players has 52 cards, there will be a winner and inner loop will stop
                if(Deck1.size()==52){
                    gamewinner = firstPlayer;
                    winner = true;
                }
                if(Deck2.size()==52){
                    gamewinner = secondPlayer;
                    winner = true;
                }
            }
            // end of the inner loop
            //congratulates the winner
            
            //ask them if they wanna play again
            System.out.println(gamewinner + "WINS! Congratulations!");
            System.out.print("Play again (y/n)?");
            String option;
            option = sc.nextLine().toLowerCase();
            option = ""+ option.charAt(0);
            
            //check error
            while(!(option.equals("y")||option.equals("n"))){
                System.out.print("invalid option. Please enter Y or N: ");
                option = sc.nextLine().toUpperCase();
                option = "" + option.charAt(0);
            }
            if(option.equals("y")){
                play = 1;
            }
            else{
                play = 0;
            }
        }
        // end of outer loop
        System.out.print("Thank you for playing!");
    }//end of main method

    public static void war() {
        System.out.println("**===================================WAR=================================**");
    }
    public static void endwar(){
        System.out.println("**=================================END WAR===============================**");
    }
    public static void shift(List<Card> warDeck){
        warDeck.add(warDeck.get(3));
        warDeck.remove(3);
        warDeck.add(2,warDeck.get(7));
        warDeck.remove(7);
    }
    
}
