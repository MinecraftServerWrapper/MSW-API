#!/usr/bin/env bash
mvn clean package

# Build javadocs
if ([ "$TRAVIS_BRANCH" == "master" ] || [ "$TRAVIS_PULL_REQUEST" == "false" ]); then
  echo "Building site"
  mvn site
  export PUSH_SITE="true"
else
  echo "Skipping site"
  export PUSH_SITE="false"
fi