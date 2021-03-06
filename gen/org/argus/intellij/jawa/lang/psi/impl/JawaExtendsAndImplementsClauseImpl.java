// This is a generated file. Not intended for manual editing.
package org.argus.intellij.jawa.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.argus.intellij.jawa.lang.psi.JawaElementTypes.*;
import org.argus.intellij.jawa.lang.psi.mixins.JawaExtendsAndImplementsClauseImplMixin;
import org.argus.intellij.jawa.lang.psi.*;
import org.argus.intellij.jawa.lang.psi.stubs.JawaExtendsAndImplementsClauseStub;
import com.intellij.psi.stubs.IStubElementType;

public class JawaExtendsAndImplementsClauseImpl extends JawaExtendsAndImplementsClauseImplMixin implements JawaExtendsAndImplementsClause {

  public JawaExtendsAndImplementsClauseImpl(JawaExtendsAndImplementsClauseStub stub, IStubElementType type) {
    super(stub, type);
  }

  public JawaExtendsAndImplementsClauseImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JawaVisitor visitor) {
    visitor.visitExtendsAndImplementsClause(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JawaVisitor) accept((JawaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<JawaExtendAndImplement> getExtendAndImplementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JawaExtendAndImplement.class);
  }

}
