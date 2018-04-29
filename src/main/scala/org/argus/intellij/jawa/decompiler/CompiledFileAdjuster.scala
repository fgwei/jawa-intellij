/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.decompiler

import com.intellij.openapi.vfs.VirtualFile

/**
 * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
 */
trait CompiledFileAdjuster {

  protected var sourceFileName : String = ""
  protected var compiled = false
  protected var virtualFile: VirtualFile = null

  private[decompiler] def setSourceFileName(s: String) {
    sourceFileName = s
  }

  private[decompiler] def setCompiled(c: Boolean) {
    compiled = c
  }

  private[decompiler] def setVirtualFile(vf: VirtualFile) {
    virtualFile = vf
  }

}