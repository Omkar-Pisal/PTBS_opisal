package ptbs.system;

import java.util.Iterator;

public class OfferingIterator implements ListIterator {

	private OfferingList offeringList;

	public boolean hasNext(Iterator iterator) {
		if(iterator.next() == null)
			return false;
		else
			return true;
	}

	public String Next(Iterator iterator) {
		if (this.HasNext(iterator) == true) {
			return (String) iterator.next();
		} else {
			return null;
		}
	}

	@Override
	public void MoveToHead(Iterator iter) {

		System.out.println("Iterator moved to Head");

	}

	@Override
	public void Remove(Iterator iter) {
		if (this.HasNext(iter)) {
			iter.next();
		}

	}

	@Override
	public boolean HasNext(Iterator iterator) {
		return false;
	}



}
