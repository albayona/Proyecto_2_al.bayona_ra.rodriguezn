package data_structures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.data_structures.DoublyLinkedList;

class DoublyLinkedListTest {

	private DoublyLinkedList<String> lista;


	//------------------------------------------------------
	//Escenarios
	//------------------------------------------------------

	@Before
	public void setUpEscenario0() {
		lista = new DoublyLinkedList<String>(); //lista vacia
	}

	@Before
	public void setUpEscenario1() {
		lista = new DoublyLinkedList<String>();
		lista.addFirst("d"); //añade los elementos en la primera posicion
		lista.addFirst("c");
		lista.addFirst("b");
		lista.addFirst("a");
	}

	@Before
	public void setUpEscenario2() {
		lista = new DoublyLinkedList<String>(); //lista con 1 elemento
		lista.addFirst("a");
	}

	//------------------------------------------------------
	//Metodos de prueba
	//------------------------------------------------------


	@Test
	public void testAddElementInEmptyList() {
		setUpEscenario0();

		lista.addFirst("Vacio");

		Iterator<String> i =  lista.iterator();

		assertEquals(i.next(), "Vacio");
	}	

	@Test
	public void testAddElementAtTheBeggining() {
		setUpEscenario1();
		lista.addFirst("z");

		Iterator<String> i = lista.iterator();

		String s1 = i.next(); //z
		String s2 = i.next(); // a
		String s3 = i.next(); // b
		String s4 = i.next(); //c
		String s5 = i.next(); //d

		assertEquals(s1, "z");
		assertEquals(s2, "a");
		assertEquals(s3, "b");
		assertEquals(s4, "c");
		assertEquals(s5, "d");
	}

	@Test
	public void testAddAtEnd() {
		setUpEscenario1();
		lista.addLast("z");

		Iterator<String> i =  lista.iterator();

		String s1 = i.next(); //a
		String s2 = i.next(); //b
		String s3 = i.next(); //c
		String s4 = i.next(); //d
		String s5 = i.next(); //z

		assertEquals(s1, "a");
		assertEquals(s2, "b");
		assertEquals(s3, "c");
		assertEquals(s4, "d");
		assertEquals(s5, "z");
	}
	
	@Test
	public void testGetElementInListWithSeveralElements() {
		setUpEscenario1();
		String n = lista.getElement(0); //elemento en la pos 0
		String n1 = lista.getElement(1); //elemento en la pos 1
		String n2 = lista.getElement(2); //elemento en la pos 2
		String n3 = lista.getElement(3); //elemento en la pos 3
		
		//ORDEN DE LA LISTA
		//pos 0 = a
		//pos 1 = b
		//pos 2 = c
		//pos 3 = d
		
		assertEquals(n, "a");
		assertEquals(n1, "b");
		assertEquals(n2, "c");
		assertEquals(n3, "d");
	}
	
	@Test
	public void testGetElementInListWithOneElement() {
		setUpEscenario2();
		String n = lista.getElement(0); //elemento en la pos 0
		
		assertEquals(n, "a");

	}
	@Test
	public void testGetSize() {
		setUpEscenario1();
		int size = lista.size();
		assertEquals(size, 4);
	}
	
	@Test
	public void testDeleteElementInListWithSeveralElements() {
		setUpEscenario1();
		//TEST1 eliminar el primer elemento de la lista
		//ORDEN DE LA LISTA ORIGINAL
		//pos 0 = a
		//pos 1 = b
		//pos 2 = c
		//pos 3 = d

		String eliminado = lista.removeFirst(); //elemento en la pos 0
		
		//ORDEN DE LA LISTA <<<ESPERADO>>>
		//pos 0 = b
		//pos 1 = c
		//pos 2 = d

		Iterator<String> i = lista.iterator();
		
		String n1 = i.next();
		String n2 = i.next();
		String n3 = i.next();
		int tamanio = lista.size();
		
		String headElement = lista.first();
		
		assertEquals(eliminado, "a");
		assertEquals(n1, "b");
		assertEquals(n2, "c");
		assertEquals(n3, "d");
		assertEquals(tamanio, 3);
		assertEquals(headElement, "b");
	}
	
	@Test
	public void testDeleteElementInListWithSeveralElements2() {
		//TEST 2 eliminar el un elemento del medio de la lista
		setUpEscenario1();
		//ORDEN DE LA LISTA ORIGINAL
		//pos 0 = a
		//pos 1 = b
		//pos 2 = c
		//pos 3 = d

		String eliminado = lista.delete(2); //elemento en la pos 0
		
		//ORDEN DE LA LISTA <<<ESPERADO>>>
		//pos 0 = a
		//pos 1 = b
		//pos 2 = d
	

		Iterator<String> i =  lista.iterator();
		
		String n1 = i.next();
		String n2 = i.next();
		String n3 = i.next();
		int tamanio = lista.size();
		
		String headElement = lista.first();
		
		assertEquals("c", eliminado);
		assertEquals("a", n1);
		assertEquals("b", n2);
		assertEquals("d", n3);
		assertEquals(3, tamanio);
		assertEquals("a", headElement);
	}

}
