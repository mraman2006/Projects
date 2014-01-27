import static org.junit.Assert.*;

import org.junit.Test;


public class MainTest {

	@Test
	public void test() {
		Main m = new Main();
		assertEquals(-8, m.diff(10,2));
	}

}
