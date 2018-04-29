/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.compiler;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.project.Project;

/**
 * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
 */
public abstract class ServerWidgetEP {
    public static ExtensionPointName<ServerWidgetEP> EP_NAME = ExtensionPointName.create("org.argus.intellij.serverWidgetEP");

    public static ServerWidgetEP[] getAllWidgetEps() {
        return EP_NAME.getExtensions();
    }

    public abstract AnAction[] getAdditionalActions(Project project);
}