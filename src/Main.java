//      https://habr.com/ru/post/440436/
//7.7.  Подсчёт элементов
//      Напишите метод, который получает на вход массив элементов типа К (Generic) и возвращает Map<K, Integer>,
//      где K — значение из массива, а Integer — количество вхождений в массив.
//      То есть сигнатура метода выглядит так:
//      <K> Map<K, Integer> arrayToMap(K[] ks);


import java.util.HashMap;
import java.util.function.BiFunction;

public class Main {

    <K> HashMap<K, Integer> contValue(K[] ks) {

        HashMap<K, Integer> map = new HashMap<>();   //создание свозвращаемого массива

        for (K k : ks) {
            map.compute(k, new BiFunction<K, Integer, Integer>() {         //создание функции замены значения
                @Override
                public Integer apply(K k, Integer cont) {
                    return cont == null ? 1 : cont + 1;
                }
            });
        }
        return map;
    }
}

//мой вариант  замены значения
//        for(K k: ks) {
//            if (map.containsKey(k)) {
//                 map.put(k, map.get(k)+1);
//            } else {
//                map.put(k, 1);
//            }
//        }