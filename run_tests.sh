#!/usr/bin/env bash
mvn clean install test -Dtest=RunnerClass
mvn cluecumber-report:reporting
