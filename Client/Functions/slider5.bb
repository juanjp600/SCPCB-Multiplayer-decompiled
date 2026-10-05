Function slider5%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5$, arg6$, arg7$, arg8$, arg9$)
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
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    local0 = (arg2 Shr $02)
    local1 = (arg2 Shr $01)
    local2 = (local1 + local0)
    local3 = imenuscale[$0E]
    local4 = (arg2 + local3)
    local5 = imenuscale[$08]
    local6 = (arg1 - local5)
    local7 = imenuscale[$0A]
    local8 = (arg1 + local7)
    local9 = (arg0 + arg2)
    local10 = arg0
    local11 = (arg0 + local0)
    local12 = (arg0 + local1)
    local13 = (arg0 + local2)
    local14 = local9
    local15 = mouseposx
    If (mousedown1 <> 0) Then
        If (onsliderid = $00) Then
            local16 = mouseposy
            If (((((local15 >= arg0) And (local15 <= (arg0 + local4))) And (local16 >= local6)) And (local16 <= local8)) <> 0) Then
                onsliderid = arg4
            EndIf
        EndIf
    ElseIf (onsliderid = arg4) Then
        onsliderid = $00
    EndIf
    setcolorraw($C8C8C8)
    rect(arg0, arg1, local4, local7, $01)
    local17 = imenuscale[$04]
    rect(local10, local6, local17, local3, $01)
    rect((imenuscale[$02] + local11), local6, local17, local3, $01)
    rect((imenuscale[$05] + local12), local6, local17, local3, $01)
    rect((imenuscale[$07] + local13), local6, local17, local3, $01)
    rect((imenuscale[$0A] + local14), local6, local17, local3, $01)
    If (arg4 = onsliderid) Then
        If (local15 <= (arg0 + local5)) Then
            arg3 = $00
        ElseIf (((local15 >= local11) And (local15 <= (local11 + local5))) <> 0) Then
            arg3 = $01
        ElseIf (((local15 >= local12) And (local15 <= (local12 + local5))) <> 0) Then
            arg3 = $02
        ElseIf (((local15 >= local13) And (local15 <= (local13 + local5))) <> 0) Then
            arg3 = $03
        ElseIf (local15 >= local14) Then
            arg3 = $04
        EndIf
        setcolorraw($FF00)
        rect(arg0, arg1, local4, local7, $01)
    Else
        local18 = mouseposy
        If (((((local15 >= arg0) And (local15 <= (arg0 + local4))) And (local18 >= local6)) And (local18 <= local8)) <> 0) Then
            setcolorraw($C800)
            rect(arg0, arg1, local4, local7, $00)
        EndIf
    EndIf
    setcolorraw($AAAAAA)
    If (arg3 = $00) Then
        drawimage(blinkmeterimg, local10, local6, $00)
        text((local10 + $02), local8, arg5, $01, $00)
    ElseIf (arg3 = $01) Then
        drawimage(blinkmeterimg, (imenuscale[$01] + local11), local6, $00)
        text((imenuscale[$04] + local11), local8, arg6, $01, $00)
    ElseIf (arg3 = $02) Then
        drawimage(blinkmeterimg, (imenuscale[$03] + local12), local6, $00)
        text((imenuscale[$07] + local12), local8, arg7, $01, $00)
    ElseIf (arg3 = $03) Then
        drawimage(blinkmeterimg, (imenuscale[$04] + local13), local6, $00)
        text((imenuscale[$09] + local13), local8, arg8, $01, $00)
    Else
        drawimage(blinkmeterimg, (imenuscale[$06] + local14), local6, $00)
        text((imenuscale[$0C] + local14), local8, arg9, $01, $00)
    EndIf
    Return arg3
    Return $00
End Function
