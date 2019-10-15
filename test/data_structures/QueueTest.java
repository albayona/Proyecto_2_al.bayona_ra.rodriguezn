package data_structures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.data_structures.Queue;

class QueueTest {

	//------------------------------------------------------
	//Escenarios
	//------------------------------------------------------
	
	private Queue<String> cola;

	@Before
	public void setUpEscenario0() {
		cola = new Queue<String>(); //lista vacia
	}

	@Before
	public void setUpEscenario1() {
		cola = new Queue<String>();
		cola.enqueue("a"); //añade el elemento al final de la lista
		cola.enqueue("b");
		cola.enqueue("c");
		cola.enqueue("d");

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
		assertEquals(4, cola.size());
		assertEquals("a", cola.dequeue()); // elimina y retorna el elemento en la primera posicion de la lista
		assertEquals("b", cola.dequeue());
		assertEquals("c", cola.dequeue());
		assertEquals("d", cola.dequeue());
		assertEquals(0, cola.size());
		assertEquals(true, cola.isEmpty());
	}

	@Test
	void testColaVacia() {
		setUpEscenario0(); //Crea una lista vacia
		
		assertEquals(0, cola.size());
		assertEquals(true, cola.isEmpty());
	}
	
	@Test
	void testIteradorCola() {
		setUpEscenario1(); //Crea una lista con 4 elementos
		//ORDEN DE LA LISTA
		//Pos 1: a
		//Pos 2: b
		//Pos 3: c
		//Pos 4: d 
		
		Iterator<String> t = cola.iterator();  //Empieza a iterar desde el primer elemento de la lista
		
		assertEquals("a", t.next());
		assertEquals("b", t.next());
		assertEquals("c", t.next());
		assertEquals("d", t.next());
		
	}

}
