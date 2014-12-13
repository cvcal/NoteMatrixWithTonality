# Tonatrix Final Write-Up


## Introduction: 

<!--Describe your domain and motivate the need for a DSL (i.e., how could domain-experts use and benefit from a DSL?). What is the essence of your language, and why is it a good language for this domain?-->

The domain of Tonatrix, or the Tone Matrix with Tonality language, is simple musical composition. My goals with this language were to create a language that would allow users to program musical melodies with multiple instruments, or voices, simultaneously, but to do so while allowing the tool to be used by people with no background in music theory or sound synthesis.

To keep it simple, I had to limit what type of sounds could be made. There are many existing tools and languages in this domain,  so I had many examples to base my ideas from. I knew that I couldn't try to make any thing resembling a fully featured synthesizer, as that would make the language far too complicated, but as varying voices was one of my initial requirements, I needed a way to specify different types of sounds, and as I was planning on having a graphics interface, I chose color. 

I also could not use standard musical notation if I wanted to keep the language accessible to people with no musical background. I decided to go for the tried and true grid representation, where the pitch is along the y-axis and time is along the x-axis. I don't think this is naturally intuitive, but it is such a commonly used system that it has become culturally so, at the very least.

## Language design details:

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


Tonatrix is a language written through a GUI, in which a user selects and un-selects cells in the grid. The user does not need to think of what absolute value a note has, though an understanding of intervals would help, but can simply click a note to play it with the selected instrument, and see what it sounds like. My ideal design is below:

<p align="center">
  <img src="https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_simple_inUse.png" width="500" />
</p>

In this idea, the user selects the instruments and size of the grid to use for the piece, and then can work within the grid to select which notes will be played by which instrument. Part of the design which I also really wanted to include in my language was the ability to control how often a single grid would loop, and how different grids could follow each other. This fully featured ideal is below.

<p align="center">
  <img src="https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_idea_withLoops_inUse.png" width="500" />
</p>


The GUI does not recognize anything that would cause an error, so there is no real need for error handling. The intermediate representation can ask for incorrect grid locations, but these should get ignored. I have not yet added error handling though, as I intend this to be used through the GUI, and through the GUI only. 

Of the many other languages and tools in the domain, some of the ones I found most relevant are the online tool [tonematrix](http://tonematrix.audiotool.com/), a text-to-sheet-music and midi output language called [ABC](abcnotation.com), a powerful but outdated 1995 workstation by Tim Thompson called [keykit](http://en.wikipedia.org/wiki/Keykit), a tool to compose using various tuning-system called [Scala](http://www.huygens-fokker.org/scala/), and a midi-sequencer called [Aria Maestosa](http://ariamaestosa.sourceforge.net/) that does much of what I'm interested in but emphasizes typical music-theory, and essentially requires some basic musical literacy.

Of these examples, the one I took the most to heart was tonematrix. I see my language, Tonatrix, to be, ideally, an extention of tonematrix. The online tool gives immediate feedback and is very intuitive to use as the locations being played are visually identified to make it easier for the user to quickly understand where the sounds are coming from. The main aspect I wanted to add to this is the ability to use multiple instruments. Other potential features initially included the ability to vary the notes' length and to use grids in loops with more control than the implicit continuous loop of tonematrix. I believe the looping functionality, which would allow sequencing of multiple grids with user-defined number of repetitions, can greatly enhance the power of this language, and it should still be within reach of the language, given a few more weeks' work. 

My current implementation has most of the initial design worked out. The user can select notes, remove them, and play the music. Here's what it looks like:

<p align="center">
  <img src="https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/pictures/workingVersionWithThings.png" width="250" />
</p> 

In the example above, there are parts on the grid associated with all four available instruments. The green instrument is selected in the upper-left hand corner, which means that clicking any location on the grid will either add a green note at the time and pitch, or remove one if there was already one there. To edit another color, first select that color from the color-chooser, then proceed. There is also a "Clear" button to empty the entire grid. The "Play" button essentially initiates the compilation step, in a sense. It will take all the notes and play them sequentially three times. The GUI does not yet have the capability of playing it for a variable number of times, though the underlying grid data structure does.

To give a sense of the intervals, the example below is "Twinkle Twinkle Little Stars," as in [this](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/src/tests/LargeGridTest.java) example program, but with all but the melody removed for visual clarity. 


<p align="center">
  <img src="https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/pictures/TwinkleTwinkleLittleStar.png" width="520" />
</p> 


## Language implementation:

<!--Describe your implementation. In particular, answer the following questions:

What host language did you use (i.e., in what language did you implement your DSL)? Why did you choose this host language (i.e., why is it well-suited for your language design)?
Is yours an external or an internal DSL (or some combination thereof)? Why is that the right design?
Provide an overview of the architecture of your language: front, middle, and back-end, along with any technologies used to implement these components.
“Parsing”: How does your DSL take a user program and turn it into something that can be executed? How do the data and control structures of your DSL connect to the underlying semantic model?
Intermediate representation: What data structure(s) in the host language do you use to represent a program in your DSL?
Execution: How did you implement the computational model? Describe the structure of your code and any special programming techniques you used to implement your language. In particular, how do the semantics of your host language differ from the semantics of your DSL?-->

Tonematrix is implemented in Java, using the JMusic library for the midi music output and the swift API for the graphical interface. I chose Java due to its versatility and cross compatibility. I also was initially hesitating with Scala for parts of the implementation, so I started by looking for music libraries in Java for compatibility and found all I needed, so it was fine.

I think my language is external in nature, but it is currently mixed in implementation. The IR is, obviously, entirely in Java, and the main interface should be the graphical interface, but the GUI is not yet full-featured and cannot stand on its own. The size of the grid and the four instruments available must all be declared in the java main class that launches the GUI. I want to eventually make the entire language environment stand on its own, but it hasn't reach that point quite yet.

The basic structure of the language is currently contained in the [Grid class](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/src/main/Grid.java). The intermediate representation is mostly made with simple variables and arrays. The grid of notes is a three dimensional boolean array representing the on/off state for each grid location (`x` dimension represents time, `y` represents pitch) for each instrument. The list of instruments is a two-dimensional array, since I wanted to be able to mark an instrument as selected/unselected as well as the number values. This is part of the implementation that I will probably wish to rethink as I expand the language and make it more adaptable. 

In the GUI format, the equivalent to parsing would be turning the clicks on screen into the appropriate changes of the grid. This is handled in the `mousePressed(MouseEvent)` method in the [Grid class](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/src/main/Grid.java), and executes by making the appropriate method calls to change the grid's contents. 

Since the grid is parsed continuously, the evaluation step just needs to compile the notes corresponding to the `true` values in the array, and translate these into Notes into Phrases into Parts (which have the instrument information) and combine them all to form Scores. This follows JMusic's hierarchy, and takes some getting used to, but it isn't quite as complicated as all the categories make it seem. On the other hand, having to deal with this reminded me why I had decided to forgo text-based input for my language. 

## Evaluation: 

<!--Provide some analysis of the work you did. In particular:

How “DSL-y” is your language? How close or far away is it from a general- purpose language?
What works well in your language? What are you particularly pleased with?
What could be improved? For example, how could the user's experience be better? How might your implementation be simpler or more cohesive? Are there more features you'd like to have? Does your current implementation differ from your larger vision for the language?
Re-visit your evaluation plan from the beginning of the project. Which tools have you used to evaluate the quality of your design? What have you learned from these evaluations? Have you made any significant changes as a result of these tools, the critiques, or user tests?
Where did you run into trouble and why? For example, did you come up with some syntax that you found difficult to implement, given your host language choice? Did you want to support multiple features, but you had trouble getting them to play well together?-->

I believe Tonatrix is very much a DSL. It is at the very least very far from a general purpose language, as it is mostly a way to input and describe musical sounds, but it could be argued that it is too close to being an app and has little about it that is truly a language. The looping implementation, with its ability to combine multiple grids after controllable numbers of loops, brings this language closer to being recognized as a programming language, but even without that feature implemented, I believe that Tonatrix treats the process of creating a song very much as a program. 

I am very pleased with my back-end. To see the Grid class before it was corrupted with all the GUI implementation, you can go to [this](https://github.com/cvcal/NoteMatrixWithTonality/commit/ea469d17c387d57383b35cbdad3dc3daef128dcb) commit. I believe I found the best way to translate my grid concept into a format compatible with the libraries available to me.

One thing I am not very pleased with is the structure of the GUI. The graphical interface is currently all coded into the [grid class](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/src/main/Grid.java), which was initially intended to be only to hold the back end but which I combined in order to have a working prototype by the end of the project. It saved me time, and I do now have something to show, so I believe the trade-off was worth it. I want to learn more about layout managers and designing graphical interfaces so that the different parts of the language can be appropriately separated instead of all thrown together into a pit. This will be necessary if I want to make the looping functionality, and will also make the code much more manageable and maintainable. 

To evaluate the language, I have mostly worked with example programs on my own, but I have also shown the grid GUI to friends with varying backgrounds in music to see how they would interact with it. For the most part, I think the interface is pretty easy to use, though I had a few people say that it wasn't at first obvious to them that the different colors represented different instruments. If I can implement real-time audio feedback with highlighting the columns as they are played, this disconnect would disappear, but until then, a few labels would probably help orient the user. In class, I was told that I should highlight certain rows to help make it easier to identify the intervals in the grid, but I have not yet done this. Partly, I don't want to impose a certain set of highlighted values that might influence which notes the user picks, and so I don't want to add anything until I can allow the user to toggle the view with highlights or tags and without. This will have to wait until the entire design is refactored. One feature request I do want to add which should be relatively trivial if I restructure the interface is to allow the user to change the rhythm, the speed at which each note is played. Mostly, however, I want to add everything I haven't yet had a chance to make - the ability to define the grid and instruments graphically, and the ability to loop multiple grids.

The biggest trouble I had in implementing this has been the sheer amount of learning (and re-learning) the environment I was developing in. I had to reacquaint myself with some aspects of Java that had been overwritten by C++, and to familiarize myself with the JMusic library and with creating graphical interfaces with swift. Every step along the way, learning the tools took at least half of the time, and then actually adding the functionality to my grid was relatively minimal. 

I also realized that I would have to give up on the multiple-note duration feature that I mentioned in the [design and implementation](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/design_and_implementation.md) document. This can be added, but I would have to restructure the very basic layers of my grid, as it wouldn't really be a grid anymore, and I would loose the nice correspondence between the grid and structure that I currently have. In short, the "nice" implementation for everything else I wanted in the language does not work at all with the nicest version I can think of that includes free range of notes. There are exceptions to this, I could add notes that span multiple cells without ever subdividing a single cell, and keep the grid structure, but that's another compromise.

I believe Tonatrix has come a long way towards the vision I had for it, but I recognize that there are still many things that I have yet to implement or that I should improve. It is still a language in its own right, though, only a very little one.



