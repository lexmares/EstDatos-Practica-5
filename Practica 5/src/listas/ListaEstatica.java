package ed.ito;

public class ListaEstatica<E> implements Lista<E> {
	
	private E items[];
	private int p,u;
	private final int SIZE=10;
	
	@SuppressWarnings("unchecked")
	public ListaEstatica() {
		this.items=(E [])new Object[this.SIZE];
		this.p=this.u=-1;
	}
	
	@SuppressWarnings("unchecked")
	public ListaEstatica(int size) {
		this.items=(E [])new Object[size];
		this.p=this.u=-1;
	}
	

	@Override
	public void add(E item) throws ExcepcionDeListaLlena {
		// TODO Auto-generated method stub
        if(this.isFull())
        	throw new ExcepcionDeListaLlena("La lista esta llena!!");
        if(this.isEmpty())
        	this.p++;
        this.items[++this.u]=item;
	}

	@Override
	public E delete(int i) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("Ls lista esta vacia!!");
		if(i>this.size())
			throw new ExcepcionDeElementoNoEncontrado("El elemento no se localiza en la lista!!");
		E item=this.items[i-1];
		for(;i<=this.u;i++)
			this.items[i-1]=this.items[i];
		this.u--;
		if(this.u==-1)
			this.p=-1;
		return item;
	}

	@Override
	public E deleteFirst() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		E item=this.items[this.p];
		for(int i=this.p;i<this.u;i++)
			this.items[i]=this.items[i+1];
		if(this.u==this.p) 
			this.u=this.p=-1;
		else
			this.u--;
		return item;
	}

	@Override
	public E deleteLast() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		E item=this.items[this.u];
		if(this.u==this.p) 
			this.u=this.p=-1;
		else
			this.u--;
		return item;
	}

	@Override
	public E deleteItem(E item) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		int i=this.p;
		while(i<=this.u) {
			@SuppressWarnings("unchecked")
			Comparable<E> x=(Comparable<E>)items[i];
			if(x.compareTo(item)==0)
				break;
			i++;
		}
		if(i>this.u)
			throw new ExcepcionDeElementoNoEncontrado("El elemento a querer eliminar no se localiza!!");
		for(;i<this.u;i++)
			this.items[i]=this.items[i+1];
		if(this.u==this.p)
			this.u=this.p=-1;
		else
			this.u--;
		return item;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.p==-1;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return this.u==this.items.length-1;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.u+1;
	}

	@Override
	public E getFirst() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista es vacia!!");
		return this.items[this.p];
	}

	@Override
	public E getLast() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		return this.items[this.u];
	}

	@Override
	public E getItem(int i) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		if(i>this.u+1)
			throw new ExcepcionDeElementoNoEncontrado("El elemento no se encuentra!!");
		return this.items[i-1];
	}

	@Override
	public boolean search(E item) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia("La lista esta vacia!!");
		int i=this.p;
		boolean test=false;
		while(i<=this.u) {
			@SuppressWarnings("unchecked")
			Comparable<E> x=(Comparable<E>)items[i];
			if(x.compareTo(item)==0) {
				test=true;
				break;
			}
			i++;
		}
		if(!test)
			throw new ExcepcionDeElementoNoEncontrado("El elemento no se localiza!!");
		return test;
	}

}
