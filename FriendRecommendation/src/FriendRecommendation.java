package edu.stanford.cs246.friendrecommendation;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class FriendRecommendation extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(args));
        int res = ToolRunner.run(new Configuration(), new FriendRecommendation(), args);
        System.exit(res);
    }

    @Override
    public int run(String[] args) throws Exception {
        System.out.println(Arrays.toString(args));
        Job job = new Job(getConf(), "FriendRecommendation");
        job.setJarByClass(FriendRecommendation.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(PairWritable.class);

        job.setMapperClass(Map.class);
        job.setReducerClass(Reduce.class);

        job.setInputFormatClass(KeyValueTextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.waitForCompletion(true);

        return 0;
    }

    // Will create the intermediary data for the reduce class
    // It will create key that is the current user
    // It will create a key pair that will contain a friend and the degree of that friend
    public static class Map extends Mapper<Text, Text, Text, PairWritable> {

        @Override
        public void map(Text key, Text value, Context context) throws IOException, InterruptedException {;
            if (value.getLength() != 0) {
                String[] friendsList = value.toString().split(",");
                for (int i = 0; i < friendsList.length; i ++) {
                    // Will add friend that are of degree one to be able to remove then from suggestions
                    context.write(key, new PairWritable(new Text(friendsList[i]), new IntWritable(1)));
                    for (int j = i + 1; j < friendsList.length; j++) {
                        // Will add degree 2 friends that can be a suggestion
                        context.write(new Text(friendsList[i]), new PairWritable(new Text(friendsList[j]), new IntWritable(2)));
                        context.write(new Text(friendsList[j]), new PairWritable(new Text(friendsList[i]), new IntWritable(2)));
                    }
                }
            }
        }
    }

    public static class Reduce extends Reducer<Text, PairWritable, Text, Text> {
        @Override
        public void reduce(Text key, Iterable<PairWritable> values, Context context) throws IOException, InterruptedException {
            Iterator<PairWritable> itr = values.iterator();
            //use a hashmap to keep track of the friends of the person and the count
            HashMap<String, Integer> hash = new HashMap<String, Integer>();
            while (itr.hasNext()) {
                PairWritable currentFriend = itr.next();
                String friendName = currentFriend.getFriend();
                // Will check if the friend is already is the hashmap
                if (hash.containsKey(friendName)) {
                    // If the friend wasn't previously a degree one friend it will increment the count
                    if (hash.get(friendName) != -1) {
                        hash.put(friendName, hash.get(friendName) + 1);
                    }
                }
                // If the friend wasn't in the hashmap
                else{
                    // If the friend is of degree one, it will set the count to -1
                    // It will be set to -1 because we do not want to suggest this friend
                    if (currentFriend.getDegree() == 1) {
                         hash.put(friendName, -1);
                    // If the friend is not in the hasmap and is a degree 2 friend, add him to the hashmap with the count of 1
                    } else {
                        hash.put(friendName, 1);
                    }
                }
            }

            Set<Entry<String, Integer>> entries = hash.entrySet();

            // sorting List by values using comparator
            Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String,Integer>>() {
                @Override public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                    String v1 = e1.getValue();
                    String v2 = e2.getValue();
                    return v1 - v2; } };

            List<Entry<String, String>> listOfEntries = new ArrayList<Entry<String, Integer>>(entries);
            Collections.sort(listOfEntries, valueComparator);

            int maxFriends = 10;
            StringBuffer output = new StringBuffer();
            for (int i = 0; ; i++ <= maxFriends && i <= listOfEntries.length){
                if(listOfEntries[i].getValue() == -1){
                    maxFriends++;
                } else{
                    output.append(top10heap.poll().getKey());
                    output.append(",");
                }
            }
            context.write(key, new Text(output.toString()));
        }
    }


    /*
     * the implementation of a friend and the degree with the WritableComparable interface required as a value
     */
    public static class PairWritable implements Writable {
        private Text friend;
        private IntWritable degree;

        public PairWritable() {
            this.friend = new Text();
            this.degree = new IntWritable();
        }

        public PairWritable(Text friend1, IntWritable degree) {
            this.friend = friend1;
            this.degree = degree;
        }

        @Override
        public void readFields(DataInput in) throws IOException {
            this.friend.readFields(in);
            this.degree.readFields(in);
        }

        @Override
        public void write(DataOutput out) throws IOException {
            friend.write(out);
            degree.write(out);
        }

        public int getDegree() {
            return degree.get();
        }

        public String getFriend() {
            return friend.toString();
        }
    }

}