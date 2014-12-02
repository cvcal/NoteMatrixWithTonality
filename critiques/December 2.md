
# December 2nd Critique - Paul Dapolito

## Preliminary Evaluation Feedback
It's great to hear that you got the backend of your DSL working! I think that it is probably a great decision to have your underlying data structure be a mirror of the GUI's grid structure. This is definitely the sort of modular software decision that will facillitate expanding your language in the future. I totally agree that doing this was a good decision!

The time you spent working on your underlying data structure and internal representation will be essential to the development of your language over the final weeks of the project. As you said, your implementation will be clean enough such that expanding the functionality of your grid will be trivial.

Have you considered adding-in any automated testing of your data  structure's implementation? As you change your implementation and add to your language in the next few weeks, it might be very beneficial to have an automated testing suite by which you can ensure that any changes you make still bring about the expected and desired underlying functionality. I see that your `tests` directory includes a sample test program, and I think your language would also benefit from creating dedicated unit tests. For example, you might ensure that the functionality of `addInstrument`, `changeLocation`, and `getScoreWithRepeats` all function properly independently of each other with respect to the `Grid` class. 

I think that the very existence of your sample program `BasicGridTests.java` is indicative of awesome progress on your project. It seems that the sample program lends itself well to being represented graphically, and I really look forward to what you will produce in that regard!

Adding automated unit tests for a `Grid`'s functionality is definitely less important than pushing forward with your language's GUI. It seems that you have a great feel for how the GUI should look and how a user's experience should be manifested. In light of reading about what you have had trouble with thus far in the project, I am wondering how you plan on implemening a GUI for the language. Do you have some library at-the-ready for this task? I have never personally developed a GUI in Java, and I am wondering how far down this road you have gone already. Have you thought about what would constitute a "minimally viable" implementation of your language's front-end?

## General Feedback

I had a bit of trouble downloading and installing JMusic with the specific caveats that you mentioned in your projects README.md file. I think that a good way to encapsulate these sort of installation issues is to create a bootstrap script for your project which performs all of the necessary installation and setup neeed to have users execute programs in your language right away. This script could also easily accommodate the caveats you mentioned regarding JMusic's `inst` directory.

I think that your implementation is off to an absolutely great start, and as I mentioned earlier in my critique, I think you can validate the quality of your internal representation using an automated testing suite. Besides this one note on your progress thus far, I think you are progressing your language perfectly, and I think that the groundwork you laid in implementing the `Grid` class will be extremely useful as you develop a GUI for your language.

Great job on putting forth a high-quality backend for your language. I really look forward to seeing how great your GUI turns out!

## Specific Questions
In terms of helping users "eyeball" intervals in your matrix, I think that highlighting rows and allowing users to shift which row is highlighted seems like it would lead to the best user experience. I do not know enough about music to really give great advice here, but it'd seem most intuitive to me to visualize the musical intervals with an assistive highlight rather than clogging-up your user interface with text.

