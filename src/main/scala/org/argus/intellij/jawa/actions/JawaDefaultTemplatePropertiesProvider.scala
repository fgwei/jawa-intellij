/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.actions

import java.util.Properties

import com.intellij.ide.fileTemplates.{FileTemplate, TemplatePackagePropertyProvider}
import com.intellij.psi.PsiDirectory

/**
  * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
  */
class JawaDefaultTemplatePropertiesProvider extends TemplatePackagePropertyProvider {
  private val QualifiedPackagePattern = "(.+)\\.(.+?)".r

  override def fillProperties(directory: PsiDirectory, props: Properties) {
    super.fillProperties(directory, props)

    val attributePackageName = props.get(FileTemplate.ATTRIBUTE_PACKAGE_NAME) match {
      case name: String => name
      case _ => return
    }

    val (packageQualifier, packageSimpleName) = attributePackageName match {
      case QualifiedPackagePattern(prefix, suffix) => (prefix, suffix)
      case name =>("", name)
    }

    props.put("PACKAGE_QUALIFIER", packageQualifier)
    props.put("PACKAGE_SIMPLE_NAME", packageSimpleName)
  }
}