Function mp_server_interactobject%(arg0.mp_player, arg1%, arg2%)
    Local local0.events
    Local local1.items
    Local local2.mp_player
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11.decals
    Local local12.itemtemplates
    Local local13%
    If (mp_ishoster() = $00) Then
        Return $00
    EndIf
    Select arg2
        Case $00
            If ((((arg1 < $1E) And (mp_rooms[arg0\Field22]\Field11[arg1] <> $00)) And (2.0 > entitydistancesquared(arg0\Field18, mp_rooms[arg0\Field22]\Field11[arg1]))) <> 0) Then
                Select mp_rooms[arg0\Field22]\Field7\Field6
                    Case $53
                        If (((arg1 = $01) And (arg0\Field4\Field33 = $00)) <> 0) Then
                            If (arg0\Field5 <> mp_getmyindex()) Then
                                local1 = createitem("Pizza Slice", $6C, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                                entitytype(local1\Field2, $03, $00)
                                mp_playertakeitem(arg0, local1)
                            EndIf
                            arg0\Field4\Field33 = $01
                        EndIf
                    Case $2B
                        If (((arg1 = $00) And soundtransmission) <> 0) Then
                            For local0 = Each events
                                If (local0\Field0 = $17) Then
                                    If (0.0 = local0\Field2) Then
                                        If (channelplaying(local0\Field6) <> 0) Then
                                            stopchannel(local0\Field6)
                                            local0\Field6 = $00
                                        EndIf
                                        snd_i\Field22 = loadsound_strict("SFX\Room\106Chamber\FemurBreaker.ogg")
                                        local0\Field6 = playsound_strict(snd_i\Field22, $01)
                                        local0\Field2 = 1.0
                                        For local2 = Each mp_player
                                            If (local2\Field5 > $01) Then
                                                mp_writebyte($12)
                                                mp_writebyte(local0\Field24)
                                                mp_send(local2\Field0, local2\Field1)
                                            EndIf
                                        Next
                                    EndIf
                                    Exit
                                EndIf
                            Next
                        EndIf
                    Case $00
                        Select arg1
                            Case $01
                                mp_playsoundat("SFX\SCP\Joke\Quack.ogg", mp_rooms[arg0\Field22]\Field11[arg1], 10.0, 1.0)
                                mp_synchronize3dsound(Null, "SFX\SCP\Joke\Quack.ogg", mp_rooms[arg0\Field22]\Field11[arg1], 10.0, 1.0)
                            Case $02
                                mp_playsoundat((("SFX\Interact\PennyFlip" + (Str rand($00, $01))) + ".ogg"), mp_rooms[arg0\Field22]\Field11[arg1], 8.0, 1.0)
                                mp_synchronize3dsound(Null, (("SFX\Interact\PennyFlip" + (Str rand($00, $01))) + ".ogg"), mp_rooms[arg0\Field22]\Field11[arg1], 8.0, 1.0)
                                For local0 = Each events
                                    If (local0\Field0 = $01) Then
                                        If (0.0 = local0\Field3) Then
                                            local0\Field3 = (Float rand($01, $02))
                                        EndIf
                                        For local2 = Each mp_player
                                            If (local2\Field5 > $01) Then
                                                mp_writebyte($12)
                                                mp_writebyte(local0\Field24)
                                                mp_send(local2\Field0, local2\Field1)
                                            EndIf
                                        Next
                                        Exit
                                    EndIf
                                Next
                        End Select
                    Case $55
                        local6 = arg1
                        If (local6 = $01) Then
                            mp_playsoundat("SFX\SCP\Joke\Quack.ogg", mp_rooms[arg0\Field22]\Field11[arg1], 10.0, 1.0)
                            mp_synchronize3dsound(Null, "SFX\SCP\Joke\Quack.ogg", mp_rooms[arg0\Field22]\Field11[arg1], 10.0, 1.0)
                        EndIf
                End Select
            EndIf
        Case $01
            If ((((arg1 < $0C) And (mp_rooms[arg0\Field22]\Field15[arg1] <> Null)) And (2.0 > entitydistancesquared(arg0\Field18, mp_rooms[arg0\Field22]\Field15[arg1]\Field3))) <> 0) Then
                local7 = mp_rooms[arg0\Field22]\Field7\Field6
                If (local7 = $3E) Then
                    local1 = createitem("Drawing", $00, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                    entitytype(local1\Field2, $03, $00)
                    mp_playertakeitem(arg0, local1)
                    removenpc(mp_rooms[arg0\Field22]\Field15[arg1])
                EndIf
            EndIf
        Case $02
            If ((((arg1 = $00) And (mp_rooms[arg0\Field22]\Field11[arg1] <> $00)) And (2.0 > entitydistancesquared(arg0\Field18, mp_rooms[arg0\Field22]\Field11[arg1]))) <> 0) Then
                local8 = mp_rooms[arg0\Field22]\Field7\Field6
                If (local8 = $1E) Then
                    local9 = createpivot(mp_rooms[arg0\Field22]\Field2)
                    positionentity(local9, 976.0, 128.0, -640.0, $00)
                    If (arg0\Field4\Field32 = Null) Then
                        mp_playsoundat((("SFX\SCP\1162_ARC\BodyHorrorExchange" + (Str rand($00, $03))) + ".ogg"), mp_rooms[arg0\Field22]\Field11[arg1], 10.0, 1.0)
                        mp_synchronize3dsound(arg0, (("SFX\SCP\1162_ARC\BodyHorrorExchange" + (Str rand($00, $03))) + ".ogg"), mp_rooms[arg0\Field22]\Field11[arg1], 10.0, 1.0)
                        local10 = createpivot($00)
                        positionentity(local10, entityx(arg0\Field18, $00), (entityy(arg0\Field18, $00) - 0.05), entityz(arg0\Field18, $00), $00)
                        turnentity(local10, 90.0, 0.0, 0.0, $00)
                        entitypick(local10, 0.3)
                        local11 = createdecal($03, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, 0.75, 1.0, $00, $01, $00, $00, $00)
                        entityparent(local11\Field0, mp_rooms[arg0\Field22]\Field2, $01)
                        freeentity(local10)
                        mp_server_synchronizedecal(local11, arg0\Field22)
                        arg0\Field4\Field6 = (arg0\Field4\Field6 + 5.0)
                        If (15.0 < arg0\Field4\Field6) Then
                            mp_terminateplayer(arg0, $00, $00)
                        EndIf
                        For local12 = Each itemtemplates
                            If ((isitemgoodfor1162arc(local12) And (rand($06, $01) = $01)) <> 0) Then
                                local1 = createitem(local12\Field1, local12\Field2, entityx(local9, $01), entityy(local9, $01), entityz(local9, $01), $00, $00, $00, 1.0, $00)
                                entitytype(local1\Field2, $03, $00)
                                Exit
                            EndIf
                        Next
                    Else
                        mp_playsoundat((("SFX\SCP\1162_ARC\Exchange" + (Str rand($00, $04))) + ".ogg"), mp_rooms[arg0\Field22]\Field11[arg1], 10.0, 1.0)
                        mp_synchronize3dsound(arg0, (("SFX\SCP\1162_ARC\Exchange" + (Str rand($00, $04))) + ".ogg"), mp_rooms[arg0\Field22]\Field11[arg1], 10.0, 1.0)
                        local13 = $00
                        For local12 = Each itemtemplates
                            If (isitemgoodfor1162arc(local12) <> 0) Then
                                Select arg0\Field4\Field32\Field4\Field2
                                    Case $69
                                        If ((((local12\Field2 = $59) Lor (local12\Field2 = $5A)) And (rand($02, $01) = $01)) <> 0) Then
                                            local13 = $01
                                        EndIf
                                    Case $00,$01
                                        If (((local12\Field2 = $00) And (rand($0C, $01) = $01)) <> 0) Then
                                            local13 = $01
                                        EndIf
                                    Case $38,$39,$3A,$3B,$3C,$3D,$3E,$3F
                                        If ((((((((((local12\Field2 = $38) Lor (local12\Field2 = $39)) Lor (local12\Field2 = $3A)) Lor (local12\Field2 = $3B)) Lor (local12\Field2 = $3C)) Lor (local12\Field2 = $3D)) Lor (local12\Field2 = $3E)) Lor (local12\Field2 = $3F)) And (rand($02, $01) = $01)) <> 0) Then
                                            local13 = $01
                                        EndIf
                                    Case $59,$5A,$5B,$5C
                                        If ((((((local12\Field2 = $59) Lor (local12\Field2 = $5A)) Lor (local12\Field2 = $5B)) Lor (local12\Field2 = $5C)) And (rand($0C, $01) = $01)) <> 0) Then
                                            local13 = $01
                                        EndIf
                                    Case $61,$63,$02,$2F
                                        If ((((((local12\Field2 = $61) Lor (local12\Field2 = $63)) Lor (local12\Field2 = $02)) Lor (local12\Field2 = $2F)) And (rand($05, $01) = $01)) <> 0) Then
                                            local13 = $01
                                        EndIf
                                    Case $27,$28
                                        If ((((local12\Field2 = $27) Lor (local12\Field2 = $28)) And (rand($02, $01) = $01)) <> 0) Then
                                            local13 = $01
                                        EndIf
                                    Case $30,$32,$33,$55,$56,$57,$10,$12,$11
                                        If (((((((((((local12\Field2 = $30) Lor (local12\Field2 = $32)) Lor (local12\Field2 = $33)) Lor (local12\Field2 = $55)) Lor (local12\Field2 = $56)) Lor (local12\Field2 = $57)) Lor (local12\Field2 = $11)) Lor (local12\Field2 = $12)) Lor (local12\Field2 = $10)) And (rand($04, $01) = $01)) <> 0) Then
                                            local13 = $01
                                        EndIf
                                    Default
                                        If ((((local12\Field2 = $61) Lor (local12\Field2 = $63)) And (rand($06, $01) = $01)) <> 0) Then
                                            local13 = $01
                                        EndIf
                                End Select
                            EndIf
                            If (local13 <> 0) Then
                                local1 = createitem(local12\Field1, local12\Field2, entityx(local9, $01), entityy(local9, $01), entityz(local9, $01), $00, $00, $00, 1.0, $00)
                                entitytype(local1\Field2, $03, $00)
                                Exit
                            EndIf
                        Next
                    EndIf
                    freeentity(local9)
                EndIf
            EndIf
    End Select
    Return $00
End Function
