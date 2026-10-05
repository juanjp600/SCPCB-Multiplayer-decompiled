Function inputbox$(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%, arg6%, arg7#)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7#
    Local local8#
    Local local9%
    Local local10%
    Local local11%
    Local local12$
    local0 = stringwidth(arg4)
    local1 = stringheight(arg4)
    local2 = ((arg2 Shr $01) + arg0)
    local3 = ((arg3 Shr $01) + arg1)
    local4 = millisecs()
    local5 = imenuscale[$05]
    local6 = imenuscale[$0A]
    local7 = (Float imenuscale[$0C])
    local8 = (Float imenuscale[$02])
    local9 = $00
    If (mouseon(arg0, arg1, arg2, arg3) <> 0) Then
        setcolorraw($323232)
        local9 = $01
        If (mousehit1 <> 0) Then
            selectedinputbox = arg5
            flushkeys()
        EndIf
    Else
        setcolorraw($00)
    EndIf
    rect(arg0, arg1, arg2, arg3, $01)
    setcolorraw($FFFFFF)
    rect(arg0, arg1, arg2, arg3, $00)
    If ((((local9 = $00) And mousehit1) And (selectedinputbox = arg5)) <> 0) Then
        selectedinputbox = $00
    EndIf
    If (mousehit1 <> 0) Then
        stringpick = $00
    EndIf
    local10 = (selectedinputbox = arg5)
    local11 = len(arg4)
    If (local10 <> 0) Then
        If (((-1.0 = arg7) Or (arg7 > (Float local0))) <> 0) Then
            arg4 = rinput(arg4)
            local0 = stringwidth(arg4)
            local11 = len(arg4)
        EndIf
        setcolorraw($FFFFFF)
        If (((((stringpick = local11) = $00) Or (stringpick = $00)) And ((-1.0 = arg7) Or (arg7 >= (Float local0)))) <> 0) Then
            If (arg6 = $00) Then
                If (stringpick = local11) Then
                    If ((local4 Mod $320) < $190) Then
                        rect((local2 - (local0 Shr $01)), (local3 - local5), (Int local8), (Int local7), $01)
                    EndIf
                ElseIf ((local4 Mod $320) < $190) Then
                    rect((((local0 Shr $01) + local2) + $02), (local3 - local5), (Int local8), (Int local7), $01)
                EndIf
            ElseIf ((local4 Mod $320) < $190) Then
                rect((((arg0 + local6) + local0) + $02), (local3 - local5), (Int local8), (Int local7), $01)
            EndIf
        ElseIf ((((stringpick = local11) = $00) Or (stringpick = $00)) <> 0) Then
            If ((local4 Mod $320) < $190) Then
                rect((((arg0 + local6) + stringwidth(right(arg4, (Int max(0.0, (arg7 / (Float stringwidth("W")))))))) + $02), (local3 - local5), (Int local8), (Int local7), $01)
            EndIf
        EndIf
    EndIf
    If (((stringpick = local11) And local10) <> 0) Then
        setcolorraw($3390FF)
        If (((-1.0 = arg7) Or (arg7 >= (Float local0))) <> 0) Then
            If (arg6 = $00) Then
                rect((Int ((Float local2) - ((Float local0) * 0.5))), (local3 - local5), local0, local1, $01)
            Else
                rect((arg0 + local6), (local3 - local5), local0, local1, $01)
            EndIf
        Else
            rect((arg0 + local6), (local3 - local5), stringwidth(right(arg4, (Int max(0.0, (arg7 / (Float stringwidth("W"))))))), local1, $01)
        EndIf
    EndIf
    setcolorraw($FFFFFF)
    If (arg6 = $00) Then
        text(local2, local3, arg4, $01, $01)
    Else
        local12 = arg4
        If (-1.0 <> arg7) Then
            If (arg7 < (Float local0)) Then
                local12 = right(local12, (Int max(0.0, (arg7 / (Float stringwidth("W"))))))
            EndIf
        EndIf
        text((arg0 + local6), (local3 - local5), local12, $00, $00)
    EndIf
    Return arg4
    Return ""
End Function
