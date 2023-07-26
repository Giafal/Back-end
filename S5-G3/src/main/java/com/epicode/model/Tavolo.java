package com.epicode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tavolo {
	private  Integer numero;
	private  Integer numeroMassimoCoperti;
	private Boolean occupato = false;

	
	
	
	
}