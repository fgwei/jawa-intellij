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

import org.argus.jc.incremental.jawa.data.{CompilationData, CompilerData}
import org.jetbrains.jps.incremental.ModuleLevelBuilder.ExitCode

/**
 * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
 */
trait Server {
  def compile(compilerData: CompilerData, compilationData: CompilationData, client: Client): ExitCode
}