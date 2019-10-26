package model.data_structures;

import java.util.Iterator;

/**
 * Clase Queue (Cola)
 */
public class Queue<E extends Comparable<E>> implements Iterable<E>{

	
	//--------------------------------------------------------
	//Atributos
	//--------------------------------------------------------
	
	/**
	 * Lista enlazada donde se van a almacenar los elementos de la cola
	 */
	private DoublyLinkedList <E> list;

	//--------------------------------------------------------
	//Constructores
	//--------------------------------------------------------
	
	/**
	 * Crea una cola vacia.
	 */
	public Queue() {
		list= new DoublyLinkedList<E>();
	}
	

	
	//--------------------------------------------------------
	//Metodos
	//--------------------------------------------------------

	public DoublyLinkedList<E> getList() {
		return list;
	}
	
	/**
	 * Quita y retorna el elemento agregado menos recientemente
	 * @return el elemento agregado menos recientemente
	 * @throws Exception 
	 */
	public E dequeue() {
		return (E) list.removeFirst();
	}

	/**
	 * Retorna el numero de elementos contenidos
	 * @return el numero de elemntos contenidos
	 */
	public int size() {
		return list.size();
	}

	/**
	 * Metodo que retorna el iterador de la cola (IteratorList), el cual comienza desde el primer nodo.
	 * @return Iterator El iterador de la cola (IteratorList implements Iterator)
	 */
	public Iterator<E> iterator() {
		return list.iterator();
	}
	
	/**
	 * Retorna true si la Cola esta vacia
	 * @return true si la Cola esta vacia, false de lo contrario
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Inserta un nuevo elemento en la Cola
	 * @param item el nuevo elemento que se va ha agregar
	 */
	public void enqueue(E item) {
		list.addLast(item);
	}


}
