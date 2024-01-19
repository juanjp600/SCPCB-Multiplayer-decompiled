Function formattextdefault$(arg0#, arg1#, arg2$, arg3%, arg4%, arg5#, arg6%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5#
    Local local6$
    Local local7$
    Local local8$
    Local local9#
    Local local10#
    Local local11%
    Local local12$
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17$
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
    local0 = selectedfont_
    local1 = colorred()
    local2 = colorgreen()
    local3 = colorblue()
    local5 = 0.0
    local11 = $00
    For local16 = $01 To len(arg2) Step $01
        local4 = mid(arg2, local16, $01)
        If (local4 = "%") Then
            local7 = right(arg2, (Int max((Float ((len(arg2) - local16) + $02)), 0.0)))
            local7 = piece(local7, $02, "%")
            local16 = ((len(local7) + local16) + $01)
        Else
            local6 = (local6 + local4)
        EndIf
    Next
    local18 = $00
    local19 = $00
    If (arg3 <> 0) Then
        arg0 = (arg0 - (Float (stringwidth(local6) Sar $01)))
    EndIf
    If (arg4 <> 0) Then
        arg1 = (arg1 - (Float (stringheight(local6) Sar $01)))
    EndIf
    For local16 = $01 To len(arg2) Step $01
        local18 = $00
        local4 = mid(arg2, local16, $01)
        If (local4 = "%") Then
            local7 = piece(right(arg2, (Int max((Float ((len(arg2) - local16) + $02)), 0.0))), $02, "%")
            local8 = ""
            color((Int (255.0 * arg5)), (Int (255.0 * arg5)), (Int (255.0 * arg5)))
            Select local7
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
                    local18 = (local18 + $01)
            End Select
            Select piece(local7, $01, "|")
                Case "font"
                    local8 = piece(local7, $02, "|")
                    local22 = piece(local8, $01, ",")
                    local23 = (Int piece(local8, $02, ","))
                    local24 = (Int piece(local8, $03, ","))
                    local25 = (Int piece(local8, $04, ","))
                    local26 = (Int piece(local8, $05, ","))
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
                    local8 = piece(local7, $02, "|")
                    color((Int ((Float (Int piece(local8, $01, ","))) * arg5)), (Int ((Float (Int piece(local8, $02, ","))) * arg5)), (Int ((Float (Int piece(local8, $03, ","))) * arg5)))
                Default
                    local18 = (local18 + $01)
            End Select
            If (local18 = $02) Then
                local18 = $00
            Else
                local16 = ((len(local7) + local16) + $01)
            EndIf
        Else
            local18 = $00
        EndIf
        If (local18 = $00) Then
            If (arg6 <> 0) Then
                local29 = colorred()
                local30 = colorgreen()
                local31 = colorblue()
                color($00, $00, $00)
                text((Int ((arg0 + local5) + 1.0)), (Int (arg1 + 1.0)), local4, $00, $00)
                color(local29, local30, local31)
            EndIf
            text((Int (arg0 + local5)), (Int arg1), local4, $00, $00)
            local5 = (local5 + (Float stringwidth(local4)))
            local10 = (local10 + (Float stringwidth(local4)))
            If (local9 <= (Float stringheight(local4))) Then
                local9 = (Float stringheight(local4))
            EndIf
        EndIf
    Next
    color(local1, local2, local3)
    setfont(selectedfont_)
    Return (((Str local9) + " ") + (Str local10))
    Return ""
End Function
