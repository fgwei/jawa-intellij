/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.psi.types

/**
  * Created by fgwei on 6/30/16.
  */
object JawaTypePsiTypeBridge extends api.JawaTypePsiTypeBridge {
  override implicit lazy val typeSystem = JawaTypeSystem
}
