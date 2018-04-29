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

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiType
import com.intellij.psi.search.GlobalSearchScope
import org.argus.jawa.core.JawaType

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
object JawaTypeSystem extends api.TypeSystem {
  override val name = "Jawa"
  override lazy val bridge: JawaTypePsiTypeBridge.type = JawaTypePsiTypeBridge
  protected override lazy val presentation: JawaTypePresentation.type = JawaTypePresentation

  def toPsiType(`type`: JawaType, project: Project,
                scope: GlobalSearchScope): PsiType = `type`.toPsiType(project, scope)
}
