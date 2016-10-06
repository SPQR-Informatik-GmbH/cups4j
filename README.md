# Description

A Java library for printing with [IPP](https://en.wikipedia.org/wiki/Internet_Printing_Protocol) to a [CUPS](https://en.wikipedia.org/wiki/CUPS) server.

# Preamble

CUPS library for Java, forked and mavenized from http://www.cups4j.org/ version 0.6.4. The reason for the fork is that the original project is unmaintained since 2013, and no maven artifact exists to use the library.

The original upstream developers have not been contacted to approve this fork, since the project is published as GPL-3.0.

# Release mapping

- Upstream release 0.6.4 maps directly to de.spqrinfo.cups4j:1.0-RELEASE

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

# License

The original license applies which is [LGPL-3.0](https://opensource.org/licenses/GPL-3.0), ([cups4j/license](http://www.cups4j.org/index.php?option=com_content&view=article&id=8&Itemid=10)).
