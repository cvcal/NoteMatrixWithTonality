# Language design and implementation overview

## Language design

First, here is an overview of how I want the final product to look. Deciding on the final functional appearance has clarified a number of design choiced, which I will go into further down.

* This is the basic idea, the first image with notes, and the second with some squares colored in for a feel of what it would look like with things being pressed.
	![Basic with notes](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_idea_simpleWithNotes.png)
	![Basic in use](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_simple_inUse.png?raw=true)
* This is that idea, with the possibility of having a single not last more that one beat. 
	![Multiple beats](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_idea_continuousTime_inUse.png?raw=true)
* This is the original idea with the addition of being able to loop multiple grids a preset number of times 
	![Loops](https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/initial_examples/GUI_idea_withLoops_inUse.png?raw=true)

I want the user / programmer to go through the following order for each composition, regardless of whether coding in text (in the intermediate representation) or when using the GUI (if that gets implemented and works). I think this will help both me, in terms that it will set a number of things in stone and make the rest of the process more straightforward.

1. Select the width and height of the grid they will be using. (In the looping scenario, which seems more and more tempting, they would have to do this for each grid. I might also want to leave the option for dynamically changing the size of the grid, but definitely not in the first version.)
2. Select colors for the instruments. (More later on how I want to implement the selection)
3. Select and highlight a single color then select the notes on the grid which that instrument will play.
   * Clicking the square again will remove the note, and you should be able to 


## Language implementation

