/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.psi.mixins;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import org.argus.intellij.jawa.lang.psi.JawaMethodNameSymbol;
import org.argus.intellij.jawa.lang.psi.JawaReferenceExpressionPsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
 */
public abstract class JawaSignatureSymbolImplMixin extends JawaReferenceExpressionPsiElement implements JawaMethodNameSymbol {
    public JawaSignatureSymbolImplMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Nullable
    @Override
    public PsiElement getReferenceNameElement() {
        return getApostropheId();
    }

    @Override
    public TextRange getRangeInElement() {
        return new TextRange(getApostropheId().getStartOffsetInParent(), getTextLength());
    }

    @Override
    public String toString() {
        return "JawaSignatureSymbol:" + getText();
    }
}
