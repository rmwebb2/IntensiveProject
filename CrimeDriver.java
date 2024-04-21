import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class CrimeDriver {
    public static void main(String[] args) throws Exception {
        JobClient myClient = new JobClient();
        JobConf jobConf = new JobConf(CrimeDriver.class);

        jobConf.setJobName("Crime");

        jobConf.setOutputKeyClass(Text.class);
        jobConf.setOutputValueClass(Text.class);

        jobConf.setMapperClass(CrimeMapper.class);
        jobConf.setReducerClass(CrimeReducer.class);

        jobConf.setInputFormat(TextInputFormat.class);
        jobConf.setOutputFormat(TextOutputFormat.class);

        FileInputFormat.setInputPaths(jobConf, new Path(args[0]));
        FileOutputFormat.setOutputPath(jobConf, new Path(args[1]));

        myClient.setConf(jobConf);
        try {
            JobClient.runJob(jobConf);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
