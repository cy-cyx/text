package com.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

public class TextPlugin1 implements Plugin<Project> {
    void apply(Project project) {
        project.task('hello') {
            doLast {
                println "Hello World from the DemoPlugin"
            }
        }
    }
}
