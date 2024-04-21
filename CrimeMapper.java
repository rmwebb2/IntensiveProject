import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.io.Text;
import java.io.IOException;

public class CrimeMapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,Text> {

    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        String line = value.toString();
        String[] data = line.split(",");
        String day = data[0];
        String crime = data[3];

        output.collect(new Text(day), new Text(crime));

    }

}