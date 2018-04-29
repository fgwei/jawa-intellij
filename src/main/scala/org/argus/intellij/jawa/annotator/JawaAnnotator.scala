/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.annotator

import com.intellij.lang.annotation.{Annotation, Annotator}
import com.intellij.openapi.editor.colors.{CodeInsightColors, EditorColorsManager, EditorColorsScheme, TextAttributesKey}
import com.intellij.openapi.editor.markup.TextAttributes
import org.argus.intellij.jawa.highlighter.JawaSyntaxHighlighter

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
abstract class JawaAnnotator extends Annotator {
  val currentScheme: EditorColorsScheme = EditorColorsManager.getInstance().getGlobalScheme
  def adjustTextAttributes(textAttributes: TextAttributes, isBuiltIn: Boolean, isDeprecated: Boolean): TextAttributes = {
    var newtextAttributes: TextAttributes = textAttributes
    if(isBuiltIn) newtextAttributes = TextAttributes.merge(newtextAttributes, JawaSyntaxHighlighter.BOLD)
    if(isDeprecated) newtextAttributes = TextAttributes.merge(newtextAttributes, currentScheme.getAttributes(CodeInsightColors.DEPRECATED_ATTRIBUTES))
    newtextAttributes
  }
  def decorateElement(annotation: Annotation, key: TextAttributesKey, builtin: Boolean, deprecated: Boolean): Unit = {
    annotation.setEnforcedTextAttributes(adjustTextAttributes(currentScheme.getAttributes(key), builtin, deprecated))
  }
}