package id.ac.ui.cs.mobileprogramming.yama.caloriemeter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = new MainActivity();
    }

    @Test
    public void addCounter() {
        mainActivity.addCounter();
        assertEquals(1, mainActivity.getCounter());
    }

    @Test
    public void subCounter() {
        mainActivity.subCounter();
        assertEquals(-1, mainActivity.getCounter());
    }

    @Test
    public void resetCounter(){
        mainActivity.resetCounter();
        assertEquals(0, mainActivity.getCounter());
    }
}