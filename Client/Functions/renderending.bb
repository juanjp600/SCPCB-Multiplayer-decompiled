Function renderending%()
    Local local0%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6.itemtemplates
    Local local7.rooms
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17$
    Local local18%
    Local local19%
    Local local20%
    Local local21%
    showpointer()
    local0 = (Int max(((me\Field45 * 2.8) + 255.0), 0.0))
    Select me\Field43
        Case $00,$03
            clscolor(local0, local0, local0)
        Default
            clscolor($00, $00, $00)
    End Select
    cls()
    If (-200.0 > me\Field45) Then
        If (-700.0 < me\Field45) Then
            If (min(((Abs me\Field45) - 200.0), 155.0) > (Float rand($96, $01))) Then
                drawblock(me\Field44, (Int ((Float mo\Field9) - (400.0 * menuscale))), (Int ((Float mo\Field10) - (400.0 * menuscale))), $00)
            Else
                color($00, $00, $00)
                rect($64, $64, (opt\Field49 - $C8), (opt\Field50 - $C8), $01)
                color($FF, $FF, $FF)
            EndIf
        Else
            drawblock(me\Field44, (Int ((Float mo\Field9) - (400.0 * menuscale))), (Int ((Float mo\Field10) - (400.0 * menuscale))), $00)
            If (((-1000.0 > me\Field45) And (-2000.0 < me\Field45)) <> 0) Then
                local2 = imagewidth(t\Field1[$00])
                local3 = imageheight(t\Field1[$00])
                local4 = (mo\Field9 - (local2 Sar $01))
                local5 = (mo\Field10 - (local3 Sar $01))
                drawblock(t\Field1[$00], local4, local5, $00)
                color($FF, $FF, $FF)
                setfontex(fo\Field0[$01])
                textex((Int ((47.0 * menuscale) + (Float ((local2 Sar $01) + local4)))), (Int ((48.0 * menuscale) + (Float local5))), getlocalstring("menu", "end"), $01, $01)
                setfontex(fo\Field0[$00])
                If (igm\Field0 <= $00) Then
                    local4 = (Int ((132.0 * menuscale) + (Float local4)))
                    local5 = (Int ((122.0 * menuscale) + (Float local5)))
                    local9 = $00
                    local10 = $00
                    For local7 = Each rooms
                        local11 = local7\Field7\Field6
                        If ((((((local11 <> $04) And (local11 <> $47)) And (local11 <> $49)) And (local11 <> $69)) And (local11 <> $6A)) <> 0) Then
                            local9 = (local9 + $01)
                            local10 = (local10 + local7\Field1)
                        EndIf
                    Next
                    If (local9 = local10) Then
                        snavunlocked = $01
                    EndIf
                    local12 = $00
                    local13 = $00
                    For local6 = Each itemtemplates
                        If (local6\Field2 = $00) Then
                            local8 = $01
                            If ((((local6\Field1 = "Drawing") Lor (local6\Field1 = "Blank Paper")) Lor ((local6\Field1 = "Note from Maynard") And (3.0 <> (Float i_005\Field0)))) <> 0) Then
                                local8 = $00
                            EndIf
                            If (local8 <> 0) Then
                                local12 = (local12 + $01)
                                local13 = (local13 + local6\Field4)
                            EndIf
                        EndIf
                    Next
                    If (local12 = local13) Then
                        ereaderunlocked = $01
                    EndIf
                    local14 = $01
                    local15 = jsongetarray(jsongetvalue(achievementsarray, "achievements"))
                    local16 = jsongetarraysize(local15)
                    For local8 = $00 To (local16 - $01) Step $01
                        local17 = jsongetstring(jsongetvalue(jsongetarrayvalue(local15, local8), "id"))
                        If (s2imapcontains(unlockedachievements, local17) <> 0) Then
                            If (jsongetbool(jsongetvalue(jsongetarrayvalue(local15, local8), "scp")) <> 0) Then
                                local14 = (local14 + $01)
                            EndIf
                        EndIf
                    Next
                    local18 = s2imapsize(unlockedachievements)
                    local19 = (escapetimer Mod $3C)
                    local20 = (Int floor((Float (escapetimer / $3C))))
                    local21 = (Int floor((Float (local20 / $3C))))
                    local20 = (local20 - (local21 * $3C))
                    textex(local4, local5, format(getlocalstring("menu", "end.scps"), (Str local14), "%s"), $00, $00)
                    textex(local4, (Int ((20.0 * menuscale) + (Float local5))), format(format(getlocalstring("menu", "end.achi"), (Str local18), "{0}"), (Str s2imapsize(achievementsindex)), "{1}"), $00, $00)
                    textex(local4, (Int ((40.0 * menuscale) + (Float local5))), format(format(getlocalstring("menu", "end.room"), (Str local10), "{0}"), (Str local9), "{1}"), $00, $00)
                    textex(local4, (Int ((60.0 * menuscale) + (Float local5))), format(format(getlocalstring("menu", "end.doc"), (Str local13), "{0}"), (Str local12), "{1}"), $00, $00)
                    textex(local4, (Int ((80.0 * menuscale) + (Float local5))), format(getlocalstring("menu", "end.914"), (Str me\Field53), "%s"), $00, $00)
                    textex(local4, (Int ((100.0 * menuscale) + (Float local5))), format(format(format(getlocalstring("menu", "end.escape"), (Str local21), "{0}"), (Str local20), "{1}"), (Str local19), "{2}"), $00, $00)
                    rendermenubuttons()
                    rendercursor()
                Else
                    rendermenu()
                EndIf
            ElseIf (-2000.0 >= me\Field45) Then
                rendercredits()
            EndIf
        EndIf
    EndIf
    setfontex(fo\Field0[$00])
    Return $00
End Function
