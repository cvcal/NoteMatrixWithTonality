# Project plan

## Language evaluation

I will consider this language successful if it is as intuitive as tonematrix to start with, and has the added capability to assign colors and corresponding tones to each note. 

I will judge intuitiveness by presenting it to students with varying degrees of musical literacy, and seeing how quickly they begin to mess around with it purposefully, as opposed to randomly.

For judging the quality of my implementation, I will need to peer-review the project, including implementation code and examples, with someone else in the class. This step should happen more than once, maybe once every 2 weeks, so that I can identify potential pitfalls or inelegance earlier rather than later. 

## Implementation plan

The "final product" is due December 12th, which leaves the ~6 following weeks to work on the project. I tried to keep these goals reasonable, in terms of how quickly I expect to work, but this list should still be viewed as a rough outline.

* Sunday 11/9: Decide which host language to use. I am currently leaning towards Java/Scala, as there are plenty of sound creation/manipulation libraries. If I confirm this quickly, I should familiarize myself with the libraries I will be using, and start on the intermediate representation of my language. 

* Sunday 11/16: Convincing draft of the IR. This should include an understanding of the advantages and disadvantages of various representations, as well as the relative ease of extending the IR into accepting varying-length notes and adding control structures to manipulate the sequence of sections. A difficult step will be to encode the type of sound required; I might need to make a color-creation step, linking sound qualities to colors, or I might simply need to somehow convert an RGB value, or some other color model, into tone quality.

* Sunday 11/23: Completed IR, with example programs described in it. Begin work on the interpretor. Laying out the notes at the right time shouldn't be too difficult, but I will need to spend considerable time working on controlling the tone quality properly.

* Sunday 11/30: Continue working on the interpretation, probably editing the IR to accommodate difficulties in tone-quality control. 

For the final two weeks, I am not going to bother trying to guess where I will be. If my implementation of the IR and interpretation is sufficiently solid at this point, I can start creating a GUI. If not, I should continue working on basics of my language, and create more IR-programs to test it's functionality. 


