import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.runners.Parameterized;

import java.time.Instant;

import static org.junit.Assert.*;
@RunWith(org.junit.runners.Parameterized.class)
public class NumberBreakdownTest {
    private final int number;
    private final int[][] breakdown;
    public NumberBreakdownTest(int number, int[][] breakdown){
        this.number = number;
        this.breakdown = breakdown;
    }
    @Test
    public void execute(){
        assertThat((new NumberBreakdown(number).lambdaNumBreak())).isEqualTo((breakdown));
    }
    @Parameterized.Parameters
    public static Object[][] cases(){
        return new Object[][]{
                {0, new int[][]{}},
                {1, new int[][]{{1, 0}}},
                {12, new int[][]{{1, 1}, {2, 0}}},
                {10, new int[][]{{1, 1}}},
                {123,new int[][]{{1,2},{2,1},{3,0}}},
                {102,new int[][]{{1,2},{2,0}}},
                {1234,new int[][]{{1,3},{2,2},{3,1},{4,0}}},
                {1023,new int[][]{{1,3},{2,1},{3,0}}},
                {1003,new int[][]{{1,3},{3,0}}},
                {1000,new int[][]{{1,3}}},
                {4000,new int[][]{}}

        };

        
    }
    /*@Test
    public void should_1000_times_less_1_sec(){
        Instant start = Instant.now();
        for (int i = 0; i < 1000; i++) {
            new NumberBreakdown().numBreak(i);

        }
        Instant finish = Instant.now();
        assertThat(finish.getNano() - start.getNano()).isLessThan((int)1e9);
        System.out.println(finish.getNano() - start.getNano());
    }*/
}