#!/bin/bash

APP_HOME=..
JAVA_HOME=$JAVA_HOME

display_help(){
   echo "  "
   echo "Help"
   echo " "
   echo "Usage: stream-sampler.sh <postive_number>"
   echo " "
   echo "Passing zero (0) as an input, defaults to value 5."
   echo " "
   echo "Example: stream-sampler.sh 5"
   echo " "
   exit 1
}

if [[ $# -gt 1 ]] || ! [[ $1 =~ ^[0-9]+$ ]]; then
    display_help
fi

CLASSPATH=$CLASSPATH:$APP_HOME/target/stream-data-process-1.0.jar

$JAVA_HOME/bin/java -classpath "$CLASSPATH" com.example.stream.Main $1


