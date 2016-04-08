package ch.leubac.autovivificationmap;

/**
 * Functional interface (Java8-like). There is no requirement that a new or
 * distinct result be returned each time the supplier is invoked.
 * 
 * @author leubac
 */
public interface Supplier<T> {
	T get();
}
