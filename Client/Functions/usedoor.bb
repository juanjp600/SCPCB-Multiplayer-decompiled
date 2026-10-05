Function usedoor%(arg0.doors, arg1%, arg2%, arg3%, arg4$, arg5%)
    Local local0%
    Local local3%
    local0 = $00
    If (multiplayer_isfullsync() <> 0) Then
        If (((arg3 = $01) And udp_getstream()) <> 0) Then
            multiplayer_senddoor(arg0, selecteditem, arg4)
        EndIf
    EndIf
    If (arg5 = $00) Then
        If (arg0\Field12 > $00) Then
            If (((selecteditem = Null) And (arg3 = $01)) <> 0) Then
                If (arg1 = $01) Then
                    If (((instr(msg, "The keycard", $01) = $00) And (instr(msg, "A keycard with", $01) = $00)) <> 0) Then
                        setmsg("A keycard is required to operate this door.")
                    EndIf
                EndIf
                Return $00
            Else
                If (arg3 = $01) Then
                    Select selecteditem\Field1\Field2
                        Case "key1"
                            local0 = $01
                        Case "key2"
                            local0 = $02
                        Case "key3"
                            local0 = $03
                        Case "key4"
                            local0 = $04
                        Case "key5"
                            local0 = $05
                        Case "key6"
                            local0 = $06
                        Default
                            local0 = $FFFFFFFF
                    End Select
                Else
                    local0 = $3E8
                EndIf
                selecteditem = Null
                If (local0 = $FFFFFFFF) Then
                    If (arg1 = $01) Then
                        If (((instr(msg, "The keycard", $01) = $00) And (instr(msg, "A keycard with", $01) = $00)) <> 0) Then
                            setmsg("A keycard is required to operate this door.")
                        EndIf
                    EndIf
                    Return $00
                ElseIf (local0 >= arg0\Field12) Then
                    If (arg1 = $01) Then
                        If (arg0\Field4 <> 0) Then
                            If (arg3 = $01) Then
                                playsound_strict(keycardsfx2)
                            EndIf
                            setmsg("The keycard was inserted into the slot but nothing happened.")
                            If (arg3 = $01) Then
                                multiplayer_writesound(keycardsfx2, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                            EndIf
                            Return $00
                        Else
                            If (arg3 = $01) Then
                                playsound_strict(keycardsfx1)
                            EndIf
                            setmsg("The keycard was inserted into the slot.")
                            If (arg3 = $01) Then
                                multiplayer_writesound(keycardsfx1, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                            EndIf
                        EndIf
                    EndIf
                Else
                    If (arg1 = $01) Then
                        If (arg3 = $01) Then
                            playsound_strict(keycardsfx2)
                        EndIf
                        If (arg0\Field4 <> 0) Then
                            setmsg("The keycard was inserted into the slot but nothing happened.")
                        Else
                            setmsg((("A keycard with security clearance " + (Str arg0\Field12)) + " or higher is required to operate this door."))
                        EndIf
                        If (arg3 = $01) Then
                            multiplayer_writesound(keycardsfx2, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                        EndIf
                    EndIf
                    Return $00
                EndIf
            EndIf
        ElseIf (arg0\Field12 < $00) Then
            If (selecteditem <> Null) Then
                local0 = (((selecteditem\Field1\Field2 = "hand") And (arg0\Field12 = $FFFFFFFF)) Or ((selecteditem\Field1\Field2 = "hand2") And (arg0\Field12 = $FFFFFFFE)))
            EndIf
            If (arg3 = $00) Then
                local0 = $01
            EndIf
            If (local0 <> $00) Then
                If (arg3 = $01) Then
                    playsound_strict(scannersfx1)
                EndIf
                If (arg3 = $01) Then
                    multiplayer_writesound(scannersfx1, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                EndIf
                If (instr(msg, "You placed your", $01) = $00) Then
                    setmsg(((("You place the palm of the hand onto the scanner. The scanner reads: " + chr($22)) + "DNA verified. Access granted.") + chr($22)))
                EndIf
                selecteditem = Null
            Else
                If (arg1 = $01) Then
                    If (arg3 = $01) Then
                        playsound_strict(scannersfx2)
                    EndIf
                    setmsg(((("You placed your palm onto the scanner. The scanner reads: " + chr($22)) + "DNA does not match known sample. Access denied.") + chr($22)))
                    If (arg3 = $01) Then
                        multiplayer_writesound(scannersfx2, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                    EndIf
                EndIf
                Return $00
            EndIf
        ElseIf (arg0\Field4 <> 0) Then
            If (arg1 = $01) Then
                If ((arg0\Field22 > $00) = $00) Then
                    If (arg3 = $01) Then
                        If (arg3 = $01) Then
                            playsound_strict(buttonsfx2)
                        EndIf
                        If (arg3 = $01) Then
                            multiplayer_writesound(buttonsfx2, 0.0, 0.0, 0.0, 10.0, 1.0)
                        EndIf
                    EndIf
                    If (playerroom\Field8\Field11 <> "room2elevator") Then
                        If (arg0\Field5 <> 0) Then
                            setmsg("You pushed the button but nothing happened.")
                        Else
                            setmsg("The door appears to be locked.")
                        EndIf
                    Else
                        setmsg("The elevator appears to be broken.")
                    EndIf
                ElseIf (arg0\Field22 = $01) Then
                    setmsg("You called the elevator.")
                ElseIf (arg0\Field22 = $03) Then
                    setmsg("The elevator is already on this floor.")
                ElseIf (msg <> "You called the elevator.") Then
                    If ((((msg = "You already called the elevator.") Or (210.0 > msgtimer)) Or (msg = "")) <> 0) Then
                        Select rand($0A, $01)
                            Case $01
                                setmsg("Stop spamming the button.")
                            Case $02
                                setmsg("Pressing it harder does not make the elevator come faster.")
                            Case $03
                                setmsg("If you continue pressing this button I will generate a Memory Access Violation.")
                            Default
                                setmsg("You already called the elevator.")
                        End Select
                    EndIf
                Else
                    setmsg("You already called the elevator.")
                EndIf
            EndIf
            Return $00
        EndIf
    EndIf
    arg0\Field5 = (arg0\Field5 = $00)
    If (arg0\Field21 <> Null) Then
        arg0\Field21\Field5 = (arg0\Field21\Field5 = $00)
    EndIf
    local3 = $00
    If (arg0\Field9 = $01) Then
        local3 = rand($00, $01)
    Else
        local3 = rand($00, $02)
    EndIf
    If (arg2 = $01) Then
        If (arg0\Field5 <> 0) Then
            If (arg0\Field21 <> Null) Then
                arg0\Field21\Field11 = (Float arg0\Field21\Field10)
            EndIf
            arg0\Field11 = (Float arg0\Field10)
            arg0\Field16 = playsound2(opendoorsfx(arg0\Field9, local3), camera, arg0\Field0, 10.0, 1.0)
        Else
            arg0\Field16 = playsound2(closedoorsfx(arg0\Field9, local3), camera, arg0\Field0, 10.0, 1.0)
        EndIf
        updatesoundorigin(arg0\Field16, camera, arg0\Field0, 10.0, 1.0)
    ElseIf (arg0\Field5 <> 0) Then
        If (arg0\Field21 <> Null) Then
            arg0\Field21\Field11 = (Float arg0\Field21\Field10)
        EndIf
        arg0\Field11 = (Float arg0\Field10)
    EndIf
    If (arg0\Field35 <> Null) Then
        arg0\Field34 = $01
        arg0\Field35\Field34 = $01
    EndIf
    If (multiplayer_isfullsync() = $00) Then
        If (((arg3 = $01) And udp_getstream()) <> 0) Then
            multiplayer_senddoor(arg0, selecteditem, arg4)
        EndIf
    EndIf
    Return $01
    Return $00
End Function
