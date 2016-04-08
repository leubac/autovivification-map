package ch.leubac.autovivificationmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Mimic the autovivification mechanism natively present in some programming
 * languages. Decorates a standard {@link Map}.
 * 
 * @author leubac
 */
public final class AutovivificationMap<K, V> implements Map<K, V> {
	private final Map<K, V> origin;
	private final Supplier<V> defaultValue;

	public AutovivificationMap(Map<K, V> origin, Supplier<V> defaultValue) {
		this.origin = origin;
		this.defaultValue = defaultValue;
	}

	/**
	 * Uses a {@link HashMap} as backing {@link Map}
	 */
	public AutovivificationMap(Supplier<V> defaultValue) {
		this(new HashMap<K, V>(), defaultValue);
	}

	/**
	 * Implements the autovivification mechanism. If a value is requested with
	 * an unknown key, a new {@link Entry} will be created with the given key
	 * and the value provided by the given {@link Supplier}. The next time this
	 * method is called with the same key, the previously supplied value is
	 * returned.
	 * 
	 * @return the value to which the specified key is mapped, otherwise the
	 *         default value given by the {@link Supplier}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {
		if (!origin.containsKey(key)) {
			origin.put((K) key, defaultValue.get());
		}
		return origin.get(key);
	}

	@Override
	public int size() {
		return origin.size();
	}

	@Override
	public boolean isEmpty() {
		return origin.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return origin.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return origin.containsValue(value);
	}

	@Override
	public V put(K key, V value) {
		return origin.put(key, value);
	}

	@Override
	public V remove(Object key) {
		return origin.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		origin.putAll(m);
	}

	@Override
	public void clear() {
		origin.clear();
	}

	@Override
	public Set<K> keySet() {
		return origin.keySet();
	}

	@Override
	public Collection<V> values() {
		return origin.values();
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return origin.entrySet();
	}
}
