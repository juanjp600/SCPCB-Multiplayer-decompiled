Function inputbox$(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%, arg6%, arg7#)
    Local local0%
    Local local1$
    color($FF, $FF, $FF)
    drawtiledimagerect(menuwhite, (arg0 Mod $100), (arg1 Mod $100), 512.0, 512.0, arg0, arg1, arg2, arg3)
    color($00, $00, $00)
    local0 = $00
    If (mouseon(arg0, arg1, arg2, arg3) <> 0) Then
        color($32, $32, $32)
        local0 = $01
        If (mousehit1 <> 0) Then
            selectedinputbox = arg5
            flushkeys()
        EndIf
    EndIf
    rect((arg0 + $02), (arg1 + $02), (arg2 - $04), (arg3 - $04), $01)
    color($FF, $FF, $FF)
    If ((((local0 = $00) And mousehit1) And (selectedinputbox = arg5)) <> 0) Then
        selectedinputbox = $00
    EndIf
    If (mousehit1 <> 0) Then
        stringpick = $00
    EndIf
    If (selectedinputbox = arg5) Then
        arg4 = rinput(arg4)
        color($FF, $FF, $FF)
        If ((((((stringpick = len(arg4)) And (selectedinputbox = arg5)) = $00) Or (stringpick = $00)) And ((-1.0 = arg7) Or (arg7 >= (Float aastringwidth(arg4))))) <> 0) Then
            If (arg6 = $00) Then
                If (stringpick = len(arg4)) Then
                    If ((millisecs2() Mod $320) < $190) Then
                        rect((((arg2 Sar $01) + arg0) - (aastringwidth(arg4) Sar $01)), (Int ((Float ((arg3 Sar $01) + arg1)) - (5.0 * menuscale))), $02, $0C, $01)
                    EndIf
                ElseIf ((millisecs2() Mod $320) < $190) Then
                    rect(((((arg2 Sar $01) + arg0) + (aastringwidth(arg4) Sar $01)) + $02), (Int ((Float ((arg3 Sar $01) + arg1)) - (5.0 * menuscale))), $02, $0C, $01)
                EndIf
            ElseIf ((millisecs2() Mod $320) < $190) Then
                rect((Int ((((10.0 * menuscale) + (Float arg0)) + (Float aastringwidth(arg4))) + 2.0)), (Int ((Float ((arg3 Sar $01) + arg1)) - (5.0 * menuscale))), $02, $0C, $01)
            EndIf
        ElseIf (((((stringpick = len(arg4)) And (selectedinputbox = arg5)) = $00) Or (stringpick = $00)) <> 0) Then
            If ((millisecs2() Mod $320) < $190) Then
                rect((Int ((((10.0 * menuscale) + (Float arg0)) + (Float aastringwidth(right(arg4, (Int max(0.0, (arg7 / (Float aastringwidth("W"))))))))) + 2.0)), (Int ((Float ((arg3 Sar $01) + arg1)) - (5.0 * menuscale))), $02, $0C, $01)
            EndIf
        EndIf
    EndIf
    If (((stringpick = len(arg4)) And (selectedinputbox = arg5)) <> 0) Then
        color($33, $90, $FF)
        If (((-1.0 = arg7) Or (arg7 >= (Float aastringwidth(arg4)))) <> 0) Then
            If (arg6 = $00) Then
                rect((((arg2 Sar $01) + arg0) - (aastringwidth(arg4) Sar $01)), (Int ((Float ((arg3 Sar $01) + arg1)) - (5.0 * menuscale))), aastringwidth(arg4), aastringheight(arg4), $01)
            Else
                rect((Int ((10.0 * menuscale) + (Float arg0))), (Int ((Float ((arg3 Sar $01) + arg1)) - (5.0 * menuscale))), aastringwidth(arg4), aastringheight(arg4), $01)
            EndIf
        Else
            rect((Int ((10.0 * menuscale) + (Float arg0))), (Int ((Float ((arg3 Sar $01) + arg1)) - (5.0 * menuscale))), aastringwidth(right(arg4, (Int max(0.0, (arg7 / (Float aastringwidth("W"))))))), aastringheight(arg4), $01)
        EndIf
    EndIf
    color($FF, $FF, $FF)
    If (arg6 = $00) Then
        aatext(((arg2 Sar $01) + arg0), ((arg3 Sar $01) + arg1), arg4, $01, $01, 1.0)
    Else
        local1 = arg4
        If (-1.0 <> arg7) Then
            If (arg7 < (Float aastringwidth(local1))) Then
                local1 = right(local1, (Int max(0.0, (arg7 / (Float aastringwidth("W"))))))
            EndIf
        EndIf
        aatext((Int ((10.0 * menuscale) + (Float arg0))), (Int ((Float ((arg3 Sar $01) + arg1)) - (5.0 * menuscale))), local1, $00, $00, 1.0)
    EndIf
    Return arg4
    Return ""
End Function
