/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.debugger.breakpoints

import com.intellij.debugger.engine.{DebugProcessImpl, JavaBreakpointHandler, JavaBreakpointHandlerFactory}

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JawaBreakpointHandlerFactory extends JavaBreakpointHandlerFactory {
  override def createHandler(process: DebugProcessImpl): JavaBreakpointHandler = new JawaBreakpointHandler(process)
}

class JawaBreakpointHandler(process: DebugProcessImpl) extends JavaBreakpointHandler(classOf[JawaLineBreakpointType], process)