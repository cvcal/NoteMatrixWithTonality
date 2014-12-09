# Note Matrix with Tonality project

<p align="center">
  <img src="https://github.com/cvcal/NoteMatrixWithTonality/blob/master/documents/pictures/logo.png" width="40" />
</p>

See the 
[project requirements](http://www.cs.hmc.edu/~benw/teaching/cs111_fa14/project.html) 
for instructions on setting up your project.

# Download and build instructions

First, you'll need the [JMusic](http://explodingart.com/jmusic/) library.
The downloading and installation instructions can be found 
[here](http://explodingart.com/jmusic/GetjMusic.html), 
with the following caveats:
* The `inst/` directory doesn't have a package, and I kept having build errors 
  no matter how I altered the classpath variable or tried to include the 
  source/compiled files.. For this reason, I am not using this as they specify 
  in the JMusic documentation. I will instead, at least for now, include any 
  instrument classes I need in my project, so you don't need to add this 
  directory to use this project.
* I also found that part of the instructions were off. For my default, bash-
  using mac, I had to put the export classpath line in the `~/.bash_profile` 
  file, not `~/.bashrc`. 

If you have other problems, let me know! Also, I've been editing this in the 
scala version of the Eclipse IDE for a number of reasons, and that might make 
some of the dependency things odd, so you'll probably have to fix that for your
machine until I figure out how to make it cleaner, but that isn't my priority 
right now, so that won't happen immediately.


