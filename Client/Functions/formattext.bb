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
    Local local23$
    Local local24%
    Local local25%
    Local local26%
    Local local27%
    Local local28.loadedfonts
    Local local29.loadedfonts
    Local local30$
    Local local31%
    Local local32$
    Local local33%
    Local local34%
    Local local35%
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
    local20 = 0.0
    If (arg3 <> 0) Then
        arg0 = (arg0 - (Float (aastringwidth(local7) Sar $01)))
    EndIf
    If (arg4 <> 0) Then
        arg1 = (arg1 - (Float (aastringheight(local7) Sar $01)))
    EndIf
    For local17 = $01 To len(arg2) Step $01
        local19 = $00
        local5 = mid(arg2, local17, $01)
        If (local5 = "%") Then
            local8 = piece(right(arg2, (Int max((Float ((len(arg2) - local17) + $02)), 0.0))), $02, "%")
            local9 = ""
            color((Int (255.0 * arg5)), (Int (255.0 * arg5)), (Int (255.0 * arg5)))
            Select local8
                Case "r"
                    color((Int (255.0 * arg5)), $00, $00)
                Case "g"
                    color($00, (Int (255.0 * arg5)), $00)
                Case "b"
                    color($00, $00, (Int (255.0 * arg5)))
                Case "y"
                    color((Int (255.0 * arg5)), (Int (255.0 * arg5)), $00)
                Case "w"
                    color((Int (255.0 * arg5)), (Int (255.0 * arg5)), (Int (255.0 * arg5)))
                Case "p"
                    color((Int (255.0 * arg5)), $00, (Int (255.0 * arg5)))
                Default
                    local19 = (local19 + $01)
            End Select
            Select piece(local8, $01, "|")
                Case "color"
                    local9 = piece(local8, $02, "|")
                    color((Int ((Float (Int piece(local9, $01, ","))) * arg5)), (Int ((Float (Int piece(local9, $02, ","))) * arg5)), (Int ((Float (Int piece(local9, $03, ","))) * arg5)))
                Case "font"
                    local9 = piece(local8, $02, "|")
                    local23 = piece(local9, $01, ",")
                    local24 = (Int piece(local9, $02, ","))
                    local25 = (Int piece(local9, $03, ","))
                    local26 = (Int piece(local9, $04, ","))
                    local27 = (Int piece(local9, $05, ","))
                    local28 = Null
                    For local29 = Each loadedfonts
                        If (local29\Field0 = local23) Then
                            If (local29\Field1 = local24) Then
                                If (local29\Field2 = local25) Then
                                    If (local29\Field3 = local26) Then
                                        If (local29\Field4 = local27) Then
                                            local28 = local29
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                    If (local28 = Null) Then
                        local28 = (New loadedfonts)
                        local28\Field0 = local23
                        local28\Field1 = local24
                        local28\Field2 = local25
                        local28\Field3 = local26
                        local28\Field4 = local27
                        local28\Field5 = aaloadfont(local23, ((Float local24) * menuscale), local25, local26, local27, $02)
                    EndIf
                    aasetfont(local28\Field5)
                Case "align"
                    arg3 = $01
                Case "alignfix"
                    arg3 = $01
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
                    local30 = ""
                    local18 = ""
                    If (local12 = $00) Then
                        local20 = 0.0
                    Else
                        local20 = ((Float aastringwidth(getformattedtext(left(arg2, (local17 - $01))))) + local20)
                        If (instr(arg2, "%", (local17 + $01)) > $00) Then
                            For local31 = instr(arg2, "%", (local17 + $01)) To len(arg2) Step $01
                                local30 = mid(arg2, local31, $01)
                                If (local30 = "%") Then
                                    local32 = piece(piece(right(arg2, (Int max((Float ((len(arg2) - local31) + $02)), 0.0))), $02, "%"), $01, "|")
                                    If (local32 = "clickable") Then
                                        Exit
                                    EndIf
                                Else
                                    local18 = (local18 + local30)
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
                local33 = colorred()
                local34 = colorgreen()
                local35 = colorblue()
                If (mouseon((Int (arg0 + local20)), (Int arg1), aastringwidth(local18), aastringheight(local18)) <> 0) Then
                    If (arg6 <> 0) Then
                        color($00, $00, $00)
                        aatext((Int ((arg0 + local6) + 1.0)), (Int (arg1 + 1.0)), local5, $00, $00, 1.0)
                    EndIf
                    color((Int ((Float local14) * arg5)), (Int ((Float local15) * arg5)), (Int ((Float local16) * arg5)))
                    If (mousehit1 <> 0) Then
                        execfile(local13)
                        mousehit1 = $00
                    EndIf
                Else
                    If (arg6 <> 0) Then
                        color($00, $00, $00)
                        aatext((Int ((arg0 + local6) + 1.0)), (Int (arg1 + 1.0)), local5, $00, $00, 1.0)
                    EndIf
                    color(local33, local34, local35)
                EndIf
                aatext((Int (arg0 + local6)), (Int arg1), local5, $00, $00, 1.0)
            Else
                If (arg6 <> 0) Then
                    local33 = colorred()
                    local34 = colorgreen()
                    local35 = colorblue()
                    color($00, $00, $00)
                    aatext((Int ((arg0 + local6) + 1.0)), (Int (arg1 + 1.0)), local5, $00, $00, 1.0)
                    color(local33, local34, local35)
                EndIf
                aatext((Int (arg0 + local6)), (Int arg1), local5, $00, $00, 1.0)
            EndIf
            local6 = (local6 + (Float aastringwidth(local5)))
            local11 = (local11 + (Float aastringwidth(local5)))
            If (local10 <= (Float aastringheight(local5))) Then
                local10 = (Float aastringheight(local5))
            EndIf
        EndIf
    Next
    color(local2, local3, local4)
    aasetfont(local0)
    Return (((Str local10) + " ") + (Str local11))
    Return ""
End Function
