Function limitformattext$(arg0#, arg1#, arg2$, arg3#, arg4%, arg5%, arg6#, arg7%)
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
    Local local20%
    Local local21#
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
    local0 = aaselectedfont
    If (disableredirectaccess = $00) Then
        For local1 = Each redirecttext
            If (instr(arg2, local1\Field1, $01) <> 0) Then
                arg2 = replace(arg2, local1\Field1, local1\Field2)
                Exit
            EndIf
        Next
    EndIf
    local2 = colorred()
    local3 = colorgreen()
    local4 = colorblue()
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
    If (arg4 <> 0) Then
        arg0 = (arg0 - (Float (aastringwidth(local7) Sar $01)))
    EndIf
    If (arg5 <> 0) Then
        arg1 = (arg1 - (Float (aastringheight(local7) Sar $01)))
    EndIf
    local20 = $00
    local21 = 0.0
    For local17 = $01 To len(arg2) Step $01
        local19 = $00
        local5 = mid(arg2, local17, $01)
        If (local5 = "%") Then
            local8 = piece(right(arg2, (Int max((Float ((len(arg2) - local17) + $02)), 0.0))), $02, "%")
            local9 = ""
            color((Int (255.0 * arg6)), (Int (255.0 * arg6)), (Int (255.0 * arg6)))
            Select local8
                Case "r"
                    color((Int (255.0 * arg6)), $00, $00)
                Case "g"
                    color($00, (Int (255.0 * arg6)), $00)
                Case "b"
                    color($00, $00, (Int (255.0 * arg6)))
                Case "y"
                    color((Int (255.0 * arg6)), (Int (255.0 * arg6)), $00)
                Case "w"
                    color((Int (255.0 * arg6)), (Int (255.0 * arg6)), (Int (255.0 * arg6)))
                Case "p"
                    color((Int (255.0 * arg6)), $00, (Int (255.0 * arg6)))
                Default
                    local19 = (local19 + $01)
            End Select
            Select piece(local8, $01, "|")
                Case "color"
                    local9 = piece(local8, $02, "|")
                    color((Int ((Float (Int piece(local9, $01, ","))) * arg6)), (Int ((Float (Int piece(local9, $02, ","))) * arg6)), (Int ((Float (Int piece(local9, $03, ","))) * arg6)))
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
                        local29\Field5 = aaloadfont(local24, ((Float local25) * menuscale), local26, local27, local28, $02)
                    EndIf
                    aasetfont(local29\Field5)
                Case "align"
                    arg4 = $01
                Case "alignfix"
                    arg4 = $01
                    arg0 = (arg0 - (Float (aastringwidth(local7) Sar $01)))
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
                        local21 = 0.0
                    Else
                        local21 = ((Float aastringwidth(getformattedtext(left(arg2, (local17 - $01))))) + local21)
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
            If (local6 >= ((arg3 - (Float aastringwidth("..."))) - (4.0 * menuscale))) Then
                local5 = "..."
                local20 = (local20 + $03)
            EndIf
            If (local12 <> 0) Then
                local34 = colorred()
                local35 = colorgreen()
                local36 = colorblue()
                If (mouseon((Int (arg0 + local21)), (Int arg1), aastringwidth(local18), aastringheight(local18)) <> 0) Then
                    If (arg7 <> 0) Then
                        color($00, $00, $00)
                        aatext((Int ((arg0 + local6) + 1.0)), (Int (arg1 + 1.0)), local5, $00, $00, 1.0)
                    EndIf
                    color((Int ((Float local14) * arg6)), (Int ((Float local15) * arg6)), (Int ((Float local16) * arg6)))
                    If (mousehit1 <> 0) Then
                        execfile(local13)
                        mousehit1 = $00
                    EndIf
                Else
                    If (arg7 <> 0) Then
                        color($00, $00, $00)
                        aatext((Int ((arg0 + local6) + 1.0)), (Int (arg1 + 1.0)), local5, $00, $00, 1.0)
                    EndIf
                    color(local34, local35, local36)
                EndIf
                aatext((Int (arg0 + local6)), (Int arg1), local5, $00, $00, 1.0)
            Else
                If (arg7 <> 0) Then
                    local34 = colorred()
                    local35 = colorgreen()
                    local36 = colorblue()
                    color($00, $00, $00)
                    aatext((Int ((arg0 + local6) + 1.0)), (Int (arg1 + 1.0)), local5, $00, $00, 1.0)
                    color(local34, local35, local36)
                EndIf
                aatext((Int (arg0 + local6)), (Int arg1), local5, $00, $00, 1.0)
            EndIf
            local6 = (local6 + (Float aastringwidth(local5)))
            local11 = (local11 + (Float aastringwidth(local5)))
            If (local10 <= (Float aastringheight(local5))) Then
                local10 = (Float aastringheight(local5))
            EndIf
            If (local20 >= $03) Then
                Exit
            EndIf
        EndIf
    Next
    color(local2, local3, local4)
    aasetfont(local0)
    Return (((Str local10) + " ") + (Str local11))
    Return ""
End Function
