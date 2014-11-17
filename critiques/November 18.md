Critique - Matt Cook

Overall, I would say the project looks well-defined, and you have a good idea of the overall control and data structures necessary to make this happen. The images of what a program would look like is very useful to show what a a working program will look like, as well as making it more intuitive as to how one would interact with this language.

A couple of possible sources for error (or just things to consider) that foresee could happen (although likely easy to fix):
- How will the user define the dimensions of the grid? Dragging/sliders would make it impossible to have errors, just a heads up in case you choose to allow the user to enter in a number for dimensions (not sure if a grid too large is an issue, or it will just scale to be infinitely small or something and then crash).
- I'm not sure how one will clear a grid location at the moment? You could have a clear cell button that would then clear the cells you click, but then for cells with multiple colors would it clear all of them?

Also, currently the structure for the language looks clear with your current outline of data structures, but I would say it is not exactly clear what a program as an internal DSL will look like. This is fine for now as maybe it will make more sense as you dive more into jMusic itself, but it would be nice to know what a program would look like (what would have to be created, the order of things in the language, etc.).

TO BE CONTINUED
