package com.github.richardikeda.nox3languageplugin.services

import com.github.richardikeda.nox3languageplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
