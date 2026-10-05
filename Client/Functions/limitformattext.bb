Function limitformattext$(arg0#, arg1#, arg2$, arg3#, arg4%, arg5%, arg6#, arg7%)
    Local local0%
    Local local1%
    Local local2%
    Local local3.redirecttext
    Local local4%
    Local local5%
    Local local6%
    Local local7$
    Local local8#
    Local local9$
    Local local10$
    Local local11$
    Local local12#
    Local local13#
    Local local14%
    Local local15$
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    Local local20$
    Local local21%
    Local local22%
    Local local23#
    Local local26$
    Local local27%
    Local local28%
    Local local29%
    Local local30%
    Local local31.loadedfonts
    Local local32.loadedfonts
    Local local33$
    Local local34%
    Local local35$
    Local local36%
    Local local37%
    Local local38%
    local0 = local1
    If (local2 = $00) Then
        For local3 = Each redirecttext
            If (instr(arg2, local3\Field1, $01) <> 0) Then
                arg2 = replace(arg2, local3\Field1, local3\Field2)
                Exit
            EndIf
        Next
    EndIf
    local4 = colorredex()
    local5 = colorgreenex()
    local6 = colorblueex()
    local8 = 0.0
    local14 = $00
    For local19 = $01 To len(arg2) Step $01
        local7 = mid(arg2, local19, $01)
        If (local7 = "%") Then
            local10 = right(arg2, (Int max((Float ((len(arg2) - local19) + $02)), 0.0)))
            local10 = piece(local10, $02, "%")
            local19 = ((len(local10) + local19) + $01)
        Else
            local9 = (local9 + local7)
        EndIf
    Next
    local21 = $00
    If (arg4 <> 0) Then
        arg0 = (arg0 - (Float (stringwidth(local9) Sar $01)))
    EndIf
    If (arg5 <> 0) Then
        arg1 = (arg1 - (Float (stringheight(local9) Sar $01)))
    EndIf
    local22 = $00
    local23 = 0.0
    For local19 = $01 To len(arg2) Step $01
        local21 = $00
        local7 = mid(arg2, local19, $01)
        If (local7 = "%") Then
            local10 = piece(right(arg2, (Int max((Float ((len(arg2) - local19) + $02)), 0.0))), $02, "%")
            local11 = ""
            setcolorex((Int (255.0 * arg6)), (Int (255.0 * arg6)), (Int (255.0 * arg6)))
            Select local10
                Case "r"
                    setcolorex((Int (255.0 * arg6)), $00, $00)
                Case "g"
                    setcolorex($00, (Int (255.0 * arg6)), $00)
                Case "b"
                    setcolorex($00, $00, (Int (255.0 * arg6)))
                Case "y"
                    setcolorex((Int (255.0 * arg6)), (Int (255.0 * arg6)), $00)
                Case "w"
                    setcolorex((Int (255.0 * arg6)), (Int (255.0 * arg6)), (Int (255.0 * arg6)))
                Case "p"
                    setcolorex((Int (255.0 * arg6)), $00, (Int (255.0 * arg6)))
                Default
                    local21 = (local21 + $01)
            End Select
            Select piece(local10, $01, "|")
                Case "color"
                    local11 = piece(local10, $02, "|")
                    setcolorex((Int ((Float (Int piece(local11, $01, ","))) * arg6)), (Int ((Float (Int piece(local11, $02, ","))) * arg6)), (Int ((Float (Int piece(local11, $03, ","))) * arg6)))
                Case "font"
                    local11 = piece(local10, $02, "|")
                    local26 = piece(local11, $01, ",")
                    local27 = (Int piece(local11, $02, ","))
                    local28 = (Int piece(local11, $03, ","))
                    local29 = (Int piece(local11, $04, ","))
                    local30 = (Int piece(local11, $05, ","))
                    local31 = Null
                    For local32 = Each loadedfonts
                        If (local32\Field0 = local26) Then
                            If (local32\Field1 = local27) Then
                                If (local32\Field2 = local28) Then
                                    If (local32\Field3 = local29) Then
                                        If (local32\Field4 = local30) Then
                                            local31 = local32
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                    If (local31 = Null) Then
                        local31 = (New loadedfonts)
                        local31\Field0 = local26
                        local31\Field1 = local27
                        local31\Field2 = local28
                        local31\Field3 = local29
                        local31\Field4 = local30
                        local31\Field5 = loadfont_strict(local26, (Int ((Float local27) * menuscale)), local28, local29, local30)
                    EndIf
                    setfont(local31\Field5)
                Case "align"
                    arg4 = $01
                Case "alignfix"
                    arg4 = $01
                    arg0 = (arg0 - (Float (stringwidth(local9) Shr $01)))
                Case "tab"
                    local11 = piece(local10, $02, "|")
                    arg0 = (((Float piece(local11, $01, ",")) * menuscale) + arg0)
                Case "clickable"
                    local11 = piece(local10, $02, "|")
                    local14 = (Int piece(local11, $01, ","))
                    local15 = piece(local11, $02, ",")
                    local16 = (Int piece(local11, $03, ","))
                    local17 = (Int piece(local11, $04, ","))
                    local18 = (Int piece(local11, $05, ","))
                    local33 = ""
                    local20 = ""
                    If (local14 = $00) Then
                        local23 = 0.0
                    Else
                        local23 = ((Float stringwidth(getformattedtext(left(arg2, (local19 - $01))))) + local23)
                        If (instr(arg2, "%", (local19 + $01)) > $00) Then
                            For local34 = instr(arg2, "%", (local19 + $01)) To len(arg2) Step $01
                                local33 = mid(arg2, local34, $01)
                                If (local33 = "%") Then
                                    local35 = piece(piece(right(arg2, (Int max((Float ((len(arg2) - local34) + $02)), 0.0))), $02, "%"), $01, "|")
                                    If (local35 = "clickable") Then
                                        Exit
                                    EndIf
                                Else
                                    local20 = (local20 + local33)
                                EndIf
                            Next
                        EndIf
                    EndIf
                Default
                    local21 = (local21 + $01)
            End Select
            If (local21 = $02) Then
                local21 = $00
            Else
                local19 = ((len(local10) + local19) + $01)
            EndIf
        Else
            local21 = $00
        EndIf
        If (local21 = $00) Then
            If (local8 >= ((arg3 - (Float stringwidth("..."))) - (4.0 * menuscale))) Then
                local7 = "..."
                local22 = (local22 + $03)
            EndIf
            If (local14 <> 0) Then
                local36 = colorredex()
                local37 = colorgreenex()
                local38 = colorblueex()
                If (mouseon((Int (arg0 + local23)), (Int arg1), stringwidth(local20), stringheight(local20)) <> 0) Then
                    If (arg7 <> 0) Then
                        setcolorex($00, $00, $00)
                        text((Int ((arg0 + local8) + 1.0)), (Int (arg1 + 1.0)), local7, $00, $00)
                    EndIf
                    setcolorex((Int ((Float local16) * arg6)), (Int ((Float local17) * arg6)), (Int ((Float local18) * arg6)))
                    If (mousehit1 <> 0) Then
                        execfile(local15)
                        mousehit1 = $00
                    EndIf
                Else
                    If (arg7 <> 0) Then
                        setcolorex($00, $00, $00)
                        text((Int ((arg0 + local8) + 1.0)), (Int (arg1 + 1.0)), local7, $00, $00)
                    EndIf
                    setcolorex(local36, local37, local38)
                EndIf
                text((Int (arg0 + local8)), (Int arg1), local7, $00, $00)
            Else
                If (arg7 <> 0) Then
                    local36 = colorredex()
                    local37 = colorgreenex()
                    local38 = colorblueex()
                    setcolorex($00, $00, $00)
                    text((Int ((arg0 + local8) + 1.0)), (Int (arg1 + 1.0)), local7, $00, $00)
                    setcolorex(local36, local37, local38)
                EndIf
                text((Int (arg0 + local8)), (Int arg1), local7, $00, $00)
            EndIf
            local8 = (local8 + (Float stringwidth(local7)))
            local13 = (local13 + (Float stringwidth(local7)))
            If (local12 <= (Float stringheight(local7))) Then
                local12 = (Float stringheight(local7))
            EndIf
            If (local22 >= $03) Then
                Exit
            EndIf
        EndIf
    Next
    setcolorex(local4, local5, local6)
    setfontex(fonts[$00]\Field0)
    Return (((Str local12) + " ") + (Str local13))
    Return ""
End Function
