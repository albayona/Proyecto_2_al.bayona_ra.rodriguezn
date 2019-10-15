package data_structures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import model.data_structures.MaxHeap;


class MaxHeapTest {

	private MaxHeap<String> colaString;

	private MaxHeap<PruebaVO> colaPruebaVO;

	private MaxHeap<Integer> colaInteger;


	//------------------------------------------------------
	//Escenarios
	//------------------------------------------------------
	@Before
	void setUpEscenario0() {
		colaString = new MaxHeap<String>(10);
		colaPruebaVO = new MaxHeap<PruebaVO>(10);
		colaInteger = new MaxHeap<Integer>(10);

		}

	void setUpEscenario1() {
		setUpEscenario0();
		PruebaVO p = new PruebaVO("aaa", "bbb", 1);
		String a = "aa";
		Integer b = 1;

		try {

			colaPruebaVO.agregar(p);
			colaInteger.agregar(b);
			colaString.agregar(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	void setUpEscenario2() {
		setUpEscenario0();
		PruebaVO p1 = new PruebaVO("aaa", "bbb", 1);
		PruebaVO p2 = new PruebaVO("ccc", "ccc", 2);
		PruebaVO p3 = new PruebaVO("ddd", "ddd", 3);
		PruebaVO p4 = new PruebaVO("eee", "eee", 4);
		PruebaVO p5 = new PruebaVO("bbb", "fff", 5);

		try {

			colaPruebaVO.agregar(p1);
			colaPruebaVO.agregar(p2);
			colaPruebaVO.agregar(p3);
			colaPruebaVO.agregar(p4);
			colaPruebaVO.agregar(p5);
			System.out.println("# elementos 5? "+colaPruebaVO.darNumElementos());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	void setUpEscenario3() {
		setUpEscenario0();
		PruebaVO p3 = new PruebaVO("ddd", "ddd", 3);
		PruebaVO p4 = new PruebaVO("eee", "eee", 4);
		PruebaVO p5 = new PruebaVO("bbb", "fff", 5);

		try {

			colaPruebaVO.agregar(p3);
			colaPruebaVO.agregar(p4);
			colaPruebaVO.agregar(p5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void setUpEscenario4() {
		setUpEscenario0();
		PruebaVO p1 = new PruebaVO("aaa", "bbb", 1);
		PruebaVO p2 = new PruebaVO("ccc", "ccc", 2);
		PruebaVO p3 = new PruebaVO("ddd", "ddd", 3);
		PruebaVO p4 = new PruebaVO("eee", "eee", 4);
		PruebaVO p5 = new PruebaVO("fff", "fff", 10);
		PruebaVO p6 = new PruebaVO("ggg", "ggg", 22);
		PruebaVO p7 = new PruebaVO("hhh", "hhh", 40);
		PruebaVO p8 = new PruebaVO("iii", "iii", 6);
		PruebaVO p9 = new PruebaVO("jjj", "jjj", 9);
		PruebaVO p10 = new PruebaVO("bbb", "kkk", 5);

		try {

			colaPruebaVO.agregar(p1);
			colaPruebaVO.agregar(p2);
			colaPruebaVO.agregar(p3);
			colaPruebaVO.agregar(p4);
			colaPruebaVO.agregar(p5);
			colaPruebaVO.agregar(p6);
			colaPruebaVO.agregar(p7);
			colaPruebaVO.agregar(p8);
			colaPruebaVO.agregar(p9);
			colaPruebaVO.agregar(p10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//------------------------------------------------------
	//Metodos de prueba
	//------------------------------------------------------
	@Test
	void sacarElementoColaVacia() {
		setUpEscenario0();
		

		try {
			PruebaVO p = colaPruebaVO.max();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals("La cola esta vacia", e.getMessage());
		}
	}


	@Test
	void insertarElementoColaVacia() {
		setUpEscenario0();
		PruebaVO p = new PruebaVO("aaa", "bbb", 1);
		String a = "aa";
		Integer b = 1;

		try {
			colaPruebaVO.agregar(p);
			colaInteger.agregar(b);
			colaString.agregar(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(colaString.darNumElementos() == 1);
		assertTrue(colaPruebaVO.darNumElementos() == 1);
		assertTrue(colaInteger.darNumElementos() == 1);
	}

	@Test
	void insertarElementoCola1Elemento() {
		setUpEscenario1();
		PruebaVO p = new PruebaVO("bbb", "ccc", 2);
		String a = "bb";
		Integer b = 2;

		try {
			colaString.agregar(a);
			colaPruebaVO.agregar(p);
			colaInteger.agregar(b);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(colaString.darNumElementos() == 2);
		assertTrue(colaPruebaVO.darNumElementos() == 2);
		assertTrue(colaInteger.darNumElementos() == 2);
	}
	@Test
	void insertarElementoMenor() {
		setUpEscenario3();
		PruebaVO pMenor = new PruebaVO("aaa", "aaa", 1);

		try {
			colaPruebaVO.agregar(pMenor);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(colaPruebaVO.darNumElementos() == 4);

		PruebaVO p1 = colaPruebaVO.max();
		PruebaVO p2 = colaPruebaVO.max();
		PruebaVO p3 = colaPruebaVO.max();
		PruebaVO pMenor2 = colaPruebaVO.max(); //el menor es el ultimo que saca

		assertEquals(pMenor.getEstacionInicio(), pMenor2.getEstacionInicio());
		assertEquals(pMenor.getEstacionFinal(), pMenor2.getEstacionFinal());
		assertTrue(pMenor.getDuracion() == pMenor2.getDuracion());
	}

	@Test
	void insertarElementoMayor() {
		setUpEscenario2();
		PruebaVO pMayor = new PruebaVO("zzz", "yyy", 1000);

		try {
			colaPruebaVO.agregar(pMayor);
			System.out.println("# elementos 6? "+colaPruebaVO.darNumElementos());
			assertTrue(colaPruebaVO.darNumElementos() == 6);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		PruebaVO pMayor2 = colaPruebaVO.max(); //el Mayor es el primero que saca

		assertEquals(pMayor.getEstacionInicio(), pMayor2.getEstacionInicio());
		assertEquals(pMayor.getEstacionFinal(), pMayor2.getEstacionFinal());
		assertTrue(pMayor.getDuracion() == pMayor2.getDuracion());

		assertTrue(colaPruebaVO.darNumElementos() == 5);

	}

	@Test
	void insertarElementoColaLlena() {
		setUpEscenario4();
		PruebaVO nuevo = new PruebaVO("zzz", "yyy", 1000);
		assertTrue(10 == colaPruebaVO.darNumElementos());

		try {
			colaPruebaVO.agregar(nuevo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals("No puede añadir más elementos; se ha alcanzado el tope maximo", e.getMessage());
		}
	}

	@Test
	void retornaElementosOrdenadorMayorAMenor() {
		setUpEscenario4();

		PruebaVO[] ordenados = new PruebaVO[10];

		ordenados[0] = colaPruebaVO.max();
		ordenados[1] = colaPruebaVO.max();
		ordenados[2] = colaPruebaVO.max();
		ordenados[3] = colaPruebaVO.max();
		ordenados[4] = colaPruebaVO.max();
		ordenados[5] = colaPruebaVO.max();
		ordenados[6] = colaPruebaVO.max();
		ordenados[7] = colaPruebaVO.max();
		ordenados[8] = colaPruebaVO.max();
		ordenados[9] = colaPruebaVO.max();

		for(int i = 0; i < 9; i++) {
			assertTrue(ordenados[i].compareTo(ordenados[i+1]) > 0);
		}
	}
}
