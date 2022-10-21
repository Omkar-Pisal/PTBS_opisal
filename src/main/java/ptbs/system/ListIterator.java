package ptbs.system;

import java.util.Iterator;

public interface ListIterator {

    public abstract boolean hasNext(Iterator iter);

    public abstract Object Next(Iterator iter);

    public abstract void MoveToHead(Iterator iter);

    public abstract void Remove(Iterator iter);

    boolean HasNext(Iterator iterator);
}
