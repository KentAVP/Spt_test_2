package Spt_test_2;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Function;
/*
Методу computeIfAbsent передаётся два параметра: ключ key и функция расчета значения по этому ключу mappingFunction.

Логика работы метода:

Проверяем наличие такого ключа в map. Если ключ есть и значение по ключу не равно null, то ничего не делаем
Иначе (нет ключа или значение по ключу равно null) считаем значение, применяя mappingFunction к key
Если итоговое значение не равно null, то записываем пару ключ-значение в map
В виде кода эта логика в документации описывается так:

if (map.get(key) == null) {
    V newValue = mappingFunction.apply(key);
    if (newValue != null)
        map.put(key, newValue);
}
 */
public class Future_test<K, V> {
    private Map<K, V> map;

    public Future<V> compute(final K k, Function<K, V> f) {
        CompletableFuture<V> completableFuture = CompletableFuture.supplyAsync(() -> map.computeIfAbsent(k, f));
        return completableFuture;
    }

}
