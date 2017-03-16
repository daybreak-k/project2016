package sample;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class SampleExecClassTest {

	@Test
	public void testExec1() {
		final SampleExecClass sampleExecClass = new SampleExecClass(true);
		final int result = sampleExecClass.exec();
		assertEquals(result, 0);
	}

	@Test
	public void testExec2() {
		final SampleExecClass sampleExecClass = new SampleExecClass(false);
		final int result = sampleExecClass.exec();
		assertEquals(result, 0);
	}

}
