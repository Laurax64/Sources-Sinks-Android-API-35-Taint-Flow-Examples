# Sources-Sinks-Android-API-35-Taint-Flow-Examples
An app designed to demonstrate the usability of the [Sources-Sinks-Android-API-35](https://github.com/Laurax64/Sources-Sinks-Android-API-35) documentation with FlowDroid. This app includes API 35 taint flows, meaning connections between sensitive sources and sinks. 

## Usage with [FlowDroid](https://github.com/secure-software-engineering/FlowDroid) (Does not work for me see [#793](https://github.com/secure-software-engineering/FlowDroid/issues/793))
1. Open this project in Android Studio and extract the APK.
2. Android Studio -> IDE and Project Settings -> Settings -> Android SDK Location
3. Open Android SDK Location in your file explorer.
4. Open platforms/android-35. The path should look something like this /Users/username/Library/Android/sdk/platforms/android-35.
5. Download the SourcesSinks file by clicking on the *Export to FlowDroid* button in [Sources-Sinks-Android-API-35 web page](https://laurax64.github.io/Sources-Sinks-Android-API-35/).
6. Open Visual Studio Code.
7. Execute the following code in the terminal in the IDE.
```
java -jar soot-infoflow-cmd/target/soot-infoflow-cmd-jar-with-dependencies.jar \
    -a <APK File> \
    -p <Android JAR folder> \
    -s <SourcesSinks file>
```
`<APK File>` is the path from 1. `<Android JAR folder>` is the path from 4. `<SourcesSinks file>` is the path from 5.
