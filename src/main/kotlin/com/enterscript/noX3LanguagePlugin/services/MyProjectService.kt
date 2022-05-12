package com.enterscript.noX3LanguagePlugin.services

import com.intellij.openapi.project.Project
import com.enterscript.noX3LanguagePlugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
