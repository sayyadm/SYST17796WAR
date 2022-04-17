/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author HP
 */
public enum Value {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);
 
    private final int ValuePoints;
    
    Value(int ValuePoints){
        this.ValuePoints = ValuePoints;
        
}
    public int getValuePoints(){
 return this.ValuePoints;   
}
@Override
public String toString(){
    return String.valueOf(this.getValuePoints());
}
}
