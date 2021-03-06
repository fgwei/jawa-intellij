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

import com.intellij.ide.structureView.{StructureViewModel, StructureViewTreeElement, TextEditorBasedStructureViewModel}
import com.intellij.ide.util.treeView.smartTree.Sorter
import org.argus.intellij.jawa.lang.psi.api.JawaFile
import org.argus.intellij.jawa.lang.psi.impl.JawaFileImpl
import org.argus.intellij.jawa.lang.structureview.elements.impl.JawaFileStructureViewElement

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JawaStructureViewModel(psiFile: JawaFile) extends TextEditorBasedStructureViewModel(psiFile) with StructureViewModel.ElementInfoProvider {

  override def getSorters: Array[Sorter] = List(Sorter.ALPHA_SORTER).toArray

  override def isAlwaysLeaf(element: StructureViewTreeElement): Boolean = element.isInstanceOf[JawaFileImpl]

  override def isAlwaysShowsPlus(structureViewTreeElement: StructureViewTreeElement): Boolean = false

  override def getRoot: StructureViewTreeElement = new JawaFileStructureViewElement(psiFile)
}
