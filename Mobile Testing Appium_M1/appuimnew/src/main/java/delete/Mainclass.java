package delete;

import org.testng.annotations.Test;

import com.base.BaseClass;

public class Mainclass extends BaseClass {

	@Test
	public void view() {
		@SuppressWarnings("unused")
		Pagemain maipg = new Pagemain();
		MainPageUsingPagefactory pgfct = new MainPageUsingPagefactory(driver);
		pgfct.gotohintbox();
	}
}
