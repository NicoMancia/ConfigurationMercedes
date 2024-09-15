plugins {
    java
    application
    id("com.github.ben-manes.versions") version "0.47.0"
}

group = "com.example"
version = "1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.jena:jena-core:4.8.0")
    implementation("org.apache.jena:jena-arq:4.8.0")

    implementation("com.github.galigator.openllet:openllet-jena:2.6.5")

    // JavaFX dependencies for Windows
    implementation("org.openjfx:javafx-controls:20.0.2:win")
    implementation("org.openjfx:javafx-fxml:20.0.2:win")
    implementation("org.openjfx:javafx-base:20.0.2:win")
    implementation("org.openjfx:javafx-graphics:20.0.2:win")


    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")

    testImplementation("org.mockito:mockito-core:3.11.2")

}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("org.example.JavaFX.CarConfigurationApp")
    applicationDefaultJvmArgs = listOf(
            "--module-path", "C:\\Program Files\\JavaFX\\javafx-sdk-22.0.2\\lib",
            "--add-modules", "javafx.controls,javafx.fxml"
    )
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
