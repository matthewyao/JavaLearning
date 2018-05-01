package com.matthewyao.test.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mrunit.MapDriver;
import org.apache.hadoop.mrunit.ReduceDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * Created by yaokuan on 2018/4/21.
 */
public class WordCountTest {

    class WordCountMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

        private IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(LongWritable key, Text value,
                        OutputCollector<Text, IntWritable> output, Reporter reporter)
                throws IOException {
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                word.set(tokenizer.nextToken());
                output.collect(word, one);
            }
        }
    }

    class WordCountReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterator<IntWritable> values,
                           OutputCollector<Text, IntWritable> output, Reporter reporter)
                throws IOException {
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next().get();
            }
            output.collect(key, new IntWritable(sum));
        }
    }

    @Test
    public void testMapper(){
        Text value = new Text("java haha hadoop welcome hadoop");

        try {
            new MapDriver<LongWritable, Text, Text, IntWritable>()
                    .withMapper(new WordCountMapper())
                    .withInput(new LongWritable(), value)
                    .withOutput(new Text("java"), new IntWritable(1))
                    .withOutput(new Text("haha"), new IntWritable(1))
                    .withOutput(new Text("java/com/matthewyao/test/hadoop"), new IntWritable(1))
                    .withOutput(new Text("welcome"), new IntWritable(1))
                    .withOutput(new Text("java/com/matthewyao/test/hadoop"), new IntWritable(1))
                    .runTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReducer(){
        try {
            new ReduceDriver<Text, IntWritable, Text, IntWritable>()
                    .withReducer(new WordCountReducer())
                    .withInput(new Text("java"), Arrays.asList(new IntWritable(1), new IntWritable(1)))
                    .withInput(new Text("java/com/matthewyao/test/hadoop"), Arrays.asList(new IntWritable(1), new IntWritable(1), new IntWritable(1)))
                    .withOutput(new Text("java"), new IntWritable(2))
                    .withOutput(new Text("java/com/matthewyao/test/hadoop"), new IntWritable(3))
                    .runTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
