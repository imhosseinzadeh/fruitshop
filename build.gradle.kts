plugins {
    id("java")
}

group = "com.imho"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
    compileOnly("org.hibernate:hibernate-jpamodelgen:6.6.15.Final")
    annotationProcessor("org.hibernate:hibernate-jpamodelgen:6.6.15.Final")

    implementation("org.postgresql:postgresql:42.7.5")
    implementation("org.hibernate.orm:hibernate-core:6.6.15.Final")
    implementation("org.hibernate.validator:hibernate-validator:8.0.2.Final")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}