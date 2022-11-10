echo "Spark text 1:" >> /usr/local/output.txt
var map = sc.textFile("/usr/local/hadoop-friend-recommendation/buchanj-midwinter-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt1/1/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt1/2/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt1/3/")) 2>> /usr/local/output.txt

echo "Spark text 2:" >> /usr/local/output.txt
var map = sc.textFile("/usr/local/hadoop-friend-recommendation/carman-farhorizons-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt2/1/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt2/2/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt2/3/")) 2>> /usr/local/output.txt

echo "Spark text 3:" >> /usr/local/output.txt
var map = sc.textFile("/usr/local/hadoop-friend-recommendation/charlesworth-scene-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt3/1/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt3/2/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt3/3/")) 2>> /usr/local/output.txt

echo "Spark text 4:" >> /usr/local/output.txt
var map = sc.textFile("/usr/local/hadoop-friend-recommendation/cheyneyp-darkbahama-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt4/1/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt4/2/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt4/3/")) 2>> /usr/local/output.txt

echo "Spark text 5:" >> /usr/local/output.txt
var map = sc.textFile("/usr/local/hadoop-friend-recommendation/colby-champlain-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt5/1/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt5/2/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt5/3/")) 2>> /usr/local/output.txt

echo "Spark text 6:" >> /usr/local/output.txt
var map = sc.textFile("/usr/local/hadoop-friend-recommendation/delamare-bumps-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt6/1/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt6/2/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt6/3/")) 2>> /usr/local/output.txt

echo "Spark text 7:" >> /usr/local/output.txt
var map = sc.textFile("/usr/local/hadoop-friend-recommendation/delamare-lucy-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt7/1/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt7/2/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt7/3/")) 2>> /usr/local/output.txt

echo "Spark text 8:" >> /usr/local/output.txt
var map = sc.textFile("/usr/local/hadoop-friend-recommendation/delamare-myfanwy-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt8/1/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt8/2/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt8/3/")) 2>> /usr/local/output.txt

echo "Spark text 9:" >> /usr/local/output.txt
var map = sc.textFile("/usr/local/hadoop-friend-recommendation/delamare-penny-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt9/1/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt9/2/")) 2>> /usr/local/output.txt
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt9/3/")) 2>> /usr/local/output.txt
