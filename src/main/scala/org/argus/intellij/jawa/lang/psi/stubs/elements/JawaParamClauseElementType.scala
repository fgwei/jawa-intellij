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

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.{IndexSink, StubElement, StubInputStream, StubOutputStream}
import org.argus.intellij.jawa.lang.psi.JawaParamClause
import org.argus.intellij.jawa.lang.psi.impl.JawaParamClauseImpl
import org.argus.intellij.jawa.lang.psi.stubs.{JawaParamClauseStub, JawaStubElementTypes}
import org.argus.intellij.jawa.lang.psi.stubs.impl.JawaParamClauseStubImpl

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JawaParamClauseElementType(debugName: String) extends JawaStubElementType[JawaParamClauseStub, JawaParamClause](debugName) {
  def serialize(stub: JawaParamClauseStub, dataStream: StubOutputStream) {
  }

  def deserializeImpl(dataStream: StubInputStream, parentStub: Any): JawaParamClauseStub = {
    new JawaParamClauseStubImpl(parentStub.asInstanceOf[StubElement[PsiElement]], this)
  }

  def createPsi(stub: JawaParamClauseStub): JawaParamClause = {
    new JawaParamClauseImpl(stub, JawaStubElementTypes.PARAM_CLAUSE)
  }

  def createStubImpl[ParentPsi <: PsiElement](psi: JawaParamClause, parentStub: StubElement[ParentPsi]): JawaParamClauseStub = {
    new JawaParamClauseStubImpl(parentStub, this)
  }

  override def indexStub(t: JawaParamClauseStub, indexSink: IndexSink): Unit = {}
}
