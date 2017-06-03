1. Which language generates the context-free grammar given by the productions: 

    S → aSa | aBa 
    
    B → bB | b
    
    ANSWER: A language where at least one symbol `b` is surrounded from both sides by at least one symbol `a`.
    For example, `aba`, `abbbba`, `aaabbbaaa` etc.
    
2. Create a CFG that generates the set of strings over the alphabet {a, b} with twice as many as as bs.

   S → BS | SB | B 
   
   B → aab | aba | baa
    
3.   Consider the following fragment of a BNF specification for addresses:

     \<Address> ::= \<House Number> \<Street Name> \<Town Name> \<City Name> \<Country> \<Postcode> |
     
     \<House Number> \<Street Name> \<City Name> \<Country> \<Post Code>
     
     Use the tokens <digit> and <letter> to complete the fragment by providing specifications for 
     <House Number>, <Street Name> and so on. (Do not use the EBNF repetition characters * or +.)  
     
     \<House Number> ::= \<integer> 
     
     \<integer> ::= \<digit> | \<integer> \<digit>
     
     \<Street Name> ::= \<word> 
     
     \<Town Name> ::= \<word> 
     
     \<City Name> ::= \<word> 
     
     \<Country> ::= \<word> 
     
     \<Post Code> ::= \<letter> \<letter> \<digit> \<digit> \<digit> \<letter> \<letter> 
     
     \<word> ::= \<letter> | \<word> \<letter>
     
     \<digit> ::= "0" | ... | "9"
     
     \<letter> :: = "A" | ... | "Z" | "a" | ... | "z"

4. Given the following BNF specification:

   1. A ::= B"@"C"."B
   2. B ::= BL | L
   3. C ::= B | B"."B 
   4. L ::= "a" | "b" | "c" | ... | "y" | "z"
   
   State whether each of the following expressions is in the language:
   
   1. j.burton@brighton.ac.uk
   2. aa.bb@cc.dd
   3. mm@pp
   4. billgates@microsoft.com
   5. bill
   6. @x.y
   
   ANSWER: 
   
   1. NO because before `@` can't be `.`
   2. NO because before `@` can't be `.`
   3. NO because it does not contain `.`
   4. YES
   5. NO because it does not contain `@` 
   6. NO because before `@` has to be at least one letter
