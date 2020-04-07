Updating password in cntlm : 

In a Linux slice, cntlm config file is usually located here : 

    /etc/cntlm.conf

Many corporate security policies require regular password changes, CNTLM makes these very easy.

First, get the hashes for the new password with: `cntlm -H`

Copy and paste those hashes into your cntlm.conf file located at: 
`/usr/local/etc/cntlm.conf`

(
if you get this error while trying to edit the file : readonly option is set (add ! to override) - 
This happens when the user is trying to write on a file without the right permissions. Login as root using sudo su and now you can do the edit.
)

Restart your CNTLM instance and reconnect, you should be good to go 

`: brew services restart cntlm` (if you have brew installed)

If this doesn't work, restarting the slice using the command `reboot` works.
