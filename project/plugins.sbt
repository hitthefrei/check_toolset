credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.19")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")
