Function slider3%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5$, arg6$, arg7$)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    local0 = imenuscale[$0E]
    local1 = (arg2 + local0)
    local2 = (arg1 - imenuscale[$08])
    local3 = imenuscale[$0A]
    local4 = (arg1 + local3)
    local5 = mouseposx
    If (mousedown1 <> 0) Then
        If (onsliderid = $00) Then
            local6 = mouseposy
            If (((((local5 >= arg0) And (local5 <= (arg0 + local1))) And (local6 >= local2)) And (local6 <= local4)) <> 0) Then
                onsliderid = arg4
            EndIf
        EndIf
    ElseIf (onsliderid = arg4) Then
        onsliderid = $00
    EndIf
    setcolorraw($C8C8C8)
    rect(arg0, arg1, local1, local3, $01)
    local7 = imenuscale[$04]
    local8 = ((arg2 Shr $01) + arg0)
    local9 = (arg0 + arg2)
    rect(arg0, local2, local7, local0, $01)
    rect((imenuscale[$05] + local8), local2, local7, local0, $01)
    rect((imenuscale[$0A] + local9), local2, local7, local0, $01)
    If (arg4 = onsliderid) Then
        local10 = imenuscale[$08]
        If (local5 <= (arg0 + local10)) Then
            arg3 = $00
        ElseIf (((local5 >= local8) And (local5 <= (local8 + local10))) <> 0) Then
            arg3 = $01
        ElseIf (local5 >= local9) Then
            arg3 = $02
        EndIf
        setcolorraw($FF00)
        rect(arg0, arg1, local1, local3, $01)
    Else
        local11 = mouseposy
        If (((((local5 >= arg0) And (local5 <= (arg0 + local1))) And (local11 >= local2)) And (local11 <= local4)) <> 0) Then
            setcolorraw($C800)
            rect(arg0, arg1, local1, local3, $00)
        EndIf
    EndIf
    setcolorraw($AAAAAA)
    If (arg3 = $00) Then
        drawimage(blinkmeterimg, arg0, local2, $00)
        text((arg0 + $02), local4, arg5, $01, $00)
    ElseIf (arg3 = $01) Then
        drawimage(blinkmeterimg, (imenuscale[$03] + local8), local2, $00)
        text((imenuscale[$07] + local8), local4, arg6, $01, $00)
    Else
        drawimage(blinkmeterimg, (imenuscale[$06] + local9), local2, $00)
        text((imenuscale[$0C] + local9), local4, arg7, $01, $00)
    EndIf
    Return arg3
    Return $00
End Function
