
lazy val versions = new {
  val akka = "2.5.8"
  val akkaHttp = "10.0.11"
  val aws = "1.11.492"
  val finatra = "19.6.0"
  val finagleOauth = "19.2.0"
  val flyway = "5.2.4"
  val guava = "27.0.1-jre"
  val guice = "4.2.2"
  val hikariCP = "3.3.0"
  val httpClient = "4.5.2"
  val httpCore = "4.4.4"
  val jacksonModules = "2.9.8"
  val jodaConvert = "1.8.1"
  val jodaTime = "2.7"
  val jsr305 = "3.0.1"
  val logback = "1.2.3"
  val metrics = "4.0.5"
  val metricsGuice = "3.1.3"
  val mockitoCore = "2.23.4"
  val mysql = "8.0.15"
  val scalaGuice = "4.2.0"
  val scalaLangModules = "1.0.6"
  val scalalikejdbc = "3.3.2"
  val scalaTest = "3.0.5"
  val slf4j = "1.7.25"
  val specs2 = "2.4.17"
  val typesafeconfigGuice = "0.1.0"
}

val logsDependencies = Seq(
  "org.slf4j" % "slf4j-api" % versions.slf4j,
  "ch.qos.logback" % "logback-classic" % versions.logback,
  "ch.qos.logback.contrib" % "logback-json-classic" % "0.1.5" excludeAll
    ExclusionRule("ch.qos.logback"),
  "ch.qos.logback.contrib" % "logback-jackson" % "0.1.5"
)

val jacksonDependencies = Seq(
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % versions.jacksonModules excludeAll ExclusionRule("com.fasterxml.jackson.core")
)

val jdbcDependencies = Seq(
  "com.zaxxer" % "HikariCP" % versions.hikariCP,
  "mysql" % "mysql-connector-java" % versions.mysql,
  "org.flywaydb" % "flyway-core" % versions.flyway,
  "org.scalikejdbc" %% "scalikejdbc" % versions.scalalikejdbc withSources() withJavadoc(),
  "org.scalikejdbc" %% "scalikejdbc-test" % versions.scalalikejdbc % Test withSources() withJavadoc()
)

val metricsDependencies = Seq(
  "com.palominolabs.metrics" % "metrics-guice" % versions.metricsGuice,
  "io.dropwizard.metrics" % "metrics-annotation" % versions.metrics,
  "io.dropwizard.metrics" % "metrics-core" % versions.metrics,
  "io.dropwizard.metrics" % "metrics-graphite" % versions.metrics,
  "io.dropwizard.metrics" % "metrics-jvm" % versions.metrics,
  "io.dropwizard.metrics" % "metrics-logback" % versions.metrics
)

val awsDependencies = Seq(
  "com.amazonaws" % "aws-java-sdk-ssm" % versions.aws excludeAll(
    ExclusionRule("commons-logging"),
    ExclusionRule("com.fasterxml.jackson.core"),
    ExclusionRule("joda-time"))
)

// Finatra test jars must be manually imported in this way because they do not resolve transitively
val testDependencies = Seq(
  "com.twitter" %% "finatra-http" % versions.finatra % "test" withSources() withJavadoc(),
  "com.twitter" %% "finatra-jackson" % versions.finatra % "test" withSources() withJavadoc(),
  "com.twitter" %% "inject-server" % versions.finatra % "test" withSources() withJavadoc(),
  "com.twitter" %% "inject-app" % versions.finatra % "test" withSources() withJavadoc(),
  "com.twitter" %% "inject-core" % versions.finatra % "test" withSources() withJavadoc(),
  "com.twitter" %% "inject-modules" % versions.finatra % "test" withSources() withJavadoc(),
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",

  "com.twitter" %% "finatra-http" % versions.finatra % "test" classifier "tests" withSources() withJavadoc(),
  "com.twitter" %% "finatra-jackson" % versions.finatra % "test" classifier "tests" withSources() withJavadoc(),
  "com.twitter" %% "inject-server" % versions.finatra % "test" classifier "tests" withSources() withJavadoc(),
  "com.twitter" %% "inject-app" % versions.finatra % "test" classifier "tests" withSources() withJavadoc(),
  "com.twitter" %% "inject-core" % versions.finatra % "test" classifier "tests" withSources() withJavadoc(),
  "com.twitter" %% "inject-modules" % versions.finatra % "test" classifier "tests" withSources() withJavadoc(),
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test" classifier "tests",

  "org.mockito" % "mockito-core" % versions.mockitoCore % Test,
  "org.pegdown" % "pegdown" % "1.6.0" % Test,
  "org.scalatest" %% "scalatest" % versions.scalaTest % Test,
  "org.specs2" %% "specs2-core" % versions.specs2 % Test,
  "org.specs2" %% "specs2-junit" % versions.specs2 % Test,
  "org.specs2" %% "specs2-mock" % versions.specs2 % Test
)

// Manual overriding of a version to satisfy ConflictManager.strict configuration
val versionControl = Seq(
  "com.fasterxml.jackson.core" % "jackson-annotations" % versions.jacksonModules,
  "com.fasterxml.jackson.core" % "jackson-core" % versions.jacksonModules,
  "com.fasterxml.jackson.core" % "jackson-databind" % versions.jacksonModules,
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % versions.jacksonModules,
  "com.google.code.findbugs" % "jsr305" % versions.jsr305,
  "com.google.guava" % "guava" % versions.guava,
  "com.google.inject" % "guice" % versions.guice,
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",
  "com.twitter" %% "finagle-core" % versions.finatra,
  "com.twitter" %% "finagle-http" % versions.finatra,
  "com.typesafe.akka" %% "akka-actor" % versions.akka,
  "com.typesafe.akka" %% "akka-stream" % versions.akka,
  "com.typesafe.akka" %% "akka-testkit" % versions.akka % Test,
  "io.dropwizard.metrics" % "metrics-annotation" % versions.metrics,
  "io.dropwizard.metrics" % "metrics-core" % versions.metrics,
  "joda-time" % "joda-time" % versions.jodaTime,
  "junit" % "junit" % "4.12",
  "net.codingwell" %% "scala-guice" % versions.scalaGuice,
  "org.apache.httpcomponents" % "httpclient" % versions.httpClient,
  "org.apache.httpcomponents" % "httpcore" % versions.httpCore,
  "org.joda" % "joda-convert" % versions.jodaConvert,
  "org.mockito" % "mockito-core" % versions.mockitoCore % Test,
  "org.pegdown" % "pegdown" % "1.6.0" % Test,
  "org.scala-lang.modules" %% "scala-parser-combinators" % versions.scalaLangModules,
  "org.scala-lang.modules" %% "scala-xml" % versions.scalaLangModules,
  "org.scalatest" %% "scalatest" % versions.scalaTest % Test,
  "org.slf4j" % "slf4j-api" % versions.slf4j
)

val projectSettings = Seq(
  scalaVersion := "2.12.8",
  scalacOptions in ThisBuild ++= Seq(
    "-feature",
    "-unchecked",
    "-deprecation",
    "-language:postfixOps",
    "-language:implicitConversions",
    "-target:jvm-1.8"
  ),
  credentials += Credentials(Path.userHome / ".sbt" / ".credentials"),
  conflictManager := ConflictManager.strict,
  testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/report"),
  dependencyOverrides := versionControl
)

lazy val `checktoolset-server` = (project in file("checktoolset-server"))
  .enablePlugins(JavaServerAppPackaging)
  .settings(projectSettings: _*)
  .settings(
    name := "checktoolset-server",
    version := System.getProperty("version", "0.0.1"),
    parallelExecution in Test := true,
    organization := "com.zava",
    mainClass in(Compile, run) := Some("com.zava.checktoolset.Main"),
    libraryDependencies ++= logsDependencies ++ jacksonDependencies ++ awsDependencies ++ metricsDependencies
      ++ testDependencies ++ jdbcDependencies ++ Seq(
      "com.github.finagle" %% "finagle-oauth2" % versions.finagleOauth,
      "com.twitter" %% "finatra-http" % versions.finatra,
      "com.github.racc" % "typesafeconfig-guice" % versions.typesafeconfigGuice exclude("com.google.inject", "guice")
    ))
