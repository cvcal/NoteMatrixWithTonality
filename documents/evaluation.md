# Tonatrix Preliminary evaluation

<!-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -->
## What works well? What are you particularly pleased with?

I'm glad I got the backend to work. It works well, quickly and convincingly,
and the class interface should make the clicking easy to implement, as the grid
keeps track of whether clicking means adding or removing. 

I decided to make the grid's data structure be basically a pure translation of 
the GUI grid, instead of having it be translated into the MIDI equivalent 
immediately when notes are added or removed, mostly because this would make 
removing notes much easier. I think this was a good design decision, so I'm 
pretty happy with it.

I also kept the data structure implementation clean in a way that will make it 
very trivial to add the looping functionality, in fact, the grid won't really 
have to change at all. The multiple-note one would take a bit more work, but 
it should be doable without any overly radical shift.


<!-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -->
## What could be improved? 

**For example, how could the user's experience be better? How might your 
implementation be simpler or more cohesive?**

Concerning the backend-structure discussed above, the fact that the parts/
notes aren't stored as is but marked down as "on/off" states in a boolean 
matrix means that the music isn't "compiled" until the user asks for it, 
which I worried might cause a lag, but so far the tests I've run haven't 
been too bad. I'm thinking of also adding a 'lazy' feature where I keep track 
of whether the parts are dirty (have been edited since last compile) or clean, 
to avoid having to recalculate everything. This would be relatively trivial to 
add, so I'll only worry about it if the lag is too noticeable.

Of course, I haven't made the GUI yet, so that is a major aspect of the 
language that is missing. The user experience is pretty hard to judge before 
this is up and running.


<!-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -->
## Evaluation Plan results. 

**Which tools have you used to evaluate the quality of your design?**

I haven't yet tried any user testing (no GUI) but I have shown the GUI idea to 
a number of people, both inside the class and out, to see if their reactions 
to it match with how I think they should view it if it is sufficiently 
'intuitive.' 

**What have you learned from these evaluations?**

Mostly the GUI should be relatively intuitive. I had a few people express 
concern that if the grid is sufficiently big (and I'm thinking of making it 
size-adjustable) then it will be hard to get a sense of where things are and 
what the intervals are. This is a concern especially since I'm planning on 
leaving the full chromatic scale available, which means an octave occurs every 
12 notes, and not one wants to count that.

**Have you made any significant changes as a result of these tools, the 
critiques, or user tests?**

I think I need to have stripes behind the boxes in the grid to indicate 
octaves, maybe more (octave and perfect 5th above each octave maybe) to give 
users a reference point. I'll have to decide what not to mark as the 
fundamental though, and whether I let the users change that, because that 
might make it harder to write in some scales. Since part of the point of 
having the full chromatic scale available is to let users make any sequence of 
notes possible in 12TET, I don't want to 'suggest' a scale by highlighting 
it's component notes.


<!-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -->
## Where did you run into trouble and why? 

**For example, did you come up with some syntax that you found difficult to 
implement, given your host language choice? Did you want to support multiple 
features, but you had trouble getting them to play well together?**


<!-- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -->
## What's left to accomplish before the end of the project?

