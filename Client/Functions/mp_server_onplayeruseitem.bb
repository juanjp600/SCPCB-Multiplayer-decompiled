Function mp_server_onplayeruseitem%(arg0.mp_player, arg1.items, arg2.items)
    Local local1%
    Local local2%
    Local local3$
    Local local4.rooms
    Local local9.props
    Local local10.items
    If (arg2 = Null) Then
        Select arg1\Field4\Field2
            Case $2B
                If (s2imapcontains(i_294\Field2, arg1\Field1) <> 0) Then
                    local1 = jsongetarrayvalue(i_294\Field3, s2imapget(i_294\Field2, arg1\Field1))
                    If (jsonisnull(jsongetvalue(local1, "refuse_message")) <> 0) Then
                        local2 = jsongetvalue(local1, "vomit")
                        If (jsonisnull(local2) = $00) Then
                            mp_playsoundat("SFX\SCP\294\Vomit.ogg", arg0\Field18, 10.0, 1.0)
                            mp_synchronize3dsound(arg0, "SFX\SCP\294\Vomit.ogg", arg0\Field18, 10.0, 1.0)
                        EndIf
                        local2 = jsongetvalue(local1, "damage")
                        If (jsonisnull(local2) = $00) Then
                            arg0\Field4\Field6 = max((arg0\Field4\Field6 + jsongetfloat(local2)), 0.0)
                        EndIf
                        local2 = jsongetvalue(local1, "bloodloss")
                        If (jsonisnull(local2) = $00) Then
                            arg0\Field4\Field7 = max((arg0\Field4\Field7 + jsongetfloat(local2)), 0.0)
                        EndIf
                        local2 = jsongetvalue(local1, "drink_sound")
                        If (jsonisnull(local2) = $00) Then
                            local3 = jsongetstring(local2)
                            If (((local3 = "SFX\SCP\294\Burn.ogg") And (0.0 < i_1025\Field1[$03])) = $00) Then
                                mp_playsoundat(local3, arg0\Field18, 10.0, 1.0)
                                mp_synchronize3dsound(arg0, local3, arg0\Field18, 10.0, 1.0)
                            Else
                                arg0\Field4\Field6 = (arg0\Field4\Field6 + 0.5)
                                mp_playsoundat("SFX\SCP\294\Slurp.ogg", arg0\Field18, 10.0, 1.0)
                                mp_synchronize3dsound(arg0, "SFX\SCP\294\Slurp.ogg", arg0\Field18, 10.0, 1.0)
                            EndIf
                        EndIf
                        local2 = jsongetvalue(local1, "blink_effect")
                        If (jsonisnull(local2) = $00) Then
                            arg0\Field4\Field12 = (jsongetfloat(local2) ^ arg1\Field12)
                        EndIf
                        local2 = jsongetvalue(local1, "blink_timer")
                        If (jsonisnull(local2) = $00) Then
                            arg0\Field4\Field13 = (jsongetfloat(local2) * arg1\Field12)
                        EndIf
                        arg1 = createitem("Empty Cup", $2C, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                        entitytype(arg1\Field2, $03, $00)
                        mp_playertakeitem(arg0, arg1)
                    EndIf
                EndIf
            Case $61,$62,$6A,$6B
                local4 = mp_rooms[arg0\Field22]
                If ((((local4 <> Null) And (local4\Field7\Field6 = $53)) And (9.0 > entitydistancesquared(local4\Field11[$00], arg0\Field18))) <> 0) Then
                    Select arg1\Field4\Field2
                        Case $61,$62
                            If (0.0 < arg1\Field12) Then
                                arg1\Field12 = (arg1\Field12 - 1.0)
                                arg0\Field4\Field29 = ((arg1\Field4\Field2 = $62) + $01)
                                playsoundex(loadtempsound("SFX\SCP\294\InsertMasterCard.ogg"), camera, local4\Field11[$00], 5.0, 1.0, $00)
                                mp_synchronize3dsound(arg0, "SFX\SCP\294\InsertMasterCard.ogg", local4\Field11[$00], 5.0, 1.0)
                            EndIf
                        Case $6A,$6B
                            arg0\Field4\Field28 = (arg0\Field4\Field28 + $01)
                            playsoundex(loadtempsound("SFX\SCP\294\CoinDrop.ogg"), camera, local4\Field11[$00], 5.0, 1.0, $00)
                            mp_synchronize3dsound(arg0, "SFX\SCP\294\CoinDrop.ogg", local4\Field11[$00], 5.0, 1.0)
                    End Select
                EndIf
            Case $16
                If (1.0 < arg0\Field4\Field12) Then
                    arg0\Field4\Field12 = 1.0
                    arg0\Field4\Field13 = 0.0
                EndIf
            Case $37
                Select rand($04, $01)
                    Case $01
                        arg0\Field4\Field6 = 3.5
                        server_sendmessage(arg0, getlocalstringformat("msg", "bleed"), 6.0, $00)
                    Case $02
                        arg0\Field4\Field6 = 0.0
                        arg0\Field4\Field7 = 0.0
                        server_sendmessage(arg0, getlocalstringformat("msg", "rapidly"), 6.0, $00)
                    Case $03
                        arg0\Field4\Field6 = max(0.0, (arg0\Field4\Field6 - rnd(0.5, 3.5)))
                        arg0\Field4\Field7 = max(0.0, (arg0\Field4\Field7 - rnd(10.0, 100.0)))
                        server_sendmessage(arg0, getlocalstringformat("msg", "better_1"), 6.0, $00)
                    Case $04
                        arg0\Field4\Field7 = 0.0
                        server_sendmessage(arg0, getlocalstringformat("msg", "nausea"), 6.0, $00)
                End Select
            Case $34,$36,$35
                If (arg1\Field4\Field2 = $36) Then
                    arg0\Field4\Field7 = 0.0
                    arg0\Field4\Field6 = max(0.0, (arg0\Field4\Field6 - 2.0))
                    If (0.0 = arg0\Field4\Field6) Then
                        server_sendmessage(arg0, getlocalstringformat("msg", "aid.fine"), 6.0, $00)
                    ElseIf (1.0 < arg0\Field4\Field6) Then
                        server_sendmessage(arg0, getlocalstringformat("msg", "aid.bleed"), 6.0, $00)
                    Else
                        server_sendmessage(arg0, getlocalstringformat("msg", "aid.sore"), 6.0, $00)
                    EndIf
                Else
                    arg0\Field4\Field7 = max(0.0, (arg0\Field4\Field7 - rnd(10.0, 20.0)))
                    If (2.5 <= arg0\Field4\Field6) Then
                        server_sendmessage(arg0, getlocalstringformat("msg", "aid.toobad_1"), 6.0, $00)
                        arg0\Field4\Field6 = max(2.5, (arg0\Field4\Field6 - rnd(0.3, 0.7)))
                    ElseIf (1.0 < arg0\Field4\Field6) Then
                        arg0\Field4\Field6 = max(0.5, (arg0\Field4\Field6 - rnd(0.5, 1.0)))
                        If (1.0 < arg0\Field4\Field6) Then
                            server_sendmessage(arg0, getlocalstringformat("msg", "aid.toobad_2"), 6.0, $00)
                        Else
                            server_sendmessage(arg0, getlocalstringformat("msg", "aid.stop"), 6.0, $00)
                        EndIf
                    ElseIf (0.5 < arg0\Field4\Field6) Then
                        arg0\Field4\Field6 = 0.5
                        server_sendmessage(arg0, getlocalstringformat("msg", "aid.slight"), 6.0, $00)
                    Else
                        arg0\Field4\Field6 = (arg0\Field4\Field6 / 2.0)
                        server_sendmessage(arg0, getlocalstringformat("msg", "aid.nowalk"), 6.0, $00)
                    EndIf
                    If (arg1\Field4\Field2 = $35) Then
                        Select rand($06, $01)
                            Case $04
                                arg0\Field4\Field12 = 0.6
                                arg0\Field4\Field13 = rnd(20.0, 30.0)
                            Case $05
                                arg0\Field4\Field7 = 0.0
                                arg0\Field4\Field6 = 0.0
                                server_sendmessage(arg0, getlocalstringformat("msg", "aid.stopall"), 6.0, $00)
                            Case $06
                                server_sendmessage(arg0, getlocalstringformat("msg", "aid.through"), 6.0, $00)
                                arg0\Field4\Field6 = 3.5
                        End Select
                    EndIf
                EndIf
            Case $55
                arg0\Field4\Field8 = rnd(20.0, 30.0)
            Case $56
                arg0\Field4\Field8 = rnd(30.0, 40.0)
            Case $57
                Select rand($03, $01)
                    Case $01
                        arg0\Field4\Field8 = 60.0
                        server_sendmessage(arg0, getlocalstringformat("msg", "syringe_3"), 6.0, $00)
                    Case $02
                    Case $03
                End Select
            Case $58
                arg0\Field4\Field8 = rnd(10.0, 20.0)
            Case $30,$31
                arg0\Field4\Field12 = 0.6
                arg0\Field4\Field13 = rnd(25.0, 35.0)
                arg0\Field4\Field10 = min((arg0\Field4\Field10 + (arg0\Field4\Field11 / 2.0)), arg0\Field4\Field11)
                If (arg1\Field4\Field2 = $31) Then
                    arg0\Field4\Field7 = max((arg0\Field4\Field7 - rnd(5.0, 10.0)), 0.0)
                EndIf
            Case $32
                arg0\Field4\Field12 = 0.4
                arg0\Field4\Field13 = rnd(35.0, 45.0)
                arg0\Field4\Field10 = arg0\Field4\Field11
            Case $33
                arg0\Field4\Field12 = 0.0
                arg0\Field4\Field13 = 60.0
                arg0\Field4\Field9 = 10000.0
            Case $10
                arg0\Field4\Field6 = max((arg0\Field4\Field6 - 0.5), 0.0)
                mp_playsoundat("SFX\Music\Using420J.ogg", arg0\Field18, 20.0, 1.0)
                mp_synchronize3dsound(arg0, "SFX\Music\Using420J.ogg", arg0\Field18, 20.0, 1.0)
            Case $2C
                For local9 = Each props
                    If ((local9\Field4 And (mp_rooms[arg0\Field22] = local9\Field2)) <> 0) Then
                        If (2.0 > entitydistancesquared(local9\Field1, arg0\Field18)) Then
                            local10 = createitem("Cup", $2B, 0.0, 0.0, 0.0, $C8, $C8, $C8, 0.2, $00)
                            local10\Field1 = "WATER"
                            local10\Field0 = format(getlocalstring("items", "cupof"), getlocalstring("misc", "water"), "%s")
                            entitytype(local10\Field2, $03, $00)
                            mp_playertakeitem(arg0, local10)
                            mp_playsoundat("SFX\SCP\294\Dispense1.ogg", local9\Field1, 8.0, 1.0)
                            mp_synchronize3dsound(arg0, "SFX\SCP\294\Dispense1.ogg", local9\Field1, 8.0, 1.0)
                        EndIf
                        Exit
                    EndIf
                Next
        End Select
        setplayerinjuriestimeout(arg0, 70.0)
        Return $00
    EndIf
    Select arg1\Field4\Field2
        Case $51
            Select arg2\Field4\Field2
                Case $49
                    arg2\Field12 = rnd(50.0, 0.0)
                Case $45
                    arg2\Field12 = rnd(50.0, 0.0)
                Case $40
                    arg2\Field12 = rnd(500.0, 0.0)
                Case $43
                    arg2\Field12 = rnd(500.0, 0.0)
                Case $4D
                    arg2\Field12 = rnd(50.0, 0.0)
            End Select
        Case $50
            Select arg2\Field4\Field2
                Case $49
                    arg2\Field12 = rnd(50.0, 100.0)
                Case $45
                    arg2\Field12 = rnd(50.0, 100.0)
                Case $40
                    arg2\Field12 = rnd(500.0, 1000.0)
                Case $43
                    arg2\Field12 = rnd(500.0, 1000.0)
                Case $4D
                    arg2\Field12 = rnd(50.0, 100.0)
            End Select
        Case $52
            Select arg2\Field4\Field2
                Case $4B
                    arg2\Field12 = rnd(50.0, 100.0)
                Case $46
                    arg2\Field12 = rnd(50.0, 100.0)
                Case $41
                    arg2\Field12 = rnd(500.0, 1000.0)
                Case $44
                    arg2\Field12 = rnd(500.0, 1000.0)
                Case $4E
                    arg2\Field12 = rnd(500.0, 1000.0)
            End Select
        Case $53,$54
            Select arg2\Field4\Field2
                Case $49
                    arg2\Field12 = 1000.0
                Case $45
                    arg2\Field12 = 1000.0
                Case $40
                    arg2\Field12 = 10000.0
                Case $43
                    arg2\Field12 = 10000.0
                Case $4D
                    arg2\Field12 = 1000.0
            End Select
    End Select
    Return $00
End Function
