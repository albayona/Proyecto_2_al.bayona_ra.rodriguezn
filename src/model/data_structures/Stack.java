package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T extends Comparable<T>> implements Iterable<T>{
	
	//--------------------------------------------------------
	//Atributos
	//--------------------------------------------------------

	/**
	 * Lista enlazada donde se van a almacenar los elementos de la pila
	 */
	private DoublyLinkedList<T> list;
	
	//--------------------------------------------------------
	//Constructores
	//--------------------------------------------------------
	
	/**
	 * Crea una pila vacia.
	 */
	public Stack() {
		list = new DoublyLinkedList<T>();
	}
	

	//--------------------------------------------------------
	//Metodos
	//--------------------------------------------------------

	/**
	 * Metodo que retorna el iterador de la pila (IteratorList), el cual comienza desde el primer nodo.
	 * @return Iterator El iterador de la pila (IteratorList implements Iterator)
	 */
	public Iterator<T> iterator() {
		return list.iterator();
	}
	
	/**
	 * Retorna true si la Pila esta vacia
	 * @return true si la Pila esta vacia, false de lo contrario
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Retorna el numero de elementos contenidos en la pila
	 * @return el numero de elemntos contenidos en la pila
	 */
	public int size() {
		return list.size();
	}

	/**
	 * Elimina y retorna el elemento agregado mas recientemente
	 * @return el elemento agregado mas recientemente
	 */
	public T pop() {
		return list.removeFirst(); //retorna el elemento que elimin� en la primera posicion (0)
	}

	/**
	 * Inserta un nuevo elemento en la Pila
	 * @param t el nuevo elemento que se va ha agregar
	 */
	public void push(T t) {
		list.addFirst(t); //El metodo add de DoublyLinkedList siempre a�ade el elemento al inicio de la lista
	}

}
