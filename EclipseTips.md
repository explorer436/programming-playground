Toggle full screen (zen mode) : `Alt + F11`

---------------------------------------------

In some Eclipse packages, like STS or Eclipse for JEE Developers, the Terminal is already installed in your IDE. 
If not, you can install the TM Terminal from the Eclipse */release update site, as you can see in the image below.
To open the command prompt (shell or terminal) using the path of a project directory inside Eclipse, you just need to select the folder, and press `Ctrl+Alt+T`, or right-click and select Show In Local Terminal > Terminal.

Use CTRL-ALT-SHIFT-T to choose which type of Terminal to run.

---------------------------------------------

How do you get Eclipse to auto-generate a main method in a new Java class?  Type `main` and press `ctrl+space`.

---------------------------------------------

Editor window commands : 

Ctrl+M 	Maximize or un-maximize current Editor Window (also works for other Windows) 

Ctrl+Page Down/Ctrl+Page Up 	Switch to next editor / switch to previous editor

Ctrl+E 	Show list of open Editors. Use arrow keys and enter to switch

Ctrl+W 	Close current file

Ctrl+Shift+W 	Close all files

---------------------------------------------

Run and debug :

 Ctrl+F11 	Save and launch application (run)

---------------------------------------------

Helpful shortcuts : 

1. Manage Files and Projects
Ctrl+N 	Create new project using the Wizard
Ctrl+Alt+N 	Create new project, file, class, etc.
Alt+F, then . 	Open project, file, etc.
Ctrl+Shift+R 	Open Resource (file, folder or project)
Alt+Enter 	Show and access file properties
Ctrl+S 	Save current file
Ctrl+Shift+S 	Save all files
Ctrl+W 	Close current file
Ctrl+Shift+W 	Close all files
F5 	Refresh content of selected element with local file system

2. Editor Window
Focus/ cursor must be in Editor Window for these to work.
F12 	Jump to Editor Window
Ctrl+Page Down/Ctrl+Page Up 	Switch to next editor / switch to previous editor
Ctrl+M 	Maximize or un-maximize current Editor Window (also works for other Windows)
Ctrl+E 	Show list of open Editors. Use arrow keys and enter to switch
Ctrl+F6/Ctrl+Shift+F6 	Show list of open Editors. Similar to ctrl+e but switches immediately upon release of ctrl
Alt+Arrow Left/Alt+Arrow Right 	Go to previous / go to next Editor Window
Alt+- 	Open Editor Window Option menu
Ctrl+F10 	Show view menu (features available on left vertical bar: breakpoints, bookmarks, line numbers, …)
Ctrl+F10, then n 	Show or hide line numbers
Ctrl+Shift+Q 	Show or hide the diff column on the left (indicates changes since last save)
Ctrl+Shift++/- 	Zoom text in/ out

3. Navigate in Editor
Home/End 	Jump to beginning / jump to end of indention. Press home twice to jump to beginning of line
Ctrl+Home/End 	Jump to beginning / jump to end of source
Ctrl+Arrow Right/Arrow Left 	Jump one word to the left / one word to the right
Ctrl+Shift+Arrow Down/Arrow Up 	Jump to previous / jump to next method
Ctrl+L 	Jump to Line Number. To hide/show line numbers, press ctrl+F10 and select 'Show Line Numbers'
Ctrl+Q 	Jump to last location edited
Ctrl+./Ctrl+, 	Jump to next / jump to previous compiler syntax warning or error
Ctrl+Shift+P 	With a bracket selected: jump to the matching closing or opening bracket
Ctrl+[+]/Ctrl+- on numeric keyboard 	Collapse / Expand current method or class
Ctrl+[/]/Ctrl+* on numeric keyboard 	Collapse / Expand all methods or classes
Ctrl+Arrow Down/Ctrl+Arrow Up 	Scroll Editor without changing cursor position
Alt+Page Up/Alt+Page Down 	Next Sub-Tab / Previous Sub-Tab

4. Select Text
Shift+Arrow Right/Arrow Left 	Expand selection by one character to the left / to the right
Ctrl+Shift+Arrow Right/Arrow Left 	Expand selection to next / previous word
Shift+Arrow Down/Arrow Up 	Expand selection by one line down / one line up
Shift+End/Home 	Expand selection to end / to beginning of line
Ctrl+A 	Select all
Alt+Shift+Arrow Up 	Expand selection to current element (e.g. current one-line expression or content within brackets)
Alt+Shift+Arrow Left/Arrow Right 	Expand selection to next / previous element
Alt+Shift+Arrow Down 	Reduce previously expanded selection by one step

5. Edit Text
Ctrl+C/Ctrl+X/Ctrl+V 	Cut, copy and paste
Ctrl+Z 	Undo last action
Ctrl+Y 	Redo last (undone) action
Ctrl+D 	Delete Line
Alt+Arrow Up/Arrow Down 	Move current line or selection up or down
Ctrl+Alt+Arrow Up/Ctrl+Alt+Arrow Down/ 	Duplicate current line or selection up or down
Ctrl+Delete 	Delete next word
Ctrl+Backspace 	Delete previous word
Shift+Enter 	Enter line below current line
Shift+Ctrl+Enter 	Enter line above current line
Insert 	Switch between insert and overwrite mode
Shift+Ctrl+Y 	Change selection to all lower case
Shift+Ctrl+X 	Change selection to all upper case

6. Search and Replace
Ctrl+F 	Open find and replace dialog
Ctrl+K/Ctrl+Shift+K 	Find previous / find next occurrence of search term (close find window first)
Ctrl+H 	Search Workspace (Java Search, Task Search, and File Search)
Ctrl+J/Ctrl+Shift+J 	Incremental search forward / backwards. Type search term after pressing ctrl+j, there is now search window
Ctrl+Shift+O 	Open a resource search dialog to find any class

7. Indentions and Comments
Tab/Shift+Tab 	Increase / decrease indent of selected text
Ctrl+I 	Correct indention of selected text or of current line
Ctrl+Shift+F 	Autoformat all code in Editor using code formatter
Ctrl+/ 	Comment / uncomment line or selection ( adds '//' )
Ctrl+Shift+/ 	Add Block Comment around selection ( adds '/... */' )
Ctrl+Shift+\ 	Remove Block Comment
Alt+Shift+J 	Add Element Comment ( adds '/** ... */')

8. Editing Source Code
Ctrl+Space 	Opens Content Assist (e.g. show available methods or field names)
Ctrl+1 	Open Quick Fix and Quick Assist
Alt+/ 	Propose word completion (after typing at least one letter). Repeatedly press alt+/ until reaching correct name
Ctrl+Shift+Insert 	Deactivate or activate Smart Insert Mode (automatic indention, automatic brackets, etc.)

9. Code Information
Ctrl+O 	Show code outline / structure
F2 	Open class, method, or variable information (tooltip text)
F3 	Open Declaration: Jump to Declaration of selected class, method, or parameter
F4 	Open Type Hierarchy window for selected item
Ctrl+T 	Show / open Quick Type Hierarchy for selected item
Ctrl+Shift+T 	Open Type in Hierarchy
Ctrl+Alt+H 	Open Call Hierarchy
Ctrl+Shift+U 	Find occurrences of expression in current file
Ctrl+move over method 	Open Declaration or Implementation

10. Refactoring
Alt+Shift+R 	Rename selected element and all references
Alt+Shift+V 	Move selected element to other class or file (With complete method or class selected)
Alt+Shift+C 	Change method signature (with method name selected)
Alt+Shift+M 	Extract selection to method
Alt+Shift+L 	Extract local variable: Create and assigns a variable from a selected expression
Alt+Shift+I 	Inline selected local variables, methods, or constants if possible (replaces variable with its declarations/ assignment and puts it directly into the statements)

11. Run and Debug
Ctrl+F11 	Save and launch application (run)
F11 	Debug
F5 	Step Into function
F6 	Next step (line by line)
F7 	Step out
F8 	Skip to next Breakpoint

12. The Rest
Ctrl+F7/Ctrl+Shift+F7 	Switch forward / backward between views (panels). Useful for switching back and forth between Package Explorer and Editor.
Ctrl+F8/Ctrl+Shift+F8 	Switch forward / backward between perspectives
Ctrl+P 	Print
F1 	Open Eclipse Help
Shift+F10 	Show Context Menu right click with mouse


