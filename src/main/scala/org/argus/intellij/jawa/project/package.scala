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

import com.intellij.openapi.module.{Module, ModuleManager}
import com.intellij.openapi.project.Project
import org.argus.intellij.jawa.lang.psi.types.JawaTypeSystem
import org.argus.intellij.jawa.lang.psi.types.api.TypeSystem

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
package object project {
  implicit class ProjectExt(val project: Project) extends AnyVal {
    private def modules: Seq[Module] = ModuleManager.getInstance(project).getModules.toSeq

    def jawaEvents: JawaProjectEvents = project.getComponent(classOf[JawaProjectEvents])

    def typeSystem: TypeSystem = JawaTypeSystem
  }
}
