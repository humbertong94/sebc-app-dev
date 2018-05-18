package com.cloudera.sdk

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.SparkSession

object SparkMLExample {
  def main(args: Array[String]): Unit = {
    if (args.length < 2) {
      System.err.println("Usage: SparkMLExample <input> <iterations>")
      System.exit(1)
    }

    val path = args(0)
    val iters = args(1).toInt
    val conf = new SparkConf()
      .setAppName("Spark ML Example")
      //    .setMaster("local[2]")
      .set("spark.io.compression.codec", "lz4")
    val sc = new SparkContext(conf)

    conf.set("spark.cleaner.ttl", "120000")
    //      conf.set("spark.driver.allowMultipleContexts", "true")

    val spark = SparkSession
      .builder()
      .config(conf)
      .getOrCreate()

    Logger.getRootLogger.setLevel(Level.WARN)

    val pTrain = spark.read.format("libsvm").load(path)

    val lr = new LinearRegression()
      .setMaxIter(iters)
      .setRegParam(0.3)
      .setElasticNetParam(0.8)


    val lrMod0 = lr.fit(pTrain)
    println(s"predicted_house_price = ${lrMod0.intercept} + ${lrMod0.coefficients.apply(0)} x num_of_rooms + ${lrMod0.coefficients.apply(1)} x num_of_baths + ${lrMod0.coefficients.apply(2)} x size_of_house + ${lrMod0.coefficients.apply(3)} x one_if_pool_zero_otherwise")
  }
}
