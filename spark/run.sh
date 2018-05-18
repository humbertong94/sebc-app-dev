#!/bin/sh

SPARK_CLASS=com.cloudera.sdk.Spark.SparkBatchExample
SPARK_BUILD_DIR=/home/raken/humberto
SPARK_JAR=sparkbatchexample_2.11-99893839.0.jar
SPARK_BASE=/home/raken/humberto/input

DEPLOY_MODE=cluster
MASTER=yarn

spark-submit --deploy-mode ${DEPLOY_MODE} --master ${MASTER} --executor-memory 128M --num-executors 2 --executor-cores 1 --class ${SPARK_CLASS} ${SPARK_BUILD_DIR}/${SPARK_JAR} ${SPARK_BASE}
