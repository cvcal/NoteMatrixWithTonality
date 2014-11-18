Critique - Matt Cook

Overall, I would say the project looks well-defined, and you have a good idea of the overall control and data structures necessary to make this happen. The images of what a program would look like is very useful to show what a a working program will look like, as well as making it more intuitive as to how one would interact with this language.

A couple of possible sources for error (or just things to consider) that foresee could happen (although likely easy to fix):
- How will the user define the dimensions of the grid? Dragging/sliders would make it impossible to have errors, just a heads up in case you choose to allow the user to enter in a number for dimensions (not sure if a grid too large is an issue, or it will just scale to be infinitely small or something and then crash).
- I'm not sure how one will clear a grid location at the moment? You could have a clear cell button that would then clear the cells you click, but then for cells with multiple colors would it clear all of them?

Also, currently the structure for the language looks clear with your current outline of data structures, but I would say it is not exactly clear what a program as an internal DSL will look like. This is fine for now as maybe it will make more sense as you dive more into jMusic itself, but it would be nice to know what a program would look like (what would have to be created, the order of things in the language, etc.).

As for the issues with jMusic... I am not sure. It does seem odd that the instruments are not in a package, which means you would have to import each individually it seems, which is odd. If you don't get any info on how to resolve it from Prof. Keller, I think you should definitely just put the files in your project, as you would only need 6 (one for each color), so it wouldn't be too tedious to have something you can work with.

It would be cool to have be able to specify a pretty simple program next week for the prototype, possibly with just picking instruments, and the time/pitch in the grid (I'm not sure how hard it is to add in the modulation part with the instruments, but it seems like for a prototype it would just be nice to add notes of selected types to a grid) in an internal language form, as the UI will likely take much more time.
