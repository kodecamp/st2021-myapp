package in.kodecamp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MissingRecordTest {



    public void testMissingRecord() {

        List<SampleData> completeData = List.of(
                                            new SampleData("","Jan", 0),
                                            new SampleData("","Feb", 0),
                                            new SampleData("","March", 0),
                                            new SampleData("","April", 0),
                                            new SampleData("","May", 0),
                                            new SampleData("","June", 0),
                                            new SampleData("","July", 0),
                                            new SampleData("","August", 0),
                                            new SampleData("","September", 0),
                                            new SampleData("","October", 0),
                                            new SampleData("","November", 0),
                                            new SampleData("","December", 0));

        Map<String, List<SampleData>> dbData = Map.of(
                "1", List.of(new SampleData("1","Jan", 100), new SampleData("1","Feb", 200)),
                "2", List.of(new SampleData("2","Feb", 100), new SampleData("2","March", 200)),
                "3", List.of(new SampleData("3","April", 100), new SampleData("3","May", 200)),
                "4", List.of(new SampleData("4","June", 100), new SampleData("4","July", 200)),
                "5", List.of(new SampleData("5","August", 100), new SampleData("5","September", 200))
                );


        Set<String> keySet = dbData.keySet();

        Map<String, Set<SampleData>> completeMapData = new HashMap<>();


        Comparator<SampleData> comparator = (SampleData data1, SampleData data2) -> {
            return data1.getMonthAsInt().compareTo(data2.getMonthAsInt());
        };
        for(String key: keySet) {
            SortedSet<SampleData> sortedSet = new TreeSet<>(comparator);
            sortedSet.addAll(dbData.get(key));
            sortedSet.addAll(completeData);
            completeMapData.put(key, sortedSet);
        }
        System.out.println(completeMapData);


    }

    static class SampleData {
        static List<String> months = Arrays.asList(new String[]{"Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});

        String personNo;
        String month;
        double value;

        SampleData(String personNo,String month , double value) {
            this.personNo = personNo;
            this.month = month;
            this.value = value;
        }

        public Integer getMonthAsInt() {
            return months.indexOf(this.month);
        }

        public String toString() {
            return String.format("{months = %s, data = %f}", this.month, this.value);
        }
    }



}
