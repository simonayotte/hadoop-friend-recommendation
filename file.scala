var map = sc.textFile("/usr/local/hadoop-friend-recommendation/buchanj-midwinter-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt1/1/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt1/2/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt1/3/")) 

var map = sc.textFile("/usr/local/hadoop-friend-recommendation/carman-farhorizons-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt2/1/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt2/2/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt2/3/")) 

var map = sc.textFile("/usr/local/hadoop-friend-recommendation/charlesworth-scene-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt3/1/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt3/2/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt3/3/")) 

var map = sc.textFile("/usr/local/hadoop-friend-recommendation/cheyneyp-darkbahama-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt4/1/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt4/2/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt4/3/")) 

var map = sc.textFile("/usr/local/hadoop-friend-recommendation/colby-champlain-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt5/1/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt5/2/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt5/3/")) 

var map = sc.textFile("/usr/local/hadoop-friend-recommendation/delamare-bumps-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt6/1/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt6/2/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt6/3/")) 

var map = sc.textFile("/usr/local/hadoop-friend-recommendation/delamare-lucy-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt7/1/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt7/2/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt7/3/")) 

var map = sc.textFile("/usr/local/hadoop-friend-recommendation/delamare-myfanwy-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt8/1/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt8/2/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt8/3/")) 

var map = sc.textFile("/usr/local/hadoop-friend-recommendation/delamare-penny-00-t.txt").flatMap(line => line.split(" ")).map(word => (word,1));
var counts = map.reduceByKey(_ + _);
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt9/1/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt9/2/")) 
spark.time(counts.saveAsTextFile("/usr/local/outputSpark/txt9/3/")) 

:quit