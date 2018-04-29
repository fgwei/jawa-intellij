/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.psi.stubs.impl

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.{IStubElementType, StubElement}
import com.intellij.util.ArrayUtil
import org.argus.intellij.jawa.lang.psi.JawaAccessFlagAnnotation
import org.argus.intellij.jawa.lang.psi.stubs.JawaAccessFlagStub

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JawaAccessFlagStubImpl[ParentPsi <: PsiElement](parent: StubElement[ParentPsi],
                                                      elemType: IStubElementType[_ <: StubElement[_ <: PsiElement], _ <: PsiElement],
                                                      modifiers: Array[String] = ArrayUtil.EMPTY_STRING_ARRAY, explicitModifiers: Boolean = false)
  extends StubBaseWrapper[JawaAccessFlagAnnotation](parent, elemType) with JawaAccessFlagStub {
  def getModifiers: Array[String] = modifiers

  def hasExplicitModifiers: Boolean = explicitModifiers
}
