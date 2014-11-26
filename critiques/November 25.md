##Critique for November 25: Mauricio Molina

I'm really happy that you got things to work well! I eventually turned to java to handle sound production as well and it's working much more smoothly. I totally agree with working with just a few instruments for now to try to get a prototype, and then add more later as necessary. I feel that adding instruments later should be fairly simple compared to some of the logic and code that may be necessary for the rest of your DSL. 

Now that you're making more progress, I'm just wondering what your feelings on your original designs are. What are you expecting to finish by the end of the semester? 


##Questions from Chloe
####My grid works! So now I need to work on my GUI. I haven't really begun to look into the best ways to do this. If you know of a good place to start looking, that would be cool.

In terms of your GUI, i tried working myself with Java Graphics API and other libraries, but ended up going with what I used in the past, which is a simple graphics library called [objectdraw](http://eventfuljava.cs.williams.edu/library/objectdrawJavadocV1.1.1/), which is used in the intro sequence at pomona college to help construct simple graphics. It probably won't be great for making anything incredibly fancy, but if you need a relatively easy library to use, I find objectdraw fairly simple. I can even put up a couple sample programs for you if you like!  Once you get the basics, constructing a grid and handling click events should be fairly easy. Please feel free to ask me and I can provide a ton more resources. 

Of course, if you'd prefer something a bit more powerful I think [Java 2D Graphics](http://docs.oracle.com/javase/tutorial/2d/) will probably work fairly well! There are several examples available online. 

####Is it ok to add the basic GUI first, and the looping functionality, before I worry about the extra instruments, or should the focus of my project be more about the instruments?

I think getting the main functionality is much more important than having a ton of instruments. I feel that most of your time should probably go to trying to creating the basic GUI and looping, as this is the main way that the user will be interacting and creating programs in your DSL. 

#### Should I implement a GUI for what I have first, or should I add the looping functionality first?

I think adding looping for what you have now would probably be ideal, and then trying to get minimal grid GUI effects working later. I feel that this backend effort should be as close to complete as possible so things don't get over complicated later with the addition of the GUI elements layer. If you do GUI first, then looping, you may have to keep updating GUI element to reflect those changes, instead of building a GUI on top of a working backend.

  
