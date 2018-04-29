/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.project

import com.intellij.ProjectTopics
import com.intellij.openapi.components.AbstractProjectComponent
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.{ModuleRootEvent, ModuleRootListener}

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JawaProjectEvents(project: Project) extends AbstractProjectComponent(project) {
  private var listeners: List[JawaProjectListener] = Nil

  private val connection = project.getMessageBus.connect()

  override def projectOpened(): Unit = {
    connection.subscribe(ProjectTopics.PROJECT_ROOTS, new ModuleRootListener {
      override def rootsChanged(event: ModuleRootEvent) {
        listeners.foreach(_.onJawaProjectChanged())
      }
    })
  }

  override def projectClosed() {
    listeners = Nil
    connection.disconnect()
  }

  def addJawaProjectListener(listener: JawaProjectListener) {
    listeners ::= listener
  }

  def removeJawaProjectListener(listener: JawaProjectListener) {
    listeners = listeners.filterNot(_ == listener)
  }
}

trait JawaProjectListener {
  def onJawaProjectChanged()
}