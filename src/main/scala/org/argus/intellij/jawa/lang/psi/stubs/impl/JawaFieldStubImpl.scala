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
import com.intellij.util.io.StringRef
import org.argus.intellij.jawa.lang.psi.JawaFieldDeclaration
import org.argus.intellij.jawa.lang.psi.stubs.JawaFieldStub
import org.argus.jawa.core.{JavaKnowledge, JawaType}

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JawaFieldStubImpl[ParentPsi <: PsiElement](parent: StubElement[ParentPsi],
                                                 elemType: IStubElementType[_ <: StubElement[_ <: PsiElement], _ <: PsiElement])
  extends StubBaseWrapper[JawaFieldDeclaration](parent, elemType) with JawaFieldStub {

  private var name: StringRef = _
  private var FQN: StringRef = _
  private var typ: StringRef = _
  private var flag: Int = _

  def this(parent: StubElement[ParentPsi],
           elemType: IStubElementType[_ <: StubElement[_ <: PsiElement], _ <: PsiElement],
           name: String, FQN: String, typ: String, flag: Int) = {
    this(parent, elemType.asInstanceOf[IStubElementType[StubElement[PsiElement], PsiElement]])
    this.name = StringRef.fromString(name)
    this.FQN = StringRef.fromString(FQN)
    this.typ = StringRef.fromString(typ)
    this.flag = flag
  }

  def this(parent: StubElement[ParentPsi],
           elemType: IStubElementType[_ <: StubElement[_ <: PsiElement], _ <: PsiElement],
           name: StringRef, FQN: StringRef, typ: StringRef, flag: Int) = {
    this(parent, elemType.asInstanceOf[IStubElementType[StubElement[PsiElement], PsiElement]])
    this.name = name
    this.FQN = FQN
    this.typ = typ
    this.flag = flag
  }

  override def getName: String = StringRef.toString(name)
  override def getFQN: String = StringRef.toString(FQN)
  override def getType: JawaType = JavaKnowledge.getTypeFromName(StringRef.toString(typ))
  override def getFlag: Int = flag
}
