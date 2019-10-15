package data_structures;

import java.util.Iterator;

import junit.framework.TestCase;
import model.data_structures.RedBlackTree;

public class RedBlackTreeTest extends TestCase {
	
	//--------------------------------------------------------
	//Atributos
	//--------------------------------------------------------
	

	private RedBlackTree<Integer, String> tree;
	
	
	//------------------------------------------------------
	//Escenarios
	//------------------------------------------------------

	public void setUpEscenario0() {
		tree = new RedBlackTree<Integer, String>();
	}  
	
	public void setUpEscenario1() {
		setUpEscenario0();
		tree.put(30, "Paola");
		tree.put(10, "Andrea");
		tree.put(50, "Andres");
		tree.put(4, "Daniel");
		tree.put(20, "David");
	}
	
	public void setUpEscenario2() {
		setUpEscenario0();
		tree.put(30, "Paola");
		tree.put(10, "Andrea");
		tree.put(50, "Andres");
		tree.put(4, "Daniel");
		tree.put(20, "David");
		
		tree.put(130, "Paola");
		tree.put(110, "Andrea");
		tree.put(150, "Andres");
		tree.put(14, "Daniel");
		tree.put(120, "David");

	}
	public void setUpEscenario3() {
		setUpEscenario0();
		tree.put(100, "A");
		tree.put(150, "B");
		tree.put(120, "C");
		tree.put(40, "D");
		tree.put(95, "E");
		tree.put(130, "F");
		tree.put(150, "G");
		tree.put(10, "H");
		tree.put(20, "I");
		tree.put(200, "J");
		tree.put(2, "K");
		tree.put(500, "L");
		tree.put(125, "M");
		tree.put(35, "N");
		tree.put(90, "J");


	}


	//------------------------------------------------------
	//Metodos de prueba
	//------------------------------------------------------
	
	public void testAgregar() {
		setUpEscenario3();
	}

	public void testAgregarVariosElementos() {
		setUpEscenario0();
		
		tree.put(30, "Paola");
		tree.put(10, "Andrea");
		tree.put(50, "Andres");
		tree.put(4, "Daniel");
		tree.put(20, "David");
		
		System.out.println("Tamaño debe ser 5 ? "+ tree.size());
		
		assertTrue(tree.size() == 5);
		
		assertTrue(tree.contains(30));
		assertTrue(tree.contains(10));
		assertTrue(tree.contains(50));
		assertTrue(tree.contains(4));
		assertTrue(tree.contains(20));
		
	}
	
	public void testDarVariosElementos() {
		setUpEscenario1();
		
		assertEquals("Paola", tree.get(30));
		assertEquals("Andrea", tree.get(10));
		assertEquals("Andres", tree.get(50));
		assertEquals("Daniel", tree.get(4));
		assertEquals("David", tree.get(20));
	}
	
	public void testEliminarVariosElementos() {
		setUpEscenario1();
		assertTrue(tree.size() == 5);

		try {
			tree.delete(30);
			assertTrue(tree.size() == 4);
			tree.delete(10);
			assertTrue(tree.size() == 3);
			tree.delete(50);
			assertTrue(tree.size() == 2);
			tree.delete(4);
			assertTrue(tree.size() == 1); 
			tree.delete(20);
			assertTrue(tree.size() == 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testCheck() {
		setUpEscenario3();
		assertTrue(tree.noHayPadreNiHijoRojoSeguidos());
		assertTrue(tree.padresMayoresQueHijoIzquierdo());
		assertTrue(tree.padresMenoresQueHijoDerecho());
		assertTrue(tree.nodosNegrosBalanceados());
	}

}
