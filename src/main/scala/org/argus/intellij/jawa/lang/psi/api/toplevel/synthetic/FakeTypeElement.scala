/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.psi.api.toplevel.synthetic

import com.intellij.lang.ASTNode
import com.intellij.psi._
import org.argus.intellij.jawa.lang.psi.JawaExpressionPsiElement
import org.argus.intellij.jawa.lang.psi.api.base.JawaTypeElement
import org.argus.intellij.jawa.lang.psi.types.JawaTypeSystem
import org.argus.jawa.core.JavaKnowledge

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class FakeTypeElement(node: ASTNode) extends JawaExpressionPsiElement(node) with JawaTypeElement{
  override def getType: PsiType = JawaTypeSystem.toPsiType(JavaKnowledge.OBJECT, getProject, getResolveScope)

  override def getInnermostComponentReferenceElement: PsiJavaCodeReferenceElement = null

  override def getApplicableAnnotations: Array[PsiAnnotation] = PsiAnnotation.EMPTY_ARRAY

  override def getAnnotations: Array[PsiAnnotation] = PsiAnnotation.EMPTY_ARRAY

  override def addAnnotation(qualifiedName: String): PsiAnnotation = this.addAfter(JavaPsiFacade.getInstance(this.getProject).getElementFactory.createAnnotationFromText("@" + qualifiedName, this), null).asInstanceOf

  override def findAnnotation(s: String): PsiAnnotation = null
}
