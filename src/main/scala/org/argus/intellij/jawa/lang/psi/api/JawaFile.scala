/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.psi.api

import com.intellij.psi.PsiClassOwnerEx
import com.intellij.psi.impl.source.PsiFileWithStubSupport
import org.argus.intellij.jawa.lang.psi.JawaPsiElement
import org.argus.intellij.jawa.lang.psi.api.toplevel.JawaToplevelElement
import org.jetbrains.annotations.Nullable

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
trait JawaFile extends JawaPsiElement with JawaToplevelElement with PsiClassOwnerEx with PsiFileWithStubSupport {
  def getPackageName: String

  @Nullable
  def packageName: String

  def isCompiled: Boolean

  def sourceName: String
}
