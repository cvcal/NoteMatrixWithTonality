# Project description and plan

## Motivation

Music is universally appealing, and everyone is capable of making music, which you might notice by asking people to hum, sing, or whistle, regardless of their ability to read music, recognize harmonies, or understand theory. Unfortunately, these traditional methods at music creation are all barriers to entry, and any intuitive musical capabilities are often pushed under the carpet because of the contrast with people who have passed these barriers. 

There exist a number of new methods of making music which try to make the interface as intuitive as possible, avoiding musical scores and note names and the like. One of my favorite examples of this type is the tonematrix and tenori-on version. This idea, a matrix of potential notes, some of which are selected and looped over, has been used extensively. In the case of the tenori-on, there are many functions, with different types of loops all displayed on the same screen, which I find too complex for immediate understanding, not to mention that the  format forces the varied functionality to all be expressed similarly, so that the user must remember what mode they are in, with minimal external clues.  In the case of the internet app tonematrix, or equivalent, the functionality is on the opposite end of the spectrum. It is very basic, only allowing one type of tone at once, one length of note, one loop.

I wish to extend the tonematrix to allow for more varied musical creation, and think that approaching this problem from the perspective of language design will help avoid the cluttered trap of the tenori-on. 

## Language domain

Music! Specifically, simple, intuitive instrumental capabilities.

There are plenty of existing languages in this domain. One obvious one is the tonematrix, described above. I would consider this a language, as it allows you to add, edit, and view the sequence of notes in your "program," which is not true for other instruments. A keyboard layout can be used to record things, but cannot be edited visually like the matrix format, since each note is played at its time, and does not appear visually at any other time, so it is impossible to see the piece as a whole. 

Other DSLs that do this sort include ABC (abcnotation.com), that takes textual input and can convert it to MIDI sound and a musical score image. This type of DSL, which is basically a textual way to input music in order to create scores, and is in no way intuitive, requiring a thorough grasp of musical notation and notes. 

Plenty of others go further this path, Haskore and CSound being favorite examples. These are much more powerful languages than ABC, but provide the synthesizer capability wrapped in syntax that's only friendly to people comfortable with standard programming languages. 

These should serve as a warning. I need to keep the simplicity of the tonematrix, avoiding anything too code-y. However, I also cannot try to make this a replication of musical synthesizer programs that rely on knobs and dials to alter the values that describe timber and tone, as that will loose the advantage of designing this as a DSL.

## Language design

## Example computations
