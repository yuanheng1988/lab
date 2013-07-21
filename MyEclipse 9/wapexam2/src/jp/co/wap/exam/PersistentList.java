package jp.co.wap.exam;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PersistentList<E> implements Iterable<E> {
    @SuppressWarnings("unchecked")
    private final static PersistentList NIL = new PersistentList(null, null);

    public final E head;
    public final PersistentList<E> tail;


    public PersistentList(E head, PersistentList<E> tail) {
        this.head = head;
        this.tail = tail;
    }

    public PersistentList<E> add(E t) {
        return new PersistentList<E>(t, this);
    }

    public boolean isEmpty() {
        return this == NIL;
    }

    public PersistentList<E> reverse() {
    	PersistentList<E> result = nil();
        for (E t : this) {
            result = result.add(t);
        }
        return result;
    }
    
    public int size() {
    	int count = 0;
    	for (E t : this) {
            count++;
        }
        return count;
    }

    @SuppressWarnings("unchecked")
    public static <T> PersistentList<T> nil() {
        return NIL;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private PersistentList<E> list = PersistentList.this;

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E t = list.head;
                list = list.tail;
                return t;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}


