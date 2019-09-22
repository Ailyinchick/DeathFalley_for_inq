import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KakoiTest {
    @Test
    public void testmethod1() {
        Kakoi k = new Kakoi();
        assertEquals(k.summ(2, 6), 8);
    }

}
