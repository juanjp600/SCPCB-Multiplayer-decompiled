Function usedoor%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local8%
    Local local9%
    Local local11.emitter
    mp_client_usedoor(d_i\Field7, selecteditem, d_i\Field11, (Int msg\Field5))
    local1 = $00
    If (selecteditem <> Null) Then
        local1 = getusingitem(selecteditem)
    EndIf
    local2 = (((((d_i\Field7\Field14 > $00) + (((d_i\Field7\Field14 > $FFFFFFFC) And (d_i\Field7\Field14 < $00)) Shl $01)) + ((d_i\Field7\Field19 <> $00) * $03)) + (((d_i\Field7\Field10 = $05) Lor (d_i\Field7\Field10 = $04)) Shl $02)) + ((d_i\Field7\Field10 = $01) * $05))
    local3 = $00
    d_i\Field7\Field35 = buttondirection
    If (mp_getsocket() <> $00) Then
        d_i\Field7\Field35 = $01
        local4 = local2
        If (local4 = $05) Then
            local2 = $06
        EndIf
    EndIf
    If ((mp_ishoster() And (currentsyncplayer = Null)) <> 0) Then
        currentsyncplayer = ue_players[mp_getmyindex()]
    EndIf
    Select local2
        Case $01
            If (selecteditem = Null) Then
                If (350.0 > msg\Field1) Then
                    createmsg(getlocalstring("msg", "key.require"), 6.0)
                EndIf
                playsoundex(buttonsfx[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                mp_synchronize3dsound(currentsyncplayer, getsoundfilename(buttonsfx[$00]), d_i\Field9, 10.0, 1.0)
                Return $00
            Else
                If (local1 <= $00) Then
                    If (350.0 > msg\Field1) Then
                        createmsg(getlocalstring("msg", "key.require"), 6.0)
                    EndIf
                Else
                    If (local1 = $01) Then
                        createmsg(getlocalstring("msg", "key.slot.6"), 6.0)
                    ElseIf (d_i\Field7\Field4 = $01) Then
                        If (local1 = $09) Then
                            createmsg(getlocalstring("msg", "key.nothappend.005"), 6.0)
                        Else
                            createmsg(getlocalstring("msg", "key.nothappend"), 6.0)
                        EndIf
                    ElseIf (local1 = $09) Then
                        createmsg(getlocalstring("msg", "key.005"), 6.0)
                        If (selecteditem\Field4\Field2 = $09) Then
                            local3 = $01
                        EndIf
                    ElseIf (local1 < d_i\Field7\Field14) Then
                        If (d_i\Field7\Field14 = $09) Then
                            If (350.0 > msg\Field1) Then
                                createmsg(getlocalstring("msg", "key.required.106"), 6.0)
                            EndIf
                        Else
                            createmsg(format(getlocalstring("msg", "key.higher"), (Str (d_i\Field7\Field14 - $02)), "%s"), 6.0)
                        EndIf
                    Else
                        createmsg(getlocalstring("msg", "key.slot"), 6.0)
                    EndIf
                    selecteditem = Null
                EndIf
                If (((d_i\Field7\Field4 <> $01) And ((((local1 > $00) And (local1 <> $01)) And (local1 >= d_i\Field7\Field14)) Lor (local1 = $09))) <> 0) Then
                    playsoundex(snd_i\Field5[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                    mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field5[$00]), d_i\Field9, 10.0, 1.0)
                Else
                    If (local1 <= $00) Then
                        playsoundex(buttonsfx[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                        mp_synchronize3dsound(currentsyncplayer, getsoundfilename(buttonsfx[$00]), d_i\Field9, 10.0, 1.0)
                    Else
                        playsoundex(snd_i\Field5[$01], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                        mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field5[$01]), d_i\Field9, 10.0, 1.0)
                    EndIf
                    Return $00
                EndIf
            EndIf
        Case $02
            If (selecteditem = Null) Then
                If (350.0 > msg\Field1) Then
                    createmsg(getlocalstring("msg", "dna.denied_1"), 6.0)
                EndIf
                playsoundex(snd_i\Field6[$01], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field6[$01]), d_i\Field9, 10.0, 1.0)
                Return $00
            Else
                If ((((local1 >= $00) Lor (local1 < $FFFFFFFD)) And (local1 <> $09)) <> 0) Then
                    If (350.0 > msg\Field1) Then
                        createmsg(getlocalstring("msg", "dna.denied_1"), 6.0)
                    EndIf
                Else
                    If (((d_i\Field7\Field14 <> local1) And (local1 <> $09)) <> 0) Then
                        createmsg(getlocalstring("msg", "dna.denied_2"), 6.0)
                    ElseIf (d_i\Field7\Field4 = $01) Then
                        If (local1 = $09) Then
                            createmsg(getlocalstring("msg", "key.nothappend.005"), 6.0)
                        Else
                            createmsg(getlocalstring("msg", "dna.nothappend"), 6.0)
                        EndIf
                    ElseIf (local1 = $09) Then
                        createmsg(getlocalstring("msg", "dna.granted.005"), 6.0)
                        If (selecteditem\Field4\Field2 = $09) Then
                            local3 = $01
                        EndIf
                    Else
                        createmsg(getlocalstring("msg", "dna.granted"), 6.0)
                    EndIf
                    selecteditem = Null
                EndIf
                If (((d_i\Field7\Field4 = $00) And ((local1 = d_i\Field7\Field14) Lor (local1 = $09))) <> 0) Then
                    playsoundex(snd_i\Field6[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                    mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field6[$00]), d_i\Field9, 10.0, 1.0)
                Else
                    playsoundex(snd_i\Field6[$01], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                    mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field6[$01]), d_i\Field9, 10.0, 1.0)
                    Return $00
                EndIf
            EndIf
        Case $03
            If (selecteditem = Null) Then
                If ((((d_i\Field7\Field4 = $00) And (d_i\Field7\Field19 <> $FFFFFFFF)) And (d_i\Field7\Field19 = (Int msg\Field5))) <> 0) Then
                    playsoundex(snd_i\Field6[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                    mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field6[$00]), d_i\Field9, 10.0, 1.0)
                Else
                    playsoundex(snd_i\Field6[$01], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                    mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field6[$01]), d_i\Field9, 10.0, 1.0)
                    Return $00
                EndIf
            Else
                If (local1 = $09) Then
                    If (d_i\Field7\Field4 = $01) Then
                        createmsg(getlocalstring("msg", "keypad.nothappend.005"), 6.0)
                    Else
                        createmsg(getlocalstring("msg", "keypad.nothappend"), 6.0)
                    EndIf
                EndIf
                selecteditem = Null
                If ((((d_i\Field7\Field4 = $00) And (d_i\Field7\Field19 <> $FFFFFFFF)) And (local1 = $09)) <> 0) Then
                    playsoundex(snd_i\Field6[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                    mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field6[$00]), d_i\Field9, 10.0, 1.0)
                    If (selecteditem\Field4\Field2 = $09) Then
                        local3 = $01
                    EndIf
                Else
                    playsoundex(snd_i\Field6[$01], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                    mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field6[$01]), d_i\Field9, 10.0, 1.0)
                    Return $00
                EndIf
            EndIf
            Select d_i\Field7\Field19
                Case code_dr_maynard
                    giveachievement("maynard", $01)
                Case code_dr_gears
                    giveachievement("gears", $01)
                Case $1E88
                    giveachievement("harp", $01)
                Case code_o5_council
                    giveachievement("o5", $01)
            End Select
        Case $04
            If (d_i\Field7\Field4 > $00) Then
                If (selecteditem = Null) Then
                    If (350.0 > msg\Field1) Then
                        createmsg(getlocalstring("msg", "wood.wontbudge"), 6.0)
                    EndIf
                    If (d_i\Field7\Field10 = $04) Then
                        playsoundex(snd_i\Field7[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                        mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field7[$00]), d_i\Field9, 10.0, 1.0)
                        setanimtime(d_i\Field7\Field0, 1.0, $00)
                        d_i\Field7\Field33 = $01
                    Else
                        playsoundex(snd_i\Field7[$01], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                        mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field7[$01]), d_i\Field9, 10.0, 1.0)
                    EndIf
                Else
                    If (((local1 > $FFFFFFFC) And (local1 <> $09)) <> 0) Then
                        If (350.0 > msg\Field1) Then
                            createmsg(getlocalstring("msg", "wood.wontbudge"), 6.0)
                        EndIf
                    Else
                        If (((d_i\Field7\Field4 = $02) Lor ((local1 <> d_i\Field7\Field14) And (local1 <> $09))) <> 0) Then
                            createmsg(getlocalstring("msg", "wood.nothappend.005"), 6.0)
                        Else
                            createmsg(getlocalstring("msg", "wood.unlock"), 6.0)
                            If (((forest_event <> Null) And (forest_event\Field1 = playerroom)) <> 0) Then
                                giveachievement("860", $01)
                                If (selecteditem\Field4\Field2 = $1F) Then
                                    If (forest_event\Field1\Field15[$00] <> Null) Then
                                        removenpc(forest_event\Field1\Field15[$00])
                                    EndIf
                                ElseIf (forest_event\Field1\Field15[$00] = Null) Then
                                    forest_event\Field1\Field15[$00] = createnpc($0A, 0.0, 0.0, 0.0)
                                EndIf
                                If (((currentsyncplayer <> Null) And (currentsyncplayer <> ue_players[mp_getmyindex()])) <> 0) Then
                                    Return $00
                                EndIf
                                d_i\Field7\Field4 = $00
                                createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                                createconsolemsg(getlocalstring("misc", "warning2"), $FF, $00, $00, $00)
                                createconsolemsg("", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            EndIf
                        EndIf
                        selecteditem = Null
                    EndIf
                    If (((local1 > $FFFFFFFC) And (local1 <> $09)) <> 0) Then
                        If (d_i\Field7\Field10 = $04) Then
                            playsoundex(snd_i\Field7[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                            mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field7[$00]), d_i\Field9, 10.0, 1.0)
                            setanimtime(d_i\Field7\Field0, 1.0, $00)
                            d_i\Field7\Field33 = $01
                        Else
                            playsoundex(snd_i\Field7[$01], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                            mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field7[$01]), d_i\Field9, 10.0, 1.0)
                        EndIf
                    Else
                        playsoundex(snd_i\Field8, camera, d_i\Field9, 10.0, 1.0, $00, $00)
                        mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field8), d_i\Field9, 10.0, 1.0)
                    EndIf
                EndIf
                Return $00
            ElseIf (d_i\Field7\Field10 = $04) Then
                playsoundex(snd_i\Field7[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field7[$00]), d_i\Field9, 10.0, 1.0)
                setanimtime(d_i\Field7\Field0, 1.0, $00)
                d_i\Field7\Field33 = $01
            EndIf
        Case $05
            If (d_i\Field7\Field4 = $01) Then
                If ((d_i\Field7\Field22 > $00) = $00) Then
                    createmsg(getlocalstring("msg", "elev.broken"), 6.0)
                    playsoundex(buttonsfx[$01], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                    mp_synchronize3dsound(currentsyncplayer, getsoundfilename(buttonsfx[$01]), d_i\Field9, 10.0, 1.0)
                    setanimtime(d_i\Field9, (((Float (d_i\Field7\Field35 = $00)) * 20.0) + 1.0), $00)
                    d_i\Field7\Field34 = d_i\Field11
                    Return $00
                Else
                    If (d_i\Field7\Field22 = $01) Then
                        createmsg(getlocalstring("msg", "elev.called"), 6.0)
                    ElseIf (d_i\Field7\Field22 = $03) Then
                        createmsg(getlocalstring("msg", "elev.floor"), 6.0)
                    ElseIf (msg\Field0 <> getlocalstring("msg", "elev.called")) Then
                        Select rand($0A, $01)
                            Case $01
                                createmsg(getlocalstring("msg", "elev.stop"), 6.0)
                            Case $02
                                createmsg(getlocalstring("msg", "elev.faster"), 6.0)
                            Case $03
                                createmsg(getlocalstring("msg", "elev.mav"), 6.0)
                            Default
                                createmsg(getlocalstring("msg", "elev.already"), 6.0)
                        End Select
                    Else
                        createmsg(getlocalstring("msg", "elev.already"), 6.0)
                    EndIf
                    playsoundex(buttonsfx[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                    mp_synchronize3dsound(currentsyncplayer, getsoundfilename(buttonsfx[$00]), d_i\Field9, 10.0, 1.0)
                    setanimtime(d_i\Field9, (((Float (d_i\Field7\Field35 = $00)) * 20.0) + 1.0), $00)
                    d_i\Field7\Field34 = d_i\Field11
                    Return $00
                EndIf
            Else
                playsoundex(buttonsfx[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                mp_synchronize3dsound(currentsyncplayer, getsoundfilename(buttonsfx[$00]), d_i\Field9, 10.0, 1.0)
                setanimtime(d_i\Field9, (((Float (d_i\Field7\Field35 = $00)) * 20.0) + 1.0), $00)
                d_i\Field7\Field34 = d_i\Field11
            EndIf
        Case $06
            If ((((d_i\Field7\Field29 = Null) Lor (d_i\Field7\Field4 = $01)) Lor ((d_i\Field7\Field29 <> Null) And (d_i\Field7\Field29\Field4 = $01))) <> 0) Then
                createmsg(getlocalstring("msg", "elev.broken"), 6.0)
                playsoundex(buttonsfx[$01], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                mp_synchronize3dsound(currentsyncplayer, getsoundfilename(buttonsfx[$01]), d_i\Field9, 10.0, 1.0)
                d_i\Field7\Field35 = $01
                setanimtime(d_i\Field9, 1.0, $00)
                d_i\Field7\Field34 = d_i\Field11
                Return $00
            EndIf
            local8 = isinsideelevator(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), d_i\Field7\Field30)
            local9 = $00
            playsoundex(buttonsfx[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
            mp_synchronize3dsound(currentsyncplayer, getsoundfilename(buttonsfx[$00]), d_i\Field9, 10.0, 1.0)
            If (((d_i\Field7\Field6 = $00) And (0.0 = d_i\Field7\Field8)) <> 0) Then
                If ((d_i\Field7\Field29\Field6 And (180.0 = d_i\Field7\Field29\Field8)) <> 0) Then
                    openclosedoor(d_i\Field7\Field29, $01, $00)
                    d_i\Field7\Field29\Field31 = $01
                    d_i\Field7\Field29\Field35 = (d_i\Field7\Field29\Field32 = $01)
                    d_i\Field7\Field35 = d_i\Field7\Field29\Field35
                    updateelevatorpanel(d_i\Field7)
                    updateelevatorpanel(d_i\Field7\Field29)
                    local9 = $01
                EndIf
                setanimtime(d_i\Field9, (((Float (d_i\Field7\Field35 = $00)) * 20.0) + 1.0), $00)
                d_i\Field7\Field34 = d_i\Field11
                If (local9 = $01) Then
                    createmsg(getlocalstring("msg", "elev.called"), 6.0)
                ElseIf (msg\Field0 <> getlocalstring("msg", "elev.called")) Then
                    Select rand($0A, $01)
                        Case $01
                            createmsg(getlocalstring("msg", "elev.stop"), 6.0)
                        Case $02
                            createmsg(getlocalstring("msg", "elev.faster"), 6.0)
                        Case $03
                            createmsg(getlocalstring("msg", "elev.mav"), 6.0)
                        Default
                            createmsg(getlocalstring("msg", "elev.already"), 6.0)
                    End Select
                Else
                    createmsg(getlocalstring("msg", "elev.already"), 6.0)
                EndIf
                Return $00
            ElseIf ((d_i\Field7\Field6 And (180.0 = d_i\Field7\Field8)) <> 0) Then
                If (local8 <> 0) Then
                    d_i\Field7\Field35 = (d_i\Field7\Field32 = $01)
                    d_i\Field7\Field31 = $01
                    setanimtime(d_i\Field9, (((Float (d_i\Field7\Field35 = $00)) * 20.0) + 1.0), $00)
                    d_i\Field7\Field34 = d_i\Field11
                    d_i\Field7\Field29\Field6 = $01
                    openclosedoor(d_i\Field7\Field29, $01, $00)
                    d_i\Field7\Field29\Field35 = d_i\Field7\Field35
                    updateelevatorpanel(d_i\Field7)
                    updateelevatorpanel(d_i\Field7\Field29)
                Else
                    d_i\Field7\Field35 = $01
                    setanimtime(d_i\Field9, 1.0, $00)
                    d_i\Field7\Field34 = d_i\Field11
                    createmsg(getlocalstring("msg", "elev.floor"), 6.0)
                    Return $00
                EndIf
            ElseIf (((((((d_i\Field7\Field6 = $00) And (0.0 = d_i\Field7\Field8)) And (d_i\Field7\Field29\Field6 = $00)) And (0.0 = d_i\Field7\Field29\Field8)) And (d_i\Field7\Field31 = $00)) And (d_i\Field7\Field29\Field31 = $00)) <> 0) Then
                d_i\Field7\Field35 = $01
                setanimtime(d_i\Field9, 1.0, $00)
                d_i\Field7\Field34 = d_i\Field11
            Else
                Return $00
            EndIf
        Default
            If (d_i\Field7\Field4 = $01) Then
                If (d_i\Field7\Field6 <> 0) Then
                    createmsg(getlocalstring("msg", "button.nothappend"), 6.0)
                Else
                    createmsg(getlocalstring("msg", "button.locked"), 6.0)
                EndIf
                playsoundex(buttonsfx[$01], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                mp_synchronize3dsound(currentsyncplayer, getsoundfilename(buttonsfx[$01]), d_i\Field9, 10.0, 1.0)
                setanimtime(d_i\Field9, 1.0, $00)
                d_i\Field7\Field34 = d_i\Field11
                Return $00
            Else
                playsoundex(buttonsfx[$00], camera, d_i\Field9, 10.0, 1.0, $00, $00)
                mp_synchronize3dsound(currentsyncplayer, getsoundfilename(buttonsfx[$00]), d_i\Field9, 10.0, 1.0)
                setanimtime(d_i\Field9, (((Float (d_i\Field7\Field35 = $00)) * 20.0) + 1.0), $00)
                d_i\Field7\Field34 = d_i\Field11
            EndIf
    End Select
    openclosedoor(d_i\Field7, arg0, $00)
    If (local3 <> 0) Then
        d_i\Field7\Field9 = $01
        If (d_i\Field7\Field6 <> 0) Then
            d_i\Field7\Field4 = $01
        EndIf
        me\Field24 = 3.0
        local11 = setemitter(Null, entityx(d_i\Field7\Field0, $01), entityy(d_i\Field7\Field0, $01), entityz(d_i\Field7\Field0, $01), $10)
        entityparent(local11\Field6, d_i\Field7\Field0, $01)
        playsoundex(snd_i\Field9, camera, d_i\Field7\Field2, 10.0, 1.0, $00, $00)
        mp_synchronize3dsound(currentsyncplayer, getsoundfilename(snd_i\Field9), d_i\Field7\Field2, 10.0, 1.0)
    EndIf
    currentsyncplayer = Null
    Return $00
End Function
