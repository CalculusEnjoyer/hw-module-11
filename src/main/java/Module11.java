import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Module11 {
    private static final long SEED = 126074519596L;

    private Module11() {
    }

    public static String namesParser(List<String> names) {
        StringBuilder result = new StringBuilder();
        IntStream.range(0, names.size()).filter(x -> x % 2 == 1).forEach(index -> result.append(index)
                                                                                        .append(". ")
                                                                                        .append(names.get(index))
                                                                                        .append(", "));
        if (result.length() != 0) result.delete(result.length() - 2, result.length() - 1);
        return result.toString();
    }

    public static List<String> reverseSort(List<String> strings) {
        return strings.stream().map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static String sortAndString(int[] arr) {
        StringBuilder result = new StringBuilder();
        Arrays.stream(arr).sorted().forEach(x -> result.append(x).append(", "));
        if (result.length() != 0) result.delete(result.length() - 2, result.length() - 1);
        return result.toString();
    }

    public static Stream<Long> randomizer(Long a, Long c, Long m) {
        return Stream.iterate(SEED, seed -> Math.abs((a * seed + c) % m));
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> resultIterator = new Iterator<T>() {
            boolean nextStreamFirst = true;

            @Override
            public boolean hasNext() {
                if (nextStreamFirst) {
                    return firstIterator.hasNext();
                } else {
                    return secondIterator.hasNext();
                }
            }

            @Override
            public T next() {
                T result;
                if (nextStreamFirst) {
                    result = firstIterator.next();
                    nextStreamFirst = false;
                } else {
                    result = secondIterator.next();
                    nextStreamFirst = true;
                }
                return result;
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(resultIterator, 0);
        return StreamSupport.stream(spliterator, false);
    }
}
