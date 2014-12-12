# Tonatrix Final Write-Up


## Introduction: (Project Description

<!--Describe your domain and motivate the need for a DSL (i.e., how could domain-experts use and benefit from a DSL?). What is the essence of your language, and why is it a good language for this domain?-->

The domain of Tonatrix, or the Tone Matrix with Tonality language, is simple musical composition. My goals with this language were to create a language that would allow users to program musical melodies with multiple instruments, or voices, simultaneously, but to do so while allowing the tool to be used by people with no background in music theory or sound synthesis.

To keep it simple, I had to limit what type of sounds could be made. There are many existing tools and languages in this domain, some of which I list in my [first notebook entry](https://github.com/cvcal/NoteMatrix-project-notebook/blob/master/November%202.md), so I had many examples to base my ideas from. I knew that I couldn't try to make any thing resembling a fully featured synthesizer, as that would make the language far too complicated, but as varying voices was one of my initial requirements, I needed a way to specify different types of sounds, and as I was planning on having a graphics interface, I chose color. 

I also could not use standard musical notation if I wanted to keep the language accessible to people with no musical background. I decided to go for the tried and true grid representation, where the pitch is along the y-axis and time is along the x-axis. I don't think this is naturally intuitive, but it is such a commonly used system that it has become culturally so, at the very least.

## Language design details: (language design overview)

<!--Give a high-level overview of your language's design. Be sure to answer the following questions:

How does a user write programs in your language (e.g., do they type in commands, use a visual/graphical tool, speak, etc.)?
How does the syntax of your language help users write programmers more easily than the syntax of a general-purpose language?
What is the basic computation that your language performs (i.e., what is the computational model)?
What are the basic data structures in your DSL, if any? How does a the user create and manipulate data?
What are the basic control structures in your DSL, if any? How does the user specify or manipulate control flow?
What kind(s) of input does a program in your DSL require? What kind(s) of output does a program produce?
Error handling: How can programs go wrong, and how does your language communicate those errors to the user?
What tool support (e.g., error-checking, development environments) does your project provide?
Are there any other DSLs for this domain? If so, what are they, and how does your language compare to these other languages?
Example program(s): Provide one or more examples that give the casual reader a good sense of your language. Include inputs and outputs. Think of this section as “Tutorial By Example”. You might combine this section with the previous one, i.e., use examples to help describe your language.-->

Tonatrix is written through a GUI, in which a user selects and un-selects cells in the grid. The user does not need to think of what absolute value a note has, though an understanding of intervals would help, but can simply click a note to play it with the selected instrument, and see what it sounds like.

<p align="center">
  <img src="https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/pictures/TwinkleTwinkleLittleStar.png" width="250" />
</p> 

In the example above, there are parts on the grid associated with all four available instruments. The green instrument is selected in the upper-left hand corner, which means that clicking any location on the grid will either add a green note at the time and pitch, or remove one if there was already one there. To edit another color, first select that color from the grid, then proceed. There is also a "Clear" button to empty the entire grid. The "Play" button essentially initiates the compilation step, in a sense. It will take all the notes and play them sequentially three times. The GUI does not yet have the capability of playing it for a variable number of times, though the underlying grid data structure does.

To give a sense of the intervals, the example below is "Twinkle Twinkle Little Stars," as in [this](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/src/tests/LargeGridTest.java) example program but with all but the melody removed for visual clarity. 

<p align="center">
  <img src="https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/pictures/workingVersionWithThings.png" width="350" />
</p> 

## Language implementation: (language implementation overview) 

<!--Describe your implementation. In particular, answer the following questions:

What host language did you use (i.e., in what language did you implement your DSL)? Why did you choose this host language (i.e., why is it well-suited for your language design)?
Is yours an external or an internal DSL (or some combination thereof)? Why is that the right design?
Provide an overview of the architecture of your language: front, middle, and back-end, along with any technologies used to implement these components.
“Parsing”: How does your DSL take a user program and turn it into something that can be executed? How do the data and control structures of your DSL connect to the underlying semantic model?
Intermediate representation: What data structure(s) in the host language do you use to represent a program in your DSL?
Execution: How did you implement the computational model? Describe the structure of your code and any special programming techniques you used to implement your language. In particular, how do the semantics of your host language differ from the semantics of your DSL?-->


## Evaluation: (preliminary evaluation)

<!--Provide some analysis of the work you did. In particular:

How “DSL-y” is your language? How close or far away is it from a general- purpose language?
What works well in your language? What are you particularly pleased with?
What could be improved? For example, how could the user's experience be better? How might your implementation be simpler or more cohesive? Are there more features you'd like to have? Does your current implementation differ from your larger vision for the language?
Re-visit your evaluation plan from the beginning of the project. Which tools have you used to evaluate the quality of your design? What have you learned from these evaluations? Have you made any significant changes as a result of these tools, the critiques, or user tests?
Where did you run into trouble and why? For example, did you come up with some syntax that you found difficult to implement, given your host language choice? Did you want to support multiple features, but you had trouble getting them to play well together?
If you worked as a pair, describe how you have divided your labor and whether that division has worked well.-->