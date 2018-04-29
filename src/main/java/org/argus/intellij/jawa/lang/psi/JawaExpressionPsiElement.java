/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
 */
public class JawaExpressionPsiElement extends ASTWrapperPsiElement implements JawaPsiElement {
    private static final Logger LOG = Logger.getInstance("#org.argus.intellij.jawa.lang.psi.JawaExpressionPsiElement");

    public JawaExpressionPsiElement(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public <Tp extends JawaPsiElement> Tp findChildByClassJawa(Class<Tp> clazz) {
        return findChildByClass(clazz);
    }

    @Override
    public <Tp extends JawaPsiElement> Tp[] findChildrenByClassJawa(Class<Tp> clazz) {
        return findChildrenByClass(clazz);
    }
}
