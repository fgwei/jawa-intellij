/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.jc.incremental.jawa
package local

import org.argus.jawa.compiler.compile.JawaCompiler
import org.argus.jc.incremental.jawa.data.CompilationData

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class IdeaIncrementalCompiler(javaVersion: String) extends AbstractCompiler {
  def compile(compilationData: CompilationData, client: Client): Unit = {
    val progress = getProgress(client)

    new JawaCompiler(javaVersion).compile(compilationData.sources.toArray, Seq(compilationData.output).toArray, None, progress)
  }

}