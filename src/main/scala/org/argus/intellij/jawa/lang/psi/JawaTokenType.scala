/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.psi

import com.intellij.psi.tree.IElementType
import org.argus.intellij.jawa.lang.JawaFileType

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
case class JawaTokenType(debugName: String) extends IElementType(debugName, JawaFileType.JAWA_LANGUAGE) {
  override def toString: String = debugName
}
