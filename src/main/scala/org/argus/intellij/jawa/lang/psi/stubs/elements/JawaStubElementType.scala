/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.psi.stubs.elements

import com.intellij.psi.{PsiElement, PsiFile}
import com.intellij.psi.stubs.{PsiFileStub, StubElement}
import org.argus.intellij.jawa.lang.psi.stubs.JawaFileStub
import org.argus.intellij.jawa.lang.psi.stubs.elements.wrappers.IStubElementTypeWrapper

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
abstract class JawaStubElementType[S <: StubElement[T], T <: PsiElement](debugName: String)
  extends IStubElementTypeWrapper[S, T](debugName) {
  def getExternalId = "jawa." + super.toString

  def isCompiled(stub: S) = {
    var parent = stub
    while (!parent.isInstanceOf[PsiFileStub[_ <: PsiFile]]) {
      parent = parent.getParentStub.asInstanceOf[S]
    }
    parent.asInstanceOf[JawaFileStub].isCompiled
  }

  override def isLeftBound = true
}
