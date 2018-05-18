[raken@cdh03 humberto]$ vi src/main/scala/com/cloudera/sdk/SparkBatchExample.scala

package com.cloudera.sdk

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.rdd.RDD

object SparkBatchExample {
    def main(args: Array[String]): Unit = {
        if (args.length < 1) {
            System.err.println("Usage: SparkBatchExample <path>")
            System.exit(1)
        }

        val path = args(0)
        val conf = new SparkConf()
            .setAppName("Spark Batch Example")
            .setMaster("local[2]")
            .set("spark.io.compression.codec", "lz4")
                /*      .set("spark.network.timeout", "10001s")
                        .set("spark.executor.heartbeatInterval", "10000s")
*/
val sc = new SparkContext(conf)
        conf.set("spark.cleaner.ttl", "120000")

        /* READ DATA FROM HDFS, SORT BY KEY, SAVE TO HDFS */
		val scFile = sc.textFile(args(0))
		val aFileText = scFile.map(f1 => f1.split(",")).map(f2 => (f2(0), f2(1)))
		aFileText.repartition(1).sortByKey().saveAsTextFile(saveAsTextFile("/home/raken/humberto/output.txt"))


    }
}
