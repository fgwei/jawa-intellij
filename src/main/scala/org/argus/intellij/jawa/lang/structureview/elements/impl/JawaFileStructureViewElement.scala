/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.structureview.elements.impl

import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import org.argus.intellij.jawa.lang.psi.api.JawaFile
import org.argus.intellij.jawa.lang.structureview.elements.JawaStructureViewElement
import org.argus.intellij.jawa.lang.structureview.presentations.impl.JawaFileItemPresentation

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JawaFileStructureViewElement(file: JawaFile) extends JawaStructureViewElement(file, false) {
  override def getChildren: Array[TreeElement] = {
    file.typeDefinitionsArray.map{
      td =>
        new JawaClassStructureViewElement(td)
    }
  }

  override def getPresentation: ItemPresentation = new JawaFileItemPresentation(file)
}
