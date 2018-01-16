/*
 * This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.datatools.sqltools.parsers.sql.lexer;

public interface SQLLexersym {
    public final static int
      Char_CtlCharNotWS = 79,
      Char_LF = 51,
      Char_CR = 52,
      Char_HT = 46,
      Char_FF = 47,
      Char_StmtTerm = 78,
      Char_ParamMark = 59,
      Char_DelimIdQt = 48,
      Char_HostVarPrfx = 60,
      Char_A = 12,
      Char_B = 13,
      Char_C = 14,
      Char_D = 15,
      Char_E = 11,
      Char_F = 16,
      Char_G = 21,
      Char_H = 22,
      Char_I = 23,
      Char_J = 24,
      Char_K = 25,
      Char_L = 26,
      Char_M = 27,
      Char_N = 28,
      Char_O = 29,
      Char_P = 30,
      Char_Q = 31,
      Char_R = 32,
      Char_S = 33,
      Char_T = 34,
      Char_U = 35,
      Char_V = 36,
      Char_W = 37,
      Char_X = 19,
      Char_Y = 38,
      Char_Z = 39,
      Char__ = 40,
      Char_0 = 1,
      Char_1 = 2,
      Char_2 = 3,
      Char_3 = 4,
      Char_4 = 5,
      Char_5 = 6,
      Char_6 = 7,
      Char_7 = 8,
      Char_8 = 9,
      Char_9 = 10,
      Char_AfterASCII = 41,
      Char_Space = 49,
      Char_DoubleQuote = 77,
      Char_SingleQuote = 17,
      Char_Percent = 61,
      Char_VerticalBar = 53,
      Char_Exclaimation = 62,
      Char_AtSign = 42,
      Char_BackQuote = 63,
      Char_Tilde = 64,
      Char_Sharp = 43,
      Char_DollarSign = 44,
      Char_Ampersand = 65,
      Char_Caret = 66,
      Char_Colon = 67,
      Char_SemiColon = 68,
      Char_BackSlash = 69,
      Char_LeftBrace = 70,
      Char_RightBrace = 71,
      Char_LeftBracket = 72,
      Char_RightBracket = 73,
      Char_QuestionMark = 54,
      Char_Comma = 74,
      Char_Dot = 55,
      Char_LessThan = 45,
      Char_GreaterThan = 20,
      Char_Plus = 56,
      Char_Minus = 50,
      Char_Slash = 75,
      Char_Star = 76,
      Char_LeftParen = 57,
      Char_RightParen = 58,
      Char_Equal = 18,
      Char_EOF = 80;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "0",
                 "1",
                 "2",
                 "3",
                 "4",
                 "5",
                 "6",
                 "7",
                 "8",
                 "9",
                 "E",
                 "A",
                 "B",
                 "C",
                 "D",
                 "F",
                 "SingleQuote",
                 "Equal",
                 "X",
                 "GreaterThan",
                 "G",
                 "H",
                 "I",
                 "J",
                 "K",
                 "L",
                 "M",
                 "N",
                 "O",
                 "P",
                 "Q",
                 "R",
                 "S",
                 "T",
                 "U",
                 "V",
                 "W",
                 "Y",
                 "Z",
                 "_",
                 "AfterASCII",
                 "AtSign",
                 "Sharp",
                 "DollarSign",
                 "LessThan",
                 "HT",
                 "FF",
                 "DelimIdQt",
                 "Space",
                 "Minus",
                 "LF",
                 "CR",
                 "VerticalBar",
                 "QuestionMark",
                 "Dot",
                 "Plus",
                 "LeftParen",
                 "RightParen",
                 "ParamMark",
                 "HostVarPrfx",
                 "Percent",
                 "Exclaimation",
                 "BackQuote",
                 "Tilde",
                 "Ampersand",
                 "Caret",
                 "Colon",
                 "SemiColon",
                 "BackSlash",
                 "LeftBrace",
                 "RightBrace",
                 "LeftBracket",
                 "RightBracket",
                 "Comma",
                 "Slash",
                 "Star",
                 "DoubleQuote",
                 "StmtTerm",
                 "CtlCharNotWS",
                 "EOF"
             };

    public final static boolean isValidForParser = true;
}