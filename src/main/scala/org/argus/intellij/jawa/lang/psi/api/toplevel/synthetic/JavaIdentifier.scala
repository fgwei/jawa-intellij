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

import com.intellij.psi.PsiElement
import com.intellij.psi.impl.light.LightIdentifier

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JavaIdentifier(jawaId : PsiElement) extends LightIdentifier(jawaId.getManager, jawaId.getText) {
  override def getTextRange = jawaId.getTextRange

  override def getStartOffsetInParent: Int = jawaId.getStartOffsetInParent

  override def getTextOffset: Int = jawaId.getTextOffset

  override def getContainingFile = jawaId.getContainingFile

  override def getParent = jawaId.getParent

  override def getPrevSibling: PsiElement = jawaId.getPrevSibling

  override def getNextSibling: PsiElement = jawaId.getNextSibling

  override def copy: PsiElement = new JavaIdentifier(jawaId)

  override def getNavigationElement: PsiElement = jawaId

  override def isValid: Boolean = jawaId.isValid
}