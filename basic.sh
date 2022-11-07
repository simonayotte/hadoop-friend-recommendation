chmod +x ./hdvspark.sh
sudo apt install openjdk-17-jdk-headless
echo "export JAVA_HOME=\"/usr/lib/jvm/java-17-openjdk-amd64\"" >> ~/.profile
source ~/.profile
echo "export PATH=\"$JAVA_HOME/bin:$PATH\"" >> ~/.profile
source ~/.profile
sudo apt install wget
wget https://dlcdn.apache.org/hadoop/common/hadoop-3.3.4/hadoop-3.3.4.tar.gz
sudo tar -xf hadoop-3.3.4.tar.gz -C /usr/local/
echo "export HADOOP_PREFIX=\"/usr/local/hadoop-3.3.4\"" >> ~/.profile
source ~/.profile
echo "export PATH=\"$HADOOP_PREFIX/bin:$PATH\"" >> ~/.profile
source ~/.profile
sudo chmod -R 777 /usr/local/
sudo echo "export JAVA_HOME=\"/usr/lib/jvm/java-17-openjdk-amd64\"" >> /usr/local/hadoop-3.3.4/etc/hadoop/hadoop-env.sh
sudo echo "export HADOOP_PREFIX=\"/usr/local/hadoop-3.3.4\"" >> /usr/local/hadoop-3.3.4/etc/hadoop/hadoop-env.sh
sudo mkdir /usr/local/input/
sudo cp /usr/local/hadoop-spark-dataset/pg4300.txt /usr/local/input/
sudo apt install python3
wget https://downloads.apache.org/spark/spark-3.3.1/spark-3.3.1-bin-hadoop3.tgz
tar -xzf ./spark-3.3.1-bin-hadoop3.tgz -C ./
echo "export SPARK_HOME=\"/usr/local/spark-3.3.1-bin-hadoop3\"" >> ~/.profile
source ~/.profile
echo "export PATH=\"$PATH:$SPARK_HOME/bin\"" >> ~/.profile   
source ~/.profile
echo "export SPARK_HOME=\"/usr/local/spark-3.3.1-bin-hadoop3\"" >> ~/.bashrc  
source ~/.bashrc
echo "export PATH=\"$PATH:$SPARK_HOME/bin\"" >> ~/.bashrc                                              
source ~/.bashrc
echo "Ready for Hadoop VS Linux test. Press enter to continue"
read
time hadoop jar /usr/local/hadoop-3.3.4/share/hadoop/mapreduce/hadoop-mapreduce-examples-3.3.4.jar wordcount /usr/local/input/pg4300.txt /usr/local/output
echo "Hadoop result. Press enter to continue to Linux"
read
time cat ./hadoop-spark-dataset/pg4300.txt | tr ' ' '\n' | sort | uniq -c
echo "Linux result"