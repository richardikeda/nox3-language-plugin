package com.enterscript.noX3LanguagePlugin.language


import com.enterscript.noX3LanguagePlugin.icons.NOX3Icons
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLiteralExpression
import com.intellij.psi.impl.source.tree.java.PsiJavaTokenImpl
import com.enterscript.noX3LanguagePlugin.language.psi.NOX3Property

import org.jetbrains.annotations.NotNull


class NOX3LineMarkerProvider : RelatedItemLineMarkerProvider() {

    override fun collectNavigationMarkers(
        @NotNull element: PsiElement,
        @NotNull result: MutableCollection<in RelatedItemLineMarkerInfo<*>?>
    ) {
        // This must be an element with a literal expression as a parent
        if (element !is PsiJavaTokenImpl || element.getParent() !is PsiLiteralExpression) {
            return
        }

        // The literal expression must start with the Simple language literal expression
        val literalExpression: PsiLiteralExpression = element.getParent() as PsiLiteralExpression
        val value = if (literalExpression.value is String) literalExpression.value else null
        if (value == null ||
            !value.toString().startsWith(NOX3Annotator.NOX3_PREFIX_STR + NOX3Annotator.NOX3_SEPARATOR_STR)
        ) {
            return
        }

        // Get the Simple language property usage
        val project: Project = element.getProject()
        val possibleProperties: String = value.toString().substring(
            NOX3Annotator.NOX3_PREFIX_STR.length + NOX3Annotator.NOX3_SEPARATOR_STR.length
        )
        val properties: List<NOX3Property> = NOX3Util.findProperties(project, possibleProperties)
        if (properties.isNotEmpty()) {
            // Add the property to a collection of line marker info
            val builder: NavigationGutterIconBuilder<PsiElement> = NavigationGutterIconBuilder.create(NOX3Icons.Icon.FileType)
                .setTargets(properties)
                .setTooltipText("Navigate to X3 language property")
            result.add(builder.createLineMarkerInfo(element))
        }
    }

}