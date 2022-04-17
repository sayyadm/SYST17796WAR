/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author HP
 */
public enum Suit {
 CLUBS("Clubs"),
 SPADES("Spades"),
 HEARTS("Hearts"),
 DIAMONDS("Diamonds");
 
 private final String suitName;
 
 Suit(String suitName){
     this.suitName=suitName;
 }
 public String getSuitName(){
  return this.suitName;   
 }
@Override
public String toString(){
    return this.getSuitName();
}
}