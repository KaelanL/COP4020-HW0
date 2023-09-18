/*Copyright 2023 by Beverly A Sanders
* 
* This code is provided for solely for use of students in COP4020 Programming Language Concepts at the 
* University of Florida during the fall semester 2023 as part of the course project.  
* 
* No other use is authorized. 
* 
* This code may not be posted on a public web site either during or after the course.  
*/
package edu.ufl.cise.cop4020fa23;

import static edu.ufl.cise.cop4020fa23.Kind.EOF;

import edu.ufl.cise.cop4020fa23.exceptions.LexicalException;

import java.util.ArrayList;
import java.util.List;


public class Lexer implements ILexer {

	String input;

	public Lexer(String input) {
		this.input = input;
	}

	public List<Token> lexinput()
	{
		//create token list
		List<Token> tokens = new ArrayList<>();
		int pos = 0;
		int line = 1;
		int col = 1;

		while(pos != input.length())
		{
			if(!((input.charAt(pos) == ' ') || (input.charAt(pos) == '\n') || (input.charAt(pos) == '\r') || (input.charAt(pos) == '\t')))
			{
				int startPos = pos;

				if(input.substring(startPos, startPos+2).equals("=="))
				{
					Token temp = new Token(Kind.EQ, startPos, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(input.substring(startPos, startPos+2).equals("<="))
				{
					Token temp = new Token(Kind.LE, startPos, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(input.substring(startPos, startPos+2).equals(">="))
				{
					Token temp = new Token(Kind.GE, startPos, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(input.substring(startPos, startPos+2).equals("&&"))
				{
					Token temp = new Token(Kind.AND, startPos, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(input.substring(startPos, startPos+2).equals("||"))
				{
					Token temp = new Token(Kind.OR, startPos, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(input.substring(startPos, startPos+2).equals("**"))
				{
					Token temp = new Token(Kind.EXP, startPos, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(input.substring(startPos, startPos+2).equals("<:"))
				{
					Token temp = new Token(Kind.BLOCK_OPEN, startPos, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(input.substring(startPos, startPos+2).equals(":>"))
				{
					Token temp = new Token(Kind.BLOCK_CLOSE, startPos, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(input.substring(startPos, startPos+2).equals("->"))
				{
					Token temp = new Token(Kind.RARROW, startPos, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(input.substring(startPos, startPos+2).equals("[]"))
				{
					Token temp = new Token(Kind.BOX, startPos, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == ',')
				{
					Token temp = new Token(Kind.COMMA, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == ';')
				{
					Token temp = new Token(Kind.SEMI, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '?')
				{
					Token temp = new Token(Kind.QUESTION, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == ':')
				{
					Token temp = new Token(Kind.COLON, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '(')
				{
					Token temp = new Token(Kind.LPAREN, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == ')')
				{
					Token temp = new Token(Kind.RPAREN, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '<')
				{
					Token temp = new Token(Kind.LT, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '>')
				{
					Token temp = new Token(Kind.GT, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '[')
				{
					Token temp = new Token(Kind.LSQUARE, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == ']')
				{
					Token temp = new Token(Kind.RSQUARE, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '=')
				{
					Token temp = new Token(Kind.ASSIGN, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '!')
				{
					Token temp = new Token(Kind.BANG, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '&')
				{
					Token temp = new Token(Kind.BITAND, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '|')
				{
					Token temp = new Token(Kind.BITOR, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '+')
				{
					Token temp = new Token(Kind.PLUS, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '-')
				{
					Token temp = new Token(Kind.MINUS, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '*')
				{
					Token temp = new Token(Kind.TIMES, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '/')
				{
					Token temp = new Token(Kind.DIV, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '%')
				{
					Token temp = new Token(Kind.MOD, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '^')
				{
					Token temp = new Token(Kind.RETURN, startPos, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else
				{

				}
			}
			else
			{
				if(true)
				{

				}
				else
				{
					tokens.add(new Token(Kind.ERROR, pos, 1, input.substring(pos, pos+1).toCharArray(), new SourceLocation(line, col)));
					col++;
				}
				pos++;
			}
		}

		tokens.add(new Token(Kind.EOF, 0, 0, null, new SourceLocation(1, 1)));
		return tokens;
	}

	@Override
	public IToken next() throws LexicalException {
		return new Token(EOF, 0, 0, null, new SourceLocation(1, 1));
	}


}
