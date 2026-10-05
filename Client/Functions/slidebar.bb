Function slidebar#(arg0%, arg1%, arg2%, arg3#, arg4%, arg5#, arg6#, arg7%)
    Local local0#
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7#
    Local local8#
    Local local9%
    local0 = (arg6 - arg5)
    local1 = imenuscale[$14]
    local2 = imenuscale[$0E]
    local3 = ((arg0 + arg2) + local2)
    local4 = (arg0 + arg1)
    If (arg7 = $00) Then
        If (mousedown1 <> 0) Then
            local5 = mouseposx
            If (onsliderid = $00) Then
                local6 = mouseposy
                If (((((local5 >= arg0) And (local5 <= local3)) And (local6 >= arg1)) And (local6 <= (arg1 + local1))) <> 0) Then
                    onsliderid = local4
                EndIf
            EndIf
            If (onsliderid = local4) Then
                local7 = ((1.0 / (Float arg2)) * (Float (local5 - arg0)))
                If (0.0 > local7) Then
                    local7 = 0.0
                ElseIf (1.0 < local7) Then
                    local7 = 1.0
                EndIf
                arg3 = ((local7 * local0) + arg5)
            EndIf
        ElseIf (onsliderid = local4) Then
            onsliderid = $00
        EndIf
    EndIf
    setcolorraw((((arg7 = $00) * $FFFFFF) + ($808080 * arg7)))
    rect(arg0, arg1, (local3 - arg0), local1, $00)
    local8 = ((arg3 - arg5) * (1.0 / local0))
    local9 = imenuscale[$03]
    drawimage(blinkmeterimg, (Int ((((Float arg2) * local8) + (Float arg0)) + (Float local9))), (arg1 + local9), $00)
    If (arg4 <> 0) Then
        setcolorraw($AAAAAA)
        text((arg0 - imenuscale[$32]), (imenuscale[$04] + arg1), "LOW", $00, $00)
        text(((arg0 + arg2) + imenuscale[$26]), (imenuscale[$04] + arg1), "HIGH", $00, $00)
    EndIf
    Return arg3
    Return 0.0
End Function
