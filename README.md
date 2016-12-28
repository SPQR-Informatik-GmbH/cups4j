# Description

A Java library for printing with [IPP](https://en.wikipedia.org/wiki/Internet_Printing_Protocol) to a [CUPS](https://en.wikipedia.org/wiki/CUPS) server.

# Preamble

CUPS library for Java, forked and mavenized from http://www.cups4j.org/ version 0.6.4. The reason for the fork is that the original project is unmaintained since 2013, and no maven artifact exists to use the library.

The original upstream developers have not been contacted to approve this fork, since the project is published as GPL-3.0.

# Release mapping

- Upstream release 0.6.4 maps directly to de.spqrinfo.cups4j:1.1-RELEASE

# Changes

The following changes where applied to the upstream source 0.6.4:
- mavenize project, by splitting into three separate artifacts
    - cups4j - core library
    - vppserver - separate package in upstream, part of the core library
    - cups4cli - in upstream part of the test package, actually a command line client for testing the library interactively
- move resources where they belong
- change package to `de.sprinfo.cups4j`
- fix class loading by replacing explicit classLoader usage to load resources
- create test case to ensure loading of xml schema files succeeds

# Using the library

Cups4j is available on Maven central:

```xml
        <dependency>
            <groupId>de.spqr-info</groupId>
            <artifactId>cups4j</artifactId>
            <version>1.1</version>
        </dependency>
```

# License

The original license applies which is [LGPL-3.0](https://opensource.org/licenses/GPL-3.0), ([cups4j/license](http://www.cups4j.org/index.php?option=com_content&view=article&id=8&Itemid=10)).

# Issue tracking

Feel free to report here any issues regarding the Maven packaging. All other issues are better handled on upstream (if any).

# Notes on releasing

- Follow the [OSSRH guide](http://central.sonatype.org/pages/apache-maven.html).
- Change the versions of the project with the help of the Maven versions plugin `mvn versions:set -DnewVersion=1.2.3`.
- Ensure that the build passes without deployment.
- Perform release `mvn clean deploy -Prelease`.
- Commit and push changes.
- Tag the release in git.
- Change versions of the project to the new SNAPSHOT release `mvn versions:set -DnewVersion=1.1-SNAPSHOT`.
- Commit and push changes.
