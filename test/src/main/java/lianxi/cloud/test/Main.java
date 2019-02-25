package lianxi.cloud.test;


import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author wangyuanhang
 */
public class Main {
    public static void main(String[] args) {
        String[] strings = {"hello", "world", "!"};
	    Arrays.asList(strings)
			    .stream()
			    .flatMap(tmp -> Arrays.asList(tmp.split("")).stream())
			    .collect(Collectors.toList())
			    .forEach(System.out::println);


    }
}
