// This is a generated file. Not intended for manual editing.
package org.argus.intellij.jawa.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface JawaSwitchStatement extends PsiElement {

  @NotNull
  List<JawaSwitchCase> getSwitchCaseList();

  @Nullable
  JawaSwitchDefaultCase getSwitchDefaultCase();

  @NotNull
  JawaVarSymbol getVarSymbol();

}
