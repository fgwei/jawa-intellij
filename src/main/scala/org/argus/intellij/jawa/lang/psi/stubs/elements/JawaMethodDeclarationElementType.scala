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

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.cache.RecordUtil
import com.intellij.psi.impl.java.stubs.index.JavaStubIndexKeys
import com.intellij.psi.stubs.{IndexSink, StubElement, StubInputStream, StubOutputStream}
import org.argus.intellij.jawa.lang.psi.JawaMethodDeclaration
import org.argus.intellij.jawa.lang.psi.impl.JawaMethodDeclarationImpl
import org.argus.intellij.jawa.lang.psi.stubs.impl.JawaMethodStubImpl
import org.argus.intellij.jawa.lang.psi.stubs.{JawaMethodStub, JawaStubElementTypes}

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JawaMethodDeclarationElementType(debugName: String) extends JawaStubElementType[JawaMethodStub, JawaMethodDeclaration](debugName) {
  override def createStubImpl[ParentPsi <: PsiElement](psi: JawaMethodDeclaration, parent: StubElement[ParentPsi]): JawaMethodStub = {
    val sigText = psi.getSignatureAnnotation.getSignatureSymbol.getSignature.signature
    new JawaMethodStubImpl[ParentPsi](parent, this, psi.name, sigText)
  }

  def serialize(stub: JawaMethodStub, dataStream: StubOutputStream) {
    dataStream.writeName(stub.getName)
    dataStream.writeName(stub.getSignatureText)
  }

  override def deserializeImpl(dataStream: StubInputStream, parentStub: Any): JawaMethodStub = {
    val name = dataStream.readName
    val sigText = dataStream.readName
    val parent = parentStub.asInstanceOf[StubElement[PsiElement]]
    new JawaMethodStubImpl(parent, this, name, sigText)
  }

  def indexStub(stub: JawaMethodStub, sink: IndexSink) = {
    val name = stub.getName
    if (name != null) {
      sink.occurrence(JavaStubIndexKeys.METHODS, name)
      if (RecordUtil.isStaticNonPrivateMember(stub)) {
        sink.occurrence(JavaStubIndexKeys.JVM_STATIC_MEMBERS_NAMES, name)
        sink.occurrence(JavaStubIndexKeys.JVM_STATIC_MEMBERS_TYPES, stub.getSignature.getReturnType.simpleName)
      }
    }
  }

  def createElement(node: ASTNode): PsiElement = new JawaMethodDeclarationImpl(node)

  def createPsi(stub: JawaMethodStub) = new JawaMethodDeclarationImpl(stub, JawaStubElementTypes.METHOD)
}
