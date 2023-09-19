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
import java.util.Arrays;
import java.util.List;


public class Lexer implements ILexer {

	String input;
	List <Token> tokens;
	int tokenPos = 0;

	public Lexer(String input){
		this.input = input;
		tokens = lexInput();
	}

	public List<Token> lexInput(){
		//create token list
		List<Token> tokens = new ArrayList<>();
		int pos = 0;
		int line = 1;
		int col = 1;

		//System.out.println(input.length());
		while(pos < input.length())
		{
			//System.out.print(pos + " ");
			//System.out.print(input.charAt(pos) + " ");
			if(!((input.charAt(pos) == ' ') || (input.charAt(pos) == '\n') || (input.charAt(pos) == '\r') || (input.charAt(pos) == '\t') || (input.charAt(pos) == '#')))
			{
				//System.out.print("no space ");
				int startPos = pos;

				if(!(startPos + 5 > input.length()) && input.substring(startPos, startPos+5).equals("image"))
				{
					//if((input.charAt(startPos+6) == ' ') || (input.charAt(startPos+6) == '\n') || (input.charAt(startPos+6) == '\r') || (input.charAt(startPos+6) == '\t'))
					{
						Token temp = new Token(Kind.RES_image, 0, 5, input.substring(startPos, startPos+5).toCharArray(), new SourceLocation(line, col));
						col += 5;
						pos += 5;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 5 > input.length()) && input.substring(startPos, startPos+5).equals("pixel"))
				{
					//if((input.charAt(startPos+6) == ' ') || (input.charAt(startPos+6) == '\n') || (input.charAt(startPos+6) == '\r') || (input.charAt(startPos+6) == '\t'))
					{
						Token temp = new Token(Kind.RES_pixel, 0, 5, input.substring(startPos, startPos+5).toCharArray(), new SourceLocation(line, col));
						col += 5;
						pos += 5;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 3 > input.length()) && input.substring(startPos, startPos+3).equals("int"))
				{
					//if((input.charAt(startPos+4) == ' ') || (input.charAt(startPos+4) == '\n') || (input.charAt(startPos+4) == '\r') || (input.charAt(startPos+4) == '\t'))
					{
						Token temp = new Token(Kind.RES_int, 0, 3, input.substring(startPos, startPos+3).toCharArray(), new SourceLocation(line, col));
						col += 3;
						pos += 3;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 6 > input.length()) && input.substring(startPos, startPos+6).equals("string"))
				{
					//if((input.charAt(startPos+7) == ' ') || (input.charAt(startPos+7) == '\n') || (input.charAt(startPos+7) == '\r') || (input.charAt(startPos+7) == '\t'))
					{
						Token temp = new Token(Kind.RES_string, 0, 6, input.substring(startPos, startPos+6).toCharArray(), new SourceLocation(line, col));
						col += 6;
						pos += 6;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 4 > input.length()) && input.substring(startPos, startPos+4).equals("void"))
				{
					//if((input.charAt(startPos+5) == ' ') || (input.charAt(startPos+5) == '\n') || (input.charAt(startPos+5) == '\r') || (input.charAt(startPos+5) == '\t'))
					{
						Token temp = new Token(Kind.RES_void, 0, 4, input.substring(startPos, startPos+4).toCharArray(), new SourceLocation(line, col));
						col += 4;
						pos += 4;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 7 > input.length()) && input.substring(startPos, startPos+7).equals("boolean"))
				{
					//if((input.charAt(startPos+8) == ' ') || (input.charAt(startPos+8) == '\n') || (input.charAt(startPos+8) == '\r') || (input.charAt(startPos+8) == '\t'))
					{
						Token temp = new Token(Kind.RES_boolean, 0, 7, input.substring(startPos, startPos+7).toCharArray(), new SourceLocation(line, col));
						col += 7;
						pos += 7;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 5 > input.length()) && input.substring(startPos, startPos+5).equals("write"))
				{
					//if((input.charAt(startPos+6) == ' ') || (input.charAt(startPos+6) == '\n') || (input.charAt(startPos+6) == '\r') || (input.charAt(startPos+6) == '\t'))
					{
						Token temp = new Token(Kind.RES_write, 0, 5, input.substring(startPos, startPos+5).toCharArray(), new SourceLocation(line, col));
						col += 5;
						pos += 5;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 6 > input.length()) && input.substring(startPos, startPos+6).equals("height"))
				{
					//if((input.charAt(startPos+7) == ' ') || (input.charAt(startPos+7) == '\n') || (input.charAt(startPos+7) == '\r') || (input.charAt(startPos+7) == '\t'))
					{
						Token temp = new Token(Kind.RES_height, 0, 6, input.substring(startPos, startPos+6).toCharArray(), new SourceLocation(line, col));
						col += 6;
						pos += 6;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 5 > input.length()) && input.substring(startPos, startPos+5).equals("width"))
				{
					//if((input.charAt(startPos+6) == ' ') || (input.charAt(startPos+6) == '\n') || (input.charAt(startPos+6) == '\r') || (input.charAt(startPos+6) == '\t'))
					{
						Token temp = new Token(Kind.RES_width, 0, 5, input.substring(startPos, startPos+5).toCharArray(), new SourceLocation(line, col));
						col += 5;
						pos += 5;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals("if"))
				{
					//if((input.charAt(startPos+3) == ' ') || (input.charAt(startPos+3) == '\n') || (input.charAt(startPos+3) == '\r') || (input.charAt(startPos+3) == '\t'))
					{
						Token temp = new Token(Kind.RES_if, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
						col += 2;
						pos += 2;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals("fi"))
				{
					//if((input.charAt(startPos+3) == ' ') || (input.charAt(startPos+3) == '\n') || (input.charAt(startPos+3) == '\r') || (input.charAt(startPos+3) == '\t'))
					{
						Token temp = new Token(Kind.RES_fi, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
						col += 2;
						pos += 2;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals("do"))
				{
					//if((input.charAt(startPos+3) == ' ') || (input.charAt(startPos+3) == '\n') || (input.charAt(startPos+3) == '\r') || (input.charAt(startPos+3) == '\t'))
					{
						Token temp = new Token(Kind.RES_do, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
						col += 2;
						pos += 2;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals("od"))
				{
					//if((input.charAt(startPos+3) == ' ') || (input.charAt(startPos+3) == '\n') || (input.charAt(startPos+3) == '\r') || (input.charAt(startPos+3) == '\t'))
					{
						Token temp = new Token(Kind.RES_od, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
						col += 2;
						pos += 2;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 3 > input.length()) && input.substring(startPos, startPos+3).equals("red"))
				{
					//if((input.charAt(startPos+4) == ' ') || (input.charAt(startPos+4) == '\n') || (input.charAt(startPos+4) == '\r') || (input.charAt(startPos+4) == '\t'))
					{
						Token temp = new Token(Kind.RES_red, 0, 3, input.substring(startPos, startPos+3).toCharArray(), new SourceLocation(line, col));
						col += 3;
						pos += 3;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 5 > input.length()) && input.substring(startPos, startPos+5).equals("green"))
				{
					//if((input.charAt(startPos+6) == ' ') || (input.charAt(startPos+6) == '\n') || (input.charAt(startPos+6) == '\r') || (input.charAt(startPos+6) == '\t'))
					{
						Token temp = new Token(Kind.RES_green, 0, 5, input.substring(startPos, startPos+5).toCharArray(), new SourceLocation(line, col));
						col += 5;
						pos += 5;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 4 > input.length()) && input.substring(startPos, startPos+4).equals("blue"))
				{
					//if((input.charAt(startPos+5) == ' ') || (input.charAt(startPos+5) == '\n') || (input.charAt(startPos+5) == '\r') || (input.charAt(startPos+5) == '\t'))
					{
						Token temp = new Token(Kind.RES_blue, 0, 4, input.substring(startPos, startPos+4).toCharArray(), new SourceLocation(line, col));
						col += 4;
						pos += 4;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 4 > input.length()) && input.substring(startPos, startPos+4).equals("TRUE"))
				{
					//if((input.charAt(startPos+5) == ' ') || (input.charAt(startPos+5) == '\n') || (input.charAt(startPos+5) == '\r') || (input.charAt(startPos+5) == '\t'))
					{
						Token temp = new Token(Kind.BOOLEAN_LIT, 0, 4, input.substring(startPos, startPos+4).toCharArray(), new SourceLocation(line, col));
						col += 4;
						pos += 4;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 5 > input.length()) && input.substring(startPos, startPos+5).equals("FALSE"))
				{
					//if((input.charAt(startPos+6) == ' ') || (input.charAt(startPos+6) == '\n') || (input.charAt(startPos+6) == '\r') || (input.charAt(startPos+6) == '\t'))
					{
						Token temp = new Token(Kind.BOOLEAN_LIT, 0, 5, input.substring(startPos, startPos+5).toCharArray(), new SourceLocation(line, col));
						col += 5;
						pos += 5;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 5 > input.length()) && input.substring(startPos, startPos+5).equals("BLACK"))
				{
					//if((input.charAt(startPos+6) == ' ') || (input.charAt(startPos+6) == '\n') || (input.charAt(startPos+6) == '\r') || (input.charAt(startPos+6) == '\t'))
					{
						Token temp = new Token(Kind.CONST, 0, 5, input.substring(startPos, startPos+5).toCharArray(), new SourceLocation(line, col));
						col += 5;
						pos += 5;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 4 > input.length()) && input.substring(startPos, startPos+4).equals("BLUE"))
				{
					//if((input.charAt(startPos+5) == ' ') || (input.charAt(startPos+5) == '\n') || (input.charAt(startPos+5) == '\r') || (input.charAt(startPos+5) == '\t'))
					{
						Token temp = new Token(Kind.CONST, 0, 4, input.substring(startPos, startPos+4).toCharArray(), new SourceLocation(line, col));
						col += 4;
						pos += 4;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 4 > input.length()) && input.substring(startPos, startPos+4).equals("CYAN"))
				{
					//if((input.charAt(startPos+5) == ' ') || (input.charAt(startPos+5) == '\n') || (input.charAt(startPos+5) == '\r') || (input.charAt(startPos+5) == '\t'))
					{
						Token temp = new Token(Kind.CONST, 0, 4, input.substring(startPos, startPos+4).toCharArray(), new SourceLocation(line, col));
						col += 4;
						pos += 4;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 9 > input.length()) && input.substring(startPos, startPos+9).equals("DARK_GRAY"))
				{
					//if((input.charAt(startPos+10) == ' ') || (input.charAt(startPos+10) == '\n') || (input.charAt(startPos+10) == '\r') || (input.charAt(startPos+10) == '\t'))
					{
						Token temp = new Token(Kind.CONST, 0, 9, input.substring(startPos, startPos+9).toCharArray(), new SourceLocation(line, col));
						col += 9;
						pos += 9;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 4 > input.length()) && input.substring(startPos, startPos+4).equals("GRAY"))
				{
					//if((input.charAt(startPos+5) == ' ') || (input.charAt(startPos+5) == '\n') || (input.charAt(startPos+5) == '\r') || (input.charAt(startPos+5) == '\t'))
					{
						Token temp = new Token(Kind.CONST, 0, 4, input.substring(startPos, startPos+4).toCharArray(), new SourceLocation(line, col));
						col += 4;
						pos += 4;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 5 > input.length()) && input.substring(startPos, startPos+5).equals("GREEN"))
				{
					//if((input.charAt(startPos+6) == ' ') || (input.charAt(startPos+6) == '\n') || (input.charAt(startPos+6) == '\r') || (input.charAt(startPos+6) == '\t'))
					{
						Token temp = new Token(Kind.CONST, 0, 5, input.substring(startPos, startPos+5).toCharArray(), new SourceLocation(line, col));
						col += 5;
						pos += 5;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 10 > input.length()) && input.substring(startPos, startPos+10).equals("LIGHT_GRAY"))
				{
					//if((input.charAt(startPos+11) == ' ') || (input.charAt(startPos+11) == '\n') || (input.charAt(startPos+11) == '\r') || (input.charAt(startPos+11) == '\t'))
					{
						Token temp = new Token(Kind.CONST, 0, 10, input.substring(startPos, startPos+10).toCharArray(), new SourceLocation(line, col));
						col += 10;
						pos += 10;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 7 > input.length()) && input.substring(startPos, startPos+7).equals("MAGENTA"))
				{
					//if((input.charAt(startPos+8) == ' ') || (input.charAt(startPos+8) == '\n') || (input.charAt(startPos+8) == '\r') || (input.charAt(startPos+8) == '\t'))
					{
						Token temp = new Token(Kind.CONST, 0, 7, input.substring(startPos, startPos+7).toCharArray(), new SourceLocation(line, col));
						col += 7;
						pos += 7;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 6 > input.length()) && input.substring(startPos, startPos+6).equals("ORANGE"))
				{
					//if((input.charAt(startPos+7) == ' ') || (input.charAt(startPos+7) == '\n') || (input.charAt(startPos+7) == '\r') || (input.charAt(startPos+7) == '\t'))
					{
						Token temp = new Token(Kind.CONST, 0, 6, input.substring(startPos, startPos+6).toCharArray(), new SourceLocation(line, col));
						col += 6;
						pos += 6;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 4 > input.length()) && input.substring(startPos, startPos+4).equals("PINK"))
				{
					//if((input.charAt(startPos+5) == ' ') || (input.charAt(startPos+5) == '\n') || (input.charAt(startPos+5) == '\r') || (input.charAt(startPos+5) == '\t'))
					{
						Token temp = new Token(Kind.CONST, 0, 4, input.substring(startPos, startPos+4).toCharArray(), new SourceLocation(line, col));
						col += 4;
						pos += 4;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 3 > input.length()) && input.substring(startPos, startPos+3).equals("RED"))
				{
					//if((input.charAt(startPos+4) == ' ') || (input.charAt(startPos+4) == '\n') || (input.charAt(startPos+4) == '\r') || (input.charAt(startPos+4) == '\t'))
					{
						//System.out.println(input.substring(startPos, startPos+3));
						Token temp = new Token(Kind.CONST, 0, 3, input.substring(startPos, startPos+3).toCharArray(), new SourceLocation(line, col));
						col += 3;
						pos += 3;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 5 > input.length()) && input.substring(startPos, startPos+5).equals("WHITE"))
				{
					//if((input.charAt(startPos+6) == ' ') || (input.charAt(startPos+6) == '\n') || (input.charAt(startPos+6) == '\r') || (input.charAt(startPos+6) == '\t'))
					{
						Token temp = new Token(Kind.CONST, 0, 5, input.substring(startPos, startPos+5).toCharArray(), new SourceLocation(line, col));
						col += 5;
						pos += 5;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 6 > input.length()) && input.substring(startPos, startPos+6).equals("YELLOW"))
				{
					//if((input.charAt(startPos+7) == ' ') || (input.charAt(startPos+7) == '\n') || (input.charAt(startPos+7) == '\r') || (input.charAt(startPos+7) == '\t'))
					{
						Token temp = new Token(Kind.CONST, 0, 6, input.substring(startPos, startPos+6).toCharArray(), new SourceLocation(line, col));
						col += 6;
						pos += 6;
						tokens.add(temp);
					}
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals("=="))
				{
					Token temp = new Token(Kind.EQ, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals("<="))
				{
					Token temp = new Token(Kind.LE, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals(">="))
				{
					Token temp = new Token(Kind.GE, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals("&&"))
				{
					Token temp = new Token(Kind.AND, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals("||"))
				{
					Token temp = new Token(Kind.OR, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals("**"))
				{
					Token temp = new Token(Kind.EXP, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals("<:"))
				{
					Token temp = new Token(Kind.BLOCK_OPEN, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals(":>"))
				{
					Token temp = new Token(Kind.BLOCK_CLOSE, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals("->"))
				{
					Token temp = new Token(Kind.RARROW, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(!(startPos + 2 > input.length()) && input.substring(startPos, startPos+2).equals("[]"))
				{
					Token temp = new Token(Kind.BOX, 0, 2, input.substring(startPos, startPos+2).toCharArray(), new SourceLocation(line, col));
					col += 2;
					pos += 2;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == ',')
				{
					Token temp = new Token(Kind.COMMA, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == ';')
				{
					Token temp = new Token(Kind.SEMI, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '?')
				{
					Token temp = new Token(Kind.QUESTION, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == ':')
				{
					Token temp = new Token(Kind.COLON, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '(')
				{
					Token temp = new Token(Kind.LPAREN, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == ')')
				{
					Token temp = new Token(Kind.RPAREN, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '<')
				{
					Token temp = new Token(Kind.LT, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '>')
				{
					Token temp = new Token(Kind.GT, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '[')
				{
					Token temp = new Token(Kind.LSQUARE, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == ']')
				{
					Token temp = new Token(Kind.RSQUARE, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '=')
				{
					Token temp = new Token(Kind.ASSIGN, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '!')
				{
					Token temp = new Token(Kind.BANG, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '&')
				{
					Token temp = new Token(Kind.BITAND, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '|')
				{
					Token temp = new Token(Kind.BITOR, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '+')
				{
					Token temp = new Token(Kind.PLUS, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '-')
				{
					Token temp = new Token(Kind.MINUS, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '*')
				{
					Token temp = new Token(Kind.TIMES, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '/')
				{
					Token temp = new Token(Kind.DIV, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '%')
				{
					Token temp = new Token(Kind.MOD, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '^')
				{
					Token temp = new Token(Kind.RETURN, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(input.charAt(startPos) == '0')
				{
					Token temp = new Token(Kind.NUM_LIT, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if(!(startPos + 2 > input.length()) && input.charAt(startPos) == 'Z' && ((input.charAt(startPos+1) == ' ') || (input.charAt(startPos+1) == '\n') || (input.charAt(startPos+1) == '\r') || (input.charAt(startPos+1) == '\t') || (input.charAt(startPos+1) == '#')))
				{
					Token temp = new Token(Kind.CONST, 0, 1, input.substring(startPos, startPos+1).toCharArray(), new SourceLocation(line, col));
					col++;
					pos++;
					tokens.add(temp);
				}
				else if((input.charAt(startPos) >= 'a' && input.charAt(startPos) <= 'z') || (input.charAt(startPos) >= 'A' && input.charAt(startPos) <= 'Z') || (input.charAt(startPos) == '_'))
				{
					String tempToken = String.valueOf(input.charAt(startPos));
					int startCol = col;
					col++;
					pos++;
					while(pos < input.length() && ((input.charAt(pos) >= '0' && input.charAt(pos) <= '9') || (input.charAt(pos) >= 'a' && input.charAt(pos) <= 'z') || (input.charAt(pos) >= 'A' && input.charAt(pos) <= 'Z') || (input.charAt(pos) == '_')))
					{
						tempToken += String.valueOf(input.charAt(pos));
						col++;
						pos++;
					}
					Token temp = new Token(Kind.IDENT, 0, tempToken.length(), tempToken.toCharArray(), new SourceLocation(line, startCol));
					tokens.add(temp);
				}
				else if(input.charAt(startPos) >= '1' && input.charAt(startPos) <= '9')
				{
					String tempToken = String.valueOf(input.charAt(startPos));
					int startCol = col;
					int numDigits = 1;
					col++;
					pos++;

					//System.out.print("test");

					while(pos < input.length() && (input.charAt(pos) >= '0' && input.charAt(pos) <= '9'))
					{
						//System.out.print("test2");

						tempToken += String.valueOf(input.charAt(pos));
						col++;
						pos++;
						numDigits++;
					}
					if(numDigits <= 10)
					{
						Token temp = new Token(Kind.NUM_LIT, 0, tempToken.length(), tempToken.toCharArray(), new SourceLocation(line, startCol));
						tokens.add(temp);
					}
					else
					{
						tokens.add(new Token(Kind.ERROR, 0, 1, input.substring(pos, pos+1).toCharArray(), new SourceLocation(line, col)));
						pos++;
						col++;
					}
				}
				else if(input.charAt(startPos) == 34)
				{
					String tempToken = String.valueOf(input.charAt(startPos));
					int startCol = col;
					col++;
					pos++;

					while(pos < input.length() && (input.charAt(pos) >= 32 && input.charAt(pos) <= 126))
					{
						//System.out.print(input.charAt(pos));
						if(input.charAt(pos) == 34)
						{
							tempToken += String.valueOf(input.charAt(pos));
							col++;
							pos++;
							break;
						}
						else
						{
							tempToken += String.valueOf(input.charAt(pos));
							col++;
							pos++;
						}
					}
					Token temp = new Token(Kind.STRING_LIT, 0, tempToken.length(), tempToken.toCharArray(), new SourceLocation(line, startCol));
					tokens.add(temp);
				}
				else //error
				{
					tokens.add(new Token(Kind.ERROR, 0, 1, input.substring(pos, pos+1).toCharArray(), new SourceLocation(line, col)));
					col++;
					pos++;
				}

				//System.out.print(" Token Done ");
			}
			else
			{
				//.out.print("Checking Space ");
				if((input.charAt(pos) == ' ') || (input.charAt(pos) == '\n') || (input.charAt(pos) == '\r') || (input.charAt(pos) == '\t') || (input.charAt(pos) == '#'))
				{
					//System.out.print("Checking Space Type " + pos);
					if(input.charAt(pos) == 10)
					{
						//System.out.print(" newline ");
						line++;
						col = 1;
						pos++;
					}
					else if((input.charAt(pos) == ' ') || (input.charAt(pos) == '\r') || (input.charAt(pos) == '\t'))
					{
						col++;
						pos++;
					}
					else if(!(pos + 2 > input.length()) && input.substring(pos, pos+2).equals("##"))
					{
						col+=2;
						pos+=2;
						while(pos < input.length() && (input.charAt(pos) >= 32 && input.charAt(pos) <= 126))
						{
							if(input.charAt(pos) == '\n')
							{
								col = 1;
								line++;
								pos++;
								break;
							}
							else
							{
								col++;
								pos++;
							}
						}
					}
					else
					{
						tokens.add(new Token(Kind.ERROR, 0, 1, null, new SourceLocation(line, col)));
						col++;
						pos++;
					}
				}
				else
				{
					tokens.add(new Token(Kind.ERROR, 0, 1, input.substring(pos, pos+1).toCharArray(), new SourceLocation(line, col)));
					col++;
					pos++;
				}
			}
		}

		//System.out.print("\nCreated list");
		tokens.add(new Token(Kind.EOF, 0, 0, null, new SourceLocation(1, 1)));
		return tokens;
	}

	@Override
	public IToken next() throws LexicalException {
		if(tokenPos >= tokens.size())
		{
			return new Token(EOF, 0, 0, null, new SourceLocation(1, 1));
		}
		else
		{
			if(tokens.get(tokenPos).kind == Kind.ERROR)
			{
				throw new LexicalException();
			}
			else
			{
				//System.out.println("\n" + tokenPos + " " + Arrays.toString(tokens.get(tokenPos).source));
				int temp = tokenPos;
				tokenPos++;
				return tokens.get(temp);
			}
		}

	}


}
