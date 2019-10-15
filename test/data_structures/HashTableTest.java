package data_structures;



import java.util.Iterator;

import junit.framework.TestCase;
import model.data_structures.HashTable;


public class HashTableTest extends TestCase{
	
	
	//--------------------------------------------------------
	//Atributos
	//--------------------------------------------------------
	
	HashTable<String, Integer> hashTable;
	

	//--------------------------------------------------------
	//Escenarios
	//--------------------------------------------------------
	
	public void setUpEscenario0() {
		hashTable = new HashTable<String, Integer>(10);
	}  
	
	public void setUpEscenario1() {
		setUpEscenario0();
		hashTable.put("Paola", 10000000);
		hashTable.put("Andrea", 20000000);
		hashTable.put("Andres", 30000000);
		hashTable.put("Daniel", 40000000);
		hashTable.put("David", 50000000);
	}
	
	public void setUpEscenario2() {
		hashTable = new HashTable<String, Integer>(5);

	}  

	
	//--------------------------------------------------------
	//Metodos
	//--------------------------------------------------------

	public void testAgregarVariosElementos() {
		setUpEscenario0();
		
		hashTable.put("Paola", 10000000);
		hashTable.put("Andrea", 20000000);
		hashTable.put("Andres", 30000000);
		hashTable.put("Daniel", 40000000);
		hashTable.put("David", 50000000);
		
		System.out.println("Tamaño debe ser 5 ? "+hashTable.sizeKeys());
		
		assertTrue(hashTable.sizeKeys() == 5);
		Iterator<String> t = hashTable.keysIterator();
		while(t.hasNext()) {
			System.out.println("Key: " +t.next());
		}
	}
	
	public void testDarVariosElementos() {
		setUpEscenario1();
		
		int int1 = hashTable.get("Paola");
		int int2 = hashTable.get("Andrea");
		int int3 = hashTable.get("Andres");
		int int4 = hashTable.get("Daniel");
		int int5 = hashTable.get("David");
		
		assertTrue(int1 == 10000000);
		assertTrue(int2 == 20000000);
		assertTrue(int3 == 30000000);
		assertTrue(int4 == 40000000);
		assertTrue(int5 == 50000000);

	}
	
	public void testEliminarVariosElementos() {
		setUpEscenario1();
		
		int int1 = hashTable.delete("Paola");
		int int2 = hashTable.delete("Andrea");
		int int3 = hashTable.delete("Andres");
		int int4 = hashTable.delete("Daniel");
		int int5 = hashTable.delete("David");
		
		assertTrue(int1 == 10000000);
		assertTrue(int2 == 20000000);
		assertTrue(int3 == 30000000);
		assertTrue(int4 == 40000000);
		assertTrue(int5 == 50000000);
		
		assertTrue(hashTable.sizeKeys() == 0);

	}
	
	public void testRehash() {
		setUpEscenario2();
		//Nota: en el escenario 2, el tamaño con que se creo es de 5
		assertTrue(hashTable.maxSize() == 5); 

		//Se añaden 6 elementos
		hashTable.put("Bayona", 6000);
		hashTable.put("Latorre", 7000);
		hashTable.put("Monica", 2000);
		hashTable.put("Andrea", 7000);
		hashTable.put("Louie", 8000);
		hashTable.put("Louie", 8000);

		//Ahora eltamaño maximo debe ser el doble del original: 10

		assertTrue(hashTable.maxSize() == 10);
	}

}
