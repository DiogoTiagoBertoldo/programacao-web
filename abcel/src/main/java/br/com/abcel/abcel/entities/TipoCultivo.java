package br.com.abcel.abcel.entities;

import jakarta.persistence.Table;

@Table(name = "TipoCultivo")
public enum TipoCultivo {
	// Fonte para os Tipos: Google mesmo
	TRADICIONAL,	// Agricultura familiar
	MODERNA,		// Agricultura mercantil
	ORGANICA,		// Agricultura com viés sustentavel e natural
	BIODINAMICA,	// Agricultura parecida com a Organica
	REGENERATIVA,	// Agricultura com objetivo de restaurar e preservar ambientes
	SINTROPICA,		// Agricultura com viés de manutençao do ambiente
	BIOLOGICA,		// Agricultura com objetivo de melhorar o ecossistema local
}
