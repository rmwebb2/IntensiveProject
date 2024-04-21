import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class CrimeReducer extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
    public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        Map<Text, Integer> reducer = new HashMap<>();

        System.out.println("In the reduce");
        while (values.hasNext()) {
            Text value = values.next();
            int count = reducer.containsKey(value) ? reducer.get(value) : 0;
            reducer.put(value, count + 1);
        }

        output.collect(key, new Text(reducer.toString()));


    }
}
