package com.enterscript.nox3languageplugin.language

import com.enterscript.nox3languageplugin.language.psi.NOX3Property
import com.enterscript.nox3languageplugin.language.psi.NOX3Variable
import com.enterscript.nox3languageplugin.language.psi.stubs.NOX3PropertyStubElementType
import com.enterscript.nox3languageplugin.language.psi.stubs.NOX3VariableStubElementType
import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex

open class NOX3Util {
    companion object {
        fun findVariables(project: Project, name: String): Collection<NOX3Variable> =
            StubIndex.getElements(
                NOX3VariableStubElementType.INDEX_KEY,
                name,
                project,
                GlobalSearchScope.allScope(project),
                NOX3Variable::class.java
            )

        fun findVariables(project: Project): Collection<NOX3Variable> {
            val index = StubIndex.getInstance()
            val scope = GlobalSearchScope.allScope(project)
            val key = NOX3VariableStubElementType.INDEX_KEY
            val result = mutableListOf<NOX3Variable>()
            for (variableName in index.getAllKeys(key, project)) {
                result.addAll(index.getElements(key, variableName, project, scope, NOX3Variable::class.java))
            }
            return result
        }

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
