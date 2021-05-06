#!/bin/sh

find -name '*.java' | xargs javac
java battleship.Main