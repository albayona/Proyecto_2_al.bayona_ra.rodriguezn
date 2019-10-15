package data_structures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.data_structures.Stack;

class StackTest {

	private Stack<String> pila;
	//------------------------------------------------------
	//Escenarios
	//------------------------------------------------------
	
	@Before
	public void setUpEscenario0() {
		pila = new Stack<String>(); //lista vacia
	}

	@Before
	public void setUpEscenario1() {
		pila = new Stack<String>();
		pila.push("d"); //añade el elemento al inicio de la lista
		pila.push("c");
		pila.push("b");
		pila.push("a");

	}
	
	//------------------------------------------------------
	//Metodos de prueba
	//------------------------------------------------------
	@Test
	void testAnadirYEliminarElemento() {
		setUpEscenario1(); //Añade 4 elementos a la lista 
		
		//ORDEN DE LA LISTA
		//Pos 1: a
		//Pos 2: b
		//Pos 3: c
		//Pos 4: d 
		assertEquals(4, pila.size());
		assertEquals("a", pila.pop()); // elimina y retorna el elemento en la primera posicion de la lista
		assertEquals("b", pila.pop());
		assertEquals("c", pila.pop());
		assertEquals("d", pila.pop());
		assertEquals(0, pila.size());
		assertEquals(true, pila.isEmpty());
		
	}

	@Test
	void testPilaVacia() {
		setUpEscenario0(); //Crea una lista vacia
		
		assertEquals(0, pila.size());
		assertEquals(true, pila.isEmpty());
	}
	
	@Test
	void testIteradorPila() {
		setUpEscenario1(); //Crea una lista con 4 elementos
		//ORDEN DE LA LISTA
		//Pos 1: a
		//Pos 2: b
		//Pos 3: c
		//Pos 4: d 
		
		Iterator<String> t = pila.iterator();  //Empieza a iterar desde el primer elemento de la lista
		
		assertEquals("a", t.next());
		assertEquals("b", t.next());
		assertEquals("c", t.next());
		assertEquals("d", t.next());
		
	}

}
