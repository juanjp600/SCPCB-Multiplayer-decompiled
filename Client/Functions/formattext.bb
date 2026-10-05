Function formattext$(arg0#, arg1#, arg2$, arg3%, arg4%, arg5#, arg6%)
    Local local0%
    Local local1.redirecttext
    Local local2%
    Local local3%
    Local local4%
    Local local5$
    Local local6#
    Local local7$
    Local local8$
    Local local9$
    Local local10#
    Local local11#
    Local local12%
    Local local13$
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18$
    Local local19%
    Local local20#
    Local local21%
    Local local24$
    Local local25%
    Local local26%
    Local local27%
    Local local28%
    Local local29.loadedfonts
    Local local30.loadedfonts
    Local local31$
    Local local32%
    Local local33$
    Local local34%
    Local local35%
    Local local36%
    If (local0 = $00) Then
        For local1 = Each redirecttext
            If (instr(arg2, local1\Field1, $01) <> 0) Then
                arg2 = replace(arg2, local1\Field1, local1\Field2)
                Exit
            EndIf
        Next
    EndIf
    local2 = colorredex()
    local3 = colorgreenex()
    local4 = colorblueex()
    local6 = 0.0
    local12 = $00
    For local17 = $01 To len(arg2) Step $01
        local5 = mid(arg2, local17, $01)
        If (local5 = "%") Then
            local8 = right(arg2, (Int max((Float ((len(arg2) - local17) + $02)), 0.0)))
            local8 = piece(local8, $02, "%")
            local17 = ((len(local8) + local17) + $01)
        Else
            local7 = (local7 + local5)
        EndIf
    Next
    local19 = $00
    local20 = 0.0
    If (arg3 <> 0) Then
        arg0 = (arg0 - (Float (stringwidth(local7) Sar $01)))
    EndIf
    If (arg4 <> 0) Then
        arg1 = (arg1 - (Float (stringheight(local7) Sar $01)))
    EndIf
    local21 = currentfont()
    For local17 = $01 To len(arg2) Step $01
        local19 = $00
        local5 = mid(arg2, local17, $01)
        If (local5 = "%") Then
            local8 = piece(right(arg2, (Int max((Float ((len(arg2) - local17) + $02)), 0.0))), $02, "%")
            local9 = ""
            setcolorex((Int (255.0 * arg5)), (Int (255.0 * arg5)), (Int (255.0 * arg5)))
            Select local8
                Case "r"
                    setcolorex((Int (255.0 * arg5)), $00, $00)
                Case "g"
                    setcolorex($00, (Int (255.0 * arg5)), $00)
                Case "b"
                    setcolorex($00, $00, (Int (255.0 * arg5)))
                Case "y"
                    setcolorex((Int (255.0 * arg5)), (Int (255.0 * arg5)), $00)
                Case "w"
                    setcolorex((Int (255.0 * arg5)), (Int (255.0 * arg5)), (Int (255.0 * arg5)))
                Case "p"
                    setcolorex((Int (255.0 * arg5)), $00, (Int (255.0 * arg5)))
                Default
                    local19 = (local19 + $01)
            End Select
            Select piece(local8, $01, "|")
                Case "color"
                    local9 = piece(local8, $02, "|")
                    setcolorex((Int ((Float (Int piece(local9, $01, ","))) * arg5)), (Int ((Float (Int piece(local9, $02, ","))) * arg5)), (Int ((Float (Int piece(local9, $03, ","))) * arg5)))
                Case "font"
                    local9 = piece(local8, $02, "|")
                    local24 = piece(local9, $01, ",")
                    local25 = (Int piece(local9, $02, ","))
                    local26 = (Int piece(local9, $03, ","))
                    local27 = (Int piece(local9, $04, ","))
                    local28 = (Int piece(local9, $05, ","))
                    local29 = Null
                    For local30 = Each loadedfonts
                        If (local30\Field0 = local24) Then
                            If (local30\Field1 = local25) Then
                                If (local30\Field2 = local26) Then
                                    If (local30\Field3 = local27) Then
                                        If (local30\Field4 = local28) Then
                                            local29 = local30
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                    If (local29 = Null) Then
                        local29 = (New loadedfonts)
                        local29\Field0 = local24
                        local29\Field1 = local25
                        local29\Field2 = local26
                        local29\Field3 = local27
                        local29\Field4 = local28
                        local29\Field5 = loadfont_mp(local24, (Int ((Float local25) * menuscale)), local26, local27, local28)
                    EndIf
                    setfont(local29\Field5)
                    lastfont = $00
                Case "align"
                    arg3 = $01
                Case "alignfix"
                    arg3 = $01
                    arg0 = (arg0 - (Float (stringwidth(local7) Shr $01)))
                Case "tab"
                    local9 = piece(local8, $02, "|")
                    arg0 = (((Float piece(local9, $01, ",")) * menuscale) + arg0)
                Case "clickable"
                    local9 = piece(local8, $02, "|")
                    local12 = (Int piece(local9, $01, ","))
                    local13 = piece(local9, $02, ",")
                    local14 = (Int piece(local9, $03, ","))
                    local15 = (Int piece(local9, $04, ","))
                    local16 = (Int piece(local9, $05, ","))
                    local31 = ""
                    local18 = ""
                    If (local12 = $00) Then
                        local20 = 0.0
                    Else
                        local20 = ((Float stringwidth(getformattedtext(left(arg2, (local17 - $01))))) + local20)
                        If (instr(arg2, "%", (local17 + $01)) > $00) Then
                            For local32 = instr(arg2, "%", (local17 + $01)) To len(arg2) Step $01
                                local31 = mid(arg2, local32, $01)
                                If (local31 = "%") Then
                                    local33 = piece(piece(right(arg2, (Int max((Float ((len(arg2) - local32) + $02)), 0.0))), $02, "%"), $01, "|")
                                    If (local33 = "clickable") Then
                                        Exit
                                    EndIf
                                Else
                                    local18 = (local18 + local31)
                                EndIf
                            Next
                        EndIf
                    EndIf
                Default
                    local19 = (local19 + $01)
            End Select
            If (local19 = $02) Then
                local19 = $00
            Else
                local17 = ((len(local8) + local17) + $01)
            EndIf
        Else
            local19 = $00
        EndIf
        If (local19 = $00) Then
            If (local12 <> 0) Then
                local34 = colorredex()
                local35 = colorgreenex()
                local36 = colorblueex()
                If (mouseon((Int (arg0 + local20)), (Int arg1), stringwidth(local18), stringheight(local18)) <> 0) Then
                    If (arg6 <> 0) Then
                        setcolorex($00, $00, $00)
                        text((Int ((arg0 + local6) + 1.0)), (Int (arg1 + 1.0)), local5, $00, $00)
                    EndIf
                    setcolorex((Int ((Float local14) * arg5)), (Int ((Float local15) * arg5)), (Int ((Float local16) * arg5)))
                    If (mousehit1 <> 0) Then
                        execfile(local13)
                        mousehit1 = $00
                    EndIf
                Else
                    If (arg6 <> 0) Then
                        setcolorex($00, $00, $00)
                        text((Int ((arg0 + local6) + 1.0)), (Int (arg1 + 1.0)), local5, $00, $00)
                    EndIf
                    setcolorex(local34, local35, local36)
                EndIf
                text((Int (arg0 + local6)), (Int arg1), local5, $00, $00)
            Else
                If (arg6 <> 0) Then
                    local34 = colorredex()
                    local35 = colorgreenex()
                    local36 = colorblueex()
                    setcolorex($00, $00, $00)
                    text((Int ((arg0 + local6) + 1.0)), (Int (arg1 + 1.0)), local5, $00, $00)
                    setcolorex(local34, local35, local36)
                EndIf
                text((Int (arg0 + local6)), (Int arg1), local5, $00, $00)
            EndIf
            local6 = (local6 + (Float stringwidth(local5)))
            local11 = (local11 + (Float stringwidth(local5)))
            If (local10 <= (Float stringheight(local5))) Then
                local10 = (Float stringheight(local5))
            EndIf
        EndIf
    Next
    setcolorex(local2, local3, local4)
    setfont(local21)
    Return (((Str local10) + " ") + (Str local11))
    Return ""
End Function
