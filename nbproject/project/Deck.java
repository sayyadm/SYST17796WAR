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

import java.util.Random;

class Deck {
    Random random = new Random();
    
    private final ArrayList<Card>Deck = new ArrayList<>(52);
    private final ArrayList<Card>Shuffled = new ArrayList<>(52);
    
    //initialize constructor
    public Deck(){
        String suit;
        suit = "";
        String rank;
        rank = "";
        
        for(int x=0; x<4; x++){
            switch (x) {
                case 0:
                    suit = "Cloud";
                    break;
                case 1:
                    suit = "Hearts";
                    break;
                case 2:
                    suit = "Spades";
                    break;
                case 3:
                    suit = "Diamonds";
                    break;
                default:
                    break;
            }
            for(int y = 1; y <= 13; y++){
                if(y==1){
                    rank = "Ace";
                }
                else if(y>1 && y<11){
                    rank = "" + y;
                }
                else if(y==11){
                    rank="Jack";
                }
                else if(y==12){
                    rank="Queen";
                }
                else if(y==13){
                    rank="King";
                }
                Card card = new Card(suit, rank);
                Deck.add(card);  
            }
        } 
    }
    public Card getFromShuffledDeck(int x){
        if(!Shuffled.isEmpty())
            return Shuffled.get(x);
        return null;
    }
    public void Shuffle(){
        ArrayList<Integer>usednums = new ArrayList<>(52);
        System.out.println("Deck Size:" +Deck.size());
        
        int x=0;
        while(x<52){
            int cardnum = random.nextInt(51-0)+0;
            while(usednums.indexOf(cardnum)==-1){
                Shuffled.add(x,Deck.get(cardnum));
                System.out.println("Shuffle Deck Cards Size: "+Shuffled.size()+""+Deck.get(cardnum).getRank()+""+Deck.get(cardnum).getSuit());
                x++;
                
            }
        }
    }
}
