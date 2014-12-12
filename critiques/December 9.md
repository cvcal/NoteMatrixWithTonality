Critique - Matt Cook

Responses to questions:

Though I would say it would be best to be able to separate the GUI from backend MVC style (which seems to be the way archetypal
for Swing applications), and just add some simple classes that keep track of data you would need, at this point it may not be
worth the trouble to do that based on size of project. Obviously as it grows larger it will be quite unwieldy to have it 
all together, but properly refactoring may end up taking too long, particular as it looks like there are still components
you would like to implement before the deadline. 

~~Though in terms of having it as part of the grid, that may be tricky because of other elements you mention such as the
color-picker. Would it be possible to just have a GUI class that has a grid and color picker, and just make a bunch of accessors
into the grid?~~ Just saw the most recent commit and it looks like you got it to work as one class! Woo!

The pictures you have in the newest notebook entry (with color picker and grid and buttons) look very cool! I wanted to try to get the
the project on my own machine but I don't think I have quite enough experience to get it running in a reasonable amount of time...
I have jMusic downloaded, but am a bit lost on getting it to work. It doesn't seem like I could get it to recognize jMusic despite
being in what I believe is the path, and I think I may not have Swing components as well? I tried (albeit, not extensively, was 
just trying to see if I could get one quickly together) making an eclipse project and adding the files, but had no luck. I know
it is not complete yet currently, but it would definitely be great to just have an executable jar file or something!

From the looks of it, you look like you have something very cool that you could already demo! Adding the ability to choose
the instruments would be very cool as well, as well as allow for the possibilities-to-implementation ratio (if that exist) 
probably be way larger as well, as it multiplies the amount of ways the user can create a piece of music. 

~~One thing I am wondering is if the clear button clears the whole board? I am kinda assuming so, but then with that, you could
possibly make a way to clear specific cells? It could just be another cell color/option, or if you go to add the ability
to choose instruments, you could make a no instrument option (though this may be a bit tricky if you want only white cells
to correspond to no sound).~~ Actually I just realized you mention that you can add/remove notes already, in which case I am
assuming remove is by simply choosing the same color and same cell, and it will just trigger to off?

It looks like you have addressed most of the concerns you had from the previous week's state, and to me it looks thorough
the functionality you already have implemented. 

There may only be enough time to implement the instruments (if that, depending on the time it takes to do final writeup and
cleaning up), but if you do have extra time, one thing that would be cool would be highlighting of the column that is playing 
(unless that is already implemented as I can't tell from looking at it :P ). Or, maybe allow some way to change the tempo of
the piece? That may not require too much coding, and would allow for the sound to change a great deal (unless that is something
you do not want to allow in your DSL). Another option would be allowing updating while playing, but
that may be more tricky as earlier issues you mentioned about real-time audio and how long it takes, 
and I would say that is less necessary.

I may try to get the project to work on my computer again later, but if you do end up making a jar or something soon and would like feedback
on it, I would be happy to help! Good luck on the final stretch!

