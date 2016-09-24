# GhostCoder-iTerm
A Ghost Coder implementation for [iTerm2](http://www.iterm2.com) in java.

Ghost Coder makes your live-coding presentations flawless by
automatically typing commands into your iTerm2 session from
a script. Never mistype live again.

# Usage
Ghost Coder works as an [iTerm2 coprocess](http://www.iterm2.com/documentation-coprocesses.html).
To start Ghost Coder, select the `Shell > Run Coprocess...`
menu item or press `⌘⌥R` with an active shell.

In the `Coprocess command to run:` text box, enter the path
to `ghost-coder.jar`, followed by the path to a script file.

    java -jar ~/ghost-coder.jar ~/script.txt

Ghost Coder script files are text files with each command
on a separate line.

Once the coprocess has started, press the back-tick key
(under `esc`) to enter the next script line into the shell. The
coprocess will terminate when the last script command is
processed.