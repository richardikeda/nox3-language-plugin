package com.enterscript.nox3languageplugin.services

import com.intellij.openapi.project.Project
import com.enterscript.nox3languageplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
