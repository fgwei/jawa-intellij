/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.hierarchy

import com.intellij.ide.hierarchy.{CallHierarchyBrowserBase, HierarchyBrowser}
import com.intellij.ide.hierarchy.call.JavaCallHierarchyProvider
import com.intellij.psi.{PsiElement, PsiMethod}

/**
  * Created by fgwei on 7/16/16.
  */
class JawaCallHierarchyProvider extends JavaCallHierarchyProvider {
  override def browserActivated(hierarchyBrowser: HierarchyBrowser): Unit = {
    hierarchyBrowser.asInstanceOf[JawaCallHierarchyBrowser].changeView(CallHierarchyBrowserBase.CALLER_TYPE)
  }

  override def createHierarchyBrowser(target: PsiElement): HierarchyBrowser = {
    new JawaCallHierarchyBrowser(target.getProject, target.asInstanceOf[PsiMethod])
  }
}