package com.castillo.rentacar.Models;

enum Suit {
	ESPADAS("Espadas"),
	CORAZONES("Corazones"),
	TREBOLES("Treboles"),
	DIAMANTES("Diamantes");

	private final String nombre;
	private Suit(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
}

class JuegaCartas {
	private Suit suit;
	private int numero;

	public JuegaCartas(Suit suit, int numero) {
		this.suit = suit;
		this.numero = numero;
	}
	public Suit getSuit() {
		return suit;
	}
	public int getNumero() {
		return numero;
	}
}

public class EnumCartas2 {
	public static void main(String[] args) {
		JuegaCartas jc = new JuegaCartas(Suit.TREBOLES, 5);
		for(Suit s: Suit.values()) {
			if(s.equals(Suit.TREBOLES)) {
				System.out.println("Elegi la Suit de "+Suit.TREBOLES+
					" mi carta es: "+jc.getNumero()+
					" de "+jc.getSuit().getNombre());
			} else {
				System.out.println(s+"->"+s.getNombre());
			}
		}
	}
}