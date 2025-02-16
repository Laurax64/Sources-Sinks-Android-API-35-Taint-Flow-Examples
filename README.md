# Sources-Sinks-Android-API-35-Taint-Flow-Examples
An app designed to demonstrate the usability of the Sources-Sinks-Android-API-35 documentation with FlowDroid. This app includes API 35 taint flows, meaning connections between sensitive sources and sinks. 

# FlowDroid Tutorial
java -jar soot-infoflow-cmd/target/soot-infoflow-cmd-jar-with-dependencies.jar \
    -a <APK File> \
    -p <Android JAR folder> \
    -s <SourcesSinks file>
