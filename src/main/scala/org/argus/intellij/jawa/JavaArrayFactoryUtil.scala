/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa

import com.intellij.util.ArrayFactory
import org.argus.intellij.jawa.lang.psi.JawaClassOrInterfaceDeclaration
import org.argus.intellij.jawa.lang.psi.api.base.JawaModifierList

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
object JavaArrayFactoryUtil {
  val JawaClassOrInterfaceDeclarationFactory: ArrayFactory[JawaClassOrInterfaceDeclaration] = new ArrayFactory[JawaClassOrInterfaceDeclaration]() {
    def create(count: Int): Array[JawaClassOrInterfaceDeclaration] = new Array[JawaClassOrInterfaceDeclaration](count)
  }
  var JawaModifierListFactory: ArrayFactory[JawaModifierList] = new ArrayFactory[JawaModifierList]() {
    def create(count: Int): Array[JawaModifierList] = new Array[JawaModifierList](count)
  }
}