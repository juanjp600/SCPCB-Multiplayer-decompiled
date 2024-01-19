Function kill%(arg0$, arg1%)
    Local local0%
    If (arg1 = $00) Then
        If (godmode <> 0) Then
            Return $00
        EndIf
    EndIf
    If (player_isdead() <> 0) Then
        Return $00
    EndIf
    If (breathchn <> $00) Then
        If (channelplaying(breathchn) <> 0) Then
            stopchannel(breathchn)
        EndIf
    EndIf
    If (0.0 <= killtimer) Then
        local0 = networkserver\Field28
        If (networkserver\Field15 = $00) Then
            createrolecorpse(myplayer\Field51, entityx(myplayer\Field13, $00), (entityy(myplayer\Field13, $00) + 0.32), entityz(myplayer\Field13, $00), entityyaw(myplayer\Field13, $00), myplayer\Field92, $00, $00, $00, $00)
        EndIf
        killanim = rand($00, $01)
        playsound_strict(damagesfx($00))
        If (selecteddifficulty\Field2 <> 0) Then
            deletefile((((currentdir() + savepath) + currsave) + "\save.txt"))
            deletedir((savepath + currsave))
            loadsavegames()
        EndIf
        killtimer = min(-1.0, killtimer)
        showentity(head)
        positionentity(head, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $01)
        resetentity(head)
        rotateentity(head, 0.0, entityyaw(camera, $00), 0.0, $00)
        myplayer\Field83 = $00
        using294 = $00
        If (((networkserver\Field23 = $00) Or (networkserver\Field15 = $01)) <> 0) Then
            If (wearingnightvision <> 0) Then
                camerafogfar = storedcamerafogfar
            EndIf
            wearinghazmat = $00
            wearinggasmask = $00
            wearingnightvision = $00
            wearing714 = $00
            wearing1499 = $00
            For local0 = $00 To $09 Step $01
                If (inventory(local0) <> Null) Then
                    dropitem(inventory(local0), $01)
                EndIf
            Next
        EndIf
        If (networkserver\Field15 = $01) Then
            If (arg0 <> "") Then
                multiplayer_addchatmsg((" " + arg0), $01)
            EndIf
            multiplayer_requestrole($00)
        Else
            If (arg0 <> "") Then
                multiplayer_addchatmsg((" " + arg0), $01)
            EndIf
            If (multiplayer_isfullsync() <> 0) Then
                multiplayer_requestrole($00)
            EndIf
        EndIf
        If (getscripts() <> 0) Then
            public_inqueue($06, $01)
        EndIf
        holdinggun = $00
    EndIf
    Return $00
End Function
