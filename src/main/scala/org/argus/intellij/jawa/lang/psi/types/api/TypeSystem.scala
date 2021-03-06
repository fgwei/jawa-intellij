/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.psi.types.api

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
trait TypeSystem {
  val name: String
  val bridge: JawaTypePsiTypeBridge
  protected val presentation: JawaTypePresentation

  def presentableText = presentation.presentableText _

  def canonicalText = presentation.canonicalText _
}

trait TypeSystemOwner {
  implicit val typeSystem: TypeSystem
}

//trait TypeInTypeSystem extends JawaType with TypeSystemOwner {
//  override final def presentableText = typeSystem.presentableText(this)
//
//  override final def canonicalText = typeSystem.canonicalText(this)
//}