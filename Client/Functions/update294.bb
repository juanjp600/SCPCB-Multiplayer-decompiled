Function update294%()
    Local local0.items
    Local local1#
    Local local2#
    Local local3$
    Local local4%
    Local local5%
    Local local6#
    Local local7%
    Local local8$
    Local local9%
    Local local10%
    Local local11%
    Local local12.events
    local1 = (Float (mo\Field9 - (imagewidth(t\Field1[$05]) Sar $01)))
    local2 = (Float (mo\Field10 - (imageheight(t\Field1[$05]) Sar $01)))
    local4 = (playerroom\Field9 = $00)
    If (local4 <> 0) Then
        i_294\Field1 = upper(updateinput(i_294\Field1, $40))
        If ((mo\Field0 Lor keyhit($1C)) <> 0) Then
            If ((local4 And (i_294\Field1 <> "")) <> 0) Then
                mp_client_use294(i_294\Field1)
                i_294\Field1 = trim(i_294\Field1)
                If (left(i_294\Field1, (Int min(7.0, (Float len(i_294\Field1))))) = "cup of ") Then
                    i_294\Field1 = right(i_294\Field1, (len(i_294\Field1) - $07))
                ElseIf (left(i_294\Field1, (Int min(9.0, (Float len(i_294\Field1))))) = "a cup of ") Then
                    i_294\Field1 = right(i_294\Field1, (len(i_294\Field1) - $09))
                EndIf
                If (s2imapcontains(i_294\Field2, i_294\Field1) <> 0) Then
                    local7 = jsongetarrayvalue(i_294\Field3, s2imapget(i_294\Field2, i_294\Field1))
                    If (jsonisnull(jsongetvalue(local7, "dispense_sound")) = $00) Then
                        local8 = jsongetstring(jsongetvalue(local7, "dispense_sound"))
                        playerroom\Field9 = playsound_strict(loadtempsound(local8), $00, $01)
                        mp_synchronize3dsound(Null, local8, playerroom\Field11[$00], 10.0, 1.0)
                    EndIf
                    If (me\Field65 > $00) Then
                        local9 = ((me\Field65 = $02) + $61)
                        playsound_strict(loadtempsound("SFX\SCP\294\PullMasterCard.ogg"), $00, $01)
                        mp_synchronize3dsound(Null, "SFX\SCP\294\PullMasterCard.ogg", playerroom\Field11[$00], 2.0, 1.0)
                        If (((mp_getsocket() = $00) Lor mp_ishoster()) <> 0) Then
                            If (getitemamount() < maxitemamount) Then
                                local0 = createitem("Mastercard", local9, 0.0, 0.0, 0.0, $00, $00, $00, 1.0, $00)
                                local0\Field12 = (Float me\Field64)
                                entitytype(local0\Field2, $03, $00)
                                pickitem(local0, $00)
                            Else
                                local0 = createitem("Mastercard", local9, entityx(me\Field60, $00), (entityy(me\Field60, $00) + 0.3), entityz(me\Field60, $00), $00, $00, $00, 1.0, $00)
                                local0\Field4\Field4 = $01
                                local0\Field12 = (Float me\Field64)
                                entitytype(local0\Field2, $03, $00)
                                createmsg(getlocalstring("msg", "cantcarry"), 6.0)
                            EndIf
                        EndIf
                    EndIf
                    local5 = jsongetvalue(local7, "explosion")
                    If (jsonisnull(local5) = $00) Then
                        If (jsongetbool(local5) <> 0) Then
                            me\Field58 = 135.0
                            local5 = jsongetvalue(local7, "death_message")
                            If (jsonisnull(local5) = $00) Then
                                msg\Field2 = jsongetstring(local5)
                            EndIf
                        EndIf
                    EndIf
                    local11 = jsongetarray(jsongetvalue(local7, "color"))
                    local6 = jsongetfloat(jsongetvalue(local7, "alpha"))
                    local5 = jsongetvalue(local7, "glow")
                    If (jsonisnull(local5) = $00) Then
                        If (jsongetbool(local5) <> 0) Then
                            local6 = (- local6)
                        EndIf
                    EndIf
                    If (((mp_getsocket() = $00) Lor mp_ishoster()) <> 0) Then
                        local0 = createitem("Cup", $2B, entityx(playerroom\Field11[$02], $01), entityy(playerroom\Field11[$02], $01), entityz(playerroom\Field11[$02], $01), jsongetint(jsongetarrayvalue(local11, $00)), jsongetint(jsongetarrayvalue(local11, $01)), jsongetint(jsongetarrayvalue(local11, $02)), local6, $00)
                        local0\Field1 = i_294\Field1
                        local0\Field0 = format(getlocalstring("items", "cupof"), i_294\Field1, "%s")
                        entitytype(local0\Field2, $03, $00)
                    EndIf
                Else
                    i_294\Field1 = getlocalstring("misc", "ofr")
                    playerroom\Field9 = playsound_strict(loadtempsound("SFX\SCP\294\OutOfRange.ogg"), $00, $01)
                    mp_synchronize3dsound(Null, "SFX\SCP\294\OutOfRange.ogg", playerroom\Field11[$00], 10.0, 1.0)
                EndIf
            EndIf
        EndIf
        If ((mo\Field1 Lor (i_294\Field0 = $00)) <> 0) Then
            i_294\Field0 = $00
            i_294\Field1 = ""
            stopmousemovement()
        EndIf
    Else
        If (i_294\Field1 <> getlocalstring("misc", "ofr")) Then
            i_294\Field1 = getlocalstring("misc", "dispensing")
        EndIf
        If (channelplaying(playerroom\Field9) = $00) Then
            If (i_294\Field1 <> getlocalstring("misc", "ofr")) Then
                i_294\Field0 = $00
                me\Field65 = $00
                stopmousemovement()
                For local12 = Each events
                    If (playerroom = local12\Field1) Then
                        local12\Field3 = 0.0
                        Exit
                    EndIf
                Next
            EndIf
            i_294\Field1 = ""
            playerroom\Field9 = $00
        EndIf
    EndIf
    Return $00
End Function
