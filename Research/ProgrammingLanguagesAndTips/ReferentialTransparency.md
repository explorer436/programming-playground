What is referential transparency?

-------------------------------

The term "referential transparency" comes from analytical philosophy, the branch of philosophy that analyzes natural language constructs, statements and arguments based on the methods of logic and mathematics. In other words, it is the closest subject outside computer science to what we call programming language semantics. The philosopher Willard Quine was responsible for initiating the concept of referential transparency, but it was also implicit in the approaches of Bertrand Russell and Alfred Whitehead.

At its core, "referential transparency" is a very simple and clear idea. The term "referent" is used in analytical philosophy to talk about the thing that an expression refers to. It is roughly the same as what we mean by "meaning" or "denotation" in programming language semantics. Using Andrew Birkett's example (blog post), the term "the capital of Scotland" refers to the city of Edinburgh. That is a straightforward example of a "referent".

A context in a sentence is "referentially transparent" if replacing a term in that context by another term that refers to, the same entity doesn't alter the meaning. For example

The Scottish Parliament meets in the capital of Scotland.

means the same as

The Scottish Parliament meets in Edinburgh.

So the context "The Scottish Parliament meets in ..." is a referentially transparent context. We can replace "the capital of Scotland" with "Edinburgh" without altering the meaning. To put another way, the context only cares about what the term refers to and nothing else. That is the sense in which the context is "referentially transparent."

On the other hand, in the sentence,

Edinburgh has been the capital of Scotland since 1999.

we can't do such a replacement. If we did, we would get "Edinburgh has been Edinburgh since 1999", which is a nutty thing to say, and doesn't convey the same meaning as the original sentence. So, it would seem that the context "Edinburgh has been ... since 1999" is referentially opaque (the opposite of referentially transparent). It apparently cares about something more than what the term refers to. What is it?

Things such as "the capital of Scotland" are called definite terms and they gave no lean amount of head ache to logicians and philosophers for a long time. Russell and Quine sorted them out saying that they are not actually "referential", i.e., it is a mistake to think that the above examples are used to refer to entities. The right way to understand "Edinburgh has been the capital of Scotland since 1999" is to say

Scotland has had a capital since 1999 and that capital is Edinburgh.

This sentence cannot be transformed to a nutty one. Problem solved! The point of Quine was to say that natural language is messy, or at least complicated, because it is made to be convenient for practical use, but philosophers and logicians should bring clarity by understanding them in the right way. Referential transparency is a tool to be used for bringing such clarity of meaning.

What does all this have to do with programming? Not very much, actually. As we said, referential transparency is a tool to be used in understanding language, i.e., in assigning meaning. Christopher Strachey, who founded the field of programming language semantics, used it in his study of meaning. His foundational paper "Fundamental concepts in programming languages" is available on the web. It is a beautiful paper and everybody can read and understand it. So, please do so. You will be much enlightened. He introduces the term "referential transparency" in this paragraph:

One of the most useful properties of expressions is that called by Quine referential transparency. In essence this means that if we wish to ﬁnd the value of an expression which contains a sub-expression, the only thing we need to know about the sub-expression is its value. Any other features of the sub-expression, such as its internal structure, the number and nature of its components, the order in which they are evaluated or the colour of the ink in which they are written, are irrelevant to the value of the main expression.

The use of "in essence" suggests that Strachey is paraphrasing it in order to explain it in simple terms. Functional programmers seem to understand this paragraph in their own way. There are 9 other occurrences of "referential transparency" in the paper, but they don't seem to bother about any of the others. In fact, the whole paper of Strachey is devoted to explaining the meaning of imperative programming languages. But, today, functional programmers claim that imperative programming languages are not referentially transparent. Strachey would be turning in his grave.

We can salvage the situation. We said that natural language is "messy, or at least complicated" because it is made to be convenient for practical use. Programming languages are the same way. They are "messy, or at least complicated" because they are made to be convenient for practical use. That does not mean that they need to confuse us. They just have to be understood the right way, using a meta language that is referentially transparent so that we have clarity of meaning. In the paper I cited, Strachey does exactly that. He explains the meaning of imperative programming languages by breaking them down into elementary concepts, never losing clarity anywhere. An important part of his analysis is to point out that expressions in programming languages have two kinds of "values", called l-values and r-values. Before Strachey's paper, this was not understood and confusion reigned supreme. Today, the definition of C mentions it routinely and every C programmer understands the distinction. (Whether the programmers in other languages understand it equally well is hard to say.)

Both Quine and Strachey were concerned with the meaning of language constructions that involve some form of context-dependence. For example, our example "Edinburgh has been the capital of Scotland since 1999" signifies the fact that "capital of Scotland" depends on the time at which it is being considered. Such context-dependence is a reality, both in natural languages and programming languages. Even in functional programming, free and bound variables are to be interpreted with respect to the context in which they appear in. Context dependence of any kind blocks referential transparency in some way or the other. If you try to understand the meaning of terms without regard to the contexts they depend on, you would again end up with confusion. Quine was concerned with the meaning of modal logic. He held that modal logic was referentially opaque and it should be cleaned up by translating it into a referentially transparent framework (e.g., by regarding necessity as provability). He largely lost this debate. Logicians and philosophers alike found Kripke's possible world semantics to be perfectly adequate. Similar situation also reigns with imperative programming. State-dependence explained by Strachey and store-dependence explained by Reynolds (in a manner similar to Kripke's possible world semantics) are perfectly adequate. Functional programmers don't know much of this research. Their ideas on referential transparency are to be taken with a large grain of salt.

[Additional note: The examples above illustrate that a simple phrase such as "capital of Scotland" has multiple levels of meaning. At one level, we might be talking about the capital at the current time. At another level, we might talking about all possible capitals that Scotland might have had through the course of time. We can "zoom into" a particular context and "zoom out" to span all contexts quite easily in normal practice. The efficiency of natural language makes use of our ability to do so. Imperative programming languages are efficient in very much the same way. We can use a variable x on the right hand side of an assignment (the r-value) to talk about its value in a particular state. Or, we might talk about its l-value which spans all states. People are rarely confused by such things. However, they may or may not be able to precisely explain all the layers of meaning inherent in language constructs. All such layers of meaning are not necessarily 'obvious' and it is a matter of science to study them properly. However, the inarticulacy of ordinary people to explain such layered meanings doesn't imply that they are confused about them.]

A separate "postscript" below relates this discussion to the concerns of functional and imperative programming.



[This is a postscript to my answer from March 25, in an effort to bring the discussion closer to the concerns of functional/imperative programming.]

The functional programmers' idea of referential transparency seems to differ from the standard notion in three ways:

Whereas the philosophers/logicians use terms like "reference", "denotation", "designatum" and "bedeutung" (Frege's German term), functional programmers use the term "value". (This is not entirely their doing. I notice that Landin, Strachey and their descendants also used the term "value" to talk about reference/denotation. It may be just a terminological simplification that Landin and Strachey introduced, but it seems to make a big difference when used in a naive way.)

Functional programmers seem to believe that these "values" exist within the programming language, not outside. In doing this, they differ from both the philosophers and the programming language semanticists.

They seem to believe that these "values" are supposed to be obtained by evaluation.

For example, the Wikipedia article on referential transparency says, this morning:

An expression is said to be referentially transparent if it can be replaced with its value without changing the behavior of a program (in other words, yielding a program that has the same effects and output on the same input).

This is completely at variance with what the philosophers/logicians say. They say that a context is referential or referentially transparent if an expression in that context can be replaced by another expression that refers to the same thing (a coreferential expression). Who are these philosophers/logicians? They include Frege, Russell, Whitehead, Carnap, Quine, Church and countless others. Each one of them is a towering figure. The combined intellectual power of these logicians is earth-shattering to say the least. All of them are unanimous in the position that referents/denotations exist outside the formal language and expressions within the language can only talk about them. So, all that one can do within the language is to replace one expression by another expression that refers to the same entity. The referents/denotations themselves do not exist within the language. Why do the functional programmers deviate from this well-established tradition?

One might presume that the programming language semanticists might have misled them. But, they didn't.

Landin:

(a) each expression has a nesting subexpression structure, (b) each subexpression denotes something (usually a number, truth value or numerical function), (c) the thing an expression denotes, i.e., its "value", depends only on the values of its sub- expressions, not on other properties of them. [Added emphasis]

Stoy:

The only thing that matters about an expression is its value, and any subexpression can be replaced by any other equal in value [Added emphasis]. Moreover, the value of an expression is, within certain limits, the same whenever it occurs".

Bird and Wadler:

the value of an expression depends only on the the values of its constituent expressions (if any) and these subexpressions may be replaced freely by others possessing the same value [Added emphasis].

So, in retrospect, the efforts of Landin and Strachey to simplify the terminology by replacing "reference"/"denotation" with "value" might have been injudicious. As soon as one hears of a "value", there is a temptation to think of an evaluation process that leads to it. It is equally tempting to think of whatever the evaluation produces as the "value", even though it might be quite clear that that is not the denotation. That is what I gather to have happened to the concept of "referential transparency" in the eyes of functional programmers. But the "value" that was being spoken of by the early semanticists is not the result of an evaluation or the output of a function or any such thing. It is the denotation of the term.

Once we understand the so-called "value" of an expression ("reference" or "denotation" in classical philosophers' discourse) as a complex mathematical/conceptual object, all kinds of possibilities open up.

Strachey interpreted variables in imperative programming languages as L-values, as mentioned in my March 25 answer, which is a sophisticated conceptual object that does not have a direct representation within the syntax of a programming language.
He also interpreted commands in such languages as state-to-state functions, another instance of a complex mathematical object that is not a "value" within the syntax.
Even a side-effecting function call in C has a well-defined "value" as a state transformer that maps states to pairs of states and values (the so-called "monad" in functional programmers' terminology).

The reluctance of functional programmers to call such languages "referentially transparent" merely implies that they are reluctant to admit such complex mathematical/conceptual objects as "values". On the other hand, they seem perfectly willing to call a state transformer a "value" when it is put in their own favourite syntax and dressed up with a buzz word like "monad". I have to say that they are being entirely inconsistent, even if we grant it to them that their idea of "referential transparency" has some coherence.

A bit of history might throw some light on how these confusions came into being. The period between 1962 to 1967 was a very intensive one for Christopher Strachey. Between 1962-65, he took a part-time job as a research assistant with Maurice Wilkes to design and implement the programming language that came to be known as CPL. This was an imperative programming language but was meant to have powerful functional programming language capabilities as well. Landin, who was an employee of Strachey in his consultancy company, had a huge influence on Strachey's view of programming languages. In the landmark 1965 paper "Next 700 programming languages", Landin unabashedly promotes functional programming languages (calling them denotative languages) and describes imperative programming languages as their "antithesis". In the ensuing discussion, we find Strachey raising doubts on Landin's strong position.

... DLs form a subset of all languages. They are an interesting subset, but one which is inconvenient to use unless you are used to it. We need them because at the moment we don't know how to construct proofs with languages which include imperatives and jumps. [Added emphasis]

In 1965, Strachey took the position of a Reader at Oxford and seems to have worked essentially full-time on developing a theory of imperatives and jumps. By 1967, he was ready with a theory, which he taught in his course on "Fundamental concepts in programming languages" in a Copenhagen summer school. The lecture notes were supposed to have been published but "unfortunately, because of dilatory editing, the proceedings never materialized; like much of Strachey’s work at Oxford, however, the paper had an influential private circulation." (Martin Campbell-Kelly)

The difficulty of obtaining Strachey's writings could have led to the confusions being propagated, with people relying on secondary sources and hearsay. But, now that "Fundamental concepts" is readily available on the web, there is no need to resort to guess work. We should read it and make up our own mind as to what Strachey meant. In particular:

In section 3.2, he deals with "expressions" where he talks about "R-value referential transparency".
His section 3.3 deals with "commands" where he talks about "L-value referential transparency".
In section 3.4.5, he talks about "functions and routines" and declares that "any departure of R-value referential transparency in a R-value context should either be eliminated by decomposing the expression into several commands and simpler expressions, or, if this turns out to be difficult, the subject of a comment."
Any talk of "referential transparency" without understanding the distinction between L-values, R-values and other complex objects that populate the imperative programmer's conceptual universe is fundamentally mistaken.

-------------------------------

