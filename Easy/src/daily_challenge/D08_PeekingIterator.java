package daily_challenge;

import java.util.Iterator;

public class D08_PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer peekedNumber = null;

    public D08_PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peekedNumber != null) return peekedNumber;
        peekedNumber = iterator.next();
        return peekedNumber;
    }

    @Override
    public boolean hasNext() {
        return peekedNumber != null || iterator.hasNext();
    }

    @Override
    public Integer next() {
        if (peekedNumber != null) {
            Integer nextNumber = peekedNumber;
            peekedNumber = null;
            return nextNumber;
        }
        return iterator.next();
    }
}