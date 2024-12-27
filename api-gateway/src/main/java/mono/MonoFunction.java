package mono;

import reactor.core.publisher.Mono;

public class MonoFunction {
    public static void main(String[] args) {

        /**
         * ✅ 2.1 Tạo Mono
         * Mono.just(T value) → Tạo Mono từ một giá trị.
         * Mono.empty() → Tạo một Mono rỗng.
         * Mono.error(Throwable e) → Tạo một Mono phát ra lỗi.
         * Mono.fromCallable(Callable<T> callable) → Tạo Mono từ Callable.
         * Mono.defer(Supplier<Mono<T>> supplier) → Tạo Mono khi nó được subscribe.
         */
//        Mono<String> mono = Mono.just("Hello World");
//        mono.subscribe(System.out::println);
//        Mono<String> emptyMono = Mono.empty();
//        emptyMono.subscribe(System.out::println);
//        Mono<String> errorMono = Mono.error(new RuntimeException("Error"));
//        errorMono.subscribe(System.out::println);
//        Mono<String> callableMono = Mono.fromCallable(() -> "Result from Callable");
//        callableMono.subscribe(System.out::println);

        /** ✅ 2.2 Biến Đổi Dữ Liệu (Transformation)
         * map(Function<T, R> mapper) → Biến đổi dữ liệu.
         * flatMap(Function<T, Mono<R>> mapper) → Biến đổi thành một Mono khác.
         * filter(Predicate<T> predicate) → Lọc giá trị.
         * defaultIfEmpty(T defaultValue) → Giá trị mặc định nếu Mono rỗng.
         */
//        Mono<?> transformedMono = Mono.just("Result from Mono")
//                .map(String::toUpperCase)
//                .filter(s -> s.length() > 0)
//                .flatMap(s -> Mono.empty())
//                .defaultIfEmpty("Another Mono");
//
//        transformedMono.subscribe(System.out::println);

        /**
         * ✅ 2.3 Xử Lý Dữ Liệu (Handling Data)
         * doOnNext(Consumer<T> consumer) → Thao tác với dữ liệu.
         * doOnError(Consumer<Throwable> consumer) → Thao tác khi lỗi xảy ra.
         * doFinally(Consumer<SignalType> consumer) → Thao tác cuối cùng khi stream kết thúc.
         */
//        Mono.just("Data")
//                .doOnNext(data -> System.out.println("Received: " + data))
//                .map(data -> Mono.error(new RuntimeException("Error")))
//                .doOnError(error -> System.out.println("Error: " + error.getMessage()))
//                .doFinally(signal -> System.out.println("Finally: " + signal))
//                .subscribe();

        /**
         * ✅ 2.4 Kết Hợp Dữ Liệu (Combining Monos)
         * Mono.zip(Mono<T1>, Mono<T2>, BiFunction<T1, T2, R>) → Kết hợp 2 Mono.
         * Mono.concat(Mono<T>, Mono<T>) → Nối các Mono.
         * Mono.merge(Mono<T>, Mono<T>) → Trộn các Mono.
         */
        Mono<String> mono1 = Mono.just("Hello");
        Mono<String> mono2 = Mono.just("World");
        Mono<String> combined = Mono.zip(mono1, mono2, (string1, string2) -> string1 + " everyone in the " + string2);
        combined.subscribe(System.out::println);
    }
}
