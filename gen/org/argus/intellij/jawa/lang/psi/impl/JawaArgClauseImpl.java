// This is a generated file. Not intended for manual editing.
package org.argus.intellij.jawa.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.argus.intellij.jawa.lang.psi.JawaElementTypes.*;
import org.argus.intellij.jawa.lang.psi.mixins.JawaArgClauseImplMixin;
import org.argus.intellij.jawa.lang.psi.*;

public class JawaArgClauseImpl extends JawaArgClauseImplMixin implements JawaArgClause {

  public JawaArgClauseImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JawaVisitor visitor) {
    visitor.visitArgClause(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JawaVisitor) accept((JawaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<JawaVarSymbol> getVarSymbolList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JawaVarSymbol.class);
  }

}
