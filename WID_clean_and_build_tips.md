List only files of a particular extension with the DIR command:

`dir *.class`

`dir /S *.class`

will show files with ".txt" suffix in specified directory and all sub-directories.

When you do a full clean/build within wid it takes quite some time to do the clean part.  
So, before you do a clean/build,  close WID, then go into a cmd prompt into your workspace and
use the command  'del *.class /s' to delete the compiled class files.
It takes about 10 seconds instead of letting wid do the clean in like 15 minutes.
