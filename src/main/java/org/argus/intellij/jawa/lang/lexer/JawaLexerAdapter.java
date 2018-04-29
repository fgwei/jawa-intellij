/*
 * Copyright (c) 2018. Fengguo (Hugo) Wei and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Detailed contributors are listed in the CONTRIBUTOR.md
 */

package org.argus.intellij.jawa.lang.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
  * Created by fgwei on 6/20/16.
  */
public class JawaLexerAdapter extends FlexAdapter {
    public JawaLexerAdapter() {
        super(new _JawaLexer((Reader) null));
    }
}
