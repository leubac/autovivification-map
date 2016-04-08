package ch.leubac.autovivificationmap;

import static org.junit.Assert.*;

import org.junit.Test;

public class AutovivificationMapTest {
	private final Supplier<Mutable> supplier = new Supplier<Mutable>() {
		@Override
		public Mutable get() {
			return new Mutable();
		}
	};

	@Test
	public void testGetDefault() {
		AutovivificationMap<String, Mutable> m = new AutovivificationMap<>(
				supplier);

		assertNotNull(m.get("test"));
		assertEquals(0, m.get("test").getValue());
	}

	@Test
	public void testGetStandard() {
		AutovivificationMap<String, Mutable> m = new AutovivificationMap<>(
				supplier);
		Mutable v = new Mutable();
		v.setValue(5);
		m.put("test", v);

		assertEquals(5, m.get("test").getValue());
	}

	@Test
	public void testDefaultModified() {
		AutovivificationMap<String, Mutable> m = new AutovivificationMap<>(
				supplier);
		Mutable v = m.get("test");
		v.setValue(5);

		assertEquals(5, m.get("test").getValue());
	}

	private static class Mutable {
		private int value;

		public Mutable() {
			this.value = 0;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

}
