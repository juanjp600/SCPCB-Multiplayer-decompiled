Function mp_server_receiveconsole%(arg0.mp_player)
    Local local0$
    Local local1%
    Local local2$
    Local local4%
    Local local6.events
    Local local7%
    Local local8.itemtemplates
    Local local9.items
    Local local10%
    Local local11%
    Local local12%
    Local local13#
    Local local14%
    If (ue_server\Field11 = $00) Then
        Return $00
    EndIf
    local0 = mp_readline()
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
        Case "enable049","en049","disable066","dis066","enable066","en066","disable096","dis096","enable096","en096","106retreat","106r","money","rich","asd","notarget","nt","godmode","god"
            local1 = $01
    End Select
    If (local1 <> 0) Then
        senddebuglog("Allowed.")
        local4 = me\Field60
        me\Field60 = arg0\Field18
        Select lower(local2)
            Case "asd"
                arg0\Field4\Field34 = $01
                For local6 = Each events
                    If (local6\Field0 = $03) Then
                        For local7 = $00 To $02 Step $01
                            removenpc(local6\Field1\Field15[local7])
                            If (local7 < $02) Then
                                freeentity(local6\Field1\Field11[local7])
                                local6\Field1\Field11[local7] = $00
                            EndIf
                        Next
                        If (1.0 = n_i\Field2\Field26) Then
                            n_i\Field2\Field26 = 0.0
                        EndIf
                        positionentity(n_i\Field2\Field3, 0.0, 0.0, 0.0, $00)
                        resetentity(n_i\Field2\Field3)
                        positionentity(local6\Field1\Field11[$02], entityx(local6\Field1\Field11[$02], $01), (local6\Field1\Field4 + 1.5), entityz(local6\Field1\Field11[$02], $01), $01)
                        rotateentity(local6\Field1\Field11[$02], entitypitch(local6\Field1\Field11[$02], $01), entityyaw(local6\Field1\Field11[$02], $01), entityroll(local6\Field1\Field11[$02], $01), $01)
                        removeevent(local6)
                        Exit
                    EndIf
                Next
            Case "heal"
                arg0\Field4\Field6 = 0.0
                arg0\Field4\Field7 = 0.0
                setplayerinjuriestimeout(arg0, 70.0)
            Case "spawnitem"
                local2 = lower(right(local0, (len(local0) - instr(local0, " ", $01))))
                For local8 = Each itemtemplates
                    If ((((lower(local8\Field1) = local2) Lor (lower(local8\Field0) = local2)) Lor ((Str local8\Field2) = local2)) <> 0) Then
                        local9 = createitem(local8\Field1, local8\Field2, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.6), entityz(me\Field60, $00), $00, $00, $00, 1.0, $00)
                        entitytype(local9\Field2, $03, $00)
                        Exit
                    EndIf
                Next
            Case "spawncup","givecup","spawndrink","givedrink"
                local2 = upper(right(local0, (len(local0) - instr(local0, " ", $01))))
                If (s2imapcontains(i_294\Field2, local2) <> 0) Then
                    local10 = jsongetarrayvalue(i_294\Field3, s2imapget(i_294\Field2, local2))
                    local11 = $00
                    local12 = jsongetarray(jsongetvalue(local10, "color"))
                    local13 = jsongetfloat(jsongetvalue(local10, "alpha"))
                    local11 = jsongetvalue(local10, "glow")
                    If (jsonisnull(local11) = $00) Then
                        If (jsongetbool(local11) <> 0) Then
                            local13 = (- local13)
                        EndIf
                    EndIf
                    local9 = createitem("Cup", $2B, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.6), entityz(me\Field60, $00), jsongetint(jsongetarrayvalue(local12, $00)), jsongetint(jsongetarrayvalue(local12, $01)), jsongetint(jsongetarrayvalue(local12, $02)), local13, $00)
                    local9\Field1 = local2
                    local9\Field0 = format(getlocalstring("items", "cupof"), local2, "%s")
                    entitytype(local9\Field2, $03, $00)
                EndIf
            Case "scp-420-j","420","weed","scp420-j","scp-420j","420j"
                For local7 = $01 To $14 Step $01
                    If (rand($02, $01) = $01) Then
                        local2 = "Some SCP-420-J"
                        local14 = $10
                    Else
                        local2 = "Joint"
                        local14 = $12
                    EndIf
                    local9 = createitem(local2, local14, ((cos((18.0 * (Float local7))) * rnd(0.3, 0.5)) + entityx(me\Field60, $00)), (entityy(me\Field60, $00) + 0.6), ((sin((18.0 * (Float local7))) * rnd(0.3, 0.5)) + entityz(me\Field60, $00)), $00, $00, $00, 1.0, $00)
                    entitytype(local9\Field2, $03, $00)
                Next
                mp_playsoundat("SFX\Music\Using420J.ogg", me\Field60, 10.0, 1.0)
                mp_synchronize3dsound(arg0, "SFX\Music\Using420J.ogg", me\Field60, 20.0, 1.0)
            Case "revive","undead","resurrect"
                mp_respawnplayer(arg0)
                senddebuglog(("Revive: " + (Str arg0\Field5)))
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
                For local7 = $01 To $14 Step $01
                    If (rand($02, $01) = $01) Then
                        local2 = "Quarter"
                        local14 = $6A
                    Else
                        local2 = "Coin"
                        local14 = $6B
                    EndIf
                    local9 = createitem(local2, local14, ((cos((18.0 * (Float local7))) * rnd(0.3, 0.5)) + entityx(me\Field60, $01)), (entityy(me\Field60, $01) + 0.6), ((sin((18.0 * (Float local7))) * rnd(0.3, 0.5)) + entityz(me\Field60, $01)), $00, $00, $00, 1.0, $00)
                    entitytype(local9\Field2, $03, $00)
                Next
            Default
                executeconsolecommand(local0)
                Delete (First consolemsg)
        End Select
        me\Field60 = local4
    EndIf
    Return $00
End Function
