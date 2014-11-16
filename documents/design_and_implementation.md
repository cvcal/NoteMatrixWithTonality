# Language design and implementation overview

## Language design

First, here is an overview of how I want the final product to look. This goes 
hand-in-hand with how I want the user to input programs in my language. Deciding 
on the final functional appearance has clarified a number of design choiced, 
which I will go into further down.

* This is the basic idea, the first image with notes, and the second with some 
  squares colored in for a feel of what it would look like with things being 
  pressed.

<p align="center">
  <img src="https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_idea_simpleWithNotes.png" width="500" />
</p>
<p align="center">
  <img src="https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_simple_inUse.png" width="500" />
</p>

* This is that idea with the addition of being able to loop multiple 
  grids a preset number of times 

<p align="center">
  <img src="https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_idea_withLoops_inUse.png" width="500" />
</p>

* This is the original idea, with the possibility of having a single note last 
  more that one beat. The idea here is to have the user click a box to have it
  highlighted, as before, except that if the user clicks a box and drags the 
  mouse over to the next box, then a multiple-beat note is created. That way, 
  you can have both 
  
<p align="center">
  <img src="https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_idea_continuousTime_inUse.png" width="500" />
</p>

I want the user / programmer to go through the following order for each 
composition, regardless of whether coding in text (in the intermediate 
representation) or when using the GUI (if that gets implemented and works). I 
think this will help both me, in terms that it will set a number of things in 
stone and make the rest of the process more straightforward. The GUI should 
enforce this order, thus preventing errors.

1. Select the width and height of the grid they will be using. (In the looping 
   scenario, which seems more and more tempting, especially if I don't make 
   this a real time too, they would have to select the dimensions for each 
   grid. I might also want to leave the option for dynamically changing the 
   size of the grid, but definitely not in the first version.)
2. Select colors for the instruments. (More later on how I want to implement 
   the selection)
3. Select and highlight a single color then select the notes on the grid which 
   that instrument will play.
   * Clicking the square again will remove the note, and you can reselect a 
     color to edit it after having worked on other sections.

This order will allow me to define things in a logical order: you can't place 
things in a grid that hasn't had its boundaries defined, and you can't define 
notes that don't have a sound.

The looping version and varying not-length version should be relatively easy 
to add on top of a basic version, though I think the loop would be easiest. I 
will still focus on the basics first. Adding a looping structure on top of the 
basic grid will still require the grid implementation to be complete, so 
that's just an additional layer. The varying-length will probably be fine, but 
I will have to be careful with how the grid data-structure stores notes, and 
each note will need an explicit start and end time, or start time and 
duration, in order to make this possible.

Here's an outline of a potential system for selection colors:

<p align="center">
  <img src="https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_idea_colorSelection.png" width="350" />
</p>

This would let me restrict the total instruments to 6, but still give some 
control over aspects of the tone quality with the 3-by-3 selection afterwards, 
which I can add on *top* of the basic instrument, as some form of modulation.

The color selection is something I want to implement simply, so this limited 
set of 54 options will offer some flexibility while allowing me to not make 
this project a language that describes sound synthesis.

### Provided questions for this document:
I answered many of these questions above, but I wanted to include more explicit
answers here as well.

**How does a user write programs in your language (e.g., do they type in 
commands, use a visual/graphical tool, speak, etc.)?**

A user would write programs in the GUI described above.

**What is the basic computation that your language performs (i.e., what is the 
computational model)?**

My language will perform a transition from a visual representation of discrete 
notes that have relative pitch, location in time, and tone quality, to a sound 
file or audio output of these pitches and sounds looping.

**What are the basic data structures in your DSL, if any? How does a the user 
create and manipulate data?**

The Grid is the basic data structure, though I guess you could consider each 
note within the grid to be its own miniature data structure. Each note's 
position in the grid defines its time and pitch, and the user adds notes as 
described above. The grid then contains all of these notes and has the 
functionality to output sound based on this series of notes.

**What are the basic control structures in your DSL, if any? How does the user 
specify or manipulate control flow?**

The most basic control structure is, again, the grid. That is, until I 
implement the ability to loop multiple grids. Without the looping explicitly 
stated, the grid is an implicit loop, of which the user can define the length. 
With the loops explicitly added in, the user can then sequence multiple grids 
and control the number of repetitions for each grid.

**What kind(s) of input does a program in your DSL require? What kind(s) of 
output does a program produce?**

Inputs would be ideally just the mouse-clicks. Output would be an audio file, 
which would, again ideally, be playable from the GUI interface. In the likely 
event where the interface isn't fully operational by the end of this project, 
the input would be a Java program that uses my grid-and-note interfaces to 
create a particular grid object and output a sound file.

**Error handling: How can programs go wrong, and how does your language 
communicate those errors to the user?**

I don't see too many potential sources for errors. If I can make my GUI 
interface fully operational, I should be able to prevent illegal actions, as I 
would only recognize legal operations. With the intermediate representation, 
there is more room for error. Here are some potential situations:
 
* The order of the operations could be wrong. Defining the dimensions of the 
  board should be done in the constructor, so that would prevent notes from 
  being added to grid without defined dimensions. However, nothing would 
  prevent notes from using problematic colors, so I will need to be careful 
  with how I want to make users input colors and link note-objects to these 
  colors. 
* Notes could be inputed at incorrect locations, outside the bounds of the 
  grid. I would ignore these inputs and print a warning to stderr.
* Multiple notes at one location - in the GUI, this could be prevented by 
  simply defining a 'click-on-filled-square' to mean clearing that grid 
  location, so that it's impossible to have two instruments playing the same 
  note at the same time. This avoids the problem, but it doesn't solve it in a 
  way I like. I prefer allowing different instruments to play the same note, as 
  there is no good reason why they shouldn't, but that might mean dividing a 
  square into stripes/boxes with the colors that have selected it. If there's 
  only one color, that's easy, but if there's two, it would allow you to see 
  both. This means that adding two notes at the same grid location would not 
  actually be an error.

**What tool support (e.g., error-checking, development environments) does your 
project provide?**

The GUI is the only tool that I will provide. If this isn't complete, the way 
to input programs will be to use Java code directly, so any Java IDE or text-
editor should work.

**Are there any other DSLs for this domain? If so, what are they, and how does 
your language compare to these other languages?**

There a plenty. I've mentioned a number of these in 
[the description](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/description.md), 
the key members being the online tool 
[tonematrix](http://tonematrix.audiotool.com/), 
and some others: a powerful but outdated 1995 workstation by Tim Thompson 
[keykit](http://en.wikipedia.org/wiki/Keykit), 
a tool to compose using various tuning-system called 
[Scala](http://www.huygens-fokker.org/scala/), 
and a midi-sequencer called 
[Aria Maestosa](http://ariamaestosa.sourceforge.net/) 
that does much of what I'm interested in but emphasizes typical music-theory, 
and essentially requires some basic musical literacy.

My DSL is simpler than KeyKit, Scala and Aria, and more complex than 
Tonematrix. I think it avoids requiring users to know how to read music or to 
understand tuning systems, and has a much more limited set of possibilities 
than many of these examples, which I hope will make it easier to get into and 
play with without needing any training on the tool or musical literacy. It 
allows for greater control and variety of composition than Tonematrix.


## Language implementation

My basic implementation will pivot around a Grid class, which will contain 
Notes. Here is my expectation of the most basic functionality, for representing 
the program's composition:

**Program**
* contains a Grid or a list of loops of grids
* a method to play and/or export the audio version.

**Grid**
* constructed with height, width, (tempo?, scale?)
* an addNote and removeNote method of some sort.
* a method to translate the grid into the proper sequence of Midi events.

**Note**
* constructed with startTime or index, pitch, timbre or instrument, 
  (endTime or index?)

**Timbre or Instrument**
I need to figure out how to leverage my APIs for this step, I don't actually 
want this project to become a synthesis project, so I can't try to make this
perfect.

**Loop**
* Has a grid, or multiple grids, and the number of times it loops through.
* a method to translate the contents to audio.

### Provided questions for this document
As in the design section, I will provide direct answers to the DSL project's 
questions. There will be some repetition. 

**Your choice of an internal vs. external implementation and how and why you 
made that choice.**

The intermediate representation will be a set of classes in Java, so it will be 
internal. The language itself would be a graphical interface, which will 
necessarily be external. I believe the choices for this are obvious and can be 
seen in the design section of this document.

**Your choice of a host language and how and why you made that choice.**

I will be coding in Java. Partly, this is because of the extensive set of 
libraries and corresponding tutorials for sound creation and creating the GUI. 
I chose Java due to it's universality and flexibility, along with the fact 
that, since it is so close to Scala, I could potentially use some of the nice 
Scala features we discussed in class without having to translate the entire 
system. This is mostly relevant if I want to implement the external version of 
this mentioned below.

**Any significant syntax design decisions you've made and the reasons for those 
decisions.**

I described much of the clicking setup and composition order above. For this 
GUI, these decisions come from the desire to make everything as intuitive as 
possible, so that meant imagining myself with the grid and seeing my first 
instincts for how I would interact with it. 

Some difficulties that I had to clear up included how best to input notes with 
colors. Should you pre-select colors and click notes on the grid to add those 
to that instrument's track, or should you select the color every time you click 
a note. I figured it would be more intuitive to be able to select multiple 
notes for an instrument at a time, so I preferred the first option. Another 
difficulty was how to choose colors and tones in the first place. I ended up 
choosing to directly map my 6 colors with instruments, and add some modulation 
on top for added variety, in order to avoid making this project solely about 
synthesizing sounds.

**An overview of the architecture of your system.**

This is outlined above. 

### Interesting thoughts, that I probably won't bother with.

If the data structures above describe the representation of the program as it 
is being messed with, and I do think that that is the main advantage of an 
object-oriented approach like this, it doesn't solve the problem of saving 
'programs/compositions.' For this purpose, it might also be nice to create an 
external language of some sort. This language could translate into and out of 
the object-oriented version, as a way to save the programs in a textual form, 
and open them back up to be edited. It would also be a nicer textual interface 
than direct creation of objects through Java, and might be nice for testing 
purposes because of this.

This external DSL might look something like this:

```
Timbre(some encoding) x4
Grid(x,y)
    Note(start, end, pitch, timbreType)
    Note(start, end, pitch, timbreType)
    ...
```

This would be a cool project on top of the current project, mostly for personal benefit (I would learn more about saving things, it would be a nice way to add new features later on before adding them to the GUI, etc.) but would not be very useful beyond this, as there are potentially other ways to save programs, say by using the Serializable interface.
