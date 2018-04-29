/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.structureview.presentations.impl

import org.argus.intellij.jawa.lang.psi.api.JawaFile
import org.argus.intellij.jawa.lang.structureview.presentations.JawaItemPresentation

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JawaFileItemPresentation(element: JawaFile) extends JawaItemPresentation(element) {
  def getPresentableText: String = {
    element.getName
  }
}