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

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import org.argus.intellij.jawa.highlighter.AnnotatorHighlighter
import org.argus.intellij.jawa.lang.psi._

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JawaHighlightingAnnotator extends JawaAnnotator {
  override def annotate(psiElement: PsiElement, annotationHolder: AnnotationHolder): Unit = psiElement.accept(new JawaVisitor{
    override def visitTypeDefSymbol(o: JawaTypeDefSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitTypeDefSymbol(o)
    }
    override def visitTypeSymbol(o:JawaTypeSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitTypeSymbol(o)
    }
    override def visitVarDefSymbol(o: JawaVarDefSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitVarDefSymbol(o)
    }
    override def visitVarSymbol(o:JawaVarSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitVarSymbol(o)
    }
    override def visitFieldDefSymbol(o: JawaFieldDefSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitFieldDefSymbol(o)
    }
    override def visitFieldNameSymbol(o:JawaFieldNameSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitFieldNameSymbol(o)
    }
    override def visitStaticFieldDefSymbol(o: JawaStaticFieldDefSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitStaticFieldDefSymbol(o)
    }
    override def visitStaticFieldNameSymbol(o:JawaStaticFieldNameSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitStaticFieldNameSymbol(o)
    }
    override def visitMethodDefSymbol(o: JawaMethodDefSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitMethodDefSymbol(o)
    }
    override def visitMethodNameSymbol(o:JawaMethodNameSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitMethodNameSymbol(o)
    }
    override def visitLocationDefSymbol(o: JawaLocationDefSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitLocationDefSymbol(o)
    }
    override def visitLocationSymbol(o:JawaLocationSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitLocationSymbol(o)
    }
    override def visitDefaultAnnotation(o: JawaDefaultAnnotation): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitDefaultAnnotation(o)
    }
    override def visitNumberLiteral(o: JawaNumberLiteral): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitNumberLiteral(o)
    }
    override def visitParam(o: JawaParam): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitParam(o)
    }
    override def visitSignatureSymbol(o: JawaSignatureSymbol): Unit = {
      AnnotatorHighlighter.highlightElement(o, annotationHolder)
      super.visitSignatureSymbol(o)
    }
  })
}