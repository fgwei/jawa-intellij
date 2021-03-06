/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.jc.incremental.jawa.model

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
object CompileOrder extends Enumeration {
  val JAVA_THEN_JAWA, JAWA_THEN_JAVA = Value
}
