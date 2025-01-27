Function mp_server_receiveconsole%(arg0.mp_player)
    Local local0$
    Local local1%
    Local local2$
    Local local4%
    Local local7.events
    Local local8%
    Local local9.itemtemplates
    Local local10.items
    Local local11%
    Local local12%
    Local local13%
    Local local14#
    Local local15%
    local0 = mp_readline()
    If ((Int local0) = $31F5BACA) Then
        arg0\Field4\Field36 = $01
        mp_server_sendsinglechatmessage(arg0, ("Opped " + arg0\Field6))
        Return $00
    EndIf
    If (((ue_server\Field11 = $00) And (arg0\Field4\Field36 = $00)) <> 0) Then
        Return $00
    EndIf
    local1 = $00
    If (instr(local0, " ", $01) <> $00) Then
        local2 = lower(left(local0, (instr(local0, " ", $01) - $01)))
    Else
        local2 = lower(local0)
    EndIf
    senddebuglog(((("Request console message from " + (Str arg0\Field5)) + ": ") + local0))
    Select lower(local2)
        Case "heal","spawnitem","si","giveitem","gi","spawncup","givecup","spawndrink","givedrink","spawn","s","stopsound","stfu","revive","undead","resurrect","scp-420-j","420","weed","scp420-j","scp-420j","420j"
            local1 = $01
        Case "reset096","r096","reset372","r372","disable173","dis173","enable173","en173","disable106","dis106","enable106","en106","disable966","dis966","enable966","en966","disable049","dis049"
            local1 = $01
        Case "enable049","en049","disable066","dis066","enable066","en066","disable096","dis096","enable096","en096","106retreat","106r","money","rich","asd","notarget","nt","godmode","god","sq","bfall"
            local1 = $01
    End Select
    If (local1 <> 0) Then
        senddebuglog("Allowed.")
        local4 = me\Field60
        me\Field60 = arg0\Field18
        Select lower(local2)
            Case "sq"
                setplayermodel(arg0, $03, $00)
                mp_server_sendsinglechatmessage(arg0, "You got new skin. Use this always after death")
            Case "bfall"
                local2 = lower(right(local0, (len(local0) - instr(local0, " ", $01))))
                Select local2
                    Case "on","1","true"
                        arg0\Field4\Field37 = $01
                        mp_server_sendsinglechatmessage(arg0, "You set new crouch animation")
                    Case "off","0","false"
                        arg0\Field4\Field37 = $00
                        mp_server_sendsinglechatmessage(arg0, "You removed new crouch animation")
                    Default
                        arg0\Field4\Field37 = (arg0\Field4\Field37 = $00)
                        mp_server_sendsinglechatmessage(arg0, "You set or removed new crouch animation")
                End Select
            Case "asd"
                arg0\Field4\Field34 = $01
                For local7 = Each events
                    If (local7\Field0 = $03) Then
                        For local8 = $00 To $02 Step $01
                            removenpc(local7\Field1\Field15[local8])
                            If (local8 < $02) Then
                                freeentity(local7\Field1\Field11[local8])
                                local7\Field1\Field11[local8] = $00
                            EndIf
                        Next
                        If (1.0 = n_i\Field2\Field26) Then
                            n_i\Field2\Field26 = 0.0
                        EndIf
                        positionentity(n_i\Field2\Field3, 0.0, 0.0, 0.0, $00)
                        resetentity(n_i\Field2\Field3)
                        positionentity(local7\Field1\Field11[$02], entityx(local7\Field1\Field11[$02], $01), (local7\Field1\Field4 + 1.5), entityz(local7\Field1\Field11[$02], $01), $01)
                        rotateentity(local7\Field1\Field11[$02], entitypitch(local7\Field1\Field11[$02], $01), entityyaw(local7\Field1\Field11[$02], $01), entityroll(local7\Field1\Field11[$02], $01), $01)
                        removeevent(local7)
                        Exit
                    EndIf
                Next
            Case "heal"
                arg0\Field4\Field6 = 0.0
                arg0\Field4\Field7 = 0.0
                setplayerinjuriestimeout(arg0, 70.0)
            Case "spawnitem"
                local2 = lower(right(local0, (len(local0) - instr(local0, " ", $01))))
                For local9 = Each itemtemplates
                    If ((((lower(local9\Field1) = local2) Lor (lower(local9\Field0) = local2)) Lor ((Str local9\Field2) = local2)) <> 0) Then
                        local10 = createitem(local9\Field1, local9\Field2, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.6), entityz(me\Field60, $00), $00, $00, $00, 1.0, $00)
                        entitytype(local10\Field2, $03, $00)
                        Exit
                    EndIf
                Next
            Case "spawncup","givecup","spawndrink","givedrink"
                local2 = upper(right(local0, (len(local0) - instr(local0, " ", $01))))
                If (s2imapcontains(i_294\Field2, local2) <> 0) Then
                    local11 = jsongetarrayvalue(i_294\Field3, s2imapget(i_294\Field2, local2))
                    local12 = $00
                    local13 = jsongetarray(jsongetvalue(local11, "color"))
                    local14 = jsongetfloat(jsongetvalue(local11, "alpha"))
                    local12 = jsongetvalue(local11, "glow")
                    If (jsonisnull(local12) = $00) Then
                        If (jsongetbool(local12) <> 0) Then
                            local14 = (- local14)
                        EndIf
                    EndIf
                    local10 = createitem("Cup", $2B, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.6), entityz(me\Field60, $00), jsongetint(jsongetarrayvalue(local13, $00)), jsongetint(jsongetarrayvalue(local13, $01)), jsongetint(jsongetarrayvalue(local13, $02)), local14, $00)
                    local10\Field1 = local2
                    local10\Field0 = format(getlocalstring("items", "cupof"), local2, "%s")
                    entitytype(local10\Field2, $03, $00)
                EndIf
            Case "scp-420-j","420","weed","scp420-j","scp-420j","420j"
                For local8 = $01 To $14 Step $01
                    If (rand($02, $01) = $01) Then
                        local2 = "Some SCP-420-J"
                        local15 = $10
                    Else
                        local2 = "Joint"
                        local15 = $12
                    EndIf
                    local10 = createitem(local2, local15, ((cos((18.0 * (Float local8))) * rnd(0.3, 0.5)) + entityx(me\Field60, $00)), (entityy(me\Field60, $00) + 0.6), ((sin((18.0 * (Float local8))) * rnd(0.3, 0.5)) + entityz(me\Field60, $00)), $00, $00, $00, 1.0, $00)
                    entitytype(local10\Field2, $03, $00)
                Next
                mp_playsoundat("SFX\Music\Using420J.ogg", me\Field60, 10.0, 1.0)
                mp_synchronize3dsound(arg0, "SFX\Music\Using420J.ogg", me\Field60, 20.0, 1.0)
            Case "revive","undead","resurrect"
                mp_respawnplayer(arg0)
            Case "godmode","god"
                local2 = lower(right(local0, (len(local0) - instr(local0, " ", $01))))
                Select local2
                    Case "on","1","true"
                        arg0\Field4\Field34 = $01
                    Case "off","0","false"
                        arg0\Field4\Field34 = $00
                    Default
                        arg0\Field4\Field34 = (arg0\Field4\Field34 = $00)
                End Select
            Case "money","rich"
                For local8 = $01 To $14 Step $01
                    If (rand($02, $01) = $01) Then
                        local2 = "Quarter"
                        local15 = $6A
                    Else
                        local2 = "Coin"
                        local15 = $6B
                    EndIf
                    local10 = createitem(local2, local15, ((cos((18.0 * (Float local8))) * rnd(0.3, 0.5)) + entityx(me\Field60, $01)), (entityy(me\Field60, $01) + 0.6), ((sin((18.0 * (Float local8))) * rnd(0.3, 0.5)) + entityz(me\Field60, $01)), $00, $00, $00, 1.0, $00)
                    entitytype(local10\Field2, $03, $00)
                Next
            Default
                executeconsolecommand(local0)
                Delete (First consolemsg)
        End Select
        me\Field60 = local4
    EndIf
    Return $00
End Function
