// This is a generated file. Not intended for manual editing.
package org.argus.intellij.jawa.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import org.argus.intellij.jawa.lang.psi.api.base.JawaPsiReferenceList;
import com.intellij.psi.StubBasedPsiElement;
import org.argus.intellij.jawa.lang.psi.stubs.JawaExtendsAndImplementsClauseStub;

public interface JawaExtendsAndImplementsClause extends JawaPsiReferenceList, StubBasedPsiElement<JawaExtendsAndImplementsClauseStub> {

  @NotNull
  List<JawaExtendAndImplement> getExtendAndImplementList();

}
