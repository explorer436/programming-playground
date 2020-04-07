If you need to kill a process manually on Windows it’s actually pretty easy. First, fire up a command prompt and type the following command.

`netstat -a -o -n`

To kill the process we need to find the PID of the process in question. I just run down the list by port until I find port 8080 and here you will see the process id was 28344.

Finally, with the PID we can run the following command to kill the process

`taskkill /F /PID 28344`

----------------------------------

In Linux : 

This command will print you PID of process bound on that port :
`fuser 8080/tcp`

And this command will kill that process : `fuser -k 8080/tcp`

----------------------------------

If anyone is running into issues with port 80 blocked while setting up their new slice, I have a workaround if you would like to use it.  I have an open ticket with VDE support to see about getting the Citrix Virtual Desktop Service changed to a different port.  I will let you know when they have verified this fix or have a different workaround.
I have been able to successfully reboot my slice several times and log back into the Citrix Workspace with no issue.
Verify it is the Citrix Desktop Service running over port 80 by using the following command (as Admin):
netsh http show servicestate | findstr HTTP
Run the following command to change its port (you should run netstat -aon to make sure the number you choose is free).
C:\Program Files\Citrix\Virtual Desktop Agent\Agent Configuration\Agentconfig.exe /portnumber:4150
Restart the Citrix Service (or reboot your machine)

----------------------------------
