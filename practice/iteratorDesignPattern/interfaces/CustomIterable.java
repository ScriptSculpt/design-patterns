package practice.iteratorDesignPattern.interfaces;

public interface CustomIterable<T> {
    CustomIterator<T> getIterator();
}
