/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.structureview

import com.intellij.ide.structureView.{StructureViewModel, TreeBasedStructureViewBuilder}
import com.intellij.openapi.editor.Editor
import org.argus.intellij.jawa.lang.psi.api.JawaFile

/**
  * Created by fgwei on 6/26/16.
  */
class JawaStructureViewBuilder(private val myPsiFile: JawaFile) extends TreeBasedStructureViewBuilder {
  override def createStructureViewModel(editor: Editor): StructureViewModel = {
    new JawaStructureViewModel(myPsiFile)
  }

  override def isRootNodeShown: Boolean = false
}
