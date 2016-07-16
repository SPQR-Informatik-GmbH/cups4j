# Preamble

CUPS library for Java forked an mavenized from http://www.cups4j.org version 0.6.4. The reason for the fork is that the original project is unmaintained since 2013, and no maven artifact exists to use the library.

The original upstream developers have not been contacted to approve this fork, because the project is published under GPL-3.0.

# Release mapping

- Upstream release 0.6.4 maps directly to de.spqrinfo.cups4j:1.0-RELEASE

# Changes

The following changes where applied to the upstream source to upstream source 0.6.4:
- mavenize project, by splitting into three separate artifacts
- move resources where they belong
- change package to `de.sprinfo.cups4j`
- fix class loading by replacing explicit classLoader usage to load resources
- create test case to ensure loading of xml schema files succeeds

# Licesnse

The original licesnse applies which is [GPL-3.0](https://opensource.org/licenses/GPL-3.0).
