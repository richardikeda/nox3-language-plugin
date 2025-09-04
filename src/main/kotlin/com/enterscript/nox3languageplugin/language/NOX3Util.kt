package com.enterscript.nox3languageplugin.language

import com.enterscript.nox3languageplugin.language.psi.NOX3Property
import com.enterscript.nox3languageplugin.language.psi.stubs.NOX3PropertyStubElementType
import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex

open class NOX3Util {
    companion object {
        fun findProperties(project: Project, name: String): Collection<NOX3Property> =
            StubIndex.getElements(
                NOX3PropertyStubElementType.INDEX_KEY,
                name,
                project,
                GlobalSearchScope.allScope(project),
                NOX3Property::class.java
            )

        fun findProperties(project: Project): Collection<NOX3Property> {
            val index = StubIndex.getInstance()
            val scope = GlobalSearchScope.allScope(project)
            val key = NOX3PropertyStubElementType.INDEX_KEY
            val result = mutableListOf<NOX3Property>()
            for (propertyName in index.getAllKeys(key, project)) {
                result.addAll(index.getElements(key, propertyName, project, scope, NOX3Property::class.java))
            }
            return result
        }
    }
}
