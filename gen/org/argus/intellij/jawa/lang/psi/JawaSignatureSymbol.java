// This is a generated file. Not intended for manual editing.
package org.argus.intellij.jawa.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import org.argus.intellij.jawa.lang.psi.api.expr.JawaReferenceExpression;
import org.argus.jawa.core.Signature;

public interface JawaSignatureSymbol extends JawaReferenceExpression {

  @NotNull
  PsiElement getApostropheId();

  Signature getSignature();

}
