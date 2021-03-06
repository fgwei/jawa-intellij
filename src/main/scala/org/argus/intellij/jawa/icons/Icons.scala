/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.icons

import com.intellij.openapi.util.IconLoader

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
object Icons {
  final val FILE = IconLoader.getIcon("/org/argus/intellij/images/jawa.png")
  final val AbstractClass = IconLoader.getIcon("/nodes/abstractClass.png")
  final val Class = IconLoader.getIcon("/nodes/class.png")
  final val Interface = IconLoader.getIcon("/nodes/interface.png")
  final val Method = IconLoader.getIcon("/nodes/method.png")
  final val AbstractMethod = IconLoader.getIcon("/nodes/abstractMethod.png")
  final val Field = IconLoader.getIcon("/nodes/field.png")

  final val COMPILE_SERVER = IconLoader.getIcon("/org/argus/intellij/images/compileServer.png")

}
