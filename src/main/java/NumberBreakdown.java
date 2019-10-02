import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.log10;
import static java.lang.Math.pow;
import static java.util.stream.IntStream.iterate;
import java.util.stream.Stream;

public class NumberBreakdown {
    private final int number;
    public NumberBreakdown(int n){
        number = n;
    }

    /*public int[][] numBreak(int number){
        int l = (int)log10(number) + 1;
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[][] res = null;
        for (int i = 0; i <= l; i++) {
            if(number%10 != 0){
                list.add(new int[]{number%10,i});
            }
            number = number/10;
        }
        Collections.reverse(list);
        res = new int[list.size()][2];
        for (int j = 0;j < list.size(); j++){
            res[j] = list.get(j);
        }
        return res;
    }*/

    public int[][] lambdaNumBreak() {
        if(number <= 0 || number >= 4000)return new int[][]{};
        return stream()
                .map(this::tuple)
                .filter(this::isNotZero)
                .toArray(int[][]::new);


    }

    private int numSize(int number){
        return (int)log10(number) + 1;
    }
    private int[] tuple(int pos){
        return new int[]{
                (number / (int) pow(10, pos))%10,
                pos
        };
    }

    private Stream<Integer> stream(){
        return iterate(0, i -> i + 1)
                .limit(numSize(number))
                .map(i -> (numSize(number) - 1 - i))
                .boxed();
    }

    private boolean isNotZero(int[] tuple){
        return tuple[0] != 0;
    }

}
