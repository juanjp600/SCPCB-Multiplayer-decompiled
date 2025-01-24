Function mp_server_receivescp294%(arg0.mp_player)
    Local local0.rooms
    Local local1$
    Local local2%
    Local local3$
    Local local4%
    Local local5%
    Local local6.items
    Local local7%
    Local local8%
    Local local9%
    If (determinepacketflooding(arg0, $04, $01, $5DC) <> 0) Then
        Return $00
    EndIf
    local0 = mp_rooms[arg0\Field22]
    If (((((local0 <> Null) And (local0\Field7\Field6 = $53)) And (9.0 > entitydistancesquared(local0\Field11[$00], arg0\Field18))) And ((arg0\Field4\Field28 >= $02) Lor (arg0\Field4\Field29 > $00))) <> 0) Then
        local1 = mp_readline()
        If (local1 = "") Then
            Return $00
        EndIf
        local1 = trim(local1)
        If (left(local1, (Int min(7.0, (Float len(local1))))) = "cup of ") Then
            local1 = right(local1, (len(local1) - $07))
        ElseIf (left(local1, (Int min(9.0, (Float len(local1))))) = "a cup of ") Then
            local1 = right(local1, (len(local1) - $09))
        EndIf
        If (s2imapcontains(i_294\Field2, local1) <> 0) Then
            arg0\Field4\Field29 = $00
            arg0\Field4\Field28 = $00
            local2 = jsongetarrayvalue(i_294\Field3, s2imapget(i_294\Field2, local1))
            If (jsonisnull(jsongetvalue(local2, "dispense_sound")) = $00) Then
                local3 = jsongetstring(jsongetvalue(local2, "dispense_sound"))
                mp_playsoundat(local3, local0\Field11[$00], 10.0, 1.0)
                mp_synchronize3dsound(arg0, local3, local0\Field11[$00], 10.0, 1.0)
            EndIf
            If (arg0\Field4\Field29 > $00) Then
                local4 = ((arg0\Field4\Field29 = $02) + $61)
                mp_playsoundat("SFX\SCP\294\PullMasterCard.ogg", local0\Field11[$00], 5.0, 1.0)
                mp_synchronize3dsound(arg0, "SFX\SCP\294\PullMasterCard.ogg", local0\Field11[$00], 5.0, 1.0)
                If (getplayeritemamount(arg0) < maxitemamount) Then
                    local6 = createitem("Mastercard", local4, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                    entitytype(local6\Field2, $03, $00)
                    mp_playertakeitem(arg0, local6)
                Else
                    local6 = createitem("Mastercard", local4, entityx(arg0\Field18, $00), (entityy(arg0\Field18, $00) + 0.3), entityz(arg0\Field18, $00), $00, $00, $00, 1.0, $00)
                    entitytype(local6\Field2, $03, $00)
                    server_sendmessage(arg0, getlocalstringformat("msg", "cantcarry"), 6.0, $00)
                EndIf
            EndIf
            local7 = jsongetvalue(local2, "explosion")
            If (jsonisnull(local7) = $00) Then
                If (jsongetbool(local7) <> 0) Then
                    Return $00
                EndIf
            EndIf
            local8 = jsongetarray(jsongetvalue(local2, "color"))
            local9 = (Int jsongetfloat(jsongetvalue(local2, "alpha")))
            local7 = jsongetvalue(local2, "glow")
            If (jsonisnull(local7) = $00) Then
                If (jsongetbool(local7) <> 0) Then
                    local9 = (- local9)
                EndIf
            EndIf
            local6 = createitem("Cup", $2B, entityx(local0\Field11[$02], $01), entityy(local0\Field11[$02], $01), entityz(local0\Field11[$02], $01), jsongetint(jsongetarrayvalue(local8, $00)), jsongetint(jsongetarrayvalue(local8, $01)), jsongetint(jsongetarrayvalue(local8, $02)), (Float local9), $00)
            local6\Field1 = local1
            local6\Field0 = format(getlocalstring("items", "cupof"), local1, "%s")
            entitytype(local6\Field2, $03, $00)
        Else
            mp_playsoundat("SFX\SCP\294\OutOfRange.ogg", local0\Field11[$00], 10.0, 1.0)
            mp_synchronize3dsound(arg0, "SFX\SCP\294\OutOfRange.ogg", local0\Field11[$00], 10.0, 1.0)
        EndIf
    EndIf
    Return $00
End Function
