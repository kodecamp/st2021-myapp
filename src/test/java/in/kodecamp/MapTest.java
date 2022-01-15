package in.kodecamp;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapTest {

   static private Map<String,String> from(String key, String value) {
       return Map.<String, String>of(key, value);
   }

   static private class HieData {
       String sub;
       String manager;


       HieData(String sub, String manager) {
           this.sub = sub;
           this.manager = manager;
       }

       static HieData from(Map<String, String> map) {
           return new HieData(map.keySet().toArray()[0].toString(), map.values().toArray()[0].toString());
       }


   }

   public void testMap() {
       List<Map<String, String>> values = List.<Map<String,String>>of(
               from("A", "C"),
               from("B", "C"),
               from("D", "A"),
               from("E", "A"));

       Function<Map<String,String>, HieData> converter = (Map<String,String> map) -> HieData.from(map);

       Map<String,List<String>> result = values.stream()
           .map(converter)
           .collect(Collectors.groupingBy(
                       h -> h.manager,
                       Collectors.mapping(h -> h.sub,Collectors.toList())));

       System.out.println(values);
       System.out.println(result);
   }




}
