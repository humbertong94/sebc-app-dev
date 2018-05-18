#!/bin/sh
export SPARK_DIST_CLASSPATH=$(hadoop classpath)
SPARK_CLASS=com.cloudera.sdk.SparkMLExample
SPARK_BUILD_DIR=/home/raken/humberto_ml/sparkml
SPARK_JAR=sparkmlexample.jar
SPARK_BASE=/home/raken/humberto_ml/sparkml/input/
ITERS=100
DEPLOY_MODE=client
MASTER=yarn
spark2-submit  --master yarn --executor-memory 1G --num-executors 2 --executor-cores 1 --class ${SPARK_CLASS} ${SPARK_BUILD_DIR}/${SPARK_JAR} ${SPARK_BASE} ${ITERS}
