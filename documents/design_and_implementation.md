# Language design and implementation overview

## Language design

First, here is an overview of how I want the final product to look. Deciding 
on the final functional appearance has clarified a number of design choiced, 
which I will go into further down.

* This is the basic idea, the first image with notes, and the second with some 
  squares colored in for a feel of what it would look like with things being 
  pressed.
  ![Basic with notes](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_idea_simpleWithNotes.png)
  ![Basic in use](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_simple_inUse.png?raw=true)
* This is that idea, with the possibility of having a single not last more 
  that one beat. 
  ![Multiple beats](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_idea_continuousTime_inUse.png?raw=true)
* This is the original idea with the addition of being able to loop multiple 
  grids a preset number of times 
  ![Loops](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_idea_withLoops_inUse.png?raw=true)

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
![Colors](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_idea_colorSelection.png?raw=true)
This would let me restrict the total instruments to 6, but still give some 
control over aspects of the tone quality, which I can add on *top* of the 
basic instrument, as some form of modulation.

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

If the data structures above describe the representation of the program as it 
is being messed with, and I do thing that that is the main advantage of an 
object-oriented approach like this, it might also be nice to create an 
external language of some sort. This language could translate into and out of 
the object-oriented version, as a way to save the programs in a textual form, 
and open them back up to be edited. It could also serve as a way to test a big
portion of my language before worrying about the GUI.

This external DSL might look something like this:

```
Timbre(some encoding) x4
Grid(x,y)
    Note(start, end, pitch, timbreType)
    Note(start, end, pitch, timbreType)
    ...
```

I need to work this out some more, but I think that my first priority is to
find how to implement the control over timbre/tone quality/instrument/whatever
you want to call it. The way I choose to 'encode' the timbre will come directly
from the way that the user selects it, how much control they are given, and
the types of variables that my implementation of it needs.


