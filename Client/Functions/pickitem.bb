Function pickitem%(arg0.items)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local5.events
    Local local6%
    If (((((0.0 > killtimer) Or (arg0\Field15 = $01)) Or multiplayer_isascp(myplayer\Field51)) Or (myplayer\Field51 = $00)) <> 0) Then
        Return $00
    EndIf
    If (wearinghazmat > $00) Then
        msg = "You cannot pick up any items while wearing a hazmat suit."
        msgtimer = 350.0
        Return $00
    EndIf
    If (myplayer\Field83 <> 0) Then
        msg = "You cannot pick up any items because you handcuffed"
        msgtimer = 350.0
        Return $00
    EndIf
    local0 = $00
    local1 = $01
    local2 = $01
    closestitem = Null
    For local0 = $00 To $09 Step $01
        If (inventory(local0) <> Null) Then
            If (inventory(local0)\Field15 = $00) Then
                inventory(local0) = Null
            EndIf
        EndIf
        For local3 = $00 To $09 Step $01
            If (((inventory(local3) <> Null) And (local3 <> local0)) <> 0) Then
                If (inventory(local3) = inventory(local0)) Then
                    inventory(local3) = Null
                EndIf
            EndIf
        Next
    Next
    For local0 = $00 To $09 Step $01
        If (inventory(local0) = Null) Then
            local2 = $00
            Exit
        EndIf
    Next
    If (networkserver\Field15 <> 0) Then
        For local0 = $00 To $09 Step $01
            If (inventory(local0) <> Null) Then
                If (((inventory(local0)\Field3\Field1 = arg0\Field3\Field1) And (inventory(local0)\Field3\Field2 = arg0\Field3\Field2)) <> 0) Then
                    msg = "You cannot carry same items."
                    msgtimer = 350.0
                    Return $00
                EndIf
            EndIf
        Next
    EndIf
    If (local2 = $00) Then
        For local0 = $00 To $09 Step $01
            If (inventory(local0) = Null) Then
                Select arg0\Field3\Field2
                    Case "scp035"
                        lightflash = 2.0
                        camerashake = 10.0
                        playsound_strict(death914sfx)
                        multiplayer_writesound(death914sfx, 0.0, 0.0, 0.0, 10.0, 1.0)
                        multiplayer_requestrole(model_035)
                    Case "urancandy"
                        msg = "You feel a little bad."
                        msgtimer = 420.0
                        blurtimer = 500.0
                    Case "1123"
                        If ((wearing714 = $01) = $00) Then
                            If (playerroom\Field7\Field11 <> "room1123") Then
                                showentity(light)
                                lightflash = 7.0
                                playsound_strict(loadtempsound("SFX\SCP\1123\Touch.ogg"))
                                deathmsg = "Subject D-9341 was shot dead after attempting to attack a member of Nine-Tailed Fox. Surveillance tapes show that the subject had been "
                                deathmsg = ((((deathmsg + "wandering around the site approximately 9 minutes prior, shouting the phrase ") + chr($22)) + "get rid of the four pests") + chr($22))
                                deathmsg = (deathmsg + " in chinese. SCP-1123 was found in [REDACTED] nearby, suggesting the subject had come into physical contact with it. How ")
                                deathmsg = (deathmsg + "exactly SCP-1123 was removed from its containment chamber is still unknown.")
                                kill("was killed", $00)
                            ElseIf (multiplayer_isfullsync() <> 0) Then
                                showentity(light)
                                lightflash = 3.0
                                kill("was killed", $00)
                            Else
                                For local5 = Each events
                                    If (local5\Field0 = "room1123") Then
                                        If (0.0 = local5\Field2) Then
                                            showentity(light)
                                            lightflash = 3.0
                                            playsound_strict(loadtempsound("SFX\SCP\1123\Touch.ogg"))
                                        EndIf
                                        local5\Field2 = max(1.0, local5\Field2)
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        EndIf
                        Return $00
                    Case "killbat"
                        showentity(light)
                        lightflash = 1.0
                        playsound_strict(introsfx($0B))
                        deathmsg = "Subject D-9341 found dead inside SCP-914's output booth next to what appears to be an ordinary nine-volt battery. The subject is covered in severe "
                        deathmsg = (deathmsg + "electrical burns, and assumed to be killed via an electrical shock caused by the battery. The battery has been stored for further study.")
                        kill("was killed", $00)
                    Case "scp148"
                        giveachievement($08, $01)
                    Case "scp513"
                        giveachievement($0F, $01)
                    Case "scp860"
                        giveachievement($12, $01)
                    Case "key6"
                        giveachievement($1E, $01)
                    Case "veryfinevest"
                        msg = "The vest is too heavy to pick up."
                        msgtimer = 420.0
                        Exit
                    Case "firstaid","finefirstaid","veryfinefirstaid","firstaid2"
                        arg0\Field13 = 0.0
                    Case "navigator","nav"
                        If (arg0\Field3\Field1 = "S-NAV Navigator Ultimate") Then
                            giveachievement($1D, $01)
                        EndIf
                    Case "hazmatsuit","hazmatsuit2","hazmatsuit3"
                        local1 = $01
                        For local6 = $00 To $09 Step $01
                            If (inventory(local6) <> Null) Then
                                If ((((inventory(local6)\Field3\Field2 = "hazmatsuit") Or (inventory(local6)\Field3\Field2 = "hazmatsuit2")) Or (inventory(local6)\Field3\Field2 = "hazmatsuit3")) <> 0) Then
                                    local1 = $00
                                    Exit
                                ElseIf (((inventory(local6)\Field3\Field2 = "vest") Or (inventory(local6)\Field3\Field2 = "finevest")) <> 0) Then
                                    local1 = $02
                                    Exit
                                EndIf
                            EndIf
                        Next
                        If (local1 = $00) Then
                            msg = "You are not able to wear two hazmat suits at the same time."
                            msgtimer = 350.0
                            Return $00
                        ElseIf (local1 = $02) Then
                            msg = "You are not able to wear a vest and a hazmat suit at the same time."
                            msgtimer = 350.0
                            Return $00
                        Else
                            selecteditem = arg0
                        EndIf
                    Case "vest","finevest"
                        local1 = $01
                        For local6 = $00 To $09 Step $01
                            If (inventory(local6) <> Null) Then
                                If (((inventory(local6)\Field3\Field2 = "vest") Or (inventory(local6)\Field3\Field2 = "finevest")) <> 0) Then
                                    local1 = $00
                                    Exit
                                ElseIf ((((inventory(local6)\Field3\Field2 = "hazmatsuit") Or (inventory(local6)\Field3\Field2 = "hazmatsuit2")) Or (inventory(local6)\Field3\Field2 = "hazmatsuit3")) <> 0) Then
                                    local1 = $02
                                    Exit
                                EndIf
                            EndIf
                        Next
                        If (local1 = $00) Then
                            msg = "You are not able to wear two vests at the same time."
                            msgtimer = 350.0
                            Return $00
                        ElseIf (local1 = $02) Then
                            msg = "You are not able to wear a vest and a hazmat suit at the same time."
                            msgtimer = 350.0
                            Return $00
                        Else
                            selecteditem = arg0
                        EndIf
                End Select
                If (arg0\Field3\Field3 <> $42) Then
                    playsound_strict(picksfx(arg0\Field3\Field3))
                EndIf
                multiplayer_writesound(picksfx(arg0\Field3\Field3), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 3.0, 1.0)
                arg0\Field3\Field4 = $01
                itemamount = (itemamount + $01)
                inventory(local0) = arg0
                hideentity(arg0\Field1)
                If (udp_network\Field0 <> $00) Then
                    udp_bytestreamwritechar($15)
                    udp_bytestreamwriteshort(arg0\Field18)
                    udp_setmicrobyte($15)
                EndIf
                If (networkserver\Field18 <> 0) Then
                    arg0\Field22 = networkserver\Field28
                    arg0\Field15 = $01
                EndIf
                If (arg0\Field3\Field2 = "scp035") Then
                    removeitem(arg0, $01)
                EndIf
                Exit
            EndIf
        Next
    Else
        msg = "You cannot carry any more items."
        msgtimer = 350.0
    EndIf
    Return $00
End Function
