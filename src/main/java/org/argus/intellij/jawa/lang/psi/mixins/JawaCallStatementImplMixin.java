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
import com.intellij.psi.*;
import com.intellij.psi.impl.source.tree.java.PsiReferenceParameterListImpl;
import org.argus.intellij.jawa.lang.psi.JawaCallStatement;
import org.argus.intellij.jawa.lang.psi.JawaExpressionPsiElement;
import org.argus.intellij.jawa.lang.psi.types.JawaTypeSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
 */
public abstract class JawaCallStatementImplMixin extends JawaExpressionPsiElement implements JawaCallStatement {

    public JawaCallStatementImplMixin(@NotNull ASTNode node) {
        super(node);
    }

    @NotNull
    @Override
    public PsiExpressionList getArgumentList() {
        return getArgClause();
    }

    @Nullable
    @Override
    public PsiMethod resolveMethod() {
        return (PsiMethod)getMethodExpression().resolve();
    }

    @NotNull
    @Override
    public JavaResolveResult resolveMethodGenerics() {
        return getMethodExpression().advancedResolve(false);
    }

    @NotNull
    @Override
    public PsiReferenceExpression getMethodExpression() {
        return getMethodNameSymbol();
    }

    @NotNull
    @Override
    public PsiReferenceParameterList getTypeArgumentList() {
        return new PsiReferenceParameterListImpl();
    }

    @NotNull
    @Override
    public PsiType[] getTypeArguments() {
        return new PsiType[0];
    }

    @Nullable
    @Override
    public PsiType getType() {
        return JawaTypeSystem.toPsiType(getSignatureAnnotation().getSignatureSymbol().getSignature().getReturnType(), getProject(), getResolveScope());
    }

    @Override
    public String toString() {
        return "JawaCallStatement:" + this.getText();
    }
}
