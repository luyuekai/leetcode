/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo0424;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-4-26
 *
 */
public class Tets0426 {
     enum Suit {CLUB, DIAMOND, HEART , SPADE}
     enum Rank {ACE,DEUCE, THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING}
     static  class Card{
          public  Card(Suit suit,Rank rank){
              
          }
          
      }

    public static void main(String[] args) {
       
       

        Collection<Suit> suits = Arrays.asList(Suit.values());
        Collection<Rank> ranks = Arrays.asList(Rank.values());
        
        List<Card> deck = new ArrayList<>();
        
        for (Iterator<Suit> i =  suits.iterator(); i.hasNext();) {
            for (Iterator<Rank> j =  ranks.iterator(); j.hasNext();) {
                Suit s1 = i.next();
                Rank r1 = j.next();
                deck.add(new Card(s1,r1));
                System.out.println(s1+" "+r1);
            }
        }
        
    }

}
