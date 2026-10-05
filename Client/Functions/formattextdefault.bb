Function formattextdefault$(arg0#, arg1#, arg2$, arg3%, arg4%, arg5#, arg6%)
    Local local0%
    Local local1%
    Local local2%
    Local local3$
    Local local4#
    Local local5$
    Local local6$
    Local local7$
    Local local8#
    Local local9#
    Local local10%
    Local local11$
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16$
    Local local17%
    Local local18%
    Local local19%
    Local local22$
    Local local23%
    Local local24%
    Local local25%
    Local local26%
    Local local27.loadedfonts
    Local local28.loadedfonts
    Local local29%
    Local local30%
    Local local31%
    local0 = colorredex()
    local1 = colorgreenex()
    local2 = colorblueex()
    local4 = 0.0
    local10 = $00
    For local15 = $01 To len(arg2) Step $01
        local3 = mid(arg2, local15, $01)
        If (local3 = "%") Then
            local6 = right(arg2, (Int max((Float ((len(arg2) - local15) + $02)), 0.0)))
            local6 = piece(local6, $02, "%")
            local15 = ((len(local6) + local15) + $01)
        Else
            local5 = (local5 + local3)
        EndIf
    Next
    local17 = $00
    local18 = $00
    local19 = currentfont()
    If (arg3 <> 0) Then
        arg0 = (arg0 - (Float (stringwidth(local5) Shr $01)))
    EndIf
    If (arg4 <> 0) Then
        arg1 = (arg1 - (Float (stringheight(local5) Shr $01)))
    EndIf
    For local15 = $01 To len(arg2) Step $01
        local17 = $00
        local3 = mid(arg2, local15, $01)
        If (local3 = "%") Then
            local6 = piece(right(arg2, (Int max((Float ((len(arg2) - local15) + $02)), 0.0))), $02, "%")
            local7 = ""
            setcolorex((Int (255.0 * arg5)), (Int (255.0 * arg5)), (Int (255.0 * arg5)))
            Select local6
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
                    local17 = (local17 + $01)
            End Select
            Select piece(local6, $01, "|")
                Case "font"
                    local7 = piece(local6, $02, "|")
                    local22 = piece(local7, $01, ",")
                    local23 = (Int piece(local7, $02, ","))
                    local24 = (Int piece(local7, $03, ","))
                    local25 = (Int piece(local7, $04, ","))
                    local26 = (Int piece(local7, $05, ","))
                    local27 = Null
                    For local28 = Each loadedfonts
                        If (local28\Field0 = local22) Then
                            If (local28\Field1 = local23) Then
                                If (local28\Field2 = local24) Then
                                    If (local28\Field3 = local25) Then
                                        If (local28\Field4 = local26) Then
                                            local27 = local28
                                            Exit
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                    If (local27 = Null) Then
                        local27 = (New loadedfonts)
                        local27\Field0 = local22
                        local27\Field1 = local23
                        local27\Field2 = local24
                        local27\Field3 = local25
                        local27\Field4 = local26
                        local27\Field5 = loadfont(local22, (Int ((Float local23) * menuscale)), local24, local25, local26)
                        local27\Field6 = $01
                    EndIf
                    setfont(local27\Field5)
                Case "color"
                    local7 = piece(local6, $02, "|")
                    setcolorex((Int ((Float (Int piece(local7, $01, ","))) * arg5)), (Int ((Float (Int piece(local7, $02, ","))) * arg5)), (Int ((Float (Int piece(local7, $03, ","))) * arg5)))
                Default
                    local17 = (local17 + $01)
            End Select
            If (local17 = $02) Then
                local17 = $00
            Else
                local15 = ((len(local6) + local15) + $01)
            EndIf
        Else
            local17 = $00
        EndIf
        If (local17 = $00) Then
            If (arg6 <> 0) Then
                local29 = colorredex()
                local30 = colorgreenex()
                local31 = colorblueex()
                setcolorex($00, $00, $00)
                text((Int ((arg0 + local4) + 1.0)), (Int (arg1 + 1.0)), local3, $00, $00)
                setcolorex(local29, local30, local31)
            EndIf
            text((Int (arg0 + local4)), (Int arg1), local3, $00, $00)
            local4 = (local4 + (Float stringwidth(local3)))
            local9 = (local9 + (Float stringwidth(local3)))
            If (local8 <= (Float stringheight(local3))) Then
                local8 = (Float stringheight(local3))
            EndIf
        EndIf
    Next
    setcolorex(local0, local1, local2)
    setfont(local19)
    Return (((Str local8) + " ") + (Str local9))
    Return ""
End Function
