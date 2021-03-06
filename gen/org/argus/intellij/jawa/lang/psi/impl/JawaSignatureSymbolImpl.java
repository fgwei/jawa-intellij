// This is a generated file. Not intended for manual editing.
package org.argus.intellij.jawa.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.argus.intellij.jawa.lang.psi.JawaElementTypes.*;
import org.argus.intellij.jawa.lang.psi.mixins.JawaSignatureSymbolImplMixin;
import org.argus.intellij.jawa.lang.psi.*;
import org.argus.jawa.core.Signature;

public class JawaSignatureSymbolImpl extends JawaSignatureSymbolImplMixin implements JawaSignatureSymbol {

  public JawaSignatureSymbolImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JawaVisitor visitor) {
    visitor.visitSignatureSymbol(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JawaVisitor) accept((JawaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getApostropheId() {
    return notNullChild(findChildByType(APOSTROPHE_ID));
  }

  public Signature getSignature() {
    return JawaPsiImplUtil.getSignature(this);
  }

}
