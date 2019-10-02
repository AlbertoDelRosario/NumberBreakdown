import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.runners.Parameterized;

import java.time.Instant;
 class PerformanceTest {

     @Test
     public void should_1000_times_less_1_sec(){
         Instant start = Instant.now();
         for (int i = 0; i < 1000; i++) {
             new NumberBreakdown(i).lambdaNumBreak();

         }
         Instant finish = Instant.now();
         assertThat(finish.getNano() - start.getNano()).isLessThan((int)1e9);
         System.out.println(finish.getNano() - start.getNano());
     }
}
