This is a small example how to use ordered broadcasts.
The example has 2 buttons:
1. Press on the first button and both receivers will accpet the broadcast
2. Press on the second button and the first receiver will abort the broadcast, thus it will not pass to the 2nd receiver

When checking the 1st Check Box (Register Dynamic broadcast), it will register a dynamic broadcast receiver with priority 3.
This means that the dynamic receiver will be triggered before the other static receivers.
when checking on the 2nd Check Box (Abort static broadcast...), it will case the dynamic receiever to the abort the broadcast. This way you can check if you app is visibile to the user (place the register unregister broadcast in the onStart/onStop or onResume/onPause of you app)

Notice: the priority in the AndroidManifest.xml file for each broadcast
