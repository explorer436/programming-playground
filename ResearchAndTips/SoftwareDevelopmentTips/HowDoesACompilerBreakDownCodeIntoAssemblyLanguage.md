How does a compiler break down code into assembly language? With a simple program, what does this look like?

Christopher F Clark · August 18, 2018 Yacc++ author, Intel chip designer, ex-Googler

A compiler breaks a program down to an assembly language program in several steps, although the steps don’t have to be performed separately and distinctly and can be merged. For example, in a “one-pass” compiler all the steps are merged into one step (and steps like 5 are skipped).

1. The compiler lexes the program to identify the individual parts, usually called tokens or terminals. Things like numbers, punctuation marks, operators, keywords, identifiers, whitespace, and comments. Some of them, such as whitespace and comments are discarded at this stage.
1. The compiler parses the program to construct an internal representation of the structure of the program. This is usually either a parse tree or an abstract syntax tree (AST). A parse tree is a relatively literal mapping of the rules of the grammar of the language to tree elements. An abstract syntax tree, removes redundant parts of a parse tree and may rename certain things to make it simpler.
1. Along side the tree, a symbol table is constructed. This associates the names of variables and things with their types and other characteristics.
1. The compiler may further convert the tree into a more semantic representation, such as triples or Static Single Assignment (SSA) form. This form is often called an Intermediate Representation (IR) or Intermediate Language (IL).
1. A global optimization phase may attempt to simplify or improve the IR, particularly to eliminate artifacts created by the “impedance mismatch” between the high level language and what the machine can do. For example, certain operations, such as the specifics of indexing an array or unboxing an object may be required by the semantics of the language, but may actually be redundant at the machine code level.
1. The elements in the symbol table are then allocated to storage locations. For example, automatic variables are given stack offsets. Fields in a structure are given offsets inside the structure. And, so forth. This is often called storage allocation.

    Note, if compiling to a Virtual Machine (VM), the process may stop here and the rest might occur in a Just-In-Time (JIT) compiler that is part of the interpreter that runs the VM.
    Sometimes variables (or intermediate results) are given register addresses. This is called register allocation.
1. Each element in the IR is then converted into its assembly language equivalent.
1. More extraneous operations can some times be removed by peephole optimization, which operates on the generated assembly language.

Note, that most of these phases, but usually not all, are covered in a one or two semester compiler class. I will show some of the intermediate results. Skipping the optimization steps because a program that involved them would be longer than I want to deal with, and even so, I am going to trim various parts once I think the result is “obvious”.

Here is a simple program in a C like language (that doesn’t require header files).

    int main(void) { 
       static int a = 1; 
       static int b = 2; 
       int c; 
       c = a + b; 
       printf ("c = %d\n", c); 
       return 0; 
    } 

Tokens (excluding whitespace which the lexer discarded):

    “int” keyword 
    "main" identifier 
    "(" lparen 
    "void" keyword 
    ")" rparen 
    "{" lbrace 
    "static" keyword 
    "int" keyword 
    "a" identifier 
    "=" assign operator 
    "1" integer number 
    ";" semi 
    ... 

AST (as ASCII art):

    func-defn 
      + func-decl 
      |    +  int 
      |    + identifier -> main 
      |    * void  
      + block 
           * var-decl 
           |  * static 
           |  + int 
           |  * identifier -> a 
           |  + initializer 
           |      + integer -> 1 
           * var-decl 
           |  * static 
           |  + int 
           |  * identifier -> b 
           |  + initializer 
           |      + integer -> 2 
           * var-decl 
           |  + int 
           |  * identifier -> c 
           + assignment (= operator) 
           |  +  identifier -> c 
           |  *  addition (+ operator) 
           |        * identifier -> a 
           |        * identifier -> b 
           + function call 
    ... 

Symbol table (after storage allocation):

    identifier   type    class   initializer            address 
    main         int     func    block (line 6 above)   0 
    a            int     static  1                      0 
    b            int     static  2                      1 
    c            int     stack   none                   0 
    printf       void    func    library                0 
    t0           string  const   "c = %d\n"             - 

Assembly language for some simple hypothetical machine:

    a      data  1      // static int a = 1; 
    b      data  2      // static int b = 2; 
    t0     data  "c = %d\n" 
    main   equ   *      // int main (void) { 
    c      equ   sp+0   // int c 
           load  r0, a  // c = a + b 
           add   r0, b 
           store r0, c 
           push  t0     // printf("c = %d\n", c); 
           push  c 
           call  printf 
           push 0       // return 0 
           return 

The data statements were created by traversing the symbol table. The code by traversing the AST. The comments show which source line created the code which follows it.

All of the above could be created by a one-pass student quality compiler as a term project in a college level compiler course,

