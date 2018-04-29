/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.psi.stubs;

import com.intellij.psi.impl.java.stubs.PsiClassStub;
import org.argus.intellij.jawa.lang.psi.JawaClassOrInterfaceDeclaration;

/**
 * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
 */
public interface JawaClassOrInterfaceStub extends PsiClassStub<JawaClassOrInterfaceDeclaration> {

    String javaQualName();

    String sourceFileName();

    /**
     * Only method names without values and variables.
     * @return method names
     */
    String[] methodNames();

    String javaName();
}
