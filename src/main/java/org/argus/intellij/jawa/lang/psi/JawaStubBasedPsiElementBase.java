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

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.ide.util.PsiNavigationSupport;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.pom.Navigatable;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import org.argus.intellij.jawa.lang.JawaLanguage;
import org.jetbrains.annotations.NotNull;

/**
 * @author <a href="mailto:fgwei521@gmail.com">Fengguo Wei</a>
 */
public class JawaStubBasedPsiElementBase<T extends StubElement> extends StubBasedPsiElementBase<T> implements JawaPsiElement {
    public JawaStubBasedPsiElementBase(@NotNull T stub, @NotNull IStubElementType nodeType) {
        super(stub, nodeType);
    }
    public JawaStubBasedPsiElementBase(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + getElementType().toString() + ")";
    }

    @Override
    public <Tp extends JawaPsiElement> Tp findChildByClassJawa(Class<Tp> clazz) {
        return findChildByClass(clazz);
    }

    @Override
    public <Tp extends JawaPsiElement> Tp[] findChildrenByClassJawa(Class<Tp> clazz) {
        return findChildrenByClass(clazz);
    }

    protected CompositeElement calcTreeElement() {
        return (CompositeElement)getNode();
    }

    @NotNull
    @Override
    public Language getLanguage() {
        return JawaLanguage.Instance;
    }

    @Override
    public int getTextOffset() {
        return this.calcTreeElement().getTextOffset();
    }

    @Override
    public void navigate(boolean requestFocus) {
        Navigatable navigatable = PsiNavigationSupport.getInstance().getDescriptor(this);
        if(navigatable != null) {
            navigatable.navigate(requestFocus);
        }

    }

    @Override
    public boolean canNavigate() {
        return PsiNavigationSupport.getInstance().canNavigate(this);
    }

    @Override
    public boolean canNavigateToSource() {
        return this.canNavigate();
    }

//    @Override
//    public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
//        return
//    }
}
