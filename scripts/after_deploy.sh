#!/usr/bin/env bash
# Download releaseupdater from dropbox
curl -L -o releaseupdater.jar https://www.dropbox.com/s/lyhpm0916hubn4v/travis-github-release-helper-1.0.jar?dl=1

# Add release notes
echo Adding release notes
java -jar releaseupdater.jar init ${REPO_OWNER} ${REPO} ${GIT_TAG}
read -d '' BODY <<-"_EOF_"
This is a development pre-release. It is not a finished product and not guaranteed
to completely work. It is highly recommended you do not use this on a production server
unless you have done your research and are aware of the risks involved in running the build.
{newline}
{newline}
_This release was automatically generated_
_EOF_
java -jar releaseupdater.jar body ${BODY}
java -jar releaseupdater.jar name "Build #${TRAVIS_BUILD_NUMBER} (${TIME})"
java -jar releaseupdater.jar update ${OAUTH_KEY}

if ([ "$PUSH_SITE" == "true" ]); then
git clone --quiet --branch=gh-pages https://${OAUTH_KEY}@github.com/${REPO_OWNER}/${REPO} gh-pages > /dev/null

# Commit and Push the Changes
cd gh-pages
git rm -rf .
cp -Rf ../target/site/. ../gh-pages
git add -f .
git commit -m "Automatically updated maven site for changes in build #$TRAVIS_BUILD_NUMBER."
git push -fq origin gh-pages > /dev/null
else
  echo "No need to deploy site"
fi